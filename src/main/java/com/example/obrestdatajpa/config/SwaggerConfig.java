package com.example.obrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Collections;


/*
Configuracion de Swagger para documentacion del API REST
 */


@Configuration
public class SwaggerConfig {
    /*
    @Bean //Para que sea visible con los demas beans
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(appInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo appInfo(){
        return new ApiInfo(
                "SPRING Book API REST",
                "API REST DOCS FOR BOOKS",
                "1.0",
                "https://google.com",
                new Contact("Nestor Villafane", "https://google.com", "mass.nestor@gmail.com"),
                "MIT",
                "https://google.com",
                Collections.emptyList() //Regresa una lista vacia

        );
    }

     */
}
