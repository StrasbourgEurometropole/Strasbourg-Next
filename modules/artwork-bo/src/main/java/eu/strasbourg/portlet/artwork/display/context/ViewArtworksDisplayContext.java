package eu.strasbourg.portlet.artwork.display.context;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.service.artwork.model.Artwork;
import eu.strasbourg.service.artwork.service.ArtworkLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewArtworksDisplayContext
	extends ViewBaseDisplayContext<Artwork> {
	private List<Artwork> _artworks;

	public ViewArtworksDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, Artwork.class);
	}

	public List<Artwork> getArtworks() throws PortalException {
		if (this._artworks == null) {
			Hits hits = getHits(this._themeDisplay.getScopeGroupId());

			// Création de la liste d'objet
			List<Artwork> results = new ArrayList<Artwork>();
			if (hits != null) {
				for (Document document : hits.getDocs()) {
					Artwork artwork = ArtworkLocalServiceUtil.fetchArtwork(
						GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
					if (artwork != null) {
						results.add(artwork);
					}
				}
			}
			this._artworks = results;
		}
		return this._artworks;
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
			this._themeDisplay.getScopeGroupId(),
			StrasbourgPortletKeys.ARTWORK_BO, StrasbourgPortletKeys.ARTWORK_BO,
			actionId);
	}

}
