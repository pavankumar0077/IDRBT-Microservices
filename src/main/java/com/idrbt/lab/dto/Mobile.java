package com.idrbt.lab.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;




@Document(collection = "mobileDB")
public class Mobile implements Serializable {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

//	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	@Id
	private int id;

	private double amount;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String account;

	private String txn_status;

	private String message;

	public Mobile() {
		super();
	}

	public Mobile(int id, double amount, @NotBlank @Size(max = 100) String account, String txn_status, String message) {
		super();
		this.id = id;
		this.amount = amount;
		this.account = account;
		this.txn_status = txn_status;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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
		return "Mobile [id=" + id + ", amount=" + amount + ", account=" + account + ", txn_status=" + txn_status
				+ ", message=" + message + "]";
	}

}
