package com.javatpoint.mypackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accNumber;
	private String bankName;

	public BankAccount() {

	}

	public BankAccount(int accNumber, String bankName) {
		super();
		this.accNumber = accNumber;
		this.bankName = bankName;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "BankAccount [accNumber=" + accNumber + ", bankName=" + bankName + "]";
	}
}
