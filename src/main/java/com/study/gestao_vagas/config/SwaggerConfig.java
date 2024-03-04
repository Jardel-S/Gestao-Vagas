package com.study.gestao_vagas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
 
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
        .info(new Info().title("Gestão de Vagas").description("API responsável pela gestão de vagas").version("1"))
        .schemaRequirement("jwt_auth", createSecuritySchema());    
    }

    private SecurityScheme createSecuritySchema() {
        return new SecurityScheme().name("jwt_auth").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
    }
}
