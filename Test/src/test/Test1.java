package test;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) 
	{
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(a, "100");
		map.put(b, "100");
		
		System.out.println(map.size());
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}

}
