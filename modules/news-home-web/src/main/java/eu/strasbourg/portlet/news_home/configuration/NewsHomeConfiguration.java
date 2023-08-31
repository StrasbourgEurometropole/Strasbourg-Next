package eu.strasbourg.portlet.news_home.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "Strasbourg", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "eu.strasbourg.portlet.news_home.configuration.NewsHomeConfiguration",
        localization = "content/Language", name = "portlet.news_home.configuration.name")

public interface NewsHomeConfiguration {

    @Meta.AD(name="classPKs", required = false)
    public String classPKs();

    @Meta.AD(name="link", required = false)
    public String link();
}
