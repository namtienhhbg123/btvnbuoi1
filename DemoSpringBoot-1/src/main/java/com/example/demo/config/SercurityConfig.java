package com.example.demo.config;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountService accountService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// permit all la cho phép vào
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and()
			// form mà bắt buộc phải đăng nhập
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/login?success=true")
				.failureUrl("/login?success=false")
				.loginProcessingUrl("/j_spring_security_check")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
				
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.inMemoryAuthentication()
			.withUser("user").password(passwordEncoder().encode("123")).authorities("ROLE_USER");
		
	}
	
	
}
