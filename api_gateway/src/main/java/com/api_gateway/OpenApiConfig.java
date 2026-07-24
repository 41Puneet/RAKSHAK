package com.api_gateway;
import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import io.swagger.v3.oas.models.OpenAPI; import io.swagger.v3.oas.models.info.Info;
@Configuration public class OpenApiConfig { @Bean public OpenAPI gatewayApi() { return new OpenAPI().info(new Info().title("RAKSHAK API Gateway").version("1.0.0").description("Unified gateway for RAKSHAK microservices")); } }
