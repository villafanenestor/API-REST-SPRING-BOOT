package com.example.obrestdatajpa.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
Configuracion de Swagger para documentacion del API REST
 */


@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring Boot Book API")
                        .description("Spring shop sample application")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

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
