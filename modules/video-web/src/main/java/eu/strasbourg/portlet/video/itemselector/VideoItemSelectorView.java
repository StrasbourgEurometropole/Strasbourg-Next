package eu.strasbourg.portlet.video.itemselector;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.servlet.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Component(property = { "item.selector.view.order:Integer=200" }, service = ItemSelectorView.class)
public class VideoItemSelectorView implements ItemSelectorView<VideoItemSelectorCriterion> {

	private ServletContext _servletContext;

	private static final List<ItemSelectorReturnType> _supportedItemSelectorReturnTypes = Collections
			.unmodifiableList(ListUtil.fromArray(new URLItemSelectorReturnType()));

	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Reference(target = "(osgi.web.symbolicname=video.web)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		this._servletContext = servletContext;
	}

	@Override
	public Class<VideoItemSelectorCriterion> getItemSelectorCriterionClass() {
		return VideoItemSelectorCriterion.class;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes;
	}

	@Override
	public String getTitle(Locale locale) {
		return "Videos";
	}

	@Override
	public boolean isVisible(ThemeDisplay themeDisplay) {
		return true;
	}

	@Override
	public void renderHTML(ServletRequest servletRequest, ServletResponse servletResponse,
			VideoItemSelectorCriterion itemSelectorCriterion, PortletURL portletURL, String itemSelectedEventName,
			boolean search) throws IOException, ServletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) servletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean multiple = GetterUtil.getBoolean(servletRequest.getParameter("multiple"), false);
		// TODO : A corriger lorsque portlet 3.0 OK sur itemSelectorPortlet
		portletURL.setParameter("multiple", String.valueOf(multiple));

		int delta = GetterUtil.getInteger(servletRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM),
				SearchContainer.DEFAULT_DELTA);

		int cur = GetterUtil.getInteger(servletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM),
				SearchContainer.DEFAULT_CUR);

		String keywords = GetterUtil.getString(servletRequest.getParameter("keywords"));

		long filterGroupId = GetterUtil.getLong(servletRequest.getParameter("filterGroupId"));
		if (filterGroupId == 0) {
			filterGroupId = themeDisplay.getScopeGroupId();
		}
		// TODO : A corriger lorsque portlet 3.0 OK sur itemSelectorPortlet
		portletURL.setParameter("filterGroupId", String.valueOf(filterGroupId));

		List<Video> videos = VideoLocalServiceUtil.findByKeyword(keywords, filterGroupId, (delta * cur) - delta,
				(delta * cur));

		long videosCount = VideoLocalServiceUtil.findByKeywordCount(keywords, filterGroupId);
		List<DropdownItem> groupFilterItems = getFilterGroupDropdownItems(portletURL, themeDisplay.getCompanyId(),
				filterGroupId);
		servletRequest.setAttribute("total", videosCount);
		servletRequest.setAttribute("videos", videos);
		servletRequest.setAttribute("portletURL", portletURL);
		servletRequest.setAttribute("itemSelectedEventName", itemSelectedEventName);
		servletRequest.setAttribute("multiple", multiple);
		servletRequest.setAttribute("groupFilterItems", groupFilterItems);
		Group filterGroup = GroupLocalServiceUtil.fetchGroup(filterGroupId);
		if (filterGroup != null) {
			servletRequest.setAttribute("filterGroupName", filterGroup.getName(Locale.FRANCE));
		}
		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher = servletContext
				.getRequestDispatcher("/video/item-selector/video-item-selector.jsp");

		requestDispatcher.include(servletRequest, servletResponse);
	}


	protected List<DropdownItem> getFilterGroupDropdownItems(PortletURL portletURL, long currentCompanyId,
																  long filterGroupId) {
		List<DropdownItem> filterVocabularyDropdownItems = new DropdownItemList();
		List<Group> groups = GroupLocalServiceUtil.getCompanyGroups(currentCompanyId, -1, -1);

		for (Group group : groups) {
			if (Validator.isNotNull(group.getName(Locale.FRANCE)) && group.getType() == 1) {
				boolean isActive = group.getGroupId() == filterGroupId;
				portletURL.setParameter("filterGroupId", String.valueOf(group.getGroupId()));
				portletURL.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA));
				filterVocabularyDropdownItems.add(
						DropdownItemBuilder
								.setActive(isActive)
								.setHref(portletURL)
								.setLabel(group.getName(Locale.FRANCE))
								.build()
				);
			}
		}

		return filterVocabularyDropdownItems;
	}


}
