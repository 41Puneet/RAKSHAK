package com.api_gateway;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
@Configuration @EnableReactiveMethodSecurity
public class SecurityConfig {
 @Bean SecurityWebFilterChain security(ServerHttpSecurity h, ReactiveJwtDecoder decoder){return h.csrf(ServerHttpSecurity.CsrfSpec::disable).authorizeExchange(a->a.pathMatchers("/api/auth/**","/actuator/health","/swagger-ui/**","/v3/api-docs/**").permitAll().anyExchange().authenticated()).oauth2ResourceServer(o->o.jwt(j->j.jwtDecoder(decoder))).build();}
 @Bean ReactiveJwtDecoder jwtDecoder(@Value("${jwt.secret}")String s){return NimbusReactiveJwtDecoder.withSecretKey(new SecretKeySpec(Base64.getDecoder().decode(s),"HmacSHA256")).build();}
}
