package com.cafe24.pjshop.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cafe24.security.AuthInterceptor;
import com.cafe24.security.AuthLoginInterceptor;
import com.cafe24.security.AuthLogoutInterceptor;
import com.cafe24.security.AuthUserHandlerMethodArgumentResolver;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = { "com.cafe24.pjshop" })
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Message Converter
	 * 
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {

		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().indentOutput(true)
				.dateFormat(new SimpleDateFormat("yyyy-MM-dd")).modulesToInstall(new ParameterNamesModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(builder.build());
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", Charset.forName("UTF-8"))));
		return converter;

	}
	
	@Bean
	public RestTemplate getRestTemplate() {
	   return new RestTemplate();
	}
	   
	@Bean
	public AlwaysSampler alwaysSampler() {
	   return new AlwaysSampler();
	}

	/**
	 * Message Converter
	 * 
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {

		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "html", Charset.forName("UTF-8"))));

		return converter;
	}

	/**
	 * Message Converter
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
		converters.add(stringHttpMessageConverter());
	}

	/**
	 * Argument Resolver
	 * 
	 * @return
	 */
	@Bean
	public AuthUserHandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}

	/**
	 * Argument Resolver
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(authUserHandlerMethodArgumentResolver());
	}

	/**
	 * AuthLoginInterceptor
	 * 
	 * @return
	 */
	@Bean
	public AuthLoginInterceptor authLoginInterceptor() {
		return new AuthLoginInterceptor();
	}

	/**
	 * AuthLogoutInterceptor
	 * 
	 * @return
	 */
	@Bean
	public AuthLogoutInterceptor authLogoutInterceptor() {
		return new AuthLogoutInterceptor();
	}

	/**
	 * AuthInterceptor
	 * 
	 * @return
	 */
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}

	/**
	 * Add Interceptor
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authLoginInterceptor()).addPathPatterns("/user/auth");

		registry.addInterceptor(authLogoutInterceptor()).addPathPatterns("/user/logout");

		registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/auth")
				.excludePathPatterns("/user/logout").excludePathPatterns("/assets/**");
	}

	/**
	 * Swagger 설정
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cafe24.pjshop.controller.api"))
				.paths(PathSelectors.any()).build();
	}

	// static 리소스 처리
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {}

	@Override
	public void addFormatters(FormatterRegistry registry) {}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
