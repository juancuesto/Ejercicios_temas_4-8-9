package com.example.Ejercicio1_Sesion6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    public ApiInfo apiDetails(){

        return  new ApiInfo("Api Laptop",
                "libreria de Laptops","1.0"
                ,"http://www.google.com",
                new Contact("Juan","http://www.google.com","juancuesto1@hotmail.com"),
                "1.0","http://www.google.com", Collections.EMPTY_LIST);
    }
}
