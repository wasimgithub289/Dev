package com.ng.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ng.services.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class SimpeAppSecurity extends WebSecurityConfigurerAdapter 
{
	 @Autowired
	 UserDetailsServiceImp userDetailsService;
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.authorizeRequests()
			.antMatchers("/loginPage").permitAll()
			.antMatchers("/maker/**").hasAnyRole("MAKER")
			.antMatchers("/checker/**").hasAnyRole("CHECKER")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
	          .loginPage("/login")
	          .loginProcessingUrl("/process-login")
	          .defaultSuccessUrl("/index")
	          .failureUrl("/login?error=true")
	          .permitAll()
	        .and()
	          .logout()
	          .logoutSuccessUrl("/login?logout=true")
	          .invalidateHttpSession(true)
	          .deleteCookies("JSESSIONID")
	          .permitAll()
	        .and()
	          .csrf()
	          .disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		/*auth.inMemoryAuthentication()
		.withUser("Wasim")
		.password(this.passwordEncoder().encode("123"))
		.roles("MAKER");
		
		auth.inMemoryAuthentication()
		.withUser("Som")
		.password(this.passwordEncoder().encode("456"))
		.roles("CHECKER");
		
		auth.inMemoryAuthentication()
		.withUser("Admin")
		.password(this.passwordEncoder().encode("111"))
		.roles("CHECKER");*/
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	
	
}
