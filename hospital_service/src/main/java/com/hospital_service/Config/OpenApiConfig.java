package com.hospital_service.Config;
import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import io.swagger.v3.oas.models.OpenAPI; import io.swagger.v3.oas.models.info.Info;
@Configuration public class OpenApiConfig { @Bean public OpenAPI hospitalApi() { return new OpenAPI().info(new Info().title("RAKSHAK Hospital API").version("1.0.0").description("Nearest suitable hospital selection API")); } }
