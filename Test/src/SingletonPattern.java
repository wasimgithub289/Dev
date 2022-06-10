
public class SingletonPattern 
{
	public static void main(String[] args) 
	{
		
		Employee e = Employee.getInstance();		
	}
}


class Employee
{
	//private static A obj=new A();//Early, instance will be created at load time
	private static Employee obj;  
	private int id;
	private String name;
	
	private Employee()
	{
		
	}
	
	public static Employee getInstance()
	{
		if (obj == null)
		{  
	      synchronized(Employee.class)
	      {  
	        if (obj == null)
	        {  
	            obj = new Employee();//instance will be created at request time  
	        }  
	      }              
		 }  
		return obj; 
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
	
	
}