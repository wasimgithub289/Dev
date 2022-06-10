package com.ng.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    @Column(name = "amount", length = Integer.MAX_VALUE)
    @NotNull(message = "Amount can not be left blank")
    private Double amount;
    
    
	public Invoice() {
		super();
	}

	public Invoice(Long id, String name, String location, Double amount) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", name=" + name + ", location=" + location + ", amount=" + amount + "]";
	}
}
