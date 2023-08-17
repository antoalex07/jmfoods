package com.antoalex07.jmfoods.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth ->
        auth.requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().permitAll())
        .formLogin(withDefaults());

        return http.build();
    }

    @Bean
    UserDetails userDetails(){
        UserDetails admin = User.builder()
            .username("admin")
            .passwordEncoder(passwordEncoder()::encode)
            .password("admin#123")
            .roles("ADMIN")
            .build();
        
        return (UserDetails) new InMemoryUserDetailsManager(admin); 
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
