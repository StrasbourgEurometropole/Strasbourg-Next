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

package eu.strasbourg.service.video.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;video_VideoToVideoGallery&quot; database table.
 *
 * @author BenjaminBini
 * @see Video
 * @see VideoGallery
 * @generated
 */
public class video_VideoToVideoGalleryTable
	extends BaseTable<video_VideoToVideoGalleryTable> {

	public static final video_VideoToVideoGalleryTable INSTANCE =
		new video_VideoToVideoGalleryTable();

	public final Column<video_VideoToVideoGalleryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<video_VideoToVideoGalleryTable, Long> videoId =
		createColumn("videoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<video_VideoToVideoGalleryTable, Long> galleryId =
		createColumn(
			"galleryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private video_VideoToVideoGalleryTable() {
		super("video_VideoToVideoGallery", video_VideoToVideoGalleryTable::new);
	}

}