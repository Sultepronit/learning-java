package com.db;

public class User {
	private int id;
	private String name;
	
	User(String name) {
		name = this.name; 
	}
	
	User(int id, String name) {
		id = this.id;
		name = this.name; 
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
	
	
}
