package com.ng.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.ng.bean.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Resource r=new ClassPathResource("applicationContext.xml");  
        BeanFactory factory=new XmlBeanFactory(r);
        
        System.out.println("\n*******Constructor Injection*********");
          
        Employee e=(Employee)factory.getBean("emp");  
        System.out.println(e.toString()); 
        
        System.out.println("\n*******Setter Injection*********");
        
        Employee s=(Employee)factory.getBean("emp1");  
        System.out.println(s.toString()); 
        
        System.out.println("\n*******Autowiring*********");
        
        Employee e3=(Employee)factory.getBean("emp3");  
        System.out.println(e3.toString()); 
        
        System.out.println("\n*******Factory Method Injection*********");
        //Employee e4=(Employee)factory.getBean("emp4");  
        //System.out.println(e4.toString());
       
    }
}
