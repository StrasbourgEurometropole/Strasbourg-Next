package eu.strasbourg.portlet.place_schedule.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "Strasbourg", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "eu.strasbourg.portlet.place_schedule.configuration.PlaceScheduleConfiguration", localization = "content/Language", name = "portlet.place_schedule.configuration.name")
public interface PlaceScheduleConfiguration {

	@Meta.AD(name = "categoryId", required = false)
	public long categoryId();

	@Meta.AD(name = "categoryTitle", deflt = "", required = false)
	public String categoryTitle();

	@Meta.AD(name = "textScheduleXML", deflt = "", required = false)
	public String textScheduleXML();

	@Meta.AD(name="linksUuids", deflt = "", required = false)
	public String linksUuids();

	@Meta.AD(name="template", deflt = "", required = false)
	public String template();

	@Meta.AD(name = "hideAffluence", required = false)
	public boolean hideAffluence();

}
