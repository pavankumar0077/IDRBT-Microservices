package com.idrbt.lab.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "db_sequence")
public class DbSequence {

	@Id
	private String id;
	private int seq;

	public DbSequence() {
		super();
	}

	public DbSequence(String id, int seq) {
		super();
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "DbSequence [id=" + id + ", seq=" + seq + "]";
	}

}
