package com.centroinformacion.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
        		requests -> 
        			requests.anyRequest()
        					.authenticated())
                			.httpBasic(withDefaults()
        );

        return http.build();
    }
}