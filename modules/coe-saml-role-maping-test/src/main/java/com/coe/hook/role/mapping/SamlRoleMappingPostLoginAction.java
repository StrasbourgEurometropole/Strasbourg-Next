package com.coe.hook.role.mapping;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.Cookie;

@Component(
        immediate = true, property = "key=login.events.post",
        service = LifecycleAction.class
)
public class SamlRoleMappingPostLoginAction implements LifecycleAction {

    private final Log _log = LogFactoryUtil.getLog(SamlRoleMappingPostLoginAction.class);

    @Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		String key = "";
		Cookie[] cookies = lifecycleEvent.getRequest().getCookies();
		for(int i = 0; i < cookies.length; i++) {
			if("SAML_SP_KEY".equals(cookies[i].getName())) {
				key = cookies[i].getValue();
				break;
			}
		}
		
		_log.info("SAML Response: " + _portalCache.get(key));
		
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
