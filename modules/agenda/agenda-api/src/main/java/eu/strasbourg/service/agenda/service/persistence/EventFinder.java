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
public interface EventFinder {

	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		findByNextHappening();

	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		findByManifestationWithLimit(
			long manifestationId, int start, int delta);

}