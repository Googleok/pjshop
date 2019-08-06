package com.cafe24.pjshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();

		// �ڿ� ���� ���� ���� ����
		http
			.authorizeRequests()
			.antMatchers("/api/admin/category").access("#oauth2.hasScope('read')")
			.anyRequest().permitAll();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer securityConfigure) throws Exception {
		securityConfigure.resourceId("pjshop_api_v1");
		//securityConfigure.tokenServices(tokenServices)
	}
	
	
}
