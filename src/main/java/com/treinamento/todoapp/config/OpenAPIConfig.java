package com.treinamento.todoapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI claimAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Todo App API Service")
                        .description("Todo Service training API service")
                        .version("0.0.1"));
    }
}
