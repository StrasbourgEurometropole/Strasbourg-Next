package eu.strasbourg.utils;

import com.liferay.adaptive.media.image.media.query.MediaQuery;
import com.liferay.adaptive.media.image.media.query.MediaQueryProvider;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portlet.documentlibrary.lar.FileEntryUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Implémentation du service FileEntryHelperService N'est qu'une couche
 * accessible par les templates FreeMarker qui délègue le travail à une classe
 * helper
 */
@Component(
	property = {},
	service = FileEntryHelperService.class)
public class FileEntryHelperImpl implements FileEntryHelperService {

	@Reference(unbind = "-")
	protected void setMediaQueryProvider(
			MediaQueryProvider mediaQueryProvider) {

		_mediaQueryProvider = mediaQueryProvider;
	}

	@Override
	public  String getClosestSizeImageURL(long fileEntryId, int size) {
		FileEntry fileEntry = FileEntryUtil.fetchByPrimaryKey(fileEntryId);
		try {
			List<MediaQuery> queries = _mediaQueryProvider.getMediaQueries(fileEntry);
			MediaQuery closestQuery = null;

			for (MediaQuery query : queries) {
				if (query.getConditions().size() > 0) {
					String attribute = query.getConditions().get(0).getAttribute();
					if (attribute.equals("max-width")) {
						String stringValue = GetterUtil.getString(query.getConditions().get(0).getValue());
						// Remove all non-numeric characters
						int value = Integer.parseInt(stringValue.replaceAll("[^0-9]", ""));


						// Check if the value is greater than the provided size
						if (value >= size) {
							// If closestQuery is null or the current query is closer than the current closestQuery
							if (closestQuery == null || value < GetterUtil.getInteger(closestQuery.getConditions().get(0).getValue())) {
								closestQuery = query;
							}
						}
					}
				}
			}
			if(closestQuery == null) {
				return this.getFileEntryURL(fileEntryId);
			}

			return closestQuery.getSrc().split(",")[0];
		} catch (PortalException e) {
			// Handle PortalException appropriately
			e.printStackTrace(); // You might want to log the exception
			return "error"; // Or throw a custom exception
		}
	}

	@Override
	public String getFileTitle(long fileEntryId, Locale locale) {
		return FileEntryHelper.getFileTitle(fileEntryId, locale);
	}
	
	@Override
	public String getReadableFileEntrySize(long fileEntryId, Locale locale) {
		return FileEntryHelper.getReadableFileEntrySize(fileEntryId, locale);
	}

	@Override
	public String getFileEntryURL(long fileEntryId) {
		return FileEntryHelper.getFileEntryURL(fileEntryId);
	}

	@Override
	public String getImageCopyright(long fileEntryId, Locale locale) {
		return FileEntryHelper.getImageCopyright(fileEntryId, locale);
	}

	@Override
	public String getImageLegend(long fileEntryId, Locale locale) {
		return FileEntryHelper.getImageLegend(fileEntryId, locale);
	}

	@Override
	public String getFileThumbnail(long fileEntryId,
		ThemeDisplay themeDisplay) {
		return FileEntryHelper.getFileThumbnail(fileEntryId, themeDisplay);
	}

	@Override
	public String getStructureFieldValue(Long fileEntryId, String fieldName,
		Locale locale) {
		return FileEntryHelper.getStructureFieldValue(fileEntryId, fieldName, locale);
	}

	@Override
	public String scanFile(File file) {
		return FileEntryHelper.scanFile(file);
	}

	@Override
	public Map<String, DLFileEntry> getPictoForVocabulary(String nomRepertoireVocabulaire, String nomRepertoire)
			throws PortalException {
		return FileEntryHelper.getPictoForVocabulary(nomRepertoireVocabulaire, nomRepertoire);
	}

	@Override
	public String getRandomFileURLByGroupIdAndFolderName(long groupId, String nomRepertoire) {
		return FileEntryHelper.getRandomFileURLByGroupIdAndFolderName(groupId, nomRepertoire);
	}

	@Override
	public String getFileExtension(long fileEntryId) {
		return FileEntryHelper.getFileExtension(fileEntryId);
	}

	private static MediaQueryProvider _mediaQueryProvider;

}
