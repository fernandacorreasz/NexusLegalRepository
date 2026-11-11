package com.nexuslegal.api.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.*;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("partner").password("{noop}partner123").roles("PARTNER").build(),
                User.withUsername("lawyer").password("{noop}lawyer123").roles("LAWYER").build(),
                User.withUsername("accountant").password("{noop}accountant123").roles("ACCOUNTANT").build(),
                User.withUsername("assistant").password("{noop}assistant123").roles("ASSISTANT").build(),
                User.withUsername("alfa_admin").password("{noop}alfa123").roles("CLIENT_ADMIN").build(),
                User.withUsername("beta_viewer").password("{noop}beta123").roles("CLIENT_VIEWER").build(),
                User.withUsername("auditor").password("{noop}auditor123").roles("AUDITOR").build());
    }

    @Bean
    SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable()).cors(Customizer.withDefaults()).httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(a -> a.requestMatchers("/", "/api", "/swagger-ui/**", "/v3/api-docs/**",
                        "/api/lab/**", "/api/debug/**").permitAll().anyRequest().authenticated());
        return http.build();
    }

    @Bean
    org.springframework.web.cors.CorsConfigurationSource cors() {
        CorsConfiguration c = new CorsConfiguration();
        c.setAllowedOriginPatterns(List.of("*"));
        c.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        c.setAllowedHeaders(List.of("*"));
        c.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource s = new UrlBasedCorsConfigurationSource();
        s.registerCorsConfiguration("/**", c);
        return s;
    }
}
