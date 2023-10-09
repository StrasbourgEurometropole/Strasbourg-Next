package eu.strasbourg.portlet.project.itemselector;

import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Joshua Chacha
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class SaisineObservatoireItemSelectorCriterionHandler extends BaseItemSelectorCriterionHandler {

    @Override
    public Class getItemSelectorCriterionClass() {
        return SaisineObservatoireItemSelectorCriterion.class;
    }

    @Activate
    @Override
    protected void activate(BundleContext bundleContext){
        super.activate(bundleContext);
    }
}
