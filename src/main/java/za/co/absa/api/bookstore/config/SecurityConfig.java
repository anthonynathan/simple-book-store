package za.co.absa.api.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .pathMatchers("/actuator/**", "/v3/api-docs/**", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html")
                .permitAll()
                .anyExchange().authenticated().and().oauth2Login();

        return http.build();
    }
}
