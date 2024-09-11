package eu.strasbourg.language;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.resource.bundle.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.resource.bundle.CacheResourceBundleLoader;
import com.liferay.portal.kernel.resource.bundle.ClassResourceBundleLoader;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;


public class LoginResourceBundleLoaderComponent
	implements ResourceBundleLoader {

    @Override
    public ResourceBundle loadResourceBundle(Locale locale) {
        return _resourceBundleLoader.loadResourceBundle(locale);
    }
	  
	  @Reference(target = "(bundle.symbolic.name=com.liferay.login.web)")
      public void setResourceBundleLoader(
          ResourceBundleLoader resourceBundleLoader) {

          _resourceBundleLoader = new AggregateResourceBundleLoader(
              new CacheResourceBundleLoader(
                  new ClassResourceBundleLoader(
                      "login.Language",
                      LoginResourceBundleLoaderComponent.class.getClassLoader())),
              resourceBundleLoader);
      }

      private AggregateResourceBundleLoader _resourceBundleLoader;
}
