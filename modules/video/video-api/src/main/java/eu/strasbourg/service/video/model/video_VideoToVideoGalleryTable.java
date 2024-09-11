/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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