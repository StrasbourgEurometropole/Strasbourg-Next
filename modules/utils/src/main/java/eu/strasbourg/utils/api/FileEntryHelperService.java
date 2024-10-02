package eu.strasbourg.utils.api;

import aQute.bnd.annotation.ProviderType;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.File;
import java.util.List;
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

	public  String getClosestSizeImageURL(FileEntry fileEntry, int size);

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

	public  List<String[]> getFilesInfos(List<AssetEntry> entries, Locale locale);
}
