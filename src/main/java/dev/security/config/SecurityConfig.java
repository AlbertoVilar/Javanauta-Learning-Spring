package dev.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/h2-console/**").permitAll() // Permite acesso ao console H2
                                .anyRequest().authenticated() // Exige autenticação para todas as outras requisições
                )
                .csrf(csrf ->
                        csrf.ignoringRequestMatchers("/h2-console/**") // Ignora CSRF para o console H2
                )
                .headers(headers ->
                        headers.frameOptions(frameOptions -> frameOptions.disable()) // Atualização para desabilitar o uso de frames
                );

        return http.build();
    }
}
