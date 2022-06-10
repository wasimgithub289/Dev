package com.ng.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(  
        name = "findEmployeeByName",  
        query = "from Employee e where e.name = :name"  
        )  
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	@Column
	private String name;
	@Column
	private String designation;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_PASSPORT")
	private PassportDetail passport;
	
	//@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "FK_DEPARTMENT", referencedColumnName = "departmentId")
	//private List<Employee> employeeList;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "JOIN_EMP_SKILLS", 
			   joinColumns = {@JoinColumn (name = "EMP_ID")},
			   inverseJoinColumns = {@JoinColumn (name = "SKILLS_ID")})
	private List<Skills> skillsList;
	
	public Employee() {
		
	}
	
	public Employee(int empId, String name, String designation, PassportDetail passport, List<Skills> skillsList) {
		super();
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.passport = passport;
		this.skillsList = skillsList;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public PassportDetail getPassport() {
		return passport;
	}

	public void setPassport(PassportDetail passport) {
		this.passport = passport;
	}
	
	public List<Skills> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", passport=" + passport
				+ "]";
	}
	
}
