package com.b2c.userservice.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
@Configuration
public class UserServiceDbConfiguration {
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;	
	@Value("${db.password}")
	private String password;
	@Value("${db.driver}")
	private String driver;

	@Bean
	DataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setUrl(url);
		source.setUsername(username);
		System.out.println("Username::::::::::::::::::::::::::::"+username);
		System.out.println("Password::::::::::::::::::::::::::::"+password);
		source.setPassword(password);
		source.setMinIdle(5);
		source.setMaxIdle(5);
		source.setMaxOpenPreparedStatements(100);
		source.setDriverClassName(driver);
		return source;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSourceTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
