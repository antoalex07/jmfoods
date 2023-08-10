package com.antoalex07.jmfoods.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration{
    
    //@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((req) ->
        req.requestMatchers("/admin/**")
        .hasAnyAuthority("ADMIN")
        .anyRequest().authenticated());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        
        String hashedPassword = passwordEncoder().encode("${PASSWORD}");

        auth.inMemoryAuthentication()
        .withUser("${USER_NAME}")
        .password(hashedPassword)
        .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
