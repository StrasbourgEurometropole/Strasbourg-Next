/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.strasbourg.portlet.place.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import eu.strasbourg.service.place.service.PlaceLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import java.util.List;
import java.io.IOException;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_BO,
		"mvc.command.name=deletePlace" },
	service = MVCActionCommand.class)
public class DeletePlaceActionCommand
	implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {
		long placeId = ParamUtil.getLong(request, "placeId");

		// vérifie que l'utilisateur à le droit de supprimer ce lieu
		Place place = PlaceLocalServiceUtil.fetchPlace(placeId);
		if (Validator.isNotNull(place)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			List<AssetCategory> typeDeLieuVocab = place.getTypes();
			List<AssetCategory> categoriesUser = AssetCategoryLocalServiceUtil.getCategories(User.class.getName(), themeDisplay.getUserId());
			if(!themeDisplay.getPermissionChecker().isOmniadmin() &&
					!typeDeLieuVocab.stream().anyMatch(categoriesUser::contains)) {
				return false;
			}

			try {
				_placeLocalService.removePlace(placeId);
				response.sendRedirect(ParamUtil.getString(request, "backURL"));
			} catch (PortalException | IOException e) {
				_log.error(e);
			}
		}
		return true;
	}

	private PlaceLocalService _placeLocalService;

	@Reference(unbind = "-")
	protected void setPlaceLocalService(
		PlaceLocalService placeLocalService) {

		_placeLocalService = placeLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}