package ets.log430.gateway.config;

import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(auth -> auth
                        .pathMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .pathMatchers("/api/v1/**").authenticated()
                        .anyExchange().permitAll()
                )
                .httpBasic(basic -> basic.authenticationEntryPoint(unauthorizedEntryPoint()))
                .build();
    }

    private ServerAuthenticationEntryPoint unauthorizedEntryPoint() {
        return (exchange, ex) -> {
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().set("Content-Type", "application/json");
            byte[] bytes = "{\"error\": \"Unauthorized\"}".getBytes();
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse()
                    .bufferFactory().wrap(bytes)));
        };
    }
}