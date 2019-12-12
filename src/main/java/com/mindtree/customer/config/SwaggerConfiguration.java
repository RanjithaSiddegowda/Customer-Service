package com.mindtree.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfiguration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInformation()).select().apis(RequestHandlerSelectors.basePackage("com.mindtree.customer.controller"))
				.paths(PathSelectors.any()).build();
	};
	
	/**
	 * Api information.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInformation() {
		return new ApiInfoBuilder().title("API Documentation")
				.description("This API documentation is related customer service").version("1.0.0").build();
	}
}
