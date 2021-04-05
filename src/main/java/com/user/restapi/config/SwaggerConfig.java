package com.user.restapi.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
//Local: http://localhost:8081/api-users/swagger-ui.html#/

public class SwaggerConfig {
	
	@Bean
    public Docket UsertApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.users.restapi"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        @SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
                "Users API REST",
                "API REST Cadastro de Usuario.",
                "1.0",
                "Terms of Service",
                new Contact(
                		"Rico Lima", "https://github.com/rico2290/restapi-usuarios",
                        "rjl220990@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
