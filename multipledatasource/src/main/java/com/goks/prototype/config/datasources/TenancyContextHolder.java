package com.goks.prototype.config.datasources;

import com.goks.prototype.config.enums.TenancyEnum;

/**
 * PackageName    : com.goks.prototype.config.datasources
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : NamedRoutingDataSources
 * Description    :
 */
public class TenancyContextHolder {

	private static final ThreadLocal<TenancyEnum> threadLocal = new ThreadLocal<>();

	public static void setTenancyContext(TenancyEnum tenancyEnum) { threadLocal.set(tenancyEnum); }

	public static TenancyEnum getTenancyContext() {
		return threadLocal.get();
	}

	public static void clearTenancyContext() {
		threadLocal.remove();
	}
}
