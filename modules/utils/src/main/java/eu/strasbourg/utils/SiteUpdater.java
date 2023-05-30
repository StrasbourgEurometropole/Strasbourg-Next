package eu.strasbourg.utils;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.dynamic.data.mapping.io.*;
import com.liferay.dynamic.data.mapping.model.*;
import com.liferay.dynamic.data.mapping.service.DDMStructureLayoutLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.storage.StorageType;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.taglib.ui.BreadcrumbEntry;
import com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.NavItem;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.UnsecureSAXReaderUtil;
import com.liferay.portlet.display.template.PortletDisplayTemplate;
import eu.strasbourg.utils.exception.SiteUpdaterException;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Component(service = SiteUpdater.class)
public class SiteUpdater {

    private final Log log = LogFactoryUtil.getLog(SiteUpdater.class.getName());
    private final long journalClassNameId = PortalUtil.getClassNameId(JournalArticle.class);
    @Reference private GroupLocalService groupLocalService;
    @Reference private CompanyLocalService companyLocalService;
    @Reference private DDMStructureLocalService ddmStructureLocalService;
    @Reference private DDMStructureLayoutLocalService ddmStructureLayoutLocalService;
    @Reference private DDMTemplateLocalService ddmTemplateLocalService;
    @Reference private AssetVocabularyLocalService vocabularyLocalService;
    @Reference private AssetCategoryLocalService categoryLocalService;

    @Reference(target = "(ddm.form.deserializer.type=json)")
    private DDMFormDeserializer jsonDDMFormDeserializer;

    @Reference(target = "(ddm.form.layout.deserializer.type=json)")
    private DDMFormLayoutDeserializer jsonDDMFormLayoutDeserializer;

    @Reference private Language language;

    private long groupId;
    private String groupPath;
    private long userId;
    private ServiceContext sc;

    public void updateSite(String groupFriendlyUrl, Class resourceBundleClass) {
        log.info("Start updating group with friendly url: " + groupFriendlyUrl);

        long defaultCompanyId = PortalUtil.getDefaultCompanyId();
        log.debug("Default company id: " + defaultCompanyId);

        log.debug("Fetching group...");
        Group group = groupLocalService.fetchFriendlyURLGroup(defaultCompanyId, groupFriendlyUrl);
        if (group == null) {
            log.warn("Group does not exist");
            return;
        }
        this.groupId = group.getGroupId();
        this.groupPath = group.getFriendlyURL().substring(1);
        log.debug("Found group " + group.getName(Locale.FRANCE));

        Company company = companyLocalService.fetchCompany(PortalUtil.getDefaultCompanyId());
        if (company == null) {
            log.error("No default company");
            return;
        }

        try {
            userId = company.getDefaultUser().getUserId();
        } catch (PortalException e) {
            log.error("No default company default user");
            return;
        }
        this.sc = new ServiceContext();
        this.sc.setScopeGroupId(groupId);
        this.sc.setAttribute("status", WorkflowConstants.STATUS_APPROVED);

        this.updateStructures(resourceBundleClass);
        this.updateWidgetTemplates(resourceBundleClass);
        this.updateVocabularies(resourceBundleClass);

        log.info("Done updating group");
    }

    private void updateVocabularies(Class resourceBundleClass) {
        log.debug("Importing vocabularies");
        Map<String, String> resourceFiles =
                getResourceFolderFilesContent("vocabularies", "*.json", resourceBundleClass);

        for (Map.Entry<String, String> vocFile : resourceFiles.entrySet()) {
            log.debug("Importing vocabulary file " + vocFile.getKey());
            JSONObject json;
            try {
                json = JSONFactoryUtil.createJSONObject(vocFile.getValue());
            } catch (JSONException e) {
                log.error("[VOCAB] Unable to import file " + vocFile.getKey() + ", invalid JSON");
                log.error(e);
                continue;
            }
            JSONArray vocabulariesArray = json.getJSONArray("vocabularies");
            for (int i = 0; i < vocabulariesArray.length(); i++) {
                JSONObject vocabularyObject = vocabulariesArray.getJSONObject(i);
                String vocabularyName = vocabularyObject.getString("name");
                JSONArray categoriesArray = vocabularyObject.getJSONArray("categories");
                AssetVocabulary vocabulary =
                        this.vocabularyLocalService.fetchGroupVocabulary(
                                this.groupId, vocabularyName.toLowerCase());
                if (vocabulary != null) {
                    log.debug("[VOCAB - " + vocabularyName + "] Vocabulary already exists, not creating it");
                } else {
                    log.debug("[VOCAB - " + vocabularyName + "] Creating new vocabulary");
                    try {
                        vocabulary =
                                this.vocabularyLocalService.addVocabulary(
                                        this.userId, this.groupId, vocabularyName, this.sc);
                        log.info("[VOCAB - " + vocabularyName + "] New vocabulary created");
                    } catch (PortalException e) {
                        log.error("[VOCAB - " + vocabularyName + "] Unable to create vocabulary");
                        log.error(e);
                        continue;
                    }
                }

                for (int j = 0; j < categoriesArray.length(); j++) {
                    JSONObject categoryObject = categoriesArray.getJSONObject(j);
                    String categoryName = categoryObject.getString("name");
                    String categoryDescription = categoryObject.getString("description");
                    AssetCategory category =
                            categoryLocalService.fetchCategory(
                                    this.groupId, 0, categoryName, vocabulary.getVocabularyId());
                    if (category != null) {
                        log.debug(
                                "[VOCAB - "
                                        + vocabularyName
                                        + " - "
                                        + categoryName
                                        + "] Category already exists, not creating it");
                    } else {
                        log.debug(
                                "[VOCAB - " + vocabularyName + " - " + categoryName + "] Creating new category");

                        try {
                            category =
                                    categoryLocalService.addCategory(
                                            this.userId,
                                            this.groupId,
                                            categoryName,
                                            vocabulary.getVocabularyId(),
                                            this.sc);
                            log.info(
                                    "[VOCAB - " + vocabularyName + " - " + categoryName + "] New category created");
                        } catch (PortalException e) {
                            log.error(
                                    "[VOCAB - "
                                            + vocabularyName
                                            + " - "
                                            + categoryName
                                            + "] Unable to create category");
                            log.error(e);
                            continue;
                        }
                    }
                    if (!category.getDescription(Locale.FRANCE).equals(categoryDescription)) {
                        Map<Locale, String> descriptionMap = getLocalizedMap(categoryDescription);
                        category.setDescriptionMap(descriptionMap);
                        this.categoryLocalService.updateAssetCategory(category);
                        log.info(
                                "[VOCAB - "
                                        + vocabularyName
                                        + " - "
                                        + categoryName
                                        + "] Updating category description");
                    }
                }
            }
        }
    }

    private void updateWidgetTemplates(Class resourceBundleClass) {
        // We fetch all files from directory resources/journal
        Map<String, String> resourceFiles =
                getResourceFolderFilesContent("adt", "*.ftl", resourceBundleClass);
        long navItemClassNameId = PortalUtil.getClassNameId(NavItem.class);
        long assetEntryClassNameId = PortalUtil.getClassNameId(AssetEntry.class);
        long breadcrumbClassNameId = PortalUtil.getClassNameId(BreadcrumbEntry.class);
        long portletDisplayClassNameId = PortalUtil.getClassNameId(PortletDisplayTemplate.class);
        long assetCategoryClassNameId = PortalUtil.getClassNameId(AssetCategory.class);
        long languageClassNameId = PortalUtil.getClassNameId(LanguageEntry.class);
        ClassName resultClassName = ClassNameLocalServiceUtil.fetchClassName("com.liferay.portal.search.web.internal.result.display.context.SearchResultSummaryDisplayContext");
        long resultClassNameId = resultClassName.getClassNameId();
        ClassName sortClassName = ClassNameLocalServiceUtil.fetchClassName("com.liferay.portal.search.web.internal.sort.display.context.SortDisplayContext");
        long sortClassNameId = sortClassName.getClassNameId();
        ClassName categoryFacetClassName = ClassNameLocalServiceUtil.fetchClassName("com.liferay.portal.search.web.internal.category.facet.portlet.CategoryFacetPortlet");
        long categoryFacetClassNameId = categoryFacetClassName.getClassNameId();
        ClassName customFacetClassName = ClassNameLocalServiceUtil.fetchClassName("com.liferay.portal.search.web.internal.custom.facet.portlet.CustomFacetPortlet");
        long customFacetClassNameId = customFacetClassName.getClassNameId();
        for (Map.Entry<String, String> template : resourceFiles.entrySet()) {
            String[] fileParts = template.getKey().split("/");
            if (fileParts.length != 3) {
                continue;
            }
            String templateType = fileParts[1];
            String fileName = fileParts[2].replace(".ftl", "");
            String templateKey = fileName.toUpperCase();
            long classNameId = 0;
            String templateCategory = "";
            switch (templateType) {
                case "navigation-menu":
                    classNameId = navItemClassNameId;
                    templateCategory = "MENU";
                    break;
                case "asset-publisher":
                    classNameId = assetEntryClassNameId;
                    templateCategory = "ASSET PUBLISHER";
                    break;
                case "breadcrumb":
                    classNameId = breadcrumbClassNameId;
                    templateCategory = "BREADCRUMB";
                    break;
                case "categories-navigation":
                    classNameId = assetCategoryClassNameId;
                    templateCategory = "BREADCRUMB";
                    break;
                case "language-selector":
                    classNameId = languageClassNameId;
                    templateCategory = "LANGUAGE SELECTOR";
                    break;
                case "sort":
                    classNameId = sortClassNameId;
                    templateCategory = "SORT";
                    break;
                case "result":
                    classNameId = resultClassNameId;
                    templateCategory = "RESULT";
                    break;
                case "category-facet":
                    classNameId = categoryFacetClassNameId;
                    templateCategory = "CATEGORY FACET";
                    break;
                case "custom-facet":
                    classNameId = customFacetClassNameId;
                    templateCategory = "CUSTOM FACET";
                    break;
            }
            if (templateCategory.equals("")) {
                log.error("[" + templateKey + "] No category for template");
                continue;
            }
            Map<Locale, String> nameMap = getLocalizedMap(templateKey);
            try {
                updateTemplate(
                        groupId,
                        classNameId,
                        templateCategory,
                        templateKey,
                        0,
                        portletDisplayClassNameId,
                        nameMap,
                        template.getValue(),
                        sc);
            } catch (PortalException e) {
                log.error(
                        "[" + templateKey + "] Impossible to add or update template, see following exception");
                log.error(e);
            }
        }
    }

    private void updateStructures(Class resourceBundleClass) {
        // We fetch all files from directory resources/journal
        Map<String, String> resourceFiles =
                getResourceFolderFilesContent("journal", "*", resourceBundleClass);

        // We filter only xml files, corresponding to structures
        List<Map.Entry<String, String>> structureDefinitions =
                resourceFiles.entrySet().stream()
                        .filter(r -> r.getKey().endsWith(".xml"))
                        .collect(Collectors.toList());

        for (Map.Entry<String, String> structureDefinitionEntry : structureDefinitions) {
            String structureKey = "";
            try {
                // Parse the XML file
                Document document =
                        getXMLDocumentFromString(
                                structureDefinitionEntry.getKey(), structureDefinitionEntry.getValue());

                Element rootElement = document.getRootElement();
                structureKey = rootElement.elementText("key");
                String name = rootElement.elementText("name");
                Element structureElement = rootElement.element("structure");
                String structureFilePath = structureElement.elementText("definition");
                String layoutFilePath = structureElement.elementText("layout");
                List<Element> templateElements = rootElement.elements("template");

                log.debug("[" + structureKey + "] Importing structure");
                validateRequiredField("", "", "key", structureKey);
                validateRequiredField("", "", "name", name);
                validateRequiredField(
                        structureKey, "", "structure definition file path", structureFilePath);
                validateRequiredField(
                        structureKey, "", "structure layout definition file path", layoutFilePath);

                Map<Locale, String> nameMap = getLocalizedMap(name);

                String structureDefinition =
                        getContentFromFilePath(structureKey, resourceFiles, structureFilePath);
                String layoutDefinition =
                        getContentFromFilePath(structureKey, resourceFiles, layoutFilePath);

                DDMStructure ddmStructure =
                        ddmStructureLocalService.fetchStructure(groupId, journalClassNameId, structureKey);
                DDMFormLayout ddmFormLayout = getDDMFormLayout(layoutDefinition);
                if (ddmStructure == null) {
                    log.debug("[" + structureKey + "] This a new structure, creating it...");
                    DDMForm ddmForm = getDDMForm(structureDefinition);
                    ddmStructure = createNewStructure(structureKey, nameMap, ddmForm, ddmFormLayout, sc);
                    log.info("[" + structureKey + "] Structure created");
                } else {
                    log.debug(
                            "["
                                    + structureKey
                                    + "] This is an existing structure (id: "
                                    + ddmStructure.getStructureId()
                                    + "), updating it...");
                    ddmStructure =
                            updateExistingStructure(
                                    ddmStructure, nameMap, structureDefinition, ddmFormLayout, layoutDefinition, sc);
                }

                for (Element templateElement : templateElements) {
                    String templateKey = templateElement.elementText("key");
                    String templateName = templateElement.elementText("name");
                    String templateScriptFilePath = templateElement.elementText("script");
                    validateRequiredField(structureKey, templateKey, "key", templateKey);
                    validateRequiredField(structureKey, templateKey, "name", templateName);
                    validateRequiredField(structureKey, templateKey, "name", templateScriptFilePath);
                    Map<Locale, String> templateNameMap = getLocalizedMap(templateName);
                    String templateScript =
                            getContentFromFilePath(structureKey, resourceFiles, templateScriptFilePath);

                    this.updateTemplate(
                            groupId,
                            PortalUtil.getClassNameId(DDMStructure.class),
                            structureKey,
                            templateKey,
                            ddmStructure.getStructureId(),
                            journalClassNameId,
                            templateNameMap,
                            templateScript,
                            sc);
                }

            } catch (Exception e) {
                log.error(
                        "["
                                + structureKey
                                + "] Impossible to add or update structure, see following exception");
                log.error(e);
            }
        }
    }

    private void updateTemplate( long groupId, long classNameId, String templateCategory, String templateKey,
                                 long classPK, long resourceClassNameId, Map<Locale, String> nameMap, String script,
                                 ServiceContext sc) throws PortalException {
        DDMTemplate ddmTemplate =
                ddmTemplateLocalService.fetchTemplate(groupId, classNameId, templateKey);
        if (ddmTemplate == null) {
            // Create template
            log.debug(
                    "["
                            + templateCategory
                            + "][Template: "
                            + templateKey
                            + "] This a new template, creating it...");
            ddmTemplateLocalService.addTemplate(
                    userId,
                    groupId,
                    classNameId,
                    classPK,
                    resourceClassNameId,
                    templateKey,
                    nameMap,
                    null,
                    DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY,
                    DDMTemplateConstants.TEMPLATE_MODE_CREATE,
                    TemplateConstants.LANG_TYPE_FTL,
                    script,
                    false,
                    false,
                    StringPool.BLANK,
                    null,
                    sc);
            log.info("[" + templateCategory + "][Template: " + templateKey + "] Template created");
        } else {
            // Update template
            log.debug(
                    "["
                            + templateCategory
                            + "] This an existing template (id: "
                            + ddmTemplate.getTemplateId()
                            + "), updating it...");
            boolean hasTemplateChanged =
                    !equalsIgnoringWhitespaces(ddmTemplate.getScript(), script)
                            || !nameMap.equals(ddmTemplate.getNameMap());
            if (hasTemplateChanged) {
                ddmTemplate.setScript(script);
                ddmTemplate.setNameMap(nameMap);
                ddmTemplateLocalService.updateDDMTemplate(ddmTemplate);
                log.info("[" + templateCategory + "][Template: " + templateKey + "] Template updated");
            } else {
                log.debug(
                        "[" + templateCategory + "][Template: " + templateKey + "] No change for template");
            }
        }
    }

    private DDMStructure updateExistingStructure( DDMStructure existingDdmStructure, Map<Locale, String> nameMap,
                                                  String structureDefinition, DDMFormLayout ddmFormLayout, String layoutDefinition,
                                                  ServiceContext sc) throws SiteUpdaterException {
        try {
            DDMStructureLayout existingLayout =
                    ddmStructureLayoutLocalService.getDDMStructureLayout(
                            existingDdmStructure.getDefaultDDMStructureLayoutId());
            boolean hasLayoutChanged =
                    !equalsIgnoringWhitespaces(layoutDefinition, existingLayout.getDefinition());
            if (hasLayoutChanged) {
                ddmStructureLayoutLocalService.updateStructureLayout(
                        existingLayout.getStructureLayoutId(), ddmFormLayout, sc);
                log.info("[" + existingDdmStructure.getStructureKey() + "] Structure layout updated");
            } else {
                log.debug(
                        "[" + existingDdmStructure.getStructureKey() + "] No change for structure layout");
            }

            boolean hasStructureChanged =
                    !equalsIgnoringWhitespaces(existingDdmStructure.getDefinition(), structureDefinition)
                            || !existingDdmStructure.getNameMap().equals(nameMap);
            if (hasStructureChanged) {
                DDMStructure ddmStructure =
                        ddmStructureLocalService.updateStructure(
                                userId,
                                existingDdmStructure.getStructureId(),
                                existingDdmStructure.getParentStructureId(),
                                nameMap,
                                new HashMap<>(),
                                structureDefinition,
                                sc);
                log.info("[" + ddmStructure.getStructureKey() + "] Structure updated");
            } else {
                log.debug("[" + existingDdmStructure.getStructureKey() + "] No change for structure");
            }
            return existingDdmStructure;

        } catch (PortalException e) {
            throw new SiteUpdaterException(e);
        }
    }

    private DDMStructure createNewStructure( String structureKey, Map<Locale, String> nameMap, DDMForm ddmForm,
                                             DDMFormLayout ddmFormLayout, ServiceContext sc) throws SiteUpdaterException {
        try {
            DDMStructure structure =
                    ddmStructureLocalService.addStructure(
                            userId,
                            groupId,
                            0,
                            journalClassNameId,
                            structureKey,
                            nameMap,
                            new HashMap<>(),
                            ddmForm,
                            new DDMFormLayout(ddmFormLayout),
                            StorageType.DEFAULT.toString(),
                            0,
                            sc);

            DDMStructureLayout layout =
                    ddmStructureLayoutLocalService.getDDMStructureLayout(
                            structure.getDefaultDDMStructureLayoutId());
            ddmStructureLayoutLocalService.updateStructureLayout(
                    layout.getStructureLayoutId(), ddmFormLayout, sc);
            return structure;
        } catch (Exception e) {
            throw new SiteUpdaterException(e);
        }
    }

    private String getContentFromFilePath(
            String structureKey, Map<String, String> files, String filename) throws SiteUpdaterException {
        Optional<Map.Entry<String, String>> maybeFileContent =
                files.entrySet().stream().filter(r -> r.getKey().endsWith("/" + filename)).findFirst();
        if (!maybeFileContent.isPresent() || maybeFileContent.get().getValue().isEmpty()) {
            throw new SiteUpdaterException(
                    "["
                            + structureKey
                            + "] Structure has been ignored because file "
                            + filename
                            + " is not found");
        }
        return maybeFileContent.get().getValue();
    }

    private void validateRequiredField(
            String structureKey, String templateKey, String fieldName, String fieldValue)
            throws SiteUpdaterException {
        if (Validator.isNull(fieldValue)) {
            String structureKeyPrefix =
                    (Validator.isNull(structureKey)) ? "" : ("[" + structureKey + "] ");
            String templateKeyPrefix = (Validator.isNull(templateKey)) ? "" : ("[" + structureKey + "] ");
            throw new SiteUpdaterException(
                    structureKeyPrefix
                            + templateKeyPrefix
                            + " Impossible to import because of missing field: "
                            + fieldName);
        }
    }

    private Map<Locale, String> getLocalizedMap(String text) {
        Map<Locale, String> localeMap = new HashMap<>();
        for (Locale curLocale : new Locale[]{ Locale.FRANCE, Locale.US }) {
            ResourceBundle resourceBundle =
                    ResourceBundleUtil.getModuleAndPortalResourceBundle(curLocale, getClass());

            localeMap.put(curLocale, language.get(resourceBundle, text));
        }
        return localeMap;
    }

    private Document getXMLDocumentFromString(String filename, String xmlString)
            throws SiteUpdaterException {
        try {
            return UnsecureSAXReaderUtil.read(xmlString);
        } catch (DocumentException e) {
            throw new SiteUpdaterException("Structure file " + filename + " has invalid XML content");
        }
    }

    private DDMForm getDDMForm(String structureDefinition) {

        DDMFormDeserializerDeserializeRequest.Builder builder =
                DDMFormDeserializerDeserializeRequest.Builder.newBuilder(structureDefinition);

        DDMFormDeserializerDeserializeResponse ddmFormDeserializerDeserializeResponse =
                jsonDDMFormDeserializer.deserialize(builder.build());

        return ddmFormDeserializerDeserializeResponse.getDDMForm();
    }

    private DDMFormLayout getDDMFormLayout(String layoutDefinition) {
        DDMFormLayoutDeserializerDeserializeRequest.Builder builder =
                DDMFormLayoutDeserializerDeserializeRequest.Builder.newBuilder(layoutDefinition);

        DDMFormLayoutDeserializerDeserializeResponse ddmFormLayoutDeserializerDeserializeResponse =
                jsonDDMFormLayoutDeserializer.deserialize(builder.build());

        return ddmFormLayoutDeserializerDeserializeResponse.getDDMFormLayout();
    }

    private Map<String, String> getResourceFolderFilesContent(
            String parentFolder, String filePattern, Class resourceBundleClass) {
        Bundle bundle = FrameworkUtil.getBundle(resourceBundleClass);
        BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);
        Collection<String> resources =
                bundleWiring.listResources(this.groupPath+"/"+parentFolder, filePattern, BundleWiring.LISTRESOURCES_RECURSE);

        Map<String, String> files = new HashMap<>();
        for (String resource : resources) {
            URL localResource = bundle.getEntry(resource);
            // Bundle.getEntry() returns null if the resource is not located in the specific bundle
            if (localResource != null) {
                StringBuilder fileContent = new StringBuilder();
                InputStreamReader ir;
                try {
                    ir = new InputStreamReader(localResource.openStream());
                } catch (IOException e) {
                    continue;
                }
                BufferedReader br = new BufferedReader(ir);
                br.lines().forEach(line -> fileContent.append(line).append("\n"));
                files.put(resource, fileContent.toString());
            }
        }
        return files;
    }

    private boolean equalsIgnoringWhitespaces(String s1, String s2) {
        String sanitizedS1 = s1.replace(" ", "").replace("\n", "");
        String sanitizedS2 = s2.replace(" ", "").replace("\n", "");
        // If it's a structure, therefore a json string starting with "{", we also ignore double quotes
        // and backslashes
        if (sanitizedS1.startsWith("{")) {
            sanitizedS1 = sanitizedS1.replace("\"", "").replace("\\", "");
            sanitizedS2 = sanitizedS2.replace("\"", "").replace("\\", "");
        }
        return sanitizedS1.equals(sanitizedS2);
    }
}

