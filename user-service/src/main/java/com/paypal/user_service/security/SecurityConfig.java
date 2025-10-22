package com.paypal.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for simplicity (mainly for POST/PUT requests in testing)
                .csrf(csrf -> csrf.disable())

                // Disable CORS if you want to test from frontend
                .cors(cors -> cors.disable())

                // Permit all requests (completely disable security)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // Disable default login form or HTTP Basic auth
                .formLogin(form -> form.disable())
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}
