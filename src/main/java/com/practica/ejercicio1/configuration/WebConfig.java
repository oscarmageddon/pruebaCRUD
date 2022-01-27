package com.practica.ejercicio1.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuracion para manejar los origenes permitidos para acceder a este backend
 * @author Mario Tigua
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	public static final String[] _ORIGINS = {"http://localhost:4200"} ;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(_ORIGINS).allowedMethods("*");
    }
	
}
