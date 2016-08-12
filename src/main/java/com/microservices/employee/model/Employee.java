package com.microservices.employee.model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.microservices.employee.address.model.EmployeeAddress;

@Entity
@Table(name="employees")
public class Employee {
	
	
	public Employee(){}
	
	public Employee(Long employeeId){this.employeeId=employeeId;}
	
	public Employee(String employeeFirstName,String employeeLastName,
			String employeeDesignation,BigInteger employeeSalary){
		this.employeeFirstName=employeeFirstName;
		this.employeeLastName=employeeLastName;
		this.employeeDesignation=employeeDesignation;
		this.employeeSalary=employeeSalary;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;
	
	@NotNull
	@Column(name="employee_firstname")
	private String employeeFirstName;
	
	@NotNull
	@Column(name="employee_lastname")
	private String employeeLastName;
	
	@NotNull
	@Column(name="employee_designation")
	private String employeeDesignation;
	
	@NotNull
	@Column(name="employee_salary")
	private BigInteger employeeSalary;
	
	@NotNull
	@Column(name="employee_phone")
	private BigInteger employeePhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EmployeeAddress employeeAddress;
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public BigInteger getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(BigInteger employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public BigInteger getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(BigInteger employeePhone) {
		this.employeePhone = employeePhone;
	}
	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	
}
