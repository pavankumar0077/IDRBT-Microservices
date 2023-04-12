package com.idrbt.lab.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.Document;

import com.idrbt.lab.controller.MobileController;

//import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "mobileDB")
public class Mobile {
	
	@ApiModelProperty(value = "Mobile identifier")
	private int id;
	
	@ApiModelProperty(value = "Mobile name")
	private String name;
	
	@ApiModelProperty(value = "Mobile txn_status")
	private String txn_status;
	
	@ApiModelProperty(value = "Mobile message")
	private String message;

	public Mobile() {
		super();
	}

	public Mobile(int id, String name, String txn_status, String message) {
		super();
		this.id = id;
		this.name = name;
		this.txn_status = txn_status;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTxn_status() {
		return txn_status;
	}

	public void setTxn_status(String txn_status) {
		this.txn_status = txn_status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", txn_status=" + txn_status + ", message=" + message + "]";
	}
	
	

}
