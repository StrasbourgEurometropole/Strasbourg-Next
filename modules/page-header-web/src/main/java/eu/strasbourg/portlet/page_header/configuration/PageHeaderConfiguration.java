package eu.strasbourg.portlet.page_header.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	category = "Strasbourg",
	scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(
	id = "eu.strasbourg.portlet.page_header.configuration.PageHeaderConfiguration",
	localization = "content/Language",
	name = "portlet.page_header.configuration.name")
public interface PageHeaderConfiguration {
	
	@Meta.AD(name="imageCredit", deflt = "", required = false)
	public String imageCredit();

	@Meta.AD(name="titleXML", deflt = "", required = false)
	public String titleXML();

	@Meta.AD(name="subTitleXML", deflt = "", required = false)
	public String subTitleXML();

	@Meta.AD(name="imageUrlXML", deflt = "", required = false)
	public String imageUrlXML();

}
