package eu.strasbourg.portlet.project.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Joshua Chacha
 */
public class SaisineObservatoireAssetRenderer extends BaseJSPAssetRenderer<SaisineObservatoire> {

    public static final String TYPE = "saisineObservatoire";
    private SaisineObservatoire _entry;

    public SaisineObservatoireAssetRenderer(SaisineObservatoire _entry) {
        this._entry = _entry;
    }

    @Override
    public SaisineObservatoire getAssetObject() {
        return _entry;
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public long getUserId() {
        return _entry.getUserId();
    }

    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    @Override
    public String getUuid() {
        return null;
    }

    @Override
    public String getClassName() {
        return SaisineObservatoire.class.getName();
    }

    @Override
    public long getClassPK() {
        return _entry.getSaisineObservatoireId();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        return null;
    }

    @Override
    public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
        request.setAttribute("entry", this._entry);
        request.setAttribute("detailPortletName", StrasbourgPortletKeys.ENTITY_DETAIL_WEB);
        return super.include(request, response, template);
    }

    public SaisineObservatoire getSaisineObservatoire() {
        return this._entry;
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Name : " + _entry.getDescription();
    }

    @Override
    public String getTitle(Locale locale) {
        return _entry.getTitle();
    }
}
