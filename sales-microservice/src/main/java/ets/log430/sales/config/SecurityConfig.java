//package ets.log430.sales.config;
//
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Value("${spring.security.user.name}")
//    private String username;
//
//    @Value("${spring.security.user.password}")
//    private String password;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/v3/api-docs/**",
//                                "/swagger-ui/**",
//                                "/swagger-ui.html").permitAll()
//                        .requestMatchers("/api/v1/**").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(basic -> basic.authenticationEntryPoint(
//                        (request, response, authException) -> {
//                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                            response.setContentType("application/json");
//                            response.getWriter().write("{\"error\": \"Unauthorized\"}");
//                        }
//                ))
//                .securityMatcher("/api/v1/**")  // Only apply security to API endpoints
//                .build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername(username)
//                        .password(passwordEncoder().encode(password))
//                        .roles("USER")
//                        .build()
//        );
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}