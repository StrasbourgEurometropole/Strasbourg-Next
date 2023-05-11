package eu.strasbourg.portlet.agenda.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AZC
 */
public class CampaignActionDropdownItemsProvider {

    public CampaignActionDropdownItemsProvider(
            Campaign campaign, RenderRequest request,
            RenderResponse response) {

        _campaign = campaign;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all campaign
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.AGENDA_BO, StrasbourgPortletKeys.AGENDA_BO, "EDIT_CAMPAIGN")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.AGENDA_BO, StrasbourgPortletKeys.AGENDA_BO, "DELETE_CAMPAIGN")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasUpdatePermission,
                                                    _getEditActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasDeletePermission,
                                                    _getDeleteActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    _getExportJsonToFolderActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    _getExportJsonActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    _getExportDocxActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .build();
    }

    /**
     * Action of Edit link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/agenda-bo-edit-campaign.jsp")
                            .setCMD("editCampaign")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "campaigns")
                            .setParameter("campaignId", _campaign.getCampaignId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Delete link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteCampaign")
                            .setMVCPath("/agenda-bo-view-campaigns.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "campaigns")
                            .setParameter("campaignId", _campaign.getCampaignId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    /**
     * Action of Export Json to Folder link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getExportJsonToFolderActionUnsafeConsumer(){

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("exportJsonToFolder")
                            .setMVCPath("/agenda-bo-view-campaigns.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "campaigns")
                            .setParameter("campaignId", _campaign.getCampaignId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "export-json-to-folder"));
        };
    }

    /**
     * Action of Export Json link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getExportJsonActionUnsafeConsumer() {

        return dropdownItem -> {
            ResourceURL resourceURL =
                    _response.createResourceURL();
            resourceURL.setResourceID("exportJson");
            resourceURL.setParameter("campaignId", String.valueOf(_campaign.getCampaignId()));

            dropdownItem.setHref(resourceURL.toString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "export-json"));
        };
    }

    /**
     * Action of Export Docx link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getExportDocxActionUnsafeConsumer() {

        return dropdownItem -> {
            ResourceURL resourceURL =
                    _response.createResourceURL();
            resourceURL.setResourceID("exportDocx");
            resourceURL.setParameter("campaignId", String.valueOf(_campaign.getCampaignId()));

            dropdownItem.setHref(resourceURL.toString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "export-docx"));
        };
    }

    private final Campaign _campaign;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}