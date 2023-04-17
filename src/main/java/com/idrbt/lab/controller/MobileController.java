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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Mobile service", description = "Mobile communication service api's")
@RestController
@RequestMapping("dispense/api")
public class MobileController {

	@Autowired
	MobileService mobileService;

	final Logger logger = LoggerFactory.getLogger(MobileController.class);

	@Operation(summary = "Retrieve all mobile details", tags = { "mobiles", "get", "filter" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Mobile.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "204", description = "There are no mobile details", content = {
					@Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping(value = "/mobile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mobile>> getAllMobiles() {
		logger.info("Displays all the mobile details");
		return ResponseEntity.ok().body(mobileService.getAllProduct());
	}

	@Operation(summary = "Retrieve a mobile by Id", description = "Get a mobile object by specifying its id. The response is mobile object with id, title, description and published status.", tags = {
			"mobiles", "get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Mobile.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping(value = "/mobile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mobile> getMobileById(@PathVariable int mobileId) {
		logger.info("Displays mobile details of particular mobile id");
		return ResponseEntity.ok().body(mobileService.getProductById(mobileId));

	}

	// Swagger 3 doc
	@Operation(summary = "Create a new mobile", tags = { "mobiles", "post" })
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Mobile.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/mobile")
	public ResponseEntity<Mobile> createProduct(@RequestBody Mobile mobile) {
		logger.info("mobile details uploaded on mongodb");
		return ResponseEntity.ok().body(this.mobileService.createNewMobile(mobile));
	}

	@Operation(summary = "Update a mobile", description = "update a mobile details. The response is mobile object with id, mobile status", tags = {
			"mobiles", "get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Mobile.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping(value = "/mobile/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Mobile> updateMobile(@PathVariable int mobileId, @RequestBody Mobile mobile) {
		mobile.setId(mobileId);
		logger.info("Change mobile details of particular mobile id");
		return ResponseEntity.ok().body(this.mobileService.updateMobile(mobile));
	}

	@Operation(summary = "delete a mobile by Id", tags = { "mobiles", "delete" })
	@ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping(value = "/mobile/{id}")
	public HttpStatus deleteMobileById(@PathVariable int mobileId) {
		logger.info("Delete mobile details of particular mobile id");
		this.mobileService.deleteMobileId(mobileId);
		return HttpStatus.OK;
	}

//	@DeleteMapping(value = "/mobile")
//	@ApiOperation(value = "Delete All Mobiles", notes = "This REST API returns empty list")
//	public HttpStatus deleteAllMobiles() {
//		this.mobileService.deleteMobileId1(mobileId);
//		return mobileService.deleteAllMobileDetails();
//	}

	@Operation(summary = "Create a new mobile in redis cache server", tags = { "mobiles", "post" })
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Mobile.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/mobile/redis")
	public ResponseEntity<String> saveMobile(@RequestBody Mobile mobile) {
		logger.info("Saving mobile details in redis cache server");
		boolean result = mobileService.saveMobile(mobile);
		if (result)
			return ResponseEntity.ok("User Created Successfully!!");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Operation(summary = "Retrieve a mobile by Id by using Redis cache server", description = "Get a mobile object by specifying its id. The response is mobile object with id, title, description and published status.", tags = {
			"mobiles", "get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Mobile.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/mobile/redis")
	public ResponseEntity<List<Mobile>> fetchAllMobiles() {
		logger.info("Fetch all the mobile details from the redis cache server");
		List<Mobile> mobile;
		mobile = mobileService.fetchAllMobiles();
		return ResponseEntity.ok(mobile);
	}

	@Operation(summary = "Sample message", description = "Sample dispense messsage", tags = { "mobiles", "get" })
	@GetMapping("/mobile/msg")
	public String showDispenseMessage() {
		logger.info("Sample dispense message");
		return "Amount credited to your account 089787XXX";

	}

}
