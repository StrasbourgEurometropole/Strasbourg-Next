package eu.strasbourg.ckeditor.config.contributor;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.file.criterion.FileItemSelectorCriterion;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author minhchau
 */
@Component(
	immediate = true,
	property = {
		"editor.name=ckeditor", "editor.name=ckeditor_classic",
		"javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet",
		"javax.portlet.name=" + StrasbourgPortletKeys.EDITION_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.LINK_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.VIDEO_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.OFFICIAL_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.INTEREST_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.NOTIFICATION_BO,
		"javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_SEARCH_WEB,
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_SCHEDULE_WEB,
        "service.ranking:Integer=100"
    },
	service = EditorConfigContributor.class)
public class GlobalBOEditorConfigContributor
	extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(JSONObject jsonObject,
										 Map<String, Object> inputEditorTaglibAttributes,
										 ThemeDisplay themeDisplay,
										 RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		// Barres d'outil
		String editorConfigurationString = "[]";
		try {
			editorConfigurationString = StringUtil.read(
					this.getClass().getClassLoader(),
					"editor-toolbar-configuration.json");
			System.out.println("");
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}

		JSONArray toolbarConfiguration;
		try {
			toolbarConfiguration = JSONFactoryUtil
					.createJSONArray(editorConfigurationString);
			jsonObject.put("toolbar_liferay", toolbarConfiguration);
			jsonObject.put("toolbar_phone", toolbarConfiguration);
			jsonObject.put("toolbar_simple", toolbarConfiguration);
		} catch (JSONException e) {
			_log.error(e.getMessage() + " : " + editorConfigurationString);
		}
		jsonObject.put("allowedContent", true);

		String removePlugins = jsonObject.getString("removePlugins");

		if (Validator.isNotNull(removePlugins)) {
			removePlugins = removePlugins + ",autogrow";
		}
		else {
			removePlugins = "autogrow";
		}

		jsonObject.put("removePlugins", removePlugins);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}