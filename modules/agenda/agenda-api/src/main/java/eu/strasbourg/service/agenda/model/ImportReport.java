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
 * The extended model interface for the ImportReport service. Represents a row in the &quot;agenda_ImportReport&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see ImportReportModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.ImportReportImpl"
)
@ProviderType
public interface ImportReport extends ImportReportModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.ImportReportImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImportReport, Long> REPORT_ID_ACCESSOR =
		new Accessor<ImportReport, Long>() {

			@Override
			public Long get(ImportReport importReport) {
				return importReport.getReportId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ImportReport> getTypeClass() {
				return ImportReport.class;
			}

		};

	public void globalError(String cause);

	public void incrementNewEvents();

	public void incrementNewManifestations();

	public void incrementModifiedEvents();

	public void incrementModifiedManifestations();

	public void incrementErrorEvents();

	public void incrementErrorManifestations();

	public void incrementUnmodifiedEvents();

	public void incrementUnmodifiedManifestations();

	public void incrementDeletedEvents();

	public void incrementDeletedManifestations();

	public java.util.List<ImportReportLine> getLines();

	public java.util.List<ImportReportLine> getNewManifestationsLines();

	public java.util.List<ImportReportLine> getModifiedManifestationsLines();

	public java.util.List<ImportReportLine> getErrorManifestationsLines();

	public java.util.List<ImportReportLine> getDeletedManifestationsLines();

	public java.util.List<ImportReportLine> getNewEventsLines();

	public java.util.List<ImportReportLine> getModifiedEventsLines();

	public java.util.List<ImportReportLine> getErrorEventsLines();

	public java.util.List<ImportReportLine> getDeletedEventsLines();

	public void sendMail();

}