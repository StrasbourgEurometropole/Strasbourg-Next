package eu.strasbourg.ckeditor.config.contributor;

import com.liferay.layout.content.page.editor.constants.ContentPageEditorPortletKeys;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "editor.config.key=fragmenEntryLinkRichTextEditor",
                "javax.portlet.name=" + ContentPageEditorPortletKeys.CONTENT_PAGE_EDITOR_PORTLET,
                "service.ranking:Integer=100"
        },
        service = EditorConfigContributor.class
)
public class AlloyEditorConfigContributor extends BaseEditorConfigContributor {

    private static final Log _log = LogFactoryUtil.getLog(AlloyEditorConfigContributor.class);

    // List of buttons to add to the add toolbar
    private static final List<String> ADD_BUTTONS = new ArrayList<String>() {{
        add("table");
    }};

    // List of buttons to add to the selection toolbar
    private static final List<String> SELECTION_BUTTONS = new ArrayList<String>() {{
        add("strike");
        add("subscript");
        add("superscript");
        add("quote");
    }};


    /**
     * Populates the editor configuration JSON object.
     *
     * @param jsonObject The JSON object to populate
     * @param map Configuration map
     * @param themeDisplay Theme display context
     * @param requestBackedPortletURLFactory Factory for creating portlet URLs
     */
    @Override
    public void populateConfigJSONObject(
            JSONObject jsonObject, Map<String, Object> map,
            ThemeDisplay themeDisplay,
            RequestBackedPortletURLFactory requestBackedPortletURLFactory
    ) {
        try {
            JSONObject toolbarsJSONObject = jsonObject.getJSONObject("toolbars");

            if (toolbarsJSONObject == null) {
                _log.error("Toolbars configuration not found in the JSON object.");
                return;
            }

            // Add buttons to the add toolbar
            addButtonsToToolbar(toolbarsJSONObject, "add", ADD_BUTTONS);

            // Add buttons to the selection toolbar
            addButtonsToSelectionToolbar(toolbarsJSONObject, "styles", SELECTION_BUTTONS);


            // add allowed tag to the allowedContent
            jsonObject.put("allowedContent", true);
        } catch (Exception e) {
            _log.error("Error populating configuration JSON object: ", e);
        }
    }

    /**
     * Adds buttons to a specified toolbar.
     *
     * @param toolbarsJSONObject The toolbars JSON object
     * @param toolbarName The name of the toolbar to modify
     * @param buttons The list of buttons to add
     */
    private void addButtonsToToolbar(JSONObject toolbarsJSONObject, String toolbarName, List<String> buttons) {
        try {
            JSONObject toolbar = toolbarsJSONObject.getJSONObject(toolbarName);
            if (toolbar == null) {
                _log.error("Toolbar '" + toolbarName + "' not found in the JSON object.");
                return;
            }

            JSONArray toolbarButtons = toolbar.getJSONArray("buttons");
            for (String button : buttons) {
                toolbarButtons.put(button);
            }
        } catch (Exception e) {
            _log.error("Error adding buttons to toolbar '" + toolbarName + "': ", e);
        }
    }

    /**
     * Adds buttons to the selection toolbar.
     *
     * @param toolbarsJSONObject The toolbars JSON object
     * @param toolbarName The name of the toolbar to modify
     * @param buttons The list of buttons to add
     */
    private void addButtonsToSelectionToolbar(JSONObject toolbarsJSONObject, String toolbarName, List<String> buttons) {
        try {
            JSONObject toolbar = toolbarsJSONObject.getJSONObject(toolbarName);
            if (toolbar == null) {
                _log.error("Toolbar '" + toolbarName + "' not found in the JSON object.");
                return;
            }

            JSONArray selectionToolbar = toolbar.getJSONArray("selections");
            if (selectionToolbar == null) {
                _log.error("Selections not found in toolbar '" + toolbarName + "'.");
                return;
            }

            JSONObject selectionToolbarButtons = selectionToolbar.getJSONObject(selectionToolbar.length() - 1);
            if (selectionToolbarButtons == null) {
                _log.error("Selection toolbar buttons not found.");
                return;
            }

            JSONArray selectionToolbarButtonsList = selectionToolbarButtons.getJSONArray("buttons");
            for (String button : buttons) {
                selectionToolbarButtonsList.put(button);
            }
        } catch (Exception e) {
            _log.error("Error adding buttons to selection toolbar '" + toolbarName + "': ", e);
        }
    }
}
