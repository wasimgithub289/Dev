package com.javatpoint.mypackage;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("contractemployee")  
public class ContractEmployee extends Employee
{
	@Column(name="salary")    
	private float salary;  
	  
	@Column(name="bonus")     
	private int bonus;
	
	

	public ContractEmployee() {
		super();
	}

	public ContractEmployee(float salary, int bonus) {
		super();
		this.salary = salary;
		this.bonus = bonus;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	} 
	
	
}
