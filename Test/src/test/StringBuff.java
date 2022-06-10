package test;

import java.util.HashMap;
import java.util.Map;

public class StringBuff {

	public static void main(String[] args) 
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("100", "Wasim");
		map.put("200", "Arshiya");
		map.put("300", "Fatima");
		map.put("400", "Zainab");
		
		for(Map.Entry<String, String> entry: map.entrySet())
		{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
