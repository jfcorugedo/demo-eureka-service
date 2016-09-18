package com.sngular.demo.userservice.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!integrationtest")
public class SwaggerConfig {
	
	@Bean
	public Docket apiData() {
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName("sngular-demo")
					.apiInfo(apiInfo())
					.select()
					.paths(regex("/api/v1.*"))
					.build();
					
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("Demo REST API")
				.description("Some useful endpoint to deal with Users resources")
				.termsOfServiceUrl("http://nolicense")
				.contact(new Contact("jfcorugedo", "https://es.linkedin.com/in/jfcorugedo", "juan.fcorugedo@sngular.team"))
				.license("Apache License Version 2.0")
				.build();
	}
}
