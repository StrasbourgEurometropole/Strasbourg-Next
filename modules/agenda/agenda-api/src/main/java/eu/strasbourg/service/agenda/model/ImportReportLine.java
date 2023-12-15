/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ImportReportLine service. Represents a row in the &quot;agenda_ImportReportLine&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see ImportReportLineModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.ImportReportLineImpl"
)
@ProviderType
public interface ImportReportLine
	extends ImportReportLineModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.ImportReportLineImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImportReportLine, Long> LINE_ID_ACCESSOR =
		new Accessor<ImportReportLine, Long>() {

			@Override
			public Long get(ImportReportLine importReportLine) {
				return importReportLine.getLineId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ImportReportLine> getTypeClass() {
				return ImportReportLine.class;
			}

		};

	public void error(String cause);

	public boolean hasError();

}