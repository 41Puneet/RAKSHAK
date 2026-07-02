package com.dispatch_service.Config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dispatch_service.Mapper.DispatchMapper;

@Configuration
public class MapperConfig {

    @Bean
    public DispatchMapper dispatchMapper() {
        return Mappers.getMapper(DispatchMapper.class);
    }
}