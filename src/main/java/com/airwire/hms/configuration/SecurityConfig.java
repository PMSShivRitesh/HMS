package com.airwire.hms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.airwire.hms.service.EmployeeService;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    	
	@Autowired
	private EmployeeService employeeService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests().antMatchers("/**").permitAll();
    	/*http.authorizeRequests()
         .antMatchers("/", "/public/**").permitAll()
         .antMatchers("/users/**").hasAuthority("ADMIN")
         .anyRequest().fullyAuthenticated()
         .and()
         .formLogin()
         .loginPage("/login")
         .failureUrl("/login?error")
         .usernameParameter("email")
         .permitAll()
         .and()
         .logout()
         .logoutUrl("/logout")
         .logoutSuccessUrl("/")
         .permitAll();*/
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	auth.userDetailsService(employeeService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
