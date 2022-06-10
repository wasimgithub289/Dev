package com.ng.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserData")
@NamedQueries({ @NamedQuery(name = "findUserByName", query = "from User u where u.name = :name"),
				@NamedQuery(name = "getCountUsers", query = "select count(id) from User") 
			  })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	@Size(min = 5, max = 10, message = "Please enter name between 5 and 10")
	@Column
	private String name;
	@Column
	private String address;
	@DecimalMax(value = "99999", message = "Amount should be less than 9999")
	private BigDecimal amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
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