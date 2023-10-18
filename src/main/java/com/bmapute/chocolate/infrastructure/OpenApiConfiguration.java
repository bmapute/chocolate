package com.bmapute.chocolate.infrastructure;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Chocolate Machine Maker with Java and Springboot ")
                        .version("v1.0")
                        .description("Projeto de desafio")
                        .termsOfService("https://bmapute.com/desafio")
                        .license(new License().name("Apache 2.0")
                                .url("https://bmapute.com/desafio"))
                );

    }

    @Bean
    public ModelResolver modelResolver( ObjectMapper objectMapper)  {
        return new ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE));
    }
}
