package rednosed.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("https://red-nosed.com");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("HEAD");
        configuration.addAllowedMethod("OPTION");
        configuration.setAllowCredentials(true);
//        configuration.addAllowedHeader("*");
        configuration.addExposedHeader("authorization");
        configuration.addExposedHeader("reauthorization");

        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
