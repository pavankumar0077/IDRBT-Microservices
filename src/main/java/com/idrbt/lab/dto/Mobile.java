package com.idrbt.lab.dto;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

@Document(collection = "mobileDB")
public class Mobile implements Serializable {

//	@ApiModelProperty(value = "Mobile identifier")
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private int id;

//	@ApiModelProperty(value = "Mobile name")
	private String name;

//	@ApiModelProperty(value = "Mobile txn_status")
	private String txn_status;

//	@ApiModelProperty(value = "Mobile message")
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

//	public String toStringMobile() {
//		return "Mobile [id=" + id + ", name=" + name + ", txn_status=" + txn_status + ", message=" + message + "]";
//	}

}
