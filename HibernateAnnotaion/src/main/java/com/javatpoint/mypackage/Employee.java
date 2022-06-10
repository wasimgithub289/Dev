package com.javatpoint.mypackage;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
/*@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="id")),  
    @AttributeOverride(name="name", column=@Column(name="name"))  
})*/  
//@Inheritance(strategy=InheritanceType.JOINED)  Table per sub class
//@PrimaryKeyJoinColumn(name="ID")  inside subclasses 


@Entity
@Table(name = "employee")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="emp_type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="employee")  
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName, lastName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cardNumber")
	private EmployeeCard empCard;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	private List<BankAccount> accountList;

	@ManyToOne(cascade = CascadeType.ALL)
	private OfficeDetails address;

	@ManyToMany(targetEntity = Skills.class, cascade = { CascadeType.ALL })
	@JoinTable( name = "skills_details", 
				joinColumns = { @JoinColumn(name = "skill_id") }, 
				inverseJoinColumns = {@JoinColumn(name = "emp_id") }
			   )
	private List<Skills> skillList;

	public Employee() {

	}

	public Employee(int id, String firstName, String lastName, EmployeeCard empCard, List<BankAccount> accountList,
			OfficeDetails address, List<Skills> skillList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empCard = empCard;
		this.accountList = accountList;
		this.address = address;
		this.skillList = skillList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmployeeCard getEmpCard() {
		return empCard;
	}

	public void setEmpCard(EmployeeCard empCard) {
		this.empCard = empCard;
	}

	public List<BankAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<BankAccount> accountList) {
		this.accountList = accountList;
	}

	public List<Skills> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skills> skillList) {
		this.skillList = skillList;
	}

	public OfficeDetails getAddress() {
		return address;
	}

	public void setAddress(OfficeDetails address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", empCard=" + empCard
				+ ", accountList=" + accountList + ", address=" + address + ", skillList=" + skillList + "]";
	}

}