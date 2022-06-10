package com.newgen.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="UserData")
public class User {
	@Id
    @GeneratedValue
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min=5, max=10, message = "Please enter name between 5 and 10")
	@Column
	private String name;
	@Column
	private String address;
	@DecimalMax(value = "99999", message = "Amount should be less than 9999")
	private BigDecimal  amount;
	
	public BigDecimal  getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal  amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + "]";
	}
}
