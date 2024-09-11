package eu.strasbourg.portlet.project.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class SaisineObservatoireActionDropdownItemsProvider {

    public SaisineObservatoireActionDropdownItemsProvider(
            SaisineObservatoire saisineObservatoire, RenderRequest request,
            RenderResponse response) {

        _saisineObservatoire = saisineObservatoire;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all Project
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PROJECT_BO, StrasbourgPortletKeys.PROJECT_BO, "EDIT_SAISINE_OBSERVATOIRE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PROJECT_BO, StrasbourgPortletKeys.PROJECT_BO, "DELETE_SAISINE_OBSERVATOIRE")
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
                ).build();
    }

    /**
     * Action of Edit project
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/project-bo-edit-saisine-observatoire.jsp")
                            .setCMD("editSaisineObservatoire")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "saisines-observatoire")
                            .setParameter("saisineObservatoireId", _saisineObservatoire.getSaisineObservatoireId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Delete project
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteSaisineObservatoire")
                            .setMVCPath("/project-bo-view-saisines-observatoire.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "saisines-observatoire")
                            .setParameter("saisineObservatoireId", _saisineObservatoire.getSaisineObservatoireId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private final SaisineObservatoire _saisineObservatoire;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}