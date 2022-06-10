package com.javatpoint.mypackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeecard")
public class EmployeeCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cardNumber")
	private int cardNumber;
	private String expDate;

	public EmployeeCard() {
	}

	public EmployeeCard(int cardNumber, String expDate) {
		super();
		this.cardNumber = cardNumber;
		this.expDate = expDate;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "EmployeeCard [cardNumber=" + cardNumber + ", expDate=" + expDate + "]";
	}

}
