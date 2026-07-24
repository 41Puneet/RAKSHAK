package com.responder_service.config;
import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import io.swagger.v3.oas.models.OpenAPI; import io.swagger.v3.oas.models.info.Info;
@Configuration public class OpenApiConfig { @Bean public OpenAPI responderApi() { return new OpenAPI().info(new Info().title("RAKSHAK Responder API").version("1.0.0").description("Responder, assignment, vehicle and availability API")); } }
