package com.example.educationalinstitutions.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class ProjectionConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("Admin")
    @Autowired
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers("/teacher/**")
                .hasAnyRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/student/**")
                .hasRole("ADMIN")
                .and().authorizeRequests().antMatchers("/course/**").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers("/teacher/login", "/teacher/update-teacher")
                .hasRole("TEACHER").and()
                .authorizeRequests().antMatchers("/teacher/login", "/teacher/update-teacher")
                .hasRole("STUDENT")
                .anyRequest()
                .authenticated();
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new MyAuthenticationProvider(
                userDetailsService, passwordEncoder()
        );
    }

}
