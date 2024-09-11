package eu.strasbourg.portlet.project.itemselector;

import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.servlet.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author Joshua Chacha
 */
@Component(
        property = {"item.selector.view.order:Integer=200"},
        service = ItemSelectorView.class)
public class SaisineObservatoireItemSelectorView implements ItemSelectorView<SaisineObservatoireItemSelectorCriterion> {

    private ServletContext _servletContext;

    private static final List<ItemSelectorReturnType> _supportedItemSelectorReturnTypes = Collections
            .unmodifiableList(ListUtil.fromArray(new URLItemSelectorReturnType()));

    public ServletContext getServletContext() {
        return _servletContext;
    }

    @Reference(target = "(osgi.web.symbolicname=project.web)", unbind = "-")
    public void setServletContext(ServletContext _servletContext) {
        this._servletContext = _servletContext;
    }

    @Override
    public Class<SaisineObservatoireItemSelectorCriterion> getItemSelectorCriterionClass() {
        return SaisineObservatoireItemSelectorCriterion.class;
    }

    @Override
    public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
        return _supportedItemSelectorReturnTypes;
    }

    @Override
    public String getTitle(Locale locale) {
        return "Saisines observatoire";
    }

    @Override
    public boolean isVisible(ThemeDisplay themeDisplay) {
        return true;
    }

    @Override
    public void renderHTML(ServletRequest servletRequest,
                           ServletResponse servletResponse,
                           SaisineObservatoireItemSelectorCriterion itemSelectorCriterion,
                           PortletURL portletURL, String itemSelectedSaisineObservatoireName,
                           boolean search) throws IOException, ServletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) servletRequest
                .getAttribute(WebKeys.THEME_DISPLAY);

        boolean multiple = GetterUtil.getBoolean(servletRequest.getParameter("multiple"), false);
        // TODO : A corriger lorsque portlet 3.0 OK sur itemSelectorPortlet
        portletURL.setParameter("multiple", String.valueOf(multiple));

        int delta = GetterUtil.getInteger(servletRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM),
                SearchContainer.DEFAULT_DELTA);

        int cur = GetterUtil.getInteger(
                servletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM),
                SearchContainer.DEFAULT_CUR);

        String keywords = GetterUtil.getString(servletRequest.getParameter("keywords"));

        long scopeGroupId = themeDisplay.getScopeGroupId();
        List<SaisineObservatoire> saisineObservatoires = SaisineObservatoireLocalServiceUtil.findByKeyword(
                keywords,
                scopeGroupId,
                ((delta * cur) - delta),
                (delta * cur));

        long saisineObservatoireCount = SaisineObservatoireLocalServiceUtil
                .findByKeywordCount(keywords, scopeGroupId);

        servletRequest.setAttribute("total", saisineObservatoireCount);
        servletRequest.setAttribute("saisineObservatoires", saisineObservatoires);
        servletRequest.setAttribute("portletURL", portletURL);
        servletRequest.setAttribute("itemSelectedSaisineObservatoireName", itemSelectedSaisineObservatoireName);
        servletRequest.setAttribute("multiple", multiple);

        ServletContext servletContext = getServletContext();

        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(
                "/saisine-observatoire/item-selector/saisine-observatoire-item-selector.jsp");

        requestDispatcher.include(servletRequest, servletResponse);

    }
}
