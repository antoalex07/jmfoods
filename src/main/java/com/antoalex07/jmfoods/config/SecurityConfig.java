package com.antoalex07.jmfoods.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/").permitAll();
                auth.requestMatchers("/client").permitAll();
                auth.requestMatchers("/admin").hasRole("ADMIN");
            })
            .httpBasic(Customizer.withDefaults())
            .build();
    }

    @Bean
    InMemoryUserDetailsManager userDetails(){
        UserDetails admin = User.builder()
            .username("admin")
            .passwordEncoder(passwordEncoder()::encode)
            .password("admin#123")
            .roles("ADMIN")
            .build();
        
        return new InMemoryUserDetailsManager(admin); 
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
