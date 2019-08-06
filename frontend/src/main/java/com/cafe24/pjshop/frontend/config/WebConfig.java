package com.cafe24.pjshop.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.pjshop.frontend.config.web.MVCConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.pjshop.frontend.controller", "com.cafe24.pjshop.frontend.exception"})
@Import({ MVCConfig.class })
public class WebConfig {
}