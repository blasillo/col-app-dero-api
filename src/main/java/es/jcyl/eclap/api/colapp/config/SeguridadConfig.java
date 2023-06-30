package es.jcyl.eclap.api.colapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
public class SeguridadConfig {

    private static final String[] LISTA_AUTORIZACION = {
            "/v2/api-docs", "/swagger-resources", "/swagger-resources/**",
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();


        http.headers().frameOptions()
                .sameOrigin();

        return http.build();
    }
}
