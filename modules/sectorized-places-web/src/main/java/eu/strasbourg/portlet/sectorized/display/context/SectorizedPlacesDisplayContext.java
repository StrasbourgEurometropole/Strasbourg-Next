package eu.strasbourg.portlet.sectorized.display.context;

import eu.strasbourg.service.place.model.Place;

import java.util.HashMap;
import java.util.Map;

public class SectorizedPlacesDisplayContext {

	public Map<String, Object> getContextObjects(Place place) {
		Map<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("entry", place);
		return contextObjects;
	}
}
