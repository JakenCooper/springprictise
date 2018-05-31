package com.jaken.sp.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class SpFormAuthencationFilter extends FormAuthenticationFilter{

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		UsernamePasswordToken token =new UsernamePasswordToken();
		token.setUsername(getUsername(request));
		token.setPassword(getPassword(request).toCharArray());
		return token;
	}

	@Override
	protected String getUsername(ServletRequest request) {
		return super.getUsername(request);
	}

	@Override
	protected String getPassword(ServletRequest request) {
		return super.getPassword(request);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		 request.setAttribute(getFailureKeyAttribute(), "");
		 return true;
	}
	
	
	
}
