package eu.strasbourg.utils;

import com.liferay.document.library.kernel.antivirus.AntivirusScannerException;
import com.liferay.document.library.kernel.antivirus.AntivirusScannerUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.Value;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.lar.FileEntryUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.*;

/**
 * Classe Helper pour tout ce qui concerne les fichiers
 * 
 * @author Benjamin Bini
 *
 */
public class FileEntryHelper {
	public static String getFileTitle(long fileEntryId, Locale locale) {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
		String titleFromStructure = getStructureFieldValue(fileEntry.getFileEntryId(), "Titre", locale);
		if (Validator.isNotNull(titleFromStructure)) {
			return titleFromStructure;
		}
		String titleFromAnotherStricture = getStructureFieldValue(fileEntry.getFileEntryId(), "title", locale);
		if (Validator.isNotNull(titleFromAnotherStricture)) {
			return titleFromAnotherStricture;
		}
		String titleFromFile = fileEntry.getTitle();
		if (Validator.isNotNull(titleFromFile)) {
			return titleFromFile;
		}
		return "";
	}

	public static String getFileEntryURL(long fileEntryId) {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
		if (fileEntry != null) {
			return getFileEntryURL(fileEntry);
		} else {
			return "";
		}
	}

	public static String getFileEntryURLWithTimeStamp(long fileEntryId) {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);

		return getFileEntryURLWithTimeStamp(fileEntry);
	}

	public static String getFileEntryURLWithTimeStamp(DLFileEntry dlFileEntry) {
		String url = "";
		if (dlFileEntry != null) {

			FileEntry fileEntry = FileEntryUtil.fetchByPrimaryKey(dlFileEntry.getFileEntryId());
			try {
				url = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK, true, true);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		return url;
	}

	public static String getFileEntryURL(DLFileEntry dlFileEntry) {
		String url = "";
		if (dlFileEntry != null) {
			FileEntry fileEntry = FileEntryUtil.fetchByPrimaryKey(dlFileEntry.getFileEntryId());
			try {
				url = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		return url;
	}


	public static String getReadableFileEntrySize(long fileEntryId, Locale locale) {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
		if (fileEntry != null) {
			return getReadableFileEntrySize(fileEntry, locale);
		} else {
			return "";
		}
	}

	public static String getReadableFileEntrySize(DLFileEntry fileEntry, Locale locale) {
		return LanguageUtil.formatStorageSize(fileEntry.getSize(), locale);
	}

	/**
	 * Prends en paramètre une map avec comme clés des locales et comme valeurs
	 * des IDs de fichiers, une map contenant les anciens et nouveaux ids de
	 * fichiers, retourne cette même map après avoir remplacé les IDs des
	 * fichiers par leurs potentiels IDs live
	 *
	 * @param locale_fileId
	 *            Map avec comme clé les locales et comme valeurs les ids des
	 *            fichiers en staging
	 * @param previousId_newId
	 *            Map avec comme clé les ids des fichiers staging et en valeur
	 *            les ids live
	 * @return Map avec comme clé les locales et comme valeurs les ids des
	 *         fichiers live s'ils existent, staging sinon
	 */
	public static Map<Locale, String> getLiveFileEntryIdMap(Map<Locale, String> locale_fileId,
			Map<Long, Long> previousId_newId) {
		// On initialize la map de résultat en recopiant la map passée en
		// paramètre
		Map<Locale, String> live_locale_fileId = new HashMap<Locale, String>(locale_fileId);
		// Pour chaque entrée de la map, on modifie la valeur avec la nouvelle
		// valeur
		for (Map.Entry<Locale, String> locale_fileIdEntry : live_locale_fileId.entrySet()) {
			try {
				Long fileId = Long.parseLong(locale_fileIdEntry.getValue());
				Long liveFileId = previousId_newId.get(fileId);
				if (Validator.isNotNull(liveFileId)) {
					locale_fileIdEntry.setValue(String.valueOf(liveFileId));
				}
			} catch (Exception ex) {
			}
		}
		return live_locale_fileId;
	}

	/**
	 * @param stagingFileEntryId
	 *            Id d'un fichier
	 * @param previousId_newId
	 *            Map contenant en clé des ids de fichiers staging et en valeur
	 *            des ids live
	 * @return L'id live correspondant à l'id passé en paramètre - si il
	 *         n'existe pas, retourne l'id staging
	 */
	public static Long getLiveFileEntryId(Long stagingFileEntryId, Map<Long, Long> previousId_newId) {
		Long newImageId = previousId_newId.get(stagingFileEntryId);
		if (Validator.isNotNull(newImageId)) {
			return newImageId;
		} else {
			return stagingFileEntryId;
		}
	}

	/**
	 * @param fileEntryId
	 *            ID d'une image
	 * @param locale
	 *            Locale
	 * @return Copyright de l'image dans la langue désirée
	 */
	public static String getImageCopyright(Long fileEntryId, Locale locale) {
		return FileEntryHelper.getStructureFieldValue(fileEntryId, "copyright", locale);
	}

	/**
	 * @param fileEntryId
	 *            ID d'une image
	 * @param locale
	 *            Locale
	 * @return Légende de l'image dans la langue désirée
	 */
	public static String getImageLegend(Long fileEntryId, Locale locale) {
		return FileEntryHelper.getStructureFieldValue(fileEntryId, "legend", locale);
	}

	/**
	 * @param fileEntryId
	 *            ID du fichier
	 * @param fieldName
	 *            Nom du champ personnalisé
	 * @param locale
	 *            Locale
	 * @return La valeur du champ personnalisé dans la langue désirée
	 */
	public static String getStructureFieldValue(Long fileEntryId, String fieldName, Locale locale) {
		String fieldValue = "";
		DLFileEntry file = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
		if (file != null) {
			try {
				Map<String, DDMFormValues> map = file
						.getDDMFormValuesMap(file.getLatestFileVersion(true).getFileVersionId());
				Collection<DDMFormValues> formValuesList = map.values();
				for (DDMFormValues formValues : formValuesList) {
					List<DDMFormFieldValue> formFieldValues = formValues.getDDMFormFieldValues();
					for (DDMFormFieldValue formFieldValue : formFieldValues) {
						if (formFieldValue.getName().equals(fieldName)) {
							Value value = formFieldValue.getValue();
							fieldValue = value.getString(locale);
							break;
						}
					}
					if (Validator.isNotNull(fieldValue)) {
						break;
					}
				}

			} catch (PortalException e) {
				_log.error(e);
			}
		}
		return fieldValue;
	}

	public static String getFileThumbnail(Long fileEntryId, ThemeDisplay themeDisplay) {
		FileEntry fileEntry = FileEntryUtil.fetchByPrimaryKey(fileEntryId);
		try {
			return DLURLHelperUtil.getThumbnailSrc(fileEntry, themeDisplay);
		} catch (Exception e) {
			_log.error(e);
			return "";
		}

	}

	/**
	 * @param file  fichier a scnner
	 * @return l'erreur si il y en a :
	 *    unable-to-scan-file-for-viruses
	 *    unable-to-scan-file-for-viruses.-size-limit-exceeded
	 *    a-virus-was-detected-in-the-file
	 *    an-unexpected-error-occurred-while-scanning-for-viruses
	 */
	public static String scanFile(File file) {
		String error = "";
		try {
			// vérifi que le fichier est clean
			AntivirusScannerUtil.scan(file);
		} catch (AntivirusScannerException e) {
			_log.error(file.getName() + " -> " + e.getMessageKey());
			error = e.getMessageKey();
			_log.error(e);
		}

		return error;
	}

	/**
	 * DEBUG : Afficher les information d'un fichier dans les log
	 * NOTE : Vérifier le niveau de journalisation si les logs INFO n'apparaissent pas
	 * 			--> "Administration du serveur" --> "Niveau de journalisation" --> "eu.strasbour.utils" à "INFO"
	 * @param file fichier à analyser
	 */
	public static void logFileInfo(File file) {
		String lineSep = System.lineSeparator();
		Path path = Paths.get(file.getAbsolutePath());
		FileOwnerAttributeView foav = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
		try {
			_log.info("File : Photo budget before upload in doclib : " + lineSep
					+ " [ canonical path : " + file.getCanonicalPath() + " ]" + lineSep
					+ " [ absolute path : " + file.getAbsolutePath() + " ]" + lineSep
					+ " [ name : " + file.getName() + " ]" + lineSep
					+ " [ exist : " + new File(file.getAbsolutePath()).exists() + " ]" + lineSep
					+ " [ owner : " + foav.getOwner().getName() + " ]" + lineSep
					+ " [ executable : " + file.canExecute() + " ]" + lineSep
					+ " [ readable : " + file.canRead() + " ]" + lineSep
					+ " [ writable : " + file.canWrite() + " ]" + lineSep
			);
		} catch (IOException e) {
			_log.error("Error during file analysis of " + file);
		}
	}

	/**
	 * Renvoie une map d'identifiant et fichier de picto
	 * @param nomRepertoireVocabulaire ex: Catégorie de lieux
	 * @param nomRepertoire ex: CSMap
	 */
	public static Map<String, DLFileEntry> getPictoForVocabulary( String nomRepertoireVocabulaire, String nomRepertoire)
			throws PortalException {

		Map<String, DLFileEntry> map = new TreeMap<>();
		if (nomRepertoireVocabulaire != null && nomRepertoire != null) {
			long companyId = PortalUtil.getDefaultCompanyId();
			long companyGroupId = CompanyLocalServiceUtil.getCompany(companyId).getGroupId();
			DLFolder pictosFolder = DLFolderLocalServiceUtil
					.getFolder(companyGroupId, 0, "Pictos");

			if (pictosFolder != null) {
				DLFolder vocabularyFolder = DLFolderLocalServiceUtil
						.getFolder(companyGroupId, pictosFolder.getFolderId(), nomRepertoireVocabulaire);

				if (vocabularyFolder != null) {
					DLFolder folder = DLFolderLocalServiceUtil
							.getFolder(companyGroupId, vocabularyFolder.getFolderId(), nomRepertoire);

					if (folder != null) {
						// Ajoute les fichiers de la rubrique qui ne sont pas dans une sous rubrique
						List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getFileEntries(companyGroupId, folder.getFolderId());

						for (DLFileEntry file : files) {
							map.put(file.getTitle(), file);
						}
					}
				}
			}
		}

		return map;

	}

	/**
	 * Renvoie l'URL d'une image random
	 * @param groupId ex: Catégorie de lieux
	 * @param nomRepertoire ex: CSMap
	 */
	public static String getRandomFileURLByGroupIdAndFolderName(long groupId, String nomRepertoire) {

		if (Validator.isNotNull(groupId) && Validator.isNotNull(nomRepertoire)) {
			DLFolder folder = DLFolderLocalServiceUtil
					.fetchFolder(groupId, 0, nomRepertoire);

			if (folder != null) {
				// Ajoute les fichiers de la rubrique qui ne sont pas dans une sous rubrique
				List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());

				if(files.size() > 0) {
					Random random = new Random();
					DLFileEntry file = files.get(random.nextInt(files.size()));
					return getFileEntryURL(file);
				}
			}
		}

		return "";
	}

	public static String getFileExtension(long fileEntryId) {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
		if (Validator.isNotNull(fileEntry)) {
			return fileEntry.getExtension();
		}
		return "";
	}

	private static final Log _log = LogFactoryUtil.getLog(FileEntryHelper.class.getName());
}
