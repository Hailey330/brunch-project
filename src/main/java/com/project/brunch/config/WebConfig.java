package com.project.brunch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.brunch.config.aop.RoleInterceptor;

// 필터링
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new RoleInterceptor())
			.addPathPatterns("/brunch/admin/**");
	}
	
}
