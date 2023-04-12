package com.idrbt.lab;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class MobileCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileCommunicationApplication.class, args);
	}

	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.idrbt.lab"))
//				.paths(PathSelectors.ant("/stockapp/*"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Mobile Comminication REST API Documentation",
				"This page gives REST API documentation for Mobile Communication", "2.5", "My Terms of Service",
				new Contact("Pavan Kumar", "https://idrbt.com/", "pavankumard@idrbt.ac.in"), "GPL",
				"http://gpl.org", new ArrayList<VendorExtension>());

		return apiInfo;
	}

}
