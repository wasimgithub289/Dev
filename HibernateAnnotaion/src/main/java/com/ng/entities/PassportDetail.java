package com.ng.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PassportDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passportId;
	@Column
	private String countryCode;
	@Column
	private String expiryDate;
	
	public PassportDetail() {
		
	}
	public PassportDetail(int passportId, String countryCode, String expiryDate) {
		super();
		this.passportId = passportId;
		this.countryCode = countryCode;
		this.expiryDate = expiryDate;
	}
	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "PassportDetail [passportId=" + passportId + ", countryCode=" + countryCode + ", expiryDate="
				+ expiryDate + "]";
	}
}
