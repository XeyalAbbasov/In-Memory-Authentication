package com.khayal.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    auth.jdbcAuthentication().dataSource(dataSource);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Xeyal").password("{noop}123").roles("ADMIN","USER")
                .and()
                .withUser("Elnur").password("{noop}123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/phones").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/phones/{id}").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/phones/pagination/{offset}/{pageSize}").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/phones/paginationAndSort/{offset}/{pageSize}/{field}").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/phones/buy").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/phones/update/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/main").permitAll()
                .and()
                .formLogin().disable();
    }
}
