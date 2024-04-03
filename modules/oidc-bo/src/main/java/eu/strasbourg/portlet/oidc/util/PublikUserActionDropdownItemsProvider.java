package eu.strasbourg.portlet.oidc.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class PublikUserActionDropdownItemsProvider {

    public PublikUserActionDropdownItemsProvider(
            PublikUser publikUser, RenderRequest request,
            RenderResponse response) {

        _publikUser = publikUser;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all arret
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.OIDC_BO, StrasbourgPortletKeys.OIDC_BO, "EDIT_PUBLIKUSER")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

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
                                            _getHistoriqueActionUnsafeConsumer()
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
                                                    _getAnonimysationActionUnsafeConsumer()
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
    private UnsafeConsumer<DropdownItem, Exception>     _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/oidc-bo-edit-publikuser.jsp")
                            .setCMD("editPublikUser")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "publikUsers")
                            .setParameter("publikUserLiferayId", _publikUser.getPublikUserLiferayId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }
    private UnsafeConsumer<DropdownItem, Exception> _getHistoriqueActionUnsafeConsumer() {
        return dropdownItem -> {
            LiferayPortletURL resourceURL =
                    (LiferayPortletURL) _response.createResourceURL();
            resourceURL.setResourceID("exportHistoricText");
            resourceURL.setParameter("publikUserLiferayId", String.valueOf(_publikUser.getPublikUserLiferayId()));

            resourceURL.setCopyCurrentRenderParameters(false);
            dropdownItem.setHref(resourceURL.toString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "historic"));
        };
    }
    private UnsafeConsumer<DropdownItem, Exception> _getAnonimysationActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/oidc-bo-view-publikusers.jsp")
                            .setCMD("anonymisedUser")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "publikUsers")
                            .setParameter("publikUserLiferayId", _publikUser.getPublikUserLiferayId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "anonymise"));
        };
    }


    private final PublikUser _publikUser;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
