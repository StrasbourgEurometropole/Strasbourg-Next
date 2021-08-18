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
package eu.strasbourg.service.place.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Angelique Zunino Champougny
 */
@ProviderType
public class NoSuchCacheJsonException extends NoSuchModelException {

	public NoSuchCacheJsonException() {
	}

	public NoSuchCacheJsonException(String msg) {
		super(msg);
	}

	public NoSuchCacheJsonException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCacheJsonException(Throwable cause) {
		super(cause);
	}

}