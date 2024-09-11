package eu.strasbourg.service.office.exporter.api;

import aQute.bnd.annotation.ProviderType;

import java.io.OutputStream;

@ProviderType
public interface PetitionsXlsxExporter {

    void exportPetitions(OutputStream stream);
}
