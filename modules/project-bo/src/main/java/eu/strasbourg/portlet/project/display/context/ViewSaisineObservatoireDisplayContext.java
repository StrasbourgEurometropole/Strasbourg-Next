package eu.strasbourg.portlet.project.display.context;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewSaisineObservatoireDisplayContext  extends ViewListBaseDisplayContext<SaisineObservatoire>  {

    private List<SaisineObservatoire> _saisinesObservatoire;

    public ViewSaisineObservatoireDisplayContext(RenderRequest request, RenderResponse response) {
        super(SaisineObservatoire.class, request, response);
    }

    public List<SaisineObservatoire> getSaisinesObservatoire() throws PortalException {
        if (this._saisinesObservatoire == null) {
            Hits hits = getHits(this._themeDisplay.getScopeGroupId());
            this._saisinesObservatoire = createObjectList(hits);
        }
        return this._saisinesObservatoire;
    }

    private List<SaisineObservatoire> createObjectList(Hits hits) {
        // Création de la liste d'objet
        List<SaisineObservatoire> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                SaisineObservatoire saisineObservatoire = SaisineObservatoireLocalServiceUtil.fetchSaisineObservatoire(
                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (saisineObservatoire != null) {
                    results.add(saisineObservatoire);
                }
            }
        }
        return results;
    }

    /**
     * Retourne la liste des saisines observatoire correspondante à la recherche lancée en ignorant la pagination
     */
    private List<SaisineObservatoire> getAllSaisinesObservatoire() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        // Création de la liste d'objet
        return createObjectList(hits);
    }

    /**
     * Retourne la liste des PK de toutes les saisines observatoire
     * @return liste de PK (ex: "1,5,7,8")
     */
    public String getAllSaisineObservatoireIds() throws PortalException {
        StringBuilder saisineObservatoireIds = new StringBuilder();
        for (SaisineObservatoire saisineObservatoire : this.getSaisinesObservatoire()) {
            if (saisineObservatoireIds.length() > 0) {
                saisineObservatoireIds.append(",");
            }
            saisineObservatoireIds.append(saisineObservatoire.getSaisineObservatoireId());
        }
        return saisineObservatoireIds.toString();
    }

    /**
     * Wrapper autour du permission checker pour les permissions de module
     */
    public boolean hasPermission(String actionId) throws PortalException {
        return _themeDisplay.getPermissionChecker().hasPermission(
                this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PROJECT_BO, StrasbourgPortletKeys.PROJECT_BO,
                actionId);
    }
}
