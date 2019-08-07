package com.cafe24.pjshop.frontend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import com.cafe24.pjshop.frontend.dto.JSONResult2;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String accept = request.getHeader("accept");

		SecurityUser securityUser = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal != null && principal instanceof UserDetails) {
				securityUser = (SecurityUser) principal;
			}
		}
		
		if (accept == null || accept.matches(".*application/json.*") == false) {

			String splitStr = request.getServerPort() + request.getContextPath();
			int subStrNo = request.getHeader("referer").indexOf(splitStr);
			String requestUrl = request.getHeader("referer").substring(subStrNo + splitStr.length());

			if(requestUrl.equals("/admin/login")) { }
			
			getRedirectStrategy().sendRedirect(request, response, "/user/login");
			return;
		}
	 
	}
}