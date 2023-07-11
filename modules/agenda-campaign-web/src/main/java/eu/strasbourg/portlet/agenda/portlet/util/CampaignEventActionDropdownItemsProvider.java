package eu.strasbourg.portlet.agenda.portlet.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AZC
 */
public class CampaignEventActionDropdownItemsProvider {

    public CampaignEventActionDropdownItemsProvider(
            CampaignEvent campaignEvent, RenderRequest request,
            RenderResponse response) {

        _campaignEvent = campaignEvent;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all campaignEvent
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasSubmitValidation = _campaignEvent.getStatus()==2;

        boolean hasApproveValidation = (_campaignEvent.getStatus()==1 &&
                _campaignEvent.isUserManagerOfTheEvent(_themeDisplay.getUserId()));

        boolean hasDelete = (_campaignEvent.getStatus()==8 &&
                _campaignEvent.isUserManagerOfTheEvent(_themeDisplay.getUserId()));

        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
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
                                                    ()->hasSubmitValidation,
                                                    _getEditStatusActionUnsafeConsumer(1,"submit-to-validation")
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
                                                    ()->hasApproveValidation,
                                                    _getEditStatusActionUnsafeConsumer(0,"approve")
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
                                                    ()->hasApproveValidation,
                                                    _getEditStatusActionUnsafeConsumer(4,"deny")
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
                                                    ()->hasDelete,
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
                                                    ()->hasDelete,
                                                    _getEditStatusActionUnsafeConsumer(-1,"deny-deletion")
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
                                                    _getEditStatusActionUnsafeConsumer(8,"request-deletion")
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
                                                    _getCopyActionUnsafeConsumer()
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
                            .setMVCPath("/campaign-edit.jsp")
                            .setCMD("editCampaignEvent")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("campaignEventId", _campaignEvent.getCampaignEventId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Edit link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditStatusActionUnsafeConsumer(int status,String message) {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/campaign-update-status.jsp")
                            .setCMD("updateStatus")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("statusFilterId", status)
                            .setParameter("campaignEventId", _campaignEvent.getCampaignEventId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, message));
        };
    }
    /**
     * Action of Delete link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteCampaignEvent")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("campaignEventId", _campaignEvent.getCampaignEventId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    /**
     * Action of copy
     */
    private UnsafeConsumer<DropdownItem, Exception> _getCopyActionUnsafeConsumer(){

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("duplicateCampaignEvent")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("campaignEventId", _campaignEvent.getCampaignEventId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "duplicate"));
        };
    }

    private final CampaignEvent _campaignEvent;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}