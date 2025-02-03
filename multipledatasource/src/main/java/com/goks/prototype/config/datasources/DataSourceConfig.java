package com.goks.prototype.config.datasources;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * PackageName    : com.goks.prototype.config.datasources
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : DataSourceConfig
 * Description    :
 */
@Configuration
@EnableJpaRepositories(
		basePackages = "com.goks.prototype.biz.position",
		transactionManagerRef = "transcationManager",
		entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean
	@Primary
	public DataSource dataSource() {
		DatasourceRouting routingDataSource = new DatasourceRouting();
		routingDataSource.initDatasource(siteADataSource(),
				siteBDataSource());
		return routingDataSource;
	}


	public DataSource siteADataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:postgresql://localhost:5432/siteA")
				.driverClassName("org.postgresql.Driver")
				.username("postgres")
				.password("circle0124")
				.type(HikariDataSource.class)
				.build();
	}

	public DataSource siteBDataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:postgresql://localhost:5432/siteB")
				.driverClassName("org.postgresql.Driver")
				.username("postgres")
				.password("circle0124")
				.type(HikariDataSource.class)
				.build();
	}

	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource()).packages("com.goks.prototype.biz.position")
				.build();
	}

	@Bean(name = "transcationManager")
	public PlatformTransactionManager transactionManager (
			LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
		return transactionManager;
	}
}
