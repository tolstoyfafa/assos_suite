package com.motus.assosuite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	   @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.motus.assosuite"))
	                .paths(PathSelectors.regex("/assosuite/api/v1/.*"))
	                .build();
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder().title("ASSOSUITE API")
	                .description("ASSOSUITE API reference for developers")
	                .termsOfServiceUrl("http://localhost:8080/v2/api-docs").license("License")
	                .licenseUrl("").version("1.0").build();
	    }
}
