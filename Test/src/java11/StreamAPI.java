package java11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args)
	{
		//Stream.of
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		stream.forEach(p -> System.out.println(p));
		
		Stream<Integer> stream2 = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
		stream2.forEach(p -> System.out.println(p));
		
		//stream()
		List<Integer> list = new ArrayList<Integer>();

		for(int i = 1; i< 10; i++){
		      list.add(i);
		}
		
		Stream<Integer> stream3 = list.stream();
		stream3.forEach(p -> System.out.println(p));
		
		//IntStream
		IntStream stream4 = "12345_abcdefg".chars();
		stream4.forEach(p -> System.out.println(p));
		
		
		//collect
		Stream<Integer> stream5 = list.stream();
		List<Integer> evenNumbersList = stream5.filter(i -> i%2 == 0)
										.collect(Collectors.toList());
		System.out.print(evenNumbersList);
		
		//filter
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		memberNames.stream().filter(s -> s.startsWith("A"))
        					.forEach(System.out::println);
		
		memberNames.stream().filter(s -> s.startsWith("A"))
        					.map(String::toUpperCase)
        					.forEach(System.out::println);
		
		memberNames.stream().sorted()
							.map(String::toUpperCase)
							.forEach(System.out::println);
		
		
	}

}
