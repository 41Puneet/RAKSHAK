package com.auth_service.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
@Configuration public class OpenApiConfig { @Bean public OpenAPI authApi() { return new OpenAPI().info(new Info().title("RAKSHAK Auth API").version("1.0.0").description("Authentication and token lifecycle API")).components(new io.swagger.v3.oas.models.Components().addSecuritySchemes("bearerAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))); } }
