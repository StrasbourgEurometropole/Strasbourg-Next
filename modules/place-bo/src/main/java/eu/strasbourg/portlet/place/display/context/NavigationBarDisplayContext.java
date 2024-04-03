package eu.strasbourg.portlet.place.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static eu.strasbourg.portlet.place.constants.PlaceConstants.*;

public class NavigationBarDisplayContext {
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedCmd;
    private final String selectedMvcPath;
    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());


    public NavigationBarDisplayContext(RenderRequest request, RenderResponse response) {
        this.response = response;
        // onglet par défaut -> PLACES
        this.selectedTab = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_TAB))
                .filter(Validator::isNotNull)
                .orElse(PLACES);
        this.selectedCmd = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_CMD))
                .filter(Validator::isNotNull)
                .orElse("");
        this.selectedMvcPath = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_MVCPATH))
                .filter(Validator::isNotNull)
                .orElse("");
    }

    public String getSelectedTab() {
        return selectedTab;
    }
    @SuppressWarnings("unused")
    public String getSelectedCmd() {
        return selectedCmd;
    }
    @SuppressWarnings("unused")
    public String getSelectedMvcPath() {
        return selectedMvcPath;
    }

    public List<NavigationItem> getNavigationItems() {
        List<NavigationItem> navigationItems = new ArrayList<>();

        NavigationItem placeItem = new NavigationItem();
        placeItem.setLabel(LanguageUtil.get(bundle, "places"));
        placeItem.setActive(this.selectedTab.equals(PLACES));
        placeItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PLACES, URL_PARAM_MVCPATH, PLACES_PATH);
        navigationItems.add(placeItem);


        NavigationItem priceItem = new NavigationItem();
        priceItem.setLabel(LanguageUtil.get(bundle, "prices"));
        priceItem.setActive(this.selectedTab.equals(PRICES));
        priceItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PRICES, URL_PARAM_MVCPATH, PRICES_PATH);
        navigationItems.add(priceItem);

        NavigationItem publicHolidayItem = new NavigationItem();
        publicHolidayItem.setLabel(LanguageUtil.get(bundle, "public-holidays"));
        publicHolidayItem.setActive(this.selectedTab.equals(PUBLIC_HOLIDAYS));
        publicHolidayItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PUBLIC_HOLIDAYS, URL_PARAM_MVCPATH, PUBLIC_HOLIDAYS_PATH);
        navigationItems.add(publicHolidayItem);

        NavigationItem subPlaceItem = new NavigationItem();
        subPlaceItem.setLabel(LanguageUtil.get(bundle, "sub-places"));
        subPlaceItem.setActive(this.selectedTab.equals(SUB_PLACES));
        subPlaceItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, SUB_PLACES, URL_PARAM_MVCPATH, SUB_PLACES_PATH);
        navigationItems.add(subPlaceItem);

        NavigationItem importItem = new NavigationItem();
        importItem.setLabel(LanguageUtil.get(bundle, "place-import"));
        importItem.setActive(this.selectedTab.equals(IMPORTS));
        importItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, IMPORTS,URL_PARAM_MVCPATH, IMPORTS_PATH);
        navigationItems.add(importItem);

        NavigationItem googleItem = new NavigationItem();
        googleItem.setLabel(LanguageUtil.get(bundle, "gmb-synchro"));
        googleItem.setActive(this.selectedTab.equals(GOOGLE));
        googleItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, GOOGLE,URL_PARAM_MVCPATH, GOOGLE_PATH);
        navigationItems.add(googleItem);

        NavigationItem tokenItem = new NavigationItem();
        tokenItem.setLabel(LanguageUtil.get(bundle, "gmb-config"));
        tokenItem.setActive(this.selectedTab.equals(TOKEN));
        tokenItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, TOKEN,URL_PARAM_MVCPATH, TOKEN_PATH);
        navigationItems.add(tokenItem);

        return navigationItems;
    }
}