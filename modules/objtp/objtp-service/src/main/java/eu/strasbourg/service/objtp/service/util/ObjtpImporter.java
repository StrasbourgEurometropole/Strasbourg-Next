package eu.strasbourg.service.objtp.service.util;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.objtp.model.FoundObject;
import eu.strasbourg.service.objtp.model.ObjectCategory;
import eu.strasbourg.service.objtp.service.FoundObjectLocalServiceUtil;
import eu.strasbourg.service.objtp.service.ObjectCategoryLocalServiceUtil;
import eu.strasbourg.utils.FileEntryHelper;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ObjtpImporter {

	private ResourceBundle bundle = ResourceBundleUtil
			.getBundle("content.ImportErrors", this.getClass().getClassLoader());
	private final Log _log = LogFactoryUtil.getLog(this.getClass());

	private List<FoundObject> foundObjectsList;
	
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = {PortalException.class, SystemException.class,IOException.class,JSONException.class, ParseException.class})	
	public void doImport() throws PortalException, ParseException {
		_log.info("Start importing objtp");
		try {

			ImportReportObjtp report = new ImportReportObjtp();

			this.doObjectCategoriesImport(report);

			if(!report.getReportLinesObjectCategory().isEmpty() && report.getObjectCategoryStatus() != ImportReportStatusObjtp.FAILURE) {
				report.setObjectCategoryStatus(ImportReportStatusObjtp.SUCCESS_WITH_ERRORS);
			}else {

				this.doFoundObjectsImport(report);

				if(!report.getReportLinesFoundObject().isEmpty() && report.getFoundObjectStatus() != ImportReportStatusObjtp.FAILURE) {
					report.setFoundObjectStatus(ImportReportStatusObjtp.SUCCESS_WITH_ERRORS);
				}
			}
			report.setEndDate(new Date());
			report.sendMail();
			_log.info("Finish importing objtp");
		} catch(Exception e) {
			_log.error(e);
		}
	}

	/**
	 * Lance l'import des catégories d'objet
	 */
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = {PortalException.class, SystemException.class,IOException.class,JSONException.class})
	public ImportReportObjtp doObjectCategoriesImport(ImportReportObjtp report)  {
		_log.info("Start importing object categories");
		
		JSONObject json = null;
		try {
			// On récupère le JSON contenant les catégories d'objet trouvé depuis un appel à l'API
			String url = StrasbourgPropsUtil.getObjtpURL() + "liste_categories";
			json = JSONHelper.readJsonFromURL(url);
		} catch (IOException e) { 
			// Erreur de lecture URL
			_log.error(e);
			report.globalErrorObjectCategory(LanguageUtil.get(bundle, "category-object-no-url"));
			return report;
		} catch (JSONException e) { 
			// Erreur de parse du JSON
			_log.error(e);
			report.globalErrorObjectCategory(LanguageUtil.get(bundle, "category-object-json-fail"));
			return report;
		}
		
	    // Récupère les résultats
		if (json != null) {
			JSONArray objectCategories = json.getJSONArray("result");

			if(objectCategories == null || objectCategories.length() == 0) {
				report.globalErrorObjectCategory(LanguageUtil.get(bundle, "no-category-object"));
				return report;
			}

			// On vide d'abord la base
			List<ObjectCategory> allCategories = ObjectCategoryLocalServiceUtil.getObjectCategories(-1, -1);
			for (ObjectCategory category : allCategories) {
				ObjectCategoryLocalServiceUtil.deleteObjectCategory(category);
			}

			// Récupère le nombre total de catégories d'objet à insérer
			report.setTotalObjectCategoryCount(objectCategories.length());
			for (int i = 0; i < objectCategories.length(); i++) {
				_log.info("Import catégorie d'objet : " + (i + 1) + "/" + objectCategories.length());
				JSONObject objectCategory = objectCategories.getJSONObject(i);
				ImportReportLineObjtp reportLine = this.importObjectCategory(objectCategory);

				if(reportLine.getStatus() == ImportReportStatusObjtp.FAILURE) {
					report.incrementErrorObjectCategoryCount();
					report.getReportLinesObjectCategory().add(reportLine);
				}
			}
		}
	    
	    _log.info("Finish importing object categories");
		return report;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = {PortalException.class, SystemException.class,IOException.class,JSONException.class})
	public ImportReportLineObjtp importObjectCategory(JSONObject objectCategoryJSON) {
		
		ImportReportLineObjtp reportLine = new ImportReportLineObjtp();
		
		// Récupération des différents champs
		String categoryName = objectCategoryJSON.getString("nom_categorie");
		if (Validator.isNull(categoryName)) {
			reportLine.error(LanguageUtil.get(bundle, "category-object-name-field-missing"));
		}	
		String codeCategory = objectCategoryJSON.getString("code_categorie");
		if (Validator.isNull(codeCategory)) {
			reportLine.error(LanguageUtil.get(bundle, "category-object-code-field-missing"));
			reportLine.setNumber("XXX");
		}
		else {
			reportLine.setNumber(codeCategory);
		}
		
		if(reportLine.getStatus() == ImportReportStatusObjtp.FAILURE) {
			return reportLine;
		}

		// si tout est bon on (re)créer la catégorie d'objet
		ObjectCategory objectCategory = ObjectCategoryLocalServiceUtil.createObjectCategory(codeCategory);
		objectCategory.setName(categoryName);
		ObjectCategoryLocalServiceUtil.updateObjectCategory(objectCategory);
	
		return reportLine;
	}
	
	/**
	 * Lance l'import des objets trouvés
	 */
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = {PortalException.class, SystemException.class,IOException.class,JSONException.class})
	public ImportReportObjtp doFoundObjectsImport(ImportReportObjtp report) throws PortalException, ParseException {
		_log.info("Start importing found objects");
		
		// On récupère le JSON contenant les objets trouvés depuis un appel à l'API
		JSONObject json = null;
		try {
			String url = StrasbourgPropsUtil.getObjtpURL() + "recherche_objets";
			json = JSONHelper.readJsonFromURL(url);
		} catch (IOException e) { 
			// Erreur de lecture URL
			_log.error(e);
			report.globalErrorFoundObject(LanguageUtil.get(bundle, "found-object-no-url"));
			return report;
		} catch (JSONException e) { 
			// Erreur de parse du JSON
			_log.error(e);
			report.globalErrorFoundObject(LanguageUtil.get(bundle, "found-object-json-fail"));
			return report;
		}
		
	    // Récupère les résultats
		if (json != null) {
			JSONArray foundObjects = json.getJSONArray("result");

			if(foundObjects == null || foundObjects.length() == 0) {
				report.globalErrorFoundObject(LanguageUtil.get(bundle, "no-found-object"));
				return report;
			}

			// On récupère les anciens objets trouvés
			List<FoundObject> oldobjects = FoundObjectLocalServiceUtil.getFoundObjects(-1, -1);

			foundObjectsList = new ArrayList<>();
			for (int i = 0; i < foundObjects.length(); i++) {
				_log.info("Import objet trouvé : " + (i + 1) + "/" + foundObjects.length());
				JSONObject foundObject = foundObjects.getJSONObject(i);
				ImportReportLineObjtp reportLine = this.importObject(foundObject);

				if (reportLine.getStatus() == ImportReportStatusObjtp.FAILURE) {
					report.incrementErrorFoundObjectCount();
					report.getReportLinesFoundObject().add(reportLine);
				} else {
					if (reportLine.getType() == ImportReportTypeObjtp.CREATED)
						report.incrementCreatedFoundObjectCount();
					if (reportLine.getType() == ImportReportTypeObjtp.MODIFICATED)
						report.incrementModifiedFoundObjectCount();
					if (reportLine.getType() == ImportReportTypeObjtp.UNMODIFICATED)
						report.incrementUnmodifiedFoundObjectCount();

					if (report.getReportLinesImageCount().get(reportLine.getCategory()) == null)
						report.getReportLinesImageCount().put(reportLine.getCategory(), Arrays.asList(0,0));
					if (reportLine.getStatus() == ImportReportStatusObjtp.SUCCESS_WITH_ERRORS) {
						report.getReportLinesImageCount().get(reportLine.getCategory()).set(0, report.getReportLinesImageCount().get(reportLine.getCategory()).get(0) + 1);
					}
					if (reportLine.getStatus() == ImportReportStatusObjtp.SUCCESS) {
						report.getReportLinesImageCount().get(reportLine.getCategory()).set(1, report.getReportLinesImageCount().get(reportLine.getCategory()).get(1) + 1);
					}
				}
			}


			// On supprime les objets qui n'ont plus lieu d'être...
			for (FoundObject object : oldobjects) {
				if(!foundObjectsList.contains(object))
					FoundObjectLocalServiceUtil.deleteFoundObject(object);
			}
		}

		_log.info("Finish importing found objects");
		return report;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = {PortalException.class, SystemException.class,IOException.class,JSONException.class})
	public ImportReportLineObjtp importObject(JSONObject objectJSON) throws PortalException, ParseException {
		
		ImportReportLineObjtp reportLine = new ImportReportLineObjtp();
		
		// Récupération des différents champs
		String objectNumero = objectJSON.getString("numero_objet");
		if (Validator.isNull(objectNumero)) {
			reportLine.error(LanguageUtil.get(bundle, "found-object-numero-field-missing"));
			reportLine.setNumber("XXX");
			return reportLine;
		}
		reportLine.setNumber(objectNumero);

		String depotDate = objectJSON.getString("date_depot");
		if (Validator.isNull(depotDate)) {
			reportLine.error(LanguageUtil.get(bundle, "found-object-date-field-missing"));
			return reportLine;
		}

		String codeCategory = objectJSON.getString("code_categorie");
		if (Validator.isNull(codeCategory)) {
			reportLine.error(LanguageUtil.get(bundle, "found-object-code-field-missing"));
			return reportLine;
		}
		ObjectCategory category = ObjectCategoryLocalServiceUtil.fetchObjectCategory(codeCategory);
		if(category == null) {
			reportLine.error(LanguageUtil.format(bundle,"found-object-no-existing-code",codeCategory));
			return reportLine;
		}
		reportLine.setCategory(category.getName());

		FoundObject object = FoundObjectLocalServiceUtil.fetchFoundObject(objectNumero);
		if(Validator.isNotNull(object)){
			if(foundObjectsList.contains(object)) {
				reportLine.error(LanguageUtil.get(bundle, "found-object-already-existing"));
				return reportLine;
			}
			reportLine.setType(ImportReportTypeObjtp.MODIFICATED);
		}else{
			// Crée le nouvel objet trouvé
			object = FoundObjectLocalServiceUtil.createFoundObject(objectNumero);
		}

		foundObjectsList.add(object);
		boolean hasChanged = false;

		if(!object.getCategoryCode().equals(codeCategory)) {
			object.setCategoryCode(codeCategory);
			hasChanged = true;
		}
		
		SimpleDateFormat recievingFormat = new SimpleDateFormat("yyyyMMdd");
		
		Date dateDepot = recievingFormat.parse(depotDate);

		if(Validator.isNull(object.getDate()) || object.getDate().compareTo(dateDepot) != 0){
			object.setDate(dateDepot);
			hasChanged = true;
		}

		if(hasChanged || Validator.isNull(object.getImageUrl())) {
			// On récupère l'image associée à l'objet trouvé
			String url = StrasbourgPropsUtil.getObjtpURL() + "image_objet?numero_objet=" + object.getNumber();
			JSONObject json = null;

			try {
				json = JSONHelper.readJsonFromURL(url, 120000);
			} catch (IOException e) {
				// Erreur de lecture URL
				_log.error(e);
				reportLine.error(LanguageUtil.get(bundle, "image-no-url"));
				reportLine.setStatus(ImportReportStatusObjtp.SUCCESS_WITH_ERRORS);
			} catch (JSONException e) {
				// Erreur de parse du JSON
				_log.error(e);
				reportLine.error(LanguageUtil.get(bundle, "image-json-fail"));
				reportLine.setStatus(ImportReportStatusObjtp.SUCCESS_WITH_ERRORS);
			}
			JSONArray imageArray = null;
			if (json != null) {
				imageArray = json.getJSONArray("result");
			}
			if(imageArray == null || imageArray.length() == 0){
				reportLine.error(LanguageUtil.get(bundle, "no-image-for-object"));
				reportLine.setStatus(ImportReportStatusObjtp.SUCCESS_WITH_ERRORS);
			}else{
				JSONObject image = imageArray.getJSONObject(0);
				String imageBase64 = image.getString("image");

				// On convertit l'image base64 en série de Bytes
				byte[] imageBytes = Base64.getDecoder().decode(imageBase64);

				// Récupère les différents ID nécessaires aux manipulations de dossiers
				Company defaultCompany = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com");
				long globalGroupId = defaultCompany.getGroup().getGroupId();

				// serviceContext nécessaire à la création du dossier et de l'enregistrement de l'image dans le dossier
				ServiceContext serviceContext = new ServiceContext();
				Role adminRole;
				try {
					// On récupère les droits d'admin pour les donner au thread, pour pouvoir manipuler Documents et Medias
					adminRole = RoleLocalServiceUtil.getRole(defaultCompany.getCompanyId(), "Administrator");
					List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
					PrincipalThreadLocal.setName(adminUsers.get(0).getUserId());
					PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUsers.get(0));
					PermissionThreadLocal.setPermissionChecker(permissionChecker);
					serviceContext.setUserId(adminUsers.get(0).getUserId());
				} catch (Exception e) {
					// Dans le cas où ça plante sur la récupération des droits d'admin
					reportLine.error("Erreur récupération de droit d'admin");
					_log.error(e);
					return reportLine;
				}

				long repositoryId = DLFolderConstants.getDataRepositoryId(globalGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);


				serviceContext.setAddGroupPermissions(true);
				serviceContext.setAddGuestPermissions(true);

				Folder objtpFolder = null;
				try {
					// on récupère le dossier "Objets trouves" présent dans Global
					objtpFolder = DLAppServiceUtil.getFolder(repositoryId, 0, "Objets trouves");
				} catch (PortalException e) {
					// Il lance une erreur s'il ne trouve rien
					// Or la première fois, on veut créer le dossier, donc ça plantera forcément
				}
				// S'il n'existe pas, on le crée
				if (objtpFolder == null) {
					objtpFolder = DLAppLocalServiceUtil.addFolder(
							null,
							serviceContext.getUserId(), 
							repositoryId,
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
							"Objets trouves",
							"Objets trouves",
							serviceContext);
				}

				FileEntry existingObjectImage = null;
				try {
					existingObjectImage = DLAppServiceUtil.getFileEntry(globalGroupId, objtpFolder.getFolderId(), object.getNumber());
				} catch (PortalException e) {
					// Il lance une erreur s'il ne trouve rien
					// Or ça peut très largement arrivé qu'il ne trouve rien pour des nouveauxs objets trouvés
				}
				if (existingObjectImage != null) {
					DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, objtpFolder.getFolderId(), object.getNumber());
				}

				// on ajoute l'image au dossier
				FileEntry objectImage = DLAppLocalServiceUtil.addFileEntry(
						null,
						serviceContext.getUserId(),
						repositoryId,
						objtpFolder.getFolderId(),
						object.getNumber(),
						"image/jpeg",
						object.getNumber(),
						null,
						"",
						"",
						imageBytes,
						null,
						null,
						serviceContext);

				String imageUrl = FileEntryHelper.getFileEntryURL(objectImage.getFileEntryId());
				object.setImageUrl(imageUrl);

			}

			if(hasChanged || Validator.isNotNull(object.getImageUrl())) {
				FoundObjectLocalServiceUtil.updateFoundObject(object);
			}else {
				reportLine.setType(ImportReportTypeObjtp.UNMODIFICATED);
			}
		}else {
			reportLine.setType(ImportReportTypeObjtp.UNMODIFICATED);
		}
	
		return reportLine;
	}	
}
