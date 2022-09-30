package com.prj.model;

import java.io.Serializable;

public class Employee implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String designation;
	private String address;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String designation, String address) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.address = address;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", address=" + address + "]";
	}
	
	
	
}

