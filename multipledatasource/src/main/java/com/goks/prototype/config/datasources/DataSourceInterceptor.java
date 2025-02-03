package com.goks.prototype.config.datasources;

import com.goks.prototype.config.enums.TenancyEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * PackageName    : com.goks.prototype.config.datasources
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : DataSourceInterceptor
 * Description    :
 */
@Component
public class DataSourceInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response, Object handler) throws Exception {
		String site = request.getHeader("tenancy");
		if (TenancyEnum.SiteA.toString().equals(site))
			TenancyContextHolder.setTenancyContext(TenancyEnum.SiteA);
		else
			TenancyContextHolder.setTenancyContext(TenancyEnum.SiteB);
		return true;
	}
}
