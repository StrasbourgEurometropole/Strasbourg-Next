package eu.strasbourg.utils.api;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * Service d'aide lié à la gestion des données de webContent
 */
@ProviderType
public interface WebContentHelperService {

    /*
     * Récupère l'Url d'une page à partir de la donnée récupérée d'une structure dans un ADT
     * Cele ci se présente sous la forme : XX@public@XXXX
     */
    String getLinkToPageUrl(String linkToPageStructure, ThemeDisplay themeDisplay);

    Layout getLinkToPageLayout(String linkToPageStructure) throws PortalException;
}

