package com.tutorial.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/javax.faces.resource/**").permitAll()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/","/index").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login.xhtml").permitAll()
        .failureUrl("/login.xhtml?error=true")
        .and()
        .logout().logoutSuccessUrl("/login.xhtml")
        .and()
        .csrf()
        .disable();
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}12345")
        .roles(UserRole.ADMIN.name())
        .and()
        .withUser("manager")
        .password("{noop}1234")
        .roles(UserRole.MANAGER.name())
        .and()
        .withUser("user")
        .password("{noop}123")
        .roles(UserRole.USER.name());
  }
}
