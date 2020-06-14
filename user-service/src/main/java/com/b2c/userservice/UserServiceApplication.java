package com.b2c.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.b2c.userservice.config.UserServiceAuthConfiguration;
import com.b2c.userservice.config.UserServiceDbConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
@Import({UserServiceDbConfiguration.class, UserServiceAuthConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class UserServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UserServiceApplication.class);
	}

}
