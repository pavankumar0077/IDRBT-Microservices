package com.idrbt.lab.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idrbt.lab.dto.Mobile;
import com.idrbt.lab.service.MobileService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api")
public class MobileController {

	@Autowired
	MobileService mobileService;

	private final Logger logger = LoggerFactory.getLogger(MobileController.class);
	
//	@GetMapping("/products")
//	public ResponseEntity<List<Product>> getAllProduct() {
//		LOGGER.info("Display all the products");
//		LOGGER.debug("Display all the products");
//		LOGGER.info("Display all the products");
//		LOGGER.warn("Display all the products");
//		LOGGER.error("Display all the products");
//
//		return ResponseEntity.ok().body(productService.getAllProduct());
//	}

	@GetMapping(value = "/mobile", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Reads all Mobiles", notes = "This REST API return list of all Mobiles")
	public ResponseEntity<List<Mobile>> getAllMobiles() {
		logger.info("Displays all the mobile details");
		return ResponseEntity.ok().body(mobileService.getAllProduct());
	}

	@GetMapping(value = "/mobile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Reads Mobiles by Id", notes = "This REST API returns Mobile by Id")
	public ResponseEntity<Mobile> getMobileById(
			@ApiParam(value = "Mobile id", name = "id") @PathVariable int mobileId) {
		logger.info("Displays all the mobile details");
		return ResponseEntity.ok().body(mobileService.getProductById(mobileId));

	}

	@PostMapping("/mobile")
	public ResponseEntity<Mobile> createProduct(@RequestBody Mobile mobile) {
		logger.info("Product is uploaded");
		return ResponseEntity.ok().body(this.mobileService.createNewMobile(mobile));
	}

	@PutMapping(value = "/mobile/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "ediitng a Mobilec", notes = "edit a Mobile")
	public ResponseEntity<Mobile> updateMobile(@PathVariable int mobileId, @RequestBody Mobile mobile) {
		mobile.setId(mobileId);
		logger.info("Change the details of particular product");
		return ResponseEntity.ok().body(this.mobileService.updateMobile(mobile));
	}

	@DeleteMapping(value = "/mobile/{id}")
	@ApiOperation(value = "Delete Mobile", notes = "This REST API delete's the Mobile")
	public HttpStatus deleteMobileById(@PathVariable int mobileId) {
		logger.info("Displays all the mobile details");
		this.mobileService.deleteMobileId(mobileId);
		return HttpStatus.OK;
	}

//	@DeleteMapping(value = "/mobile")
//	@ApiOperation(value = "Delete All Mobiles", notes = "This REST API returns empty list")
//	public HttpStatus deleteAllMobiles() {
//		this.mobileService.deleteMobileId1(mobileId);
//		return mobileService.deleteAllMobileDetails();
//	}

}
