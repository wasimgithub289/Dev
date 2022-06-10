package com.javatpoint.mypackage;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
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
		
		
 
        // Commit the transaction and close the session
        session.getTransaction().commit();
        session.close();
        System.out.println("successfully persisted Applicant details");
	}	
	public static void main1(String[] args)
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query q= session.createQuery("select count(*) from Employee");
		List list = q.list();
		System.out.println(q.toString());
		
		Criteria c=session.createCriteria(Employee.class);  
		c.add(Restrictions.eq("id",33));//salary is the propertyname  
		List list2=c.list();  
		System.out.println(list2);
		
		session.getTransaction().commit();
        factory.close();
		session.close();
		
		System.out.println("-------------Transaction completed---------");
	}
	public static void main5(String[] args)
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setFirstName("SOM");
		e1.setLastName("Rai"); 
            
        RegularEmployee e2=new RegularEmployee();      
        e2.setSalary(50000);    
        e2.setBonus(5);    
            
        ContractEmployee e3=new ContractEmployee();      
        e3.setSalary(10000);    
        e3.setBonus(2);    
            
        session.persist(e1);    
        session.persist(e2);    
        session.persist(e3);  
        
        session.getTransaction().commit();
		System.out.println("successfully saved employee");
		
        factory.close();
		session.close();
	}
	
	public static void main2(String[] args)
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		session.beginTransaction();

		EmployeeCard card1 = new EmployeeCard();
		card1.setExpDate("01-12-2021");
		
		EmployeeCard card2 = new EmployeeCard();
		card2.setExpDate("15-12-2022");
		
		OfficeDetails of1 = new OfficeDetails();
		of1.setAddress("Mumbai, Airoli, Mahrashtra");
		
		OfficeDetails of2 = new OfficeDetails();
		of2.setAddress("Delhi, Mahrashtra");
		
		BankAccount b1 = new BankAccount();
		b1.setBankName("HDFC");
		BankAccount b2 = new BankAccount();
		b2.setBankName("ICICI");
		BankAccount b3 = new BankAccount();
		b3.setBankName("SBI");
		
		List<BankAccount> list = new ArrayList<BankAccount>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		Skills sk1 = new Skills();
		sk1.setSkillName("Java");
		Skills sk2 = new Skills();
		sk2.setSkillName(".NET");
		Skills sk3 = new Skills();
		sk3.setSkillName("PHP");
		
		List<Skills> list2 = new ArrayList<Skills>();
		list2.add(sk1);
		list2.add(sk2);
		list2.add(sk3);
		
		Employee e1 = new Employee();
		e1.setFirstName("Arshiya");
		e1.setLastName("Ansari");
		e1.setEmpCard(card1);
		e1.setAccountList(list);
		e1.setSkillList(list2);
		e1.setAddress(of1);
		
		Employee e2 = new Employee();
		e2.setFirstName("Fatima");
		e2.setLastName("Ansari");
		e2.setEmpCard(card2);
		e2.setAccountList(list);
		e2.setSkillList(list2);
		e2.setAddress(of1);

		session.save(e1);
		session.save(e2);

		session.getTransaction().commit();
		System.out.println("successfully saved employee");
		
		
		List<Employee> listEmp = session.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		for(Employee emp: listEmp)
		{
			System.out.println(emp.toString());
		}
		
		factory.close();
		session.close();
	}
	public static void main11(String[] args)
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		/*Employee e1 = new Employee();
		e1.setId(104);
		e1.setFirstName("Wasim Ansari");
		e1.setLastName("A karim");

		int id = (Integer) session.save(e1);
		t.commit();
		System.out.println("successfully saved employee "+id);*/
		
		//Get All Employees from table
		List<Employee> list = session.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		for(Employee emp: list)
		{
			System.out.println(emp);
		}
		
		//get() Employee by id
		Employee emp1 = session.get(Employee.class, 103);
		System.out.println(emp1.toString());
		
		//load() Employee by id
		Employee emp2 = session.load(Employee.class, 103);
		System.out.println(emp2.toString());
		
		factory.close();
		session.close();

	}

}