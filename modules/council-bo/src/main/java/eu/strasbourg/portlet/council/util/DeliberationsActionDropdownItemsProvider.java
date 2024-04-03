package eu.strasbourg.portlet.council.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.council.constants.StageDeliberation;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class DeliberationsActionDropdownItemsProvider {

    public DeliberationsActionDropdownItemsProvider(
            Deliberation deliberation, RenderRequest request,
            RenderResponse response) {

        _deliberation = deliberation;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all types
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.COUNCIL_BO, StrasbourgPortletKeys.COUNCIL_BO, "EDIT_DELIBERATION")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasExaminatePermission =_deliberation.isCree() && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
        boolean hasOpenPermission =_deliberation.isAffichageEnCours()&& Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
        boolean hasClosePermission =_deliberation.isVoteOuvert() && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasAdoptDeliberationPermission =(_deliberation.isCree() || _deliberation.isRejete() || _deliberation.isAffichageEnCours())
                                                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasRejectDeliberationPermission =(_deliberation.isCree() || _deliberation.isAdopte() || _deliberation.isAffichageEnCours())
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
            boolean hasCommunicateDeliberationPermission= _deliberation.isCree() || _deliberation.isAffichageEnCours()
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
                                                    () -> hasExaminatePermission,
                                                    _getStageChangeDeliberationActionUnsafeConsumer("stageChangeDeliberation",
                                                            getStageDeliberationName(2),"examinate")
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
                                                    () -> hasOpenPermission,
                                                    _getStageChangeDeliberationActionUnsafeConsumer("openDeliberation",
                                                            getStageDeliberationName(3),"open")
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
                                                    () -> hasClosePermission,
                                                    _getCloseActionUnsafeConsumer()
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
                                                    () -> hasAdoptDeliberationPermission,
                                                    _getStageChangeDeliberationActionUnsafeConsumer("stageChangeDeliberation",
                                                            getStageDeliberationName(4),"adopt")
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
                                                    () -> hasRejectDeliberationPermission,
                                                    _getStageChangeDeliberationActionUnsafeConsumer("stageChangeDeliberation",
                                                            getStageDeliberationName(5  ),"reject")
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
                                                    () -> hasCommunicateDeliberationPermission,
                                                    _getStageChangeDeliberationActionUnsafeConsumer("stageChangeDeliberation",
                                                            getStageDeliberationName(6  ),"communicate")
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
                                                    () -> hasExaminatePermission,
                                                    _getStageChangeDeliberationActionUnsafeConsumer("stageChangeDeliberation",
                                                            getStageDeliberationName(7  ),"pull-out")
                                            )
                                            .build()
                            );
                        }
                )
                .build();
    }

    /**
     * Action of Edit deliberation
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/council-bo-edit-deliberation.jsp")
                            .setCMD("editDeliberation")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "deliberations")
                            .setParameter("deliberationId", _deliberation.getDeliberationId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception> _getCloseActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("closeDeliberation")
                            .setMVCPath("/council-bo-view-deliberations.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "deliberations")
                            .setParameter("deliberationId", _deliberation.getDeliberationId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "close"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception> _getStageChangeDeliberationActionUnsafeConsumer(String actionName,String stageDeliberationName, String label) {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName(actionName)
                            .setMVCPath("/council-bo-view-deliberations.jsp")
                            .setCMD(actionName)
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "deliberations")
                            .setParameter("deliberationId", _deliberation.getDeliberationId())
                            .setParameter("stage", stageDeliberationName)
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, label));
        };
    }
    private String getStageDeliberationName(long id) {
        return StageDeliberation.get(id).getName();
    }

    private final Deliberation _deliberation;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}