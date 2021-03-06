package eu.strasbourg.service.office.exporter.api;

import java.io.OutputStream;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import eu.strasbourg.service.agenda.model.EventParticipation;

@ProviderType
public interface EventParticipationsXlsxExporter {
	
	public void exportEventParticipations(OutputStream stream, long eventId);
	
	public void exportEventParticipations(OutputStream stream, String eventTitle, List<EventParticipation> eventParticipations);

}
