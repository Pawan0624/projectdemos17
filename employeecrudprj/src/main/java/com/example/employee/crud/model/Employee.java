package com.example.employee.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	private int empid;
	
	@Column
	private String dept;
	
	@Column
	private String desg;
	
	@Column
	private String name;
	
	public Employee() {
		
	}
	public Employee(int empid, String dept, String desg, String name) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.desg = desg;
		this.name = name;
	}
	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
