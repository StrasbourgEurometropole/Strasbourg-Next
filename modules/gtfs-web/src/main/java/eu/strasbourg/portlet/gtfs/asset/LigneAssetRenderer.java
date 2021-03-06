package eu.strasbourg.portlet.gtfs.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

public class LigneAssetRenderer extends BaseJSPAssetRenderer<Ligne> {
	
	public static final String TYPE = "ligne";
	private Ligne _entry;
	
	public LigneAssetRenderer(Ligne entry){	
		_entry = entry;
	}
	
	@Override
	public Ligne getAssetObject() {
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
		return _entry.getUuid();
	}

	@Override
	public String getClassName() {
		return Ligne.class.getName();
	}

	@Override
	public long getClassPK() {
		return _entry.getLigneId();
	}

	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		return null;
	}
	
	@Override
	public boolean include(HttpServletRequest request,
		HttpServletResponse response, String template) throws Exception {

		request.setAttribute("entry", this._entry);
		request.setAttribute("detailPortletName", StrasbourgPortletKeys.ENTITY_DETAIL_WEB);
		
		return super.include(request, response, template);
	}

	public Ligne getLigne() {
		return this._entry;
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return "Name: " + _entry.getShortName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getTitle();
	}

}
