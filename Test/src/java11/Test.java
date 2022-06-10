package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

enum Days
{
	SUNDAY, MONDAY, TUESDAY, THURSDAY, FRIDAY, SATURDAY;
	
	public void show()
	{
		System.out.println(Days.SATURDAY);
	}
}

public class Test
{
	public static void main1(String[] args) throws IOException 
	{
		System.out.println();
	}
	public static void main(String[] args) throws IOException 
	{
		//lines()
		String str = "Wasim\nAhmad\nAbdul\nKarim\nAnsari"; 
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));
        
        //isBlank()
        String a = "  ";
        System.out.println(a.isBlank());
        System.out.println(a.isEmpty());
        
        //strip(), stripLeading(), stripTrailing()
        String name = " Wasim ";
        System.out.println("Start"+name.strip()+"End");
        System.out.println("Start"+name.stripLeading()+"End");
        System.out.println("Start"+name.stripTrailing()+"End");
        
        //repeat()
        String str2 = "Wasim".repeat(200);
        System.out.println(str2); 
        
        //Files.writeString  &  Files.readString    
        Path path = Paths.get("C:\\Users\\wasim289\\Data.txt");
        Files.writeString(path, "\n This is my second text", StandardOpenOption.APPEND);
        
        String fileText = Files.readString(path);
        System.out.println(fileText);
	}
}
