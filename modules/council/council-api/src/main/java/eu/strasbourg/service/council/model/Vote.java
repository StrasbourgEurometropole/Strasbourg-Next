/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.council.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Vote service. Represents a row in the &quot;council_Vote&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VoteModel
 * @see eu.strasbourg.service.council.model.impl.VoteImpl
 * @see eu.strasbourg.service.council.model.impl.VoteModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.council.model.impl.VoteImpl")
@ProviderType
public interface Vote extends VoteModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.council.model.impl.VoteImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Vote, Long> VOTE_ID_ACCESSOR = new Accessor<Vote, Long>() {
			@Override
			public Long get(Vote vote) {
				return vote.getVoteId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Vote> getTypeClass() {
				return Vote.class;
			}
		};
}