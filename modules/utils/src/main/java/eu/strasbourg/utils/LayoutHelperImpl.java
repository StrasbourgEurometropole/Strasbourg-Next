package eu.strasbourg.utils;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.NavItem;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.utils.api.LayoutHelperService;
import org.osgi.service.component.annotations.Component;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Implémentation du service LayoutHelperService N'est qu'une couche accessible
 * par les templates FreeMarker qui délègue le travail à une classe helper
 */
@Component(immediate = true, property = {}, service = LayoutHelperService.class)
public class LayoutHelperImpl implements LayoutHelperService {

	@Override
	public String getLayoutPath(Layout layout, Locale locale) {
		return LayoutHelper.getLayoutPath(layout, locale);
	}

	@Override
	public String getJournalArticleLayoutURL(long groupId, String articleId, ThemeDisplay themeDisplay) {
		return LayoutHelper.getJournalArticleLayoutURL(groupId, articleId, themeDisplay);
	}

	/**
	 * TODO : appeler les méthodes statiques du Helper associé
	 */
	@Override
	public String getPublikLoginURL(String currentURL) throws MalformedURLException, UnsupportedEncodingException {
		URL url = new URL(currentURL);
		Map<String, List<String>> params;
		try {
			params = getQueryParams(url);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException(e.getMessage() + "url = " + currentURL);
		}
		String loginURL = url.toString().split("\\?")[0].split("\\#")[0];
		loginURL += "?";
		for (Map.Entry<String, List<String>> param : params.entrySet()) {
			if (!param.getKey().equals("logout")) {
				for (String paramValue : param.getValue()) {
					loginURL += param.getKey() + "=" + paramValue + "&";
				}
			}
		}
		loginURL += "auth=publik";
		return loginURL;
	}

	@Override
	public String getPublikLogoutURL(String currentURL) throws MalformedURLException, UnsupportedEncodingException {
		URL url = new URL(currentURL);
		Map<String, List<String>> params = getQueryParams(url);
		String logoutURL = url.toString().split("\\?")[0].split("\\#")[0];
		logoutURL += "?";
		for (Map.Entry<String, List<String>> param : params.entrySet()) {
			if (!param.getKey().equals("auth")) {
				for (String paramValue : param.getValue()) {
					logoutURL += param.getKey() + "=" + paramValue + "&";
				}
			}
		}
		logoutURL += "logout=true";
		return logoutURL;
	}

	/**
	 * TODO : appeler les méthodes statiques du Helper associé
	 */
	public static Map<String, List<String>> getQueryParams(URL url)
			throws UnsupportedEncodingException {
		final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
		final String[] pairs = url.getQuery() != null ? url.getQuery().split("&") : new String[0];
		for (String pair : pairs) {
			final int idx = pair.indexOf("=");
			final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
			if (!query_pairs.containsKey(key)) {
				query_pairs.put(key, new LinkedList<String>());
			}
			final String value = idx > 0 && pair.length() > idx + 1
					? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
			query_pairs.get(key).add(value);
		}
		return query_pairs;
	}

	@Override
	public String getPublikProfileURL() {
		return StrasbourgPropsUtil.getPublikProfileURL();
	}

	@Override
	public List<NavItem> filterLayouts(List<NavItem> navItems, String categoryName) {
		return LayoutHelper.filterLayouts(navItems, categoryName);
	}

    @Override
    public String getDashboardURL() {
        return StrasbourgPropsUtil.getDashboardURL();
    }
    
    @Override
    public String getPublikIssuerURL() {
        return StrasbourgPropsUtil.getPublikIssuer();
    }

	/**
	 * Retourne true si la page a des enfants visibles. False sinon.
	 */
	@Override
	public Boolean hasQuickAccess(NavItem navItem) throws Exception {
		boolean hasQuickAccess = false;

		for (NavItem subLayout : navItem.getChildren()) {
			if (subLayout.getName().equals("Raccourcis") || subLayout.getName().equals("Accès rapides")) {
				hasQuickAccess = true;
				break;
			}
		}

		return hasQuickAccess;
	}
}
