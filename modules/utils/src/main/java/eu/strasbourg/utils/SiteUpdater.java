package eu.strasbourg.utils;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.dynamic.data.mapping.io.DDMFormDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormDeserializerDeserializeRequest;
import com.liferay.dynamic.data.mapping.io.DDMFormDeserializerDeserializeResponse;
import com.liferay.dynamic.data.mapping.io.DDMFormLayoutDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormLayoutDeserializerDeserializeRequest;
import com.liferay.dynamic.data.mapping.io.DDMFormLayoutDeserializerDeserializeResponse;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormLayout;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMStructureLayout;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.model.DDMTemplateConstants;
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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.UnsecureSAXReaderUtil;
import com.liferay.portlet.display.template.PortletDisplayTemplate;
import eu.strasbourg.utils.bean.Structure;
import eu.strasbourg.utils.bean.Template;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

@Component(service = SiteUpdater.class)
public class SiteUpdater {

    private final Log log = LogFactoryUtil.getLog(SiteUpdater.class.getName());
    private final long journalClassNameId = PortalUtil.getClassNameId(JournalArticle.class);
    private final long portletDisplayClassNameId = PortalUtil.getClassNameId(PortletDisplayTemplate.class);
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

    private long companyId;
    private long groupId;
    private String groupPath;
    private List<Locale> availableLanguages;
    private long userId;

    private long guestId;
    private ServiceContext sc;

    public void updateSite(String groupFriendlyUrl, Class resourceBundleClass) {
        this.log.info("Start updating group with friendly url: " + groupFriendlyUrl);

        long defaultCompanyId = PortalUtil.getDefaultCompanyId();
        this.log.debug("Default company id: " + defaultCompanyId);

        this.log.debug("Fetching group...");
        Group group = this.groupLocalService.fetchFriendlyURLGroup(defaultCompanyId, groupFriendlyUrl);
        if (group == null) {
            log.warn("Group does not exist");
            return;
        }
        this.groupId = group.getGroupId();
        this.groupPath = group.getFriendlyURL().substring(1);
        String[] availableLanguageIds = group.getAvailableLanguageIds();
        this.availableLanguages = new ArrayList<>();
        for (String availableLanguageId : availableLanguageIds) {
            Locale locale = LocaleUtil.fromLanguageId(availableLanguageId);
            this.availableLanguages.add(locale);
        }
        this.log.debug("Found group " + group.getName(Locale.FRANCE));

        Company company = this.companyLocalService.fetchCompany(PortalUtil.getDefaultCompanyId());
        if (company == null) {
            this.log.error("No default company");
            return;
        }
        this.companyId = company.getCompanyId();

        try {
            this.userId = company.getDefaultUser().getUserId();
        } catch (PortalException e) {
            this.log.error("No default company default user");
            return;
        }

        try {
            Role guest = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);
            if (guest == null) {
                this.log.error("No role guest");
                return;
            }
            this.guestId = guest.getRoleId();
        } catch (PortalException e) {
            this.log.error("No role guest");
            return;
        }

        this.sc = new ServiceContext();
        this.sc.setIndexingEnabled(false);
        this.sc.setScopeGroupId(this.groupId);
        this.sc.setAttribute("status", WorkflowConstants.STATUS_APPROVED);

        long startTime = System.nanoTime();
        this.updateStructures(resourceBundleClass);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000_000;
        this.log.info("update structures : " + duration + "s");

        startTime = System.nanoTime();
        this.updateADTs(resourceBundleClass);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000_000;
        this.log.info("update ADTs : " + duration + "s");

        startTime = System.nanoTime();
        this.updateVocabularies(resourceBundleClass);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000_000;
        this.log.info("update vocabularies : " + duration + "s");

        this.log.info("Done updating group");
    }

    /**
     * Mise à jour des vocabulaires (vocabulaire + categorie(s))
     *
     * @param resourceBundleClass class qui a fait appel au siteUpdater et qui donc contient les fichiers
     */
    private void updateVocabularies(Class resourceBundleClass) {
        this.log.debug("Importing vocabularies");
        Map<String, String> resourceFiles =
                getResourceFolderFilesContent(this.groupPath, "vocabularies", "*.json", resourceBundleClass);

        for (Map.Entry<String, String> vocFile : resourceFiles.entrySet()) {
            this.log.debug("Importing vocabulary file " + vocFile.getKey());
            JSONObject json;
            try {
                json = JSONFactoryUtil.createJSONObject(vocFile.getValue());
            } catch (JSONException e) {
                this.log.error("[VOCAB] Unable to import file " + vocFile.getKey() + ", invalid JSON");
                this.log.error(e);
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
                    this.log.debug("[VOCAB - " + vocabularyName + "] Vocabulary already exists, not creating it");
                } else {
                    this.log.debug("[VOCAB - " + vocabularyName + "] Creating new vocabulary");
                    try {
                        vocabulary =
                                this.vocabularyLocalService.addVocabulary(
                                        this.userId, this.groupId, vocabularyName, this.sc);
                        this.log.info("[VOCAB - " + vocabularyName + "] New vocabulary created");
                    } catch (PortalException e) {
                        this.log.error("[VOCAB - " + vocabularyName + "] Unable to create vocabulary");
                        this.log.error(e);
                        continue;
                    }
                }

                for (int j = 0; j < categoriesArray.length(); j++) {
                    JSONObject categoryObject = categoriesArray.getJSONObject(j);
                    String categoryName = categoryObject.getString("name");
                    String categoryDescription = categoryObject.getString("description");
                    AssetCategory category =
                            this.categoryLocalService.fetchCategory(
                                    this.groupId, 0, categoryName, vocabulary.getVocabularyId());
                    if (category != null) {
                        this.log.debug(
                                "[VOCAB - "
                                        + vocabularyName
                                        + " - "
                                        + categoryName
                                        + "] Category already exists, not creating it");
                    } else {
                        this.log.debug(
                                "[VOCAB - " + vocabularyName + " - " + categoryName + "] Creating new category");

                        try {
                            category =
                                    this.categoryLocalService.addCategory(
                                            this.userId,
                                            this.groupId,
                                            categoryName,
                                            vocabulary.getVocabularyId(),
                                            this.sc);
                            this.log.info(
                                    "[VOCAB - " + vocabularyName + " - " + categoryName + "] New category created");
                        } catch (PortalException e) {
                            this.log.error(
                                    "[VOCAB - "
                                            + vocabularyName
                                            + " - "
                                            + categoryName
                                            + "] Unable to create category");
                            this.log.error(e);
                            continue;
                        }
                    }
                    if (!category.getDescription(Locale.FRANCE).equals(categoryDescription)) {
                        Map<Locale, String> descriptionMap = getLocalizedMap(categoryDescription);
                        category.setDescriptionMap(descriptionMap);
                        this.categoryLocalService.updateAssetCategory(category);
                        this.log.info(
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

    /**
     * Mise à jour des ADTs
     *
     * @param resourceBundleClass class qui a fait appel au siteUpdater et qui donc contient les fichiers
     */
    private void updateADTs(Class resourceBundleClass) {

        // Initialisation les variables parent, suffix, skipType, templatesToOverride, templatesToCreate et templatesToSkip
        String parent = "";
        String suffix = "";
        List<String> skipType = new ArrayList<>();
        Map<String, Template> templatesToOverride = new HashMap<>();
        List<Template> templatesToCreate = new ArrayList<>();
        List<String> templatesToSkip = new ArrayList<>();

        // Si il y a un pb à la récupération des xmls de l'enfant, on ne fait pas les ADTs du groupe
        try {
            // on récupère le fichier adt-inherit.xml s'il existe pour y renseigner les variables parent, suffix et skipType
            Map<String, String> adtInheritFile =
                    getResourceFolderFilesContent(this.groupPath,"adt", "adt-inherit.xml", resourceBundleClass);
            for (Map.Entry<String, String> adtInheritFileEntry : adtInheritFile.entrySet()) {
                // Parse the XML file
                Document document =
                        getXMLDocumentFromString(
                                adtInheritFileEntry.getKey(), adtInheritFileEntry.getValue());

                Element rootElement = document.getRootElement();
                parent = rootElement.elementText("parent");
                suffix = rootElement.elementText("suf");
                if(Validator.isNotNull(rootElement.elementText("skipType")))
                    skipType = List.of(rootElement.elementText("skipType").split(","));
                validateRequiredField(adtInheritFileEntry.getKey(), null, null, "parent", parent);
                validateRequiredField(adtInheritFileEntry.getKey(), null, null, "suf", suffix);
            }

            // Parcours de tous les autres XMLs qui se trouvent dans le dossier.
            Map<String, String> resourceFiles =
                    getResourceFolderFilesContent(this.groupPath, "adt", "*.xml", resourceBundleClass);
            for (Map.Entry<String, String> resourceFilesEntry : resourceFiles.entrySet()) {
                // Le fichier doit se trouver dans un dossier type
                // adt/[type]/fichier
                String[] fileParts = resourceFilesEntry.getKey().split("/");
                if (fileParts.length != 4)
                    continue;

                String path = resourceFilesEntry.getKey().replace(fileParts[3], "");
                // Parse the XML file
                Document document =
                        getXMLDocumentFromString(
                                resourceFilesEntry.getKey(), resourceFilesEntry.getValue());

                Element rootElement = document.getRootElement();
                String className = rootElement.elementText("className");
                validateRequiredField(resourceFilesEntry.getKey(), null, null, "className", className);

                // Ajout 'skipKey' dans templatesToSkip
                String skipKey = rootElement.elementText("skipKey");
                if(Validator.isNotNull(skipKey))
                    templatesToSkip.addAll(List.of(skipKey.split(",")));

                // Ajout des templates qui se trouvent dans 'override' dans templatesToOverride
                List<Element> overrideElements = rootElement.elements("override");
                for (Element overrideElement : overrideElements) {
                    String templateParentKey = overrideElement.elementText("parentKey");
                    String templateKey = overrideElement.elementText("key");
                    String templateName = overrideElement.elementText("name");
                    String templateScriptFilePath = overrideElement.elementText("script");
                    validateRequiredField(resourceFilesEntry.getKey(), null, null, "parentKey", templateParentKey);

                    Template template = new Template(className, templateKey, templateName, path + templateScriptFilePath);
                    templatesToOverride.put(templateParentKey, template);
                }

                // Ajout des templates qui se trouvent dans 'template' dans templatesToCreate
                List<Element> templateElements = rootElement.elements("template");
                for (Element templateElement : templateElements) {
                    String templateKey = templateElement.elementText("key");
                    String templateName = templateElement.elementText("name");
                    String templateScriptFilePath = templateElement.elementText("script");
                    validateRequiredField(resourceFilesEntry.getKey(), null, null, "key", templateKey);
                    validateRequiredField(resourceFilesEntry.getKey(), null, templateKey, "name", templateName);
                    validateRequiredField(resourceFilesEntry.getKey(), null, templateKey, "script", templateScriptFilePath);

                    Template template = new Template(className, templateKey, templateName, path + templateScriptFilePath);
                    templatesToCreate.add(template);
                }
            }

            // Si parent not null, on parcourt les .xml du dossier adt du parent
            if(Validator.isNotNull(parent)){
                Map<String, String> resourceParentFiles =
                        getResourceFolderFilesContent(parent, "adt", "*.xml", resourceBundleClass);
                for (Map.Entry<String, String> resourceParentFilesEntry : resourceParentFiles.entrySet()) {
                    // Le fichier doit se trouver dans un dossier type
                    // adt/[type]/fichier
                    String[] fileParts = resourceParentFilesEntry.getKey().split("/");
                    if (fileParts.length != 4)
                        continue;

                    String path = resourceParentFilesEntry.getKey().replace(fileParts[3], "");
                    // Si le nom du dossier se trouve dans skipType, on ignore
                    String templateType = fileParts[2];
                    if(skipType.contains(templateType))
                        continue;

                    try {
                        // Parse the XML file
                        Document document =
                                getXMLDocumentFromString(
                                        resourceParentFilesEntry.getKey(), resourceParentFilesEntry.getValue());

                        Element rootElement = document.getRootElement();
                        String className = rootElement.elementText("className");
                        validateRequiredField(resourceParentFilesEntry.getKey(), null, null, "className", className);

                        List<Element> templateElements = rootElement.elements("template");
                        for (Element templateElement : templateElements) {
                            String templateKey = templateElement.elementText("key");
                            validateRequiredField(resourceParentFilesEntry.getKey(), null, templateKey, "key", templateKey);

                            // Si key se trouve dans templatesToSkip, on ignore
                            if(templatesToSkip.contains(templateKey))
                                continue;

                            String templateName = templateElement.elementText("name");
                            String templateScriptFilePath = templateElement.elementText("script");
                            validateRequiredField(resourceParentFilesEntry.getKey(), null, templateKey, "name", templateName);
                            validateRequiredField(resourceParentFilesEntry.getKey(), null, templateKey, "script", templateScriptFilePath);

                            // Si key se trouve dans templatesToOverride, on met à jour les infos qui s'y trouve et on l'ajoute à templatesToCreate
                            Template childTemplate = templatesToOverride.get(templateKey);
                            if(Validator.isNotNull(childTemplate)) {
                                if(Validator.isNull(childTemplate.getKey()))
                                    childTemplate.setKey(templateKey + '-' + suffix);
                                if(Validator.isNull(childTemplate.getName()))
                                    childTemplate.setName(templateName);
                                if(childTemplate.getScriptFilePath().endsWith("null"))
                                    childTemplate.setScriptFilePath(path + templateScriptFilePath);

                                templatesToCreate.add(childTemplate);
                            } else {
                                // Si key ne se trouve pas dans templatesToOverride, on ajoute le template parent dans templatesToCreate
                                Template template = new Template(className, templateKey + '-' + suffix, templateName, path + templateScriptFilePath);
                                templatesToCreate.add(template);
                            }

                        }

                    } catch (Exception e) {
                        this.log.error(
                                "[" + resourceParentFilesEntry.getKey()
                                        + "] Impossible to add or update ADTs, see following exception");
                        this.log.error(e);
                    }
                }
            }

            // On parcourt templateToCreate pour créer/updater les ADTs
            Map<String, String> resourceFTLFiles =
                    getResourceFolderFilesContent(this.groupPath, "adt", "*.ftl", resourceBundleClass);
            resourceFTLFiles.putAll(
                    getResourceFolderFilesContent(parent, "adt", "*.ftl", resourceBundleClass));
            for(Template template : templatesToCreate) {
                String templateKey = template.getKey();
                String scriptFilePath = template.getScriptFilePath();
                String classNameString = template.getClassName();

                long classNameId;
                ClassName className = ClassNameLocalServiceUtil.fetchClassName(classNameString);
                classNameId = className.getClassNameId();
                if (classNameId == 0) {
                    this.log.error("[" + scriptFilePath + "][" + templateKey + "]" +
                            "Impossible to add or update ADT, see following exception");
                    this.log.error("[" + classNameString + "] No category for template");
                    continue;
                }

                try {
                    Map<Locale, String> templateNameMap = getLocalizedMap(template.getName());
                    String templateScript =
                            getContentFromFilePath(resourceFTLFiles, scriptFilePath);
                    updateTemplate(
                            this.groupId,
                            classNameId,
                            template.getScriptFilePath(),
                            templateKey,
                            0,
                            this.portletDisplayClassNameId,
                            templateNameMap,
                            templateScript,
                            false,
                            this.sc);
                } catch (Exception e) {
                    this.log.error("[" + scriptFilePath + "] [" + templateKey + "]" +
                            "Impossible to add or update ADT, see following exception");
                    this.log.error(e);
                }
            }
        } catch (Exception e) {
            this.log.error(
                    "Impossible to add or update ADTs, see following exception");
            this.log.error(e);
        }
    }

    /**
     * Mise à jour des structures (structure + layout de structure + template(s))
     *
     * @param resourceBundleClass class qui a fait appel au siteUpdater et qui donc contient les fichiers
     */
    private void updateStructures(Class resourceBundleClass) {

        // Initialisation les variables parent, suffix, skipStructure, structuresToOverride, structuresToCreate, templatesToOverride, templatesToCreate et templatesToSkip
        String parent = "";
        String suffix = "";
        List<String> skipStructure = new ArrayList<>();
        List<Template> basicCWTemplatesToCreate = new ArrayList<>();
        Map<String, Template> basicCWTemplatesToOverride = new HashMap<>();
        Map<String, Structure> structuresToOverride = new HashMap<>();
        List<Structure> structuresToCreate = new ArrayList<>();
        Map<String, Template> templatesToOverride = new HashMap<>();
        Map<String, List<Template>> templatesToCreate = new HashMap<>();
        List<String> templatesToSkip = new ArrayList<>();

        // Si il y a un pb à la récupération des xmls de l'enfant, on ne fait pas les CWs du groupe
        try {
            // on récupère le fichier journal-inherit.xml s'il existe pour y renseigner les variables parent, suffix et skipStructure
            Map<String, String> journalInheritFile =
                    getResourceFolderFilesContent(this.groupPath,"journal", "journal-inherit.xml", resourceBundleClass);
            for (Map.Entry<String, String> journalInheritFileEntry : journalInheritFile.entrySet()) {
                // Parse the XML file
                Document document =
                        getXMLDocumentFromString(
                                journalInheritFileEntry.getKey(), journalInheritFileEntry.getValue());

                Element rootElement = document.getRootElement();
                parent = rootElement.elementText("parent");
                suffix = rootElement.elementText("suf");
                if(Validator.isNotNull(rootElement.elementText("skipStructure")))
                    skipStructure = List.of(rootElement.elementText("skipStructure").split(","));
                validateRequiredField(journalInheritFileEntry.getKey(), null, null, "parent", parent);
                validateRequiredField(journalInheritFileEntry.getKey(), null, null, "suf", suffix);
            }

            // Parcours de tous les autres XMLs qui se trouvent dans le dossier.
            Map<String, String> resourceFiles =
                    getResourceFolderFilesContent(this.groupPath, "journal", "*.xml", resourceBundleClass);
            for (Map.Entry<String, String> resourceFilesEntry : resourceFiles.entrySet()) {
                String structureLink;
                // Le fichier doit se trouver dans un dossier structure
                // journal/[structure]/fichier
                String[] fileParts = resourceFilesEntry.getKey().split("/");
                if (fileParts.length != 4)
                    continue;

                String path = resourceFilesEntry.getKey().replace(fileParts[3], "");
                // Parse the XML file
                Document document =
                        getXMLDocumentFromString(
                                resourceFilesEntry.getKey(), resourceFilesEntry.getValue());

                Element rootElement = document.getRootElement();

                // s'il n'y a pas de structure, structureOverride, de basicCWTemplate ni de basicCWTemplateOverride on retourne une erreur
                Element structureOverrideElement = rootElement.element("structureOverride");
                Element structureElement = rootElement.element("structure");
                List<Element> basicCWTemplateElements = rootElement.elements("basicCWTemplate");
                List<Element> basicCWTemplateOverrideElements = rootElement.elements("basicCWTemplateOverride");
                if (Validator.isNull(structureOverrideElement) && Validator.isNull(structureElement) &&
                        basicCWTemplateElements.isEmpty() && basicCWTemplateOverrideElements.isEmpty()) {
                    throw new SiteUpdaterException("[" + resourceFilesEntry.getKey() +
                            "] Impossible to import because of missing field: structure or structureOverride and basicCWTemplate or basicCWTemplateOverride");
                }

                // Si c'est un contenu web de base, on ignore les structures
                if (!basicCWTemplateElements.isEmpty() || !basicCWTemplateOverrideElements.isEmpty()){
                    // Ajout des templates qui se trouvent dans 'basicCWTemplateOverride' dans basicCWTemplatesToOverride
                    for (Element templateOverrideElement : basicCWTemplateOverrideElements) {
                        String templateParentKey = templateOverrideElement.elementText("parentKey");
                        String templateKey = templateOverrideElement.elementText("key");
                        String templateName = templateOverrideElement.elementText("name");
                        String templateCacheable = templateOverrideElement.elementText("cacheable");
                        String templateScriptFilePath = templateOverrideElement.elementText("script");
                        validateRequiredField(resourceFilesEntry.getKey(), "BASIC-WEB-CONTENT", templateKey, "parentKey", templateParentKey);

                        Template template = new Template("BASIC-WEB-CONTENT", templateKey, templateName, templateCacheable, path + templateScriptFilePath);
                        basicCWTemplatesToOverride.put(templateParentKey, template);
                    }

                    // Ajout des templates qui se trouvent dans 'basicCWTemplate' dans basicCWTemplatesToCreate
                    for (Element templateElement : basicCWTemplateElements) {
                        String templateKey = templateElement.elementText("key");
                        String templateName = templateElement.elementText("name");
                        String templateCacheable = templateElement.elementText("cacheable");
                        String templateScriptFilePath = templateElement.elementText("script");
                        validateRequiredField(resourceFilesEntry.getKey(), "BASIC-WEB-CONTENT", null, "key", templateKey);
                        validateRequiredField(resourceFilesEntry.getKey(), "BASIC-WEB-CONTENT", templateKey, "name", templateName);
                        validateRequiredField(resourceFilesEntry.getKey(), "BASIC-WEB-CONTENT", templateKey, "script", templateScriptFilePath);

                        Template template = new Template("BASIC-WEB-CONTENT", templateKey, templateName, templateCacheable, path + templateScriptFilePath);
                        basicCWTemplatesToCreate.add(template);
                    }
                }else{
                    // Ajout de la structure qui se trouve dans 'structureOverride' dans structuresToOverride
                    // Si pas de 'structureOverride', ajout de la structure qui se trouve dans 'structure' dans structuresToCreate
                    if(Validator.isNotNull(structureOverrideElement)) {
                        String structureParentKey = structureOverrideElement.elementText("parentKey");
                        String structureKey = structureOverrideElement.elementText("key");
                        String structureName = structureOverrideElement.elementText("name");
                        String structureDefinitionFilePath = structureOverrideElement.elementText("definition");
                        String structureLayoutFilePath = structureOverrideElement.elementText("layout");
                        validateRequiredField(resourceFilesEntry.getKey(), null, null, "structureOverride\'s parentKey", structureParentKey);

                        Structure structure = new Structure(structureKey, structureName, path + structureDefinitionFilePath, path + structureLayoutFilePath);
                        structuresToOverride.put(structureParentKey, structure);
                        if(Validator.isNotNull(structureKey))
                            structureLink = structureKey;
                        else
                            structureLink = structureParentKey + "-" + suffix;
                    }else {
                        String structureKey = structureElement.elementText("key");
                        String structureName = structureElement.elementText("name");
                        String structureDefinitionFilePath = structureElement.elementText("definition");
                        String structureLayoutFilePath = structureElement.elementText("layout");
                        validateRequiredField(resourceFilesEntry.getKey(), null, null, "structure\'s key", structureKey);
                        validateRequiredField(resourceFilesEntry.getKey(), structureKey, null, "structure\'s name", structureName);
                        validateRequiredField(resourceFilesEntry.getKey(), structureKey, null, "definition", structureDefinitionFilePath);
                        validateRequiredField(resourceFilesEntry.getKey(), structureKey, null, "layout", structureLayoutFilePath);

                        Structure structure = new Structure(structureKey, structureName, path + structureDefinitionFilePath, path + structureLayoutFilePath);
                        structuresToCreate.add(structure);
                        structureLink = structureKey;
                    }

                    // Ajout des templates qui se trouvent dans 'templateOverride' dans templatesToOverride
                    List<Element> templateOverrideElements = rootElement.elements("templateOverride");
                    for (Element templateOverrideElement : templateOverrideElements) {
                        String templateParentKey = templateOverrideElement.elementText("parentKey");
                        String templateKey = templateOverrideElement.elementText("key");
                        String templateName = templateOverrideElement.elementText("name");
                        String templateCacheable = templateOverrideElement.elementText("cacheable");
                        String templateScriptFilePath = templateOverrideElement.elementText("script");
                        validateRequiredField(resourceFilesEntry.getKey(), null, templateKey, "templateOverride\'s parentKey", templateParentKey);

                        Template template = new Template(structureLink, templateKey, templateName, templateCacheable, path + templateScriptFilePath);
                        templatesToOverride.put(templateParentKey, template);
                    }

                    // Ajout des templates qui se trouvent dans 'template' dans templatesToCreate
                    List<Element> templateElements = rootElement.elements("template");
                    List<Template> templates = new ArrayList<>();
                    for (Element templateElement : templateElements) {
                        String templateKey = templateElement.elementText("key");
                        String templateName = templateElement.elementText("name");
                        String templateCacheable = templateElement.elementText("cacheable");
                        String templateScriptFilePath = templateElement.elementText("script");
                        validateRequiredField(resourceFilesEntry.getKey(), structureLink, null, "template\'s key", templateKey);
                        validateRequiredField(resourceFilesEntry.getKey(), structureLink, templateKey, "template\'s name", templateName);
                        validateRequiredField(resourceFilesEntry.getKey(), structureLink, templateKey, "script", templateScriptFilePath);

                        Template template = new Template(structureLink, templateKey, templateName, templateCacheable, path + templateScriptFilePath);
                        templates.add(template);
                    }
                    templatesToCreate.put(structureLink, templates);
                }

                // Ajout 'skipTemplate' dans templatesToSkip
                String skipTemplate = rootElement.elementText("skipTemplate");
                if(Validator.isNotNull(skipTemplate))
                    templatesToSkip.addAll(List.of(skipTemplate.split(",")));
            }

            // Si parent not null, on parcourt les .xml du dossier journal du parent
            if(Validator.isNotNull(parent)){
                Map<String, String> resourceParentFiles =
                        getResourceFolderFilesContent(parent, "journal", "*.xml", resourceBundleClass);
                for (Map.Entry<String, String> resourceParentFilesEntry : resourceParentFiles.entrySet()) {
                    // Le fichier doit se trouver dans un dossier type
                    // journal/[type]/fichier
                    String[] fileParts = resourceParentFilesEntry.getKey().split("/");
                    if (fileParts.length != 4)
                        continue;

                    String path = resourceParentFilesEntry.getKey().replace(fileParts[3], "");
                    // Si le nom du dossier se trouve dans skipStructure, on ignore
                    String structureType = fileParts[2];
                    if(skipStructure.contains(structureType))
                        continue;

                    try {
                        // Parse the XML file
                        Document document =
                                getXMLDocumentFromString(
                                        resourceParentFilesEntry.getKey(), resourceParentFilesEntry.getValue());

                        Element rootElement = document.getRootElement();

                        // s'il n'y a pas de structure, ni basicCWTemplate on retourne une erreur
                        Element structureElement = rootElement.element("structure");
                        List<Element> basicCWTemplatesElement = rootElement.elements("basicCWTemplate");
                        if (Validator.isNull(structureElement) && basicCWTemplatesElement.isEmpty()) {
                            throw new SiteUpdaterException("[" + resourceParentFilesEntry.getKey() +
                                    "] Impossible to import because of missing field: structure and basicCWTemplate");
                        }

                        // Si c'est un contenu web de base, on ignore les structures
                        if (!basicCWTemplatesElement.isEmpty()) {
                            List<Element> basicCWTemplateElements = rootElement.elements("basicCWTemplate");
                            for (Element templateElement : basicCWTemplateElements) {
                                try {
                                    String templateKey = templateElement.elementText("key");
                                    validateRequiredField(resourceParentFilesEntry.getKey(), "BASIC-WEB-CONTENT", templateKey, "key", templateKey);

                                    // Si key se trouve dans templatesToSkip, on ignore
                                    if (templatesToSkip.contains(templateKey))
                                        continue;

                                    String templateName = templateElement.elementText("name");
                                    String templateCacheable = templateElement.elementText("cacheable");
                                    String templateScriptFilePath = templateElement.elementText("script");
                                    validateRequiredField(resourceParentFilesEntry.getKey(), "BASIC-WEB-CONTENT", templateKey, "name", templateName);
                                    validateRequiredField(resourceParentFilesEntry.getKey(), "BASIC-WEB-CONTENT", templateKey, "script", templateScriptFilePath);

                                    // Si key se trouve dans basicCWTemplatesToOverride, on met à jour les infos qui s'y trouvent et on l'ajoute à basicCWTemplatesToCreate
                                    // sinone, on ajoute le template parent dans basicCWTemplatesToCreate
                                    Template childTemplate = basicCWTemplatesToOverride.get(templateKey);
                                    if (Validator.isNotNull(childTemplate)) {
                                        if (Validator.isNull(childTemplate.getKey()))
                                            childTemplate.setKey(templateKey + '-' + suffix);
                                        if (Validator.isNull(childTemplate.getName()))
                                            childTemplate.setName(templateName);
                                        if (Validator.isNull(childTemplate.getCacheable()))
                                            childTemplate.setCacheable(templateCacheable);
                                        if (childTemplate.getScriptFilePath().endsWith("null"))
                                            childTemplate.setScriptFilePath(path + templateScriptFilePath);

                                        basicCWTemplatesToCreate.add(childTemplate);
                                    } else {
                                        Template template = new Template("BASIC-WEB-CONTENT", templateKey + '-' + suffix, templateName, templateCacheable, path + templateScriptFilePath);
                                        basicCWTemplatesToCreate.add(template);
                                    }
                                } catch (Exception e) {
                                    this.log.error(
                                            "[" + resourceParentFilesEntry.getKey()
                                                    + "] Impossible to add or update CW\'s template, see following exception");
                                    this.log.error(e);
                                }
                            }
                        }else{
                            String structureKey = structureElement.elementText("key");
                            String structureName = structureElement.elementText("name");
                            String structureDefinitionFilePath = structureElement.elementText("definition");
                            String structureLayoutFilePath = structureElement.elementText("layout");
                            validateRequiredField(resourceParentFilesEntry.getKey(), null, null, "structure\'s key", structureKey);
                            validateRequiredField(resourceParentFilesEntry.getKey(), structureKey, null, "structure\'s name", structureName);
                            validateRequiredField(resourceParentFilesEntry.getKey(), structureKey, null, "definition", structureDefinitionFilePath);
                            validateRequiredField(resourceParentFilesEntry.getKey(), structureKey, null, "layout", structureLayoutFilePath);

                            String structureLink;
                            // Si key se trouve dans structuresToOverride, on met à jour les infos qui s'y trouvent et on l'ajoute à structuresToCreate
                            // sinon, on ajoute la structure parent dans structuresToCreate
                            Structure childStructure = structuresToOverride.get(structureKey);
                            if (Validator.isNotNull(childStructure)) {
                                if (Validator.isNull(childStructure.getKey()))
                                    childStructure.setKey(structureKey + '-' + suffix);
                                if (Validator.isNull(childStructure.getName()))
                                    childStructure.setName(structureName);
                                if (childStructure.getDefinitionFilePath().endsWith("null"))
                                    childStructure.setDefinitionFilePath(path + structureDefinitionFilePath);
                                if (childStructure.getLayoutFilePath().endsWith("null"))
                                    childStructure.setLayoutFilePath(path + structureLayoutFilePath);

                                structureLink = childStructure.getKey();
                                structuresToCreate.add(childStructure);
                            } else {
                                Structure structure = new Structure(structureKey + '-' + suffix, structureName, path + structureDefinitionFilePath, path + structureLayoutFilePath);
                                structureLink = structure.getKey();
                                structuresToCreate.add(structure);
                            }

                            List<Element> templateElements = rootElement.elements("template");
                            List<Template> templates = templatesToCreate.get(structureLink) != null ? templatesToCreate.get(structureLink) : new ArrayList<>();
                            for (Element templateElement : templateElements) {
                                try {
                                    String templateKey = templateElement.elementText("key");
                                    validateRequiredField(resourceParentFilesEntry.getKey(), null, templateKey, "template\'s key", templateKey);

                                    // Si key se trouve dans templatesToSkip, on ignore
                                    if(templatesToSkip.contains(templateKey))
                                        continue;

                                    String templateName = templateElement.elementText("name");
                                    String templateCacheable = templateElement.elementText("cacheable");
                                    String templateScriptFilePath = templateElement.elementText("script");
                                    validateRequiredField(resourceParentFilesEntry.getKey(), null, templateKey, "template\'s name", templateName);
                                    validateRequiredField(resourceParentFilesEntry.getKey(), null, templateKey, "script", templateScriptFilePath);

                                    // Si key se trouve dans templatesToOverride, on met à jour les infos qui s'y trouvent et on l'ajoute à templatesToCreate
                                    Template childTemplate = templatesToOverride.get(templateKey);
                                    if(Validator.isNotNull(childTemplate)) {
                                        if(Validator.isNull(childTemplate.getKey()))
                                            childTemplate.setKey(templateKey + '-' + suffix);
                                        if(Validator.isNull(childTemplate.getName()))
                                            childTemplate.setName(templateName);
                                        if(Validator.isNull(childTemplate.getCacheable()))
                                            childTemplate.setCacheable(templateCacheable);
                                        if(childTemplate.getScriptFilePath().endsWith("null"))
                                            childTemplate.setScriptFilePath(path + templateScriptFilePath);

                                        templates.add(childTemplate);
                                    } else {
                                        // Si key ne se trouve pas dans templatesToOverride, on ajoute le template parent dans templatesToCreate
                                        Template template = new Template(structureLink, templateKey + '-' + suffix, templateName, templateCacheable, path + templateScriptFilePath);
                                        templates.add(template);
                                    }
                                } catch (Exception e) {
                                    this.log.error(
                                            "[" + resourceParentFilesEntry.getKey()
                                                    + "] Impossible to add or update CW\'s template, see following exception");
                                    this.log.error(e);
                                }
                            }
                            templatesToCreate.put(structureLink, templates);
                        }
                    } catch (Exception e) {
                        this.log.error(
                                "[" + resourceParentFilesEntry.getKey()
                                        + "] Impossible to add or update CW, see following exception");
                        this.log.error(e);
                    }
                }
            }

            long startStructuresTime = System.nanoTime();
            // On parcourt structuresToCreate pour créer/updater les structures
            Map<String, String> resourceFTLFiles =
                    getResourceFolderFilesContent(this.groupPath, "journal", "*.ftl", resourceBundleClass);
            resourceFTLFiles.putAll(
                    getResourceFolderFilesContent(parent, "journal", "*.ftl", resourceBundleClass));
            Map<String, String> resourceJSONFiles =
                    getResourceFolderFilesContent(this.groupPath, "journal", "*.json", resourceBundleClass);
            resourceJSONFiles.putAll(
                    getResourceFolderFilesContent(parent, "journal", "*.json", resourceBundleClass));
            for(Structure structure : structuresToCreate) {
                String structureKey = structure.getKey();

                try {
                    Map<Locale, String> structureNameMap = getLocalizedMap(structure.getName());
                    String structureDefinition =
                            getContentFromFilePath(resourceJSONFiles, structure.getDefinitionFilePath());
                    String structureLayout =
                            getContentFromFilePath(resourceJSONFiles, structure.getLayoutFilePath());

                    DDMStructure ddmStructure =
                            this.ddmStructureLocalService.fetchStructure(this.groupId, this.journalClassNameId, structureKey);
                    DDMFormLayout ddmFormLayout = getDDMFormLayout(structureLayout);
                    if (ddmStructure == null) {
                        // Create structure
                        this.log.debug("[" + structureKey + "] This a new structure, creating it...");
                        long startCreateStructuresLayoutTime = System.nanoTime();
                        DDMForm ddmForm = getDDMForm(structureDefinition);
                        ddmStructure = createNewStructure(structureKey, structureNameMap, ddmForm, ddmFormLayout, this.sc);
                        this.log.info("[" + structureKey + "] Structure created");
                        long endTime = System.nanoTime();
                        long duration = (endTime - startCreateStructuresLayoutTime) / 1_000_000_000;
                        this.log.info("create structures and layout : " + duration + "s");
                    } else {
                        // Update structure
                        this.log.debug(
                                "["
                                        + structureKey
                                        + "] This is an existing structure (id: "
                                        + ddmStructure.getStructureId()
                                        + "), updating it...");
                        long startUpdateStructuresLayoutTime = System.nanoTime();
                        ddmStructure =
                                updateExistingStructure(
                                        ddmStructure, structureKey, structureNameMap, structureDefinition, ddmFormLayout, structureLayout, this.sc);
                        long endTime = System.nanoTime();
                        long duration = (endTime - startUpdateStructuresLayoutTime) / 1_000_000_000;
                        this.log.info("update structures and layout : " + duration + "s");
                    }

                    long startTemplatesTime = System.nanoTime();
                    // On parcourt templatesToCreate pour créer/updater les templates du CW
                    for(Template template : templatesToCreate.get(structureKey)) {
                        String templateKey = template.getKey();
                        try {
                            boolean isCacheable = false;
                            if(Validator.isNotNull(template.getCacheable()))
                                isCacheable = Boolean.parseBoolean(template.getCacheable());
                            Map<Locale, String> templateNameMap = getLocalizedMap(template.getName());
                            String templateScript =
                                    getContentFromFilePath(resourceFTLFiles, template.getScriptFilePath());
                            this.updateTemplate(
                                    this.groupId,
                                    PortalUtil.getClassNameId(DDMStructure.class),
                                    template.getScriptFilePath(),
                                    templateKey,
                                    ddmStructure.getStructureId(),
                                    this.journalClassNameId,
                                    templateNameMap,
                                    templateScript,
                                    isCacheable,
                                    this.sc);
                        } catch (Exception e) {
                            this.log.error("[" + structureKey + "]" +"[" + templateKey + "]" +
                                    "Impossible to add or update CW\'s template, see following exception");
                            this.log.error(e);
                        }
                    }
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTemplatesTime) / 1_000_000_000;
                    this.log.info("create/update of structure template : " + duration + "s");
                } catch (Exception e) {
                    this.log.error("[" + structureKey + "]" +
                            "Impossible to add or update CW, see following exception");
                    this.log.error(e);
                }
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startStructuresTime) / 1_000_000_000;
            this.log.info("create/update structures with templates  : " + duration + "s");

            // On parcourt basicCWTemplatesToCreate pour créer/updater les templates du CW de base
            long startBasicTemplatesTime = System.nanoTime();
            for(Template template : basicCWTemplatesToCreate) {
                String templateKey = template.getKey();
                try {
                    boolean isCacheable = false;
                    if(Validator.isNotNull(template.getCacheable()))
                        isCacheable = Boolean.parseBoolean(template.getCacheable());
                    Map<Locale, String> templateNameMap = getLocalizedMap(template.getName());
                    String templateScript =
                            getContentFromFilePath(resourceFTLFiles, template.getScriptFilePath());
                    this.updateTemplate(
                            this.groupId,
                            PortalUtil.getClassNameId(DDMStructure.class),
                            template.getScriptFilePath(),
                            templateKey,
                            32309,
                            this.journalClassNameId,
                            templateNameMap,
                            templateScript,
                            isCacheable,
                            this.sc);
                } catch (Exception e) {
                    this.log.error("[BASIC-WEB-CONTENT]" +"[" + templateKey + "]" +
                            "Impossible to add or update CW\'s template, see following exception");
                    this.log.error(e);
                }
            }
            endTime = System.nanoTime();
            duration = (endTime - startBasicTemplatesTime) / 1_000_000_000;
            this.log.info("create/update basic structures templates  : " + duration + "s");

        } catch (Exception e) {
            this.log.error(
                    "Impossible to add or update CWs, see following exception");
            this.log.error(e);
        }
    }

    /**
     * Créer ou Modifie le template
     *
     * @param groupId Id du groupe
     * @param classNameId classNameId du template (classNameId de DDMStructure pour les template de structure)
     * @param templateFilePath chemin du fichier du template
     * @param templateKey key du template
     * @param classPK structureId de la structure associée (0 pour les ADTs)
     * @param resourceClassNameId classNameId de la ressource (classNameId de JournalArticle pour les templates de structure
     *                             et de PortletDisplayTemplate pour les ADTs)
     * @param nameMap nom du template
     * @param script script du template
     * @param isCacheable si mise en cache (inutile pour les ADTs)
     * @param sc serviceContext
     * @exception PortalException si un problème est survenu lors de la création ou de l'update
     */
    private void updateTemplate( long groupId, long classNameId, String templateFilePath, String templateKey,
                                 long classPK, long resourceClassNameId, Map<Locale, String> nameMap, String script,
                                 Boolean isCacheable, ServiceContext sc) throws PortalException {
        DDMTemplate ddmTemplate =
                this.ddmTemplateLocalService.fetchTemplate(groupId, classNameId, templateKey);
        if (ddmTemplate == null) {
            // Create template
            this.log.debug(
                    "["
                            + templateFilePath
                            + "] This a new template, creating it...");
            DDMTemplate adt = this.ddmTemplateLocalService.addTemplate(
                    this.userId,
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
                    isCacheable,
                    false,
                    StringPool.BLANK,
                    null,
                    sc);
            ResourcePermissionLocalServiceUtil.setResourcePermissions(this.companyId,"com.liferay.dynamic.data.mapping.model.DDMTemplate",
                    ResourceConstants.SCOPE_INDIVIDUAL,""+adt.getTemplateId(), guestId, new String[]{ActionKeys.VIEW});
            this.log.info("[" + templateFilePath + "] Template created");
        } else {
            // Update template
            this.log.debug(
                    "["
                            + templateFilePath
                            + "] This an existing template (id: "
                            + ddmTemplate.getTemplateId()
                            + "), updating it...");
            boolean hasTemplateChanged =
                    !equalsIgnoringWhitespaces(ddmTemplate.getScript(), script)
                            || !nameMap.equals(ddmTemplate.getNameMap())
                            || isCacheable != ddmTemplate.getCacheable();
            if (hasTemplateChanged) {
                ddmTemplate.setScript(script);
                ddmTemplate.setNameMap(nameMap);
                ddmTemplate.setCacheable(isCacheable);
                this.ddmTemplateLocalService.updateDDMTemplate(ddmTemplate);
                this.log.info("[" + templateFilePath + "] Template updated");
            } else {
                this.log.debug(
                        "[" + templateFilePath + "] No change for template");
            }
        }
    }

    /**
     * Modifie la structure et son layout
     *
     * @param existingDdmStructure structure existante en BDD
     * @param structureKey key de la structure
     * @param nameMap nouveau nom multilingue de la structure
     * @param structureDefinition nouvelle définition de la structure
     * @param ddmFormLayout nouveau ddmFormLayout de la structure
     * @param layoutDefinition nouvelle définition du layout de la structure
     * @param sc serviceContext
     * @return la DDMStructure.
     * @exception SiteUpdaterException si un problème est survenu lors de la récupération du layout en BDD,
     * de la modification de celui-ci ou de la structure
     */
    private DDMStructure updateExistingStructure( DDMStructure existingDdmStructure, String structureKey, Map<Locale, String> nameMap,
                                                  String structureDefinition, DDMFormLayout ddmFormLayout, String layoutDefinition,
                                                  ServiceContext sc) throws SiteUpdaterException {
        try {
            DDMStructureLayout existingLayout =
                    this.ddmStructureLayoutLocalService.getDDMStructureLayout(
                            existingDdmStructure.getDefaultDDMStructureLayoutId());
            boolean hasLayoutChanged =
                    !equalsIgnoringWhitespaces(layoutDefinition, existingLayout.getDefinition());
            if (hasLayoutChanged) {
                this.ddmStructureLayoutLocalService.updateStructureLayout(
                        existingLayout.getStructureLayoutId(), ddmFormLayout, sc);
                this.log.info("[" + existingDdmStructure.getStructureKey() + "] Structure layout updated");
            } else {
                this.log.debug(
                        "[" + existingDdmStructure.getStructureKey() + "] No change for structure layout");
            }

            long startUpdateStructureTime = System.nanoTime();
            boolean hasStructureChanged =
                    !equalsIgnoringWhitespaces(existingDdmStructure.getDefinition(), structureDefinition)
                            || !existingDdmStructure.getNameMap().equals(nameMap);
            if (hasStructureChanged) {
                DDMStructure ddmStructure =
                        this.ddmStructureLocalService.updateStructure(
                                this.userId,
                                existingDdmStructure.getStructureId(),
                                existingDdmStructure.getParentStructureId(),
                                structureKey,
                                nameMap,
                                new HashMap<>(),
                                structureDefinition,
                                sc);
                long endTime = System.nanoTime();
                long duration = (endTime - startUpdateStructureTime) / 1_000_000_000;
                this.log.info("update structure - " + structureKey + " : " + duration + "s");
                this.log.info("[" + ddmStructure.getStructureKey() + "] Structure updated");

                return ddmStructure;
            } else {
                this.log.debug("[" + existingDdmStructure.getStructureKey() + "] No change for structure");
            }
            return existingDdmStructure;

        } catch (PortalException e) {
            throw new SiteUpdaterException(e);
        }
    }

    /**
     * créer la structure et son layout
     *
     * @param structureKey key de structure
     * @param nameMap nom multilingue de la structure
     * @param ddmForm définition de la structure
     * @param ddmFormLayout ddmFormLayout de la structure
     * @param sc serviceContext
     * @return la DDMStructure.
     * @exception SiteUpdaterException si un problème est survenu lors l'ajout de la structure,
     * la récupération de son layout ou sa modification
     */
    private DDMStructure createNewStructure( String structureKey, Map<Locale, String> nameMap, DDMForm ddmForm,
                                             DDMFormLayout ddmFormLayout, ServiceContext sc) throws SiteUpdaterException {
        try {
            DDMStructure structure =
                    this.ddmStructureLocalService.addStructure(
                            this.userId,
                            this.groupId,
                            0,
                            this.journalClassNameId,
                            structureKey,
                            nameMap,
                            new HashMap<>(),
                            ddmForm,
                            new DDMFormLayout(ddmFormLayout),
                            StorageType.DEFAULT.toString(),
                            0,
                            sc);

            DDMStructureLayout layout =
                    this.ddmStructureLayoutLocalService.getDDMStructureLayout(
                            structure.getDefaultDDMStructureLayoutId());
            this.ddmStructureLayoutLocalService.updateStructureLayout(
                    layout.getStructureLayoutId(), ddmFormLayout, sc);
            return structure;
        } catch (Exception e) {
            throw new SiteUpdaterException(e);
        }
    }

    /**
     * Retourne le contenu du fichier (filename) qui devrait se trouver dans la map (files)
     *
     * @param files une map de chemin + nom du fichier et son contenu
     *              dans lequel devrait se trouver le fichier voulu
     * @param filename nom du fichier voulu
     * @return le contenu d'un fichier.
     * @exception SiteUpdaterException si le fichier est introuvable
     */
    private String getContentFromFilePath(Map<String, String> files, String filename) throws SiteUpdaterException {
        Optional<Map.Entry<String, String>> maybeFileContent =
                files.entrySet().stream().filter(r -> r.getKey().equals(filename)).findFirst();
        if (maybeFileContent.isEmpty() || maybeFileContent.get().getValue().isEmpty()) {
            throw new SiteUpdaterException("[" + filename
                            + "] is not found");
        }
        return maybeFileContent.get().getValue();
    }

    /**
     * Vérifie que la valeur du champ (fieldValue) est renseignée
     *
     * @param file fichier concerné
     * @param structureKey key de structure
     * @param templateKey key du template
     * @param fieldName  nom du champ
     * @param fieldValue valeur du champ
     * @exception SiteUpdaterException si le champ n'a pas de valeur
     */
    private void validateRequiredField(String file,
            String structureKey, String templateKey, String fieldName, String fieldValue)
            throws SiteUpdaterException {
        if (Validator.isNull(fieldValue)) {
            String structureKeyPrefix =
                    (Validator.isNull(structureKey)) ? "" : ("[" + structureKey + "] ");
            String templateKeyPrefix = (Validator.isNull(templateKey)) ? "" : ("[" + templateKey + "] ");
            throw new SiteUpdaterException("[" + file + "]" +
                    structureKeyPrefix
                            + templateKeyPrefix
                            + " Impossible to import because of missing field: "
                            + fieldName);
        }
    }

    /**
     * Transforme la valeur d'un champ (text) en texte multilingue
     *
     * @param text valeur du champ
     * @return la version multilingue.
     */
    private Map<Locale, String> getLocalizedMap(String text) {
        Map<Locale, String> localeMap = new HashMap<>();
        Locale locale = LocaleUtil.getSiteDefault();
        ResourceBundle resourceBundle =
                ResourceBundleUtil.getModuleAndPortalResourceBundle(locale, getClass());

        localeMap.put(locale, this.language.get(resourceBundle, text));
        for (Locale availableLanguage : this.availableLanguages) {
            resourceBundle =
                    ResourceBundleUtil.getModuleAndPortalResourceBundle(availableLanguage, getClass());

            localeMap.put(availableLanguage, this.language.get(resourceBundle, text));
        }
        return localeMap;
    }

    /**
     * Transforme le String d'un fichier(xmlString) en Document
     *
     * @param filename  chemin + nom du fichier
     * @param xmlString contenu du fichier
     * @return un document.
     * @exception SiteUpdaterException si le fichier n'a pas pu être transformé
     */
    private Document getXMLDocumentFromString(String filename, String xmlString)
            throws SiteUpdaterException {
        try {
            return UnsecureSAXReaderUtil.read(xmlString);
        } catch (DocumentException e) {
            throw new SiteUpdaterException("[" + filename + "] has invalid XML content");
        }
    }

    /**
     * Transforme le String de la définition de la structure (structureDefinition) en DDMForm
     *
     * @param structureDefinition nouvelle définition de structure
     * @return un DDMForm.
     */
    private DDMForm getDDMForm(String structureDefinition) {

        DDMFormDeserializerDeserializeRequest.Builder builder =
                DDMFormDeserializerDeserializeRequest.Builder.newBuilder(structureDefinition);

        DDMFormDeserializerDeserializeResponse ddmFormDeserializerDeserializeResponse =
                this.jsonDDMFormDeserializer.deserialize(builder.build());

        return ddmFormDeserializerDeserializeResponse.getDDMForm();
    }

    /**
     * Transforme le String de la définition du layout(layoutDefinition) en DDMFormLayout
     *
     * @param layoutDefinition nouvelle définition du layout
     * @return un DDMFormLayout.
     */
    private DDMFormLayout getDDMFormLayout(String layoutDefinition) {
        DDMFormLayoutDeserializerDeserializeRequest.Builder builder =
                DDMFormLayoutDeserializerDeserializeRequest.Builder.newBuilder(layoutDefinition);

        DDMFormLayoutDeserializerDeserializeResponse ddmFormLayoutDeserializerDeserializeResponse =
                this.jsonDDMFormLayoutDeserializer.deserialize(builder.build());

        return ddmFormLayoutDeserializerDeserializeResponse.getDDMFormLayout();
    }

    /**
     * Retourne les fichiers désirés (filePattern)
     * contenus dans le dossier parent (parentFolder)
     * du module qui les contients (resourceBundleClass)
     *
     * @param groupPath  le chemin du group
     * @param parentFolder  le dossier parent
     * @param filePattern pattern du nom des fichiers désirés
     * @param resourceBundleClass class qui a fait appel au siteUpdater et qui donc contient les fichiers
     * @return une map de chemin + nom du fichier et son contenu.
     */
    private Map<String, String> getResourceFolderFilesContent(String groupPath,
            String parentFolder, String filePattern, Class resourceBundleClass) {
        Bundle bundle = FrameworkUtil.getBundle(resourceBundleClass);
        BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);
        Collection<String> resources =
                bundleWiring.listResources(groupPath+"/"+parentFolder, filePattern, BundleWiring.LISTRESOURCES_RECURSE);

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

    /**
     * Compare 2 String sans le '\n' et les espaces, ni les '\"' et les '\\' pour les jsons
     *
     * @param s1 String 1
     * @param s2 String 2
     * @return true si les 2 strings sont égaux sinon false.
     */
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

