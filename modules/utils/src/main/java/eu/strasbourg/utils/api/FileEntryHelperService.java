package eu.strasbourg.utils.api;

import aQute.bnd.annotation.ProviderType;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.File;
import java.util.Locale;
import java.util.Map;

/**
 * Classe de service qui peut être utilisée dans les templates L'implémentation
 * appelle des fonctions statiques présentes dans les classes Helper classiques
 * 
 * @author Benjamin Bini
 *
 */
@ProviderType
public interface FileEntryHelperService {

	public  String getClosestSizeImageURL(long fileEntryId, int size);

	public String getFileTitle(long fileEntryId, Locale locale);

	public String getReadableFileEntrySize(long fileEntryId, Locale locale);

	public String getFileEntryURL(long fileEntryId);

	public String getStructureFieldValue(Long fileEntryId, String fieldName, Locale locale);

	public String getImageCopyright(long fileEntryId, Locale locale);

	public String getImageLegend(long fileEntryId, Locale locale);

	public String getFileThumbnail(long fileEntryId, ThemeDisplay themeDisplay);

	public String scanFile(File file);

	public Map<String, DLFileEntry> getPictoForVocabulary(String nomRepertoireVocabulaire, String nomRepertoire)
			throws PortalException;

	public String getRandomFileURLByGroupIdAndFolderName(long groupId, String nomRepertoire);

    String getFileExtension(long fileEntryId);
}
