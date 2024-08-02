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

package eu.strasbourg.service.place.model.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.models.Pair;

import java.text.DateFormat;
import java.time.LocalTime;

/**
 * @author Angelique Zunino Champougny
 */
public class PublicHolidayImpl extends PublicHolidayBaseImpl {

    /**
     * Retourne la version JSON des jours fériés
     */
    @Override
    public JSONObject toJSON() {
        JSONObject publicHolidayJSON = JSONFactoryUtil.createJSONObject();

        publicHolidayJSON.put("description",
                JSONHelper.getJSONFromI18nMap(this.getNameMap()));
        DateFormat dateFormat = DateFormatFactoryUtil
                .getSimpleDateFormat("yyyy-MM-dd");
        publicHolidayJSON.put("startDate",
                dateFormat.format(this.getDate()));
        publicHolidayJSON.put("endDate",
                dateFormat.format(this.getDate()));
        publicHolidayJSON.put("closed", true);

        return publicHolidayJSON;
    }
}