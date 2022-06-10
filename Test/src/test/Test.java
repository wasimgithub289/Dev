package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test 
{
	public static void main(String args[])
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("A", "100");
		map.put("B", "200");
		map.put("C", "300");
		map.put("D", "400");
		map.put("E", "500");
		
		for(Map.Entry<String, String> entry: map.entrySet())
		{
			map.put("A", "43");
			System.out.println(entry.getKey() +"  "+entry.getValue());
		}
		
		Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<String, String> entry = itr.next();
			System.out.println(entry.getKey() +"  "+entry.getValue());
		}
		
		for (var entry : map.entrySet()) {
		    System.out.println(entry.getKey() + "  " + entry.getValue());
		    
		}
		
		
		
	}
}
