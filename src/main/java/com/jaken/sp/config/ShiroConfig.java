package com.jaken.sp.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jaken.sp.entity.User;
import com.jaken.sp.entity.security.Principal;
import com.jaken.sp.service.UserService;

@Configuration
public class ShiroConfig {

	@Autowired
	private UserService userService;
	
	@Bean(name="shiroFilter")
	@Autowired
	public ShiroFilterFactoryBean getFilterFactory(DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean sff=new ShiroFilterFactoryBean();
		sff.setSecurityManager(securityManager);
		
		sff.setFilters(genFilterMap());
		sff.setFilterChainDefinitions(getFilterDefinition());
		sff.setLoginUrl("login");
		sff.setSuccessUrl("welcome");
		sff.setUnauthorizedUrl("fail");
		return sff;
	}
	
	@Bean(name="securityManager")
	@Autowired
	public DefaultWebSecurityManager getDefaultSecurityManager(DefaultWebSessionManager sessionManager,CacheManager cacheManager){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		AuthorizingRealm ar=new AuthorizingRealm() {
			@Override
			protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
				UsernamePasswordToken upt=(UsernamePasswordToken)token;
				String userName=upt.getUsername();
				String password=new String(upt.getPassword());
				User user=new User();
				user.setUserName(userName);
				user.setPassword(password);
				int usercount=userService.count(user);
				if(usercount<1){
					return null;
				}
				return new SimpleAuthenticationInfo(new Principal(userName,password),password.toCharArray()
						,ByteSource.Util.bytes(password.toCharArray()),userName);
			}
			
			@Override
			protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
				return null;
			}
		};
		securityManager.setRealm(ar);
		securityManager.setSessionManager(sessionManager);
		securityManager.setCacheManager(cacheManager);
		return securityManager;
	}
	
	@Bean(name="sessionManager")
	@Autowired
	public DefaultWebSessionManager getDefaultSessionManager(){
		DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
		SessionDAO sessionDao=new EnterpriseCacheSessionDAO();
		sessionManager.setSessionDAO(sessionDao);
		sessionManager.setGlobalSessionTimeout(30000000);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		return sessionManager;
	}
	
	@Bean(name="cacheManager")
	public EhCacheManager getCacheManager(){
		EhCacheManager cacheManager=new EhCacheManager();
		return cacheManager;
	}
	
	private Map<String, Filter> genFilterMap(){
		CasFilter casFilter=new CasFilter();
		casFilter.setFailureUrl("fail");
//		FormAuthenticationFilter formFilter=new FormAuthenticationFilter();
		SpFormAuthencationFilter formFilter=new SpFormAuthencationFilter();
		Map<String, Filter> filtermap=new HashMap<String,Filter>();
//		filtermap.put("casFilter", casFilter);
		filtermap.put("formFilter",formFilter);
		return filtermap;
	}
	
	private String getFilterDefinition(){
		return "/static/** = anon\r\n" + 
				"				/login = authc\r\n" + 
				"				/logout = logout\r\n" ;
	}
	
	 @Bean(name = "lifecycleBeanPostProcessor")  
	    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {  
	        return new LifecycleBeanPostProcessor();  
	    }  
	  
	    @Bean  
	    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {  
	        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();  
	        daap.setProxyTargetClass(true);  
	        return daap;  
	    }
}
