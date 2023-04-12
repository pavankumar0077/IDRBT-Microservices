package com.idrbt.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MobileCommunicationApplication {

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(MobileCommunicationApplication.class);
		logger.info("Mobile Communication Application service started");
		SpringApplication.run(MobileCommunicationApplication.class, args);
	}

//	@Bean	
//	public Docket getCustomizedDocket() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.idrbt.lab"))
////				.paths(PathSelectors.ant("/stockapp/*"))
//				.paths(PathSelectors.any())
//				.build()
//				.apiInfo(getApiInfo());
//	}
//
//	private ApiInfo getApiInfo() {
//		ApiInfo apiInfo = new ApiInfo("Mobile Comminication REST API Documentation",
//				"This page gives REST API documentation for Mobile Communication", "2.5", "My Terms of Service",
//				new Contact("Pavan Kumar", "https://idrbt.com/", "pavankumard@idrbt.ac.in"), "GPL",
//				"http://gpl.org", new ArrayList<VendorExtension>());
//
//		return apiInfo;
//	}

}
