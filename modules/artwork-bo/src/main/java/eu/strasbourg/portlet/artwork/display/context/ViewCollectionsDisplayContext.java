package eu.strasbourg.portlet.artwork.display.context;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.service.artwork.model.ArtworkCollection;
import eu.strasbourg.service.artwork.service.ArtworkCollectionLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewCollectionsDisplayContext
	extends ViewBaseDisplayContext<ArtworkCollection> {
	private List<ArtworkCollection> _collections;

	public ViewCollectionsDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, ArtworkCollection.class);
	}

	public List<ArtworkCollection> getCollections() throws PortalException {
		if (this._collections == null) {
			Hits hits = getHits(this._themeDisplay.getScopeGroupId());

			// Création de la liste d'objet
			List<ArtworkCollection> results = new ArrayList<ArtworkCollection>();
			if (hits != null) {
				for (Document document : hits.getDocs()) {
					ArtworkCollection collection = ArtworkCollectionLocalServiceUtil
						.fetchArtworkCollection(GetterUtil
							.getLong(document.get(Field.ENTRY_CLASS_PK)));
					if (collection != null) {
						results.add(collection);
					}
				}
			}
			this._collections = results;
		}
		return this._collections;
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
