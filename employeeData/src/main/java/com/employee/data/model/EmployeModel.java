package com.employee.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeModel {

	@Id
    private long id;
	
	private String fname;
	
	private String lname;
	
	private String designation;
	
	private String companyName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "EmployeModel [id=" + id + ", fname=" + fname + ", lname=" + lname + ", designation=" + designation
				+ ", companyName=" + companyName + "]";
	}
}
