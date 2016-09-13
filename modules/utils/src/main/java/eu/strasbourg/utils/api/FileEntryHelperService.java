package eu.strasbourg.utils.api;

import java.util.Locale;

import aQute.bnd.annotation.ProviderType;

/**
 * Classe de service qui peut �tre utilis�e dans les templates OSGI
 * L'impl�mentation appelle des fonctions statiques pr�sentes dans les classes Helper classiques
 * @author Benjamin Bini
 *
 */
@ProviderType
public interface FileEntryHelperService {
	public String getReadableFileEntrySize(long fileEntryId, Locale locale);
	
	public String getFileEntryURL(long fileEntryId);
}
