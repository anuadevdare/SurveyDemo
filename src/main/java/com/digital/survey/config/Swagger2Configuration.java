package com.digital.survey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger UI allows user to visualize and interact with the API’s resources
 * without having any of the implementation logic in place
 * 
 * @author Anita Devdare
 * @version 1.0
 * @since 2019-11-01
 **/
@Configuration
@EnableSwagger2
@EnableWebMvc
public class Swagger2Configuration  {
	/*
	 * Indicates that a method produces a bean to be managed by the Spring
	 * container.
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.digital.survey.demo")).paths(PathSelectors.any()).build();

	}
	

}
