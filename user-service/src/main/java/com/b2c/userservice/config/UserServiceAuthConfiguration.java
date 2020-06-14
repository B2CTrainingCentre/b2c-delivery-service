package com.b2c.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.b2c.userservice.security.RestAuthentication;
@EnableWebSecurity
@Configuration
public class UserServiceAuthConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private RestAuthentication restAuthentication;

	// Configure in memory authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN").and()
				.withUser("user").password(encoder().encode("userPass")).roles("USER");
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().and().exceptionHandling().authenticationEntryPoint(restAuthentication)
				.and().authorizeRequests()
				.antMatchers("/v1/insertcustomer").access("hasRole('ADMIN')") // Place secure uri under this
				.antMatchers("/v1/insertcustomer").access("hasRole('USER')")
				.antMatchers("/v1/fetchcustomer").access("hasRole('USER')")
				.antMatchers("/v1/updatecustomer").access("hasRole('USER')")
				.antMatchers("/v1/deactivecustomer").access("hasRole('USER')")
				.antMatchers("/v1/insertagent").access("hasRole('USER')")
				.antMatchers("/v1/fetchagent").access("hasRole('USER')")
				.antMatchers("/v1/updateagent").access("hasRole('USER')")
				.antMatchers("/v1/deactiveagent").access("hasRole('USER')")
				.antMatchers("/v1/insertstore").access("hasRole('USER')")
				.antMatchers("/v1/fetchstore").access("hasRole('USER')")
				.antMatchers("/v1/updatestore").access("hasRole('USER')")
				.antMatchers("/v1/deactivestore").access("hasRole('USER')")
				.anyRequest().authenticated().and().httpBasic().and()
				.logout();
	}


}
