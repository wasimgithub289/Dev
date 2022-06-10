package com.ng.bean;

import java.util.List;
import java.util.Map;

public class Employee {
	private int id;
	private String name;
	private Address address;
	private List<String> contactNumber; 
	private List<LeaveDetails> leaveDetails; 
	private Map<String,String> apprailSalComment;  

	private Employee() {
		System.out.println("def cons");
	}
	
	/*private static final Employee emp = new Employee();
	public static Employee getEmpInstance()
	{
		return emp;
	}*/

	public Employee(int id) {
		this.id = id;
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public Employee(Address address) {
		this.address = address;
	}
	
	public Employee(List<LeaveDetails> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}


	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Employee(int id, String name, Address address, List<String> contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public Employee(int id, String name, Address address, List<String> contactNumber, List<LeaveDetails> leaveDetails) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.leaveDetails = leaveDetails;
	}
	
	

	public Employee(int id, String name, Address address, List<String> contactNumber, List<LeaveDetails> leaveDetails,
			Map<String, String> apprailSalComment) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.leaveDetails = leaveDetails;
		this.apprailSalComment = apprailSalComment;
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(List<String> contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<LeaveDetails> getLeaveDetails() {
		return leaveDetails;
	}

	public void setLeaveDetails(List<LeaveDetails> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

	public Map<String, String> getApprailSalComment() {
		return apprailSalComment;
	}

	public void setApprailSalComment(Map<String, String> apprailSalComment) {
		this.apprailSalComment = apprailSalComment;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ",\n name=" + name + ",\n address=" + address + ",\n contactNumber=" + contactNumber
				+ ",\n leaveDetails=" + leaveDetails + ",\n apprailSalComment=" + apprailSalComment +"]";
	}
}