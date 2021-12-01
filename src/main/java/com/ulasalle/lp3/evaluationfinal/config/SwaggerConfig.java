package com.ulasalle.lp3.evaluationfinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInformation())
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.ulasalle.lp3.evaluationfinal.controller"
                ))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInformation() {
        return new ApiInfoBuilder()
                .title("API NORTHWIND")
                .version("v1.0.0")
                .description("Servicio para la evalucion final de LP3.")
                .contact(new Contact(
                        "Paul Abrahan Caceres",
                        "miwebsite.pe",
                        "pcaceresc@ulasalle.edu.pe"))
                .build();
    }
}
