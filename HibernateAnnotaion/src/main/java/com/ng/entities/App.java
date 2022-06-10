package com.ng.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class App 
{
	public static void main(String[] args) 
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Employee");
		List<Employee> list = q.list();
		System.out.println(list);
		
		Employee e1 = session.load(Employee.class, 150);
		//System.out.println(e1);
		//System.out.println(e1.getPassport().toString());
		
		
		TypedQuery query = session.getNamedQuery("findEmployeeByName");    
        query.setParameter("name","Shikha Khare"); 
        List<Employee> employees=query.getResultList(); 
        System.out.println(employees);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public static void main1(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Skills sk1 = new Skills("JAVA");
		Skills sk2 = new Skills("PYTHON");
		Skills sk3 = new Skills("PHP");
		Skills sk4 = new Skills(".NET");
		Skills sk5 = new Skills("REACT");
		
		
		List<Skills> list1= new ArrayList<Skills>();
		list1.add(sk1);
		list1.add(sk2);
		list1.add(sk3);
		
		List<Skills> list2= new ArrayList<Skills>();
		list2.add(sk1);
		list2.add(sk2);
		
		List<Skills> list3= new ArrayList<Skills>();
		list3.add(sk1);
		list3.add(sk2);
		list3.add(sk3);
		list3.add(sk4);
		list3.add(sk5);
		
		PassportDetail passport1 = new PassportDetail();
		passport1.setCountryCode("IN");
		passport1.setExpiryDate("31-12-2025");
		
		PassportDetail passport2 = new PassportDetail();
		passport2.setCountryCode("US");
		passport2.setExpiryDate("31-12-2030");
		
		PassportDetail passport3 = new PassportDetail();
		passport3.setCountryCode("AUS");
		passport3.setExpiryDate("31-12-2045");
		
		Employee e1 = new Employee();
		e1.setName("Kaustubh Tawate");
		e1.setDesignation("Team Lead");
		e1.setPassport(passport1);
		e1.setSkillsList(list1);
		
		Employee e2 = new Employee();
		e2.setName("Shikha Khare");
		e2.setDesignation("Software Engineer");
		e2.setPassport(passport2);
		e2.setSkillsList(list2);
		
		Employee e3 = new Employee();
		e3.setName("Anil Pathak");
		e3.setDesignation("Project Manager");
		e3.setPassport(passport3);
		e3.setSkillsList(list3);
		
		List<Employee> empList1 = new ArrayList<Employee>();
		empList1.add(e1);
		empList1.add(e2);
		
		List<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(e3);
		
		Department dept1 = new Department();
		dept1.setDepartmentName("Production");
		dept1.setEmployeeList(empList1);

		Department dept2 = new Department();
		dept2.setDepartmentName("Testing");
		dept2.setEmployeeList(empList2);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(dept1);
		session.save(dept2);

		session.getTransaction().commit();
		session.close();
		factory.close();
		System.out.println("successfully persisted Applicant details");
	}

}
