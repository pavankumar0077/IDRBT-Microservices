package com.idrbt.lab.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.idrbt.lab.controller.MobileController;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	
	final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
