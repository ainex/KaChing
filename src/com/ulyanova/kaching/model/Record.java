package com.ulyanova.kaching.model;

import java.util.Date;

public class Record {
	private Integer id;
	private Date date;
	private RecordType type;
	private Integer value;
	private String description;
	private String user;
	
	
	
	public Record(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	private enum RecordType {
		INCOME,
		EXPENSE
	};
}
