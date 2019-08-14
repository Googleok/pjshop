package com.cafe24.pjshop.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.pjshop.frontend.config.web.FileUploadConfig;
import com.cafe24.pjshop.frontend.config.web.MVCConfig;
import com.cafe24.pjshop.frontend.config.web.ZipkinConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.pjshop.frontend.controller", "com.cafe24.pjshop.frontend.exception"})
@Import({ MVCConfig.class, FileUploadConfig.class, ZipkinConfig.class })
public class WebConfig {
}
