package com.goks.prototype.config;

import com.goks.prototype.config.datasources.DataSourceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * PackageName    : com.goks.prototype.config
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : WebConfig
 * Description    :
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private DataSourceInterceptor dataSourceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(dataSourceInterceptor);
	}
}
