package eu.strasbourg.portlet.form_send.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "Strasbourg", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "eu.strasbourg.portlet.form_send.configuration.FormSendConfiguration",
        localization = "content/Language", name = "portlet.form_send.configuration.name")
public interface FormSendConfiguration {

    @Meta.AD(name = "title", deflt = "", required = false)
    public String title();

    @Meta.AD(name = "nbEntries", deflt = "", required = false)
    public String nbEntries();

    @Meta.AD(name = "message", deflt = "", required = false)
    public String message();

    @Meta.AD(name = "formInstanceId", deflt = "", required = false)
    public String formInstanceId();

    @Meta.AD(name = "fieldsSelected", required = false)
    public String fieldsSelected();

    @Meta.AD(name = "newLibs", required = false)
    public String newLibs();

    @Meta.AD(name = "template", required = false)
    public String template();

    @Meta.AD(name = "defaultSort", required = false, deflt = "asc")
    public String defaultSort();

}
