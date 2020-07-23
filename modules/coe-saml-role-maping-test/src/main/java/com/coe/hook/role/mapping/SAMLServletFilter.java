package com.coe.hook.role.mapping;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Component (
	immediate = true,
	property = {
	        "servlet-context-name=",
	        "servlet-filter-name=LifeDev SAML ACS Filter",
	        "url-pattern=/c/portal/saml/acs"
	},		
	service = Filter.class
)
public class SAMLServletFilter implements Filter {
	
private static Log _log = LogFactoryUtil.getLog(SAMLServletFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String samlResponse = ParamUtil.get(httpServletRequest, "SAMLResponse", "");
		
		_log.info("Got SAML Response: " + samlResponse);
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		
		Cookie cookie = new Cookie("SAML_SP_KEY", randomUUIDString);
		httpServletResponse.addCookie(cookie);
		
		_portalCache.put(randomUUIDString, samlResponse);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Activate
	protected void activate() {
		_portalCache = (PortalCache<String, String>) _multiVMPool.getPortalCache(CACHE_NAME);
	}
	
	@Deactivate
	public void deactivate() {
	    _multiVMPool.removePortalCache(CACHE_NAME);
	}
	
	private static PortalCache<String, String> _portalCache;
	
	protected static final String CACHE_NAME = "SAMLResponse";
	
	@Reference
	private MultiVMPool _multiVMPool;

}
