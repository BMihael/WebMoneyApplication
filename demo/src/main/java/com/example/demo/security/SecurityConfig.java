package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DataSource dataSource;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		auth
			.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder)
			.withUser("admin").password(passwordEncoder.encode("adminpass")).roles("ADMIN","USER")
			.and()
			.withUser("user").password(passwordEncoder.encode("userpass")).roles("USER")
			.and()
			.withUser("belko").password(passwordEncoder.encode("belkopass")).roles("BELKO");
		*/
		
		
		auth
			.jdbcAuthentication()
	        .dataSource(dataSource)
	        .usersByUsernameQuery("select username, password, enabled from Users where username=?")
	        .authoritiesByUsernameQuery("select username, authority from Authorities where username=?")
	        .passwordEncoder(passwordEncoder);
		
	
	}
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	
		/*http
		.authorizeRequests()
		.antMatchers("/wallet/resetWallet", "/wallet/deleteWallet").hasRole("ADMIN")
		.antMatchers("/expenses/**", "wallet/**").hasRole("USER")
		.antMatchers("/images/**").permitAll()
		.antMatchers("/bootstrap-4.3.1/**").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/login").anonymous()
		.antMatchers("/**").authenticated()
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/", true)
        .and().logout().logoutSuccessUrl("/login?logout").permitAll()
        .and()
        .rememberMe()
        .and()
        .csrf().ignoringAntMatchers("/h2-console/**");
	 * 
	 * */
	
		http.authorizeRequests()
		.antMatchers("/h2-console").hasRole("ADMIN")
		.antMatchers("/api/**").hasRole("ADMIN")
		.antMatchers("/troskovi/novcanikSearch").hasRole("ADMIN")
		.antMatchers("/registration").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/login")
      		.anonymous()
      	.antMatchers("/**")
      		.authenticated()
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/index.html")
            .failureUrl("/login?error=true")
            .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
        .and().rememberMe();
	
		 
		
		http.csrf().disable();
        
		http.headers().frameOptions().disable();
	
		
		
	}
	
}
