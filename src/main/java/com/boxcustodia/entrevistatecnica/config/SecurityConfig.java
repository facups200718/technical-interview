package com.boxcustodia.entrevistatecnica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = false)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
                /*.csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/api/documents/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/documents/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/documents/**").hasRole("ADMIN")
                .requestMatchers("/api/documents/**").hasAuthority("ADMIN")
                .requestMatchers("/api/documents/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();*/

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}