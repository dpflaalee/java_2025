package com.thejoa.boot3.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Value("${upload.path}")
	private String uploadPath;
	
	@Value("${resource.path}")
	private String sesourcePath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(uploadPath) //해당 경로로 올리면 
				.addResourceLocations("file:"+sesourcePath); //실제는 이쪽으로 저장
	}
	
	
}
