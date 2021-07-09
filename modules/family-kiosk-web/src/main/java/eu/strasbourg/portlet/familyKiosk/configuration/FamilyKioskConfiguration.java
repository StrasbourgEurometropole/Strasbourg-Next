package eu.strasbourg.portlet.familyKiosk.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
		category = "Strasbourg", 
		scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "eu.strasbourg.portlet.familyKiosk.configuration.FamilyKioskConfiguration",
	localization = "content/Language", 
	name = "portlet.familySpace.configuration.name")
public interface FamilyKioskConfiguration {

	@Meta.AD(name = "introXML", deflt = "", required = false)
	public String introXML();

	@Meta.AD(name = "familyKioskURL", deflt = "", required = false)
	public String familyKioskURL();


	@Meta.AD(name = "requestsURL", deflt = "", required = false)
	public String requestsURL();

}
