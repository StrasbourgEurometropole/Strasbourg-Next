/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.service.persistence.EditionPersistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author BenjaminBini
 * @generated
 */
public class EditionFinderBaseImpl extends BasePersistenceImpl<Edition> {

	public EditionFinderBaseImpl() {
		setModelClass(Edition.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getEditionPersistence().getBadColumnNames();
	}

	/**
	 * Returns the edition persistence.
	 *
	 * @return the edition persistence
	 */
	public EditionPersistence getEditionPersistence() {
		return editionPersistence;
	}

	/**
	 * Sets the edition persistence.
	 *
	 * @param editionPersistence the edition persistence
	 */
	public void setEditionPersistence(EditionPersistence editionPersistence) {
		this.editionPersistence = editionPersistence;
	}

	@BeanReference(type = EditionPersistence.class)
	protected EditionPersistence editionPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		EditionFinderBaseImpl.class);

}