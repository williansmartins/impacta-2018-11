package com.jwtme.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.web.filter.GenericFilterBean;

public class JWTRestritoFilter extends GenericFilterBean {
	
	private String url;

	public JWTRestritoFilter(String url) {
		this.url = url;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println(url);
		
//		Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		filterChain.doFilter(request, response);
	}

}
