package eu.strasbourg.service.office.exporter.api;

import aQute.bnd.annotation.ProviderType;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.project.model.Signataire;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@ProviderType
public interface PlaceXlsxExporter {
	
	public void export(OutputStream stream,  List<Place> places) throws IOException;
	
}
