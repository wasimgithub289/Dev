package test;
public class Test3 
{
	public static void main(String[] args) 
	{
		Mobile m1 = new Samsung();
		Samsung c1 = (Samsung)m1;
		
		c1.show();
		
		/*String a = "Wasim";
		final String b = "Wasim";
		StringBuffer sb= new StringBuffer("Wasim");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(sb.toString().hashCode());*/
	}
}

class Mobile
{
    void show()
    {
       System.out.println("Mobile number is 12345");
    }
    
    void getMobileName()
    {
        System.out.println("This is  mobile");
        
        
    }
}

class Samsung extends Mobile
{
   void getMobileName()
   {
       System.out.println("This is Samsung mobile");
   }

   void getAndroidVersion()
   {
       System.out.println("Android version is 1.0");
   }
}

class Apple extends Mobile
{
	
   void getMobileName()
   {
       System.out.println("This is Apple mobile");
   }

   void getIOSVersion()
   {
       System.out.println("IOS version is 2.0");
   }
}