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

package eu.strasbourg.service.ejob.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OfferService}.
 *
 * @author Brian Wing Shun Chan
 * @see OfferService
 * @generated
 */
public class OfferServiceWrapper
	implements OfferService, ServiceWrapper<OfferService> {

	public OfferServiceWrapper() {
		this(null);
	}

	public OfferServiceWrapper(OfferService offerService) {
		_offerService = offerService;
	}

	@Override
	public String exportOffer(
			Long offerId, java.util.Locale locale,
			java.io.ByteArrayOutputStream baos)
		throws java.io.IOException {

		return _offerService.exportOffer(offerId, locale, baos);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getOffer(
			String publicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.getOffer(publicationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offerService.getOSGiServiceIdentifier();
	}

	@Override
	public OfferService getWrappedService() {
		return _offerService;
	}

	@Override
	public void setWrappedService(OfferService offerService) {
		_offerService = offerService;
	}

	private OfferService _offerService;

}