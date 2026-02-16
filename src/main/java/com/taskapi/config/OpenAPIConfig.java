package com.taskapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI taskOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Task API")
                        .description("Basic REST API for managing Tasks")
                        .version("v1.0"));
    }



}
