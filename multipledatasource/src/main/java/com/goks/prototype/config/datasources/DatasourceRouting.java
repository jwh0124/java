package com.goks.prototype.config.datasources;

import com.goks.prototype.config.enums.TenancyEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * PackageName    : com.goks.prototype.config.datasources
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : DatasourceRouting
 * Description    :
 */
public class DatasourceRouting extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return TenancyContextHolder.getTenancyContext();
	}

	public void initDatasource(DataSource siteADataSource,
	                           DataSource siteBDataSource) {
		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put(TenancyEnum.SiteA, siteADataSource);
		dataSourceMap.put(TenancyEnum.SiteB, siteBDataSource);
		this.setTargetDataSources(dataSourceMap);
		this.setDefaultTargetDataSource(siteADataSource);
	}
}
