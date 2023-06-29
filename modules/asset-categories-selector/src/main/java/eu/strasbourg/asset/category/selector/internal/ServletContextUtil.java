package eu.strasbourg.asset.category.selector.internal;


import com.liferay.item.selector.ItemSelector;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;

@Component(immediate = true)
public class ServletContextUtil {

    private static ServletContextUtil _instance;

    public static ServletContext getServletContext() {
        return _instance._getServletContext();
    }

    public static ItemSelector getItemSelector() {
        return _instance._getItemSelector();
    }

    private ServletContext _servletContext;
    private ItemSelector _itemSelector;

    private ServletContext _getServletContext() {
        return _servletContext;
    }

    private ItemSelector _getItemSelector() {
        return _itemSelector;
    }

    @Activate
    protected void activate() {
        _instance = this;
    }

    @Deactivate
    protected void deactivate() {
        _instance = null;
    }

    @Reference(target = "(osgi.web.symbolicname=eu.strasbourg.asset.category.selector.taglib)", unbind = "-")
    protected void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference(unbind = "-")
    protected void setItemSelector(ItemSelector itemSelector) {
        _itemSelector = itemSelector;
    }

}
