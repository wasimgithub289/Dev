package com.javatpoint.mypackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "OfficeDetails") 
public class OfficeDetails
{
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;  
	private String address;
	
	public OfficeDetails() 
	{

	}
	public OfficeDetails(int addressId, String address) 
	{
		super();
		this.addressId = addressId;
		this.address = address;
	}
	
	public int getId() {
		return addressId;
	}
	public void setId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OfficeDetails [id=" + addressId + ", address=" + address + "]";
	}
}
