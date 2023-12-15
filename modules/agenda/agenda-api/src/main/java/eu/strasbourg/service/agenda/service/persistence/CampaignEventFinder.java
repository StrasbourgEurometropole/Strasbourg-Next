/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author BenjaminBini
 * @generated
 */
@ProviderType
public interface CampaignEventFinder {

	public java.util.List<eu.strasbourg.service.agenda.model.CampaignEvent>
		findByKeywordThemeAndStatus(
			String keyword, long themeId, int status, long userId, long groupId,
			int start, int end);

	public java.util.List<eu.strasbourg.service.agenda.model.CampaignEvent>
		findByKeywordThemeTypeCampaignAndStatus(
			String keyword, long themeId, long typeId, long campaignId,
			int status, long userId, long groupId, int start, int end);

	public long findByKeywordThemeAndStatusCount(
		String keyword, long themeId, int status, long userId, long groupId);

	public long findByKeywordThemeTypeCampaignAndStatusCount(
		String keyword, long themeId, long typeId, long campaignId, int status,
		long userId, long groupId);

}