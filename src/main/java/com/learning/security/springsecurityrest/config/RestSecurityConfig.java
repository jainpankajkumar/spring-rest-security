package com.learning.security.springsecurityrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@EnableWebSecurity
@Configuration
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    @Qualifier("myAccessDeniedHandler")
    AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
    @Qualifier("CustomAuthenticationFailureHandler")
	AuthenticationFailureHandler authFailureHandler;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN")
			.and()
			.withUser("employee").password("employee").roles("EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.authorizeRequests()
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.formLogin()
		.failureHandler(authFailureHandler)
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
		.and()
		.httpBasic();
		httpSecurity.csrf().disable();
	}

}
