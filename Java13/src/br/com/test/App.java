package br.com.test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		/*
		 * Helper Methods Collections
		 */
		
		//Old Set
		Set<String> listSet = new HashSet<String>();
		listSet.add("item1");
		listSet.add("item2");
		listSet.add("item3");
		
		//New Set
		Set<String> newListSet = Set.of("item1","item2","item3");
		newListSet.toString();

		//.iterate
		Stream.iterate(1, seed -> seed*2)
			  .limit(5)
			  .forEach(System.out::println);
		
		/*
		 * String - Text Blocks - JEP 355
		 */

		//old
		String str = "hello \n world \n !!!";
		
		//new - *enable new feature
		@SuppressWarnings("preview")
		String multiline = """
							hello
							   world
							      !!!
						   """;
		
		System.out.println(multiline);
		
		System.out.println(str.isBlank() +" - "+ str.isEmpty());
		
		Stream<String> lines = str.lines();
		lines.forEach(System.out::println);
		
		/*
		 * Switch - JEP 354
		 * 
		 * Java 13, value breaks are superseded by 'yield' statements
    	 * Java 12, switch expression returning value via break
		 */
		
		//Java13 - yield
		System.out.println("Yield value: " + getValueViaYield("c"));
		
		//Java12 - multiple comma-separated labels
		System.out.println("Arrow value: " + getValueViaArrow("c"));
	}
	
	@SuppressWarnings("preview")
	private static int getValueViaArrow(String mode) {
        int result = switch (mode) {
            case "a", "b" -> 1;
            case "c" -> 2;
            case "d", "e", "f" -> {
                // do something here...
                System.out.println("Supports multi line block!");
                yield 3;
            }
            default -> -1;
        };
        return result;
    }
	
	@SuppressWarnings("preview")
	public static int getValueViaYield(String mode) {
        int result = switch (mode) {
            case "a", "b":
                yield 1;
            case "c":
                yield 2;
            case "d", "e", "f":
                // do something here...
                System.out.println("Supports multi line block!");
                yield 3;
            default:
                yield -1;
        };
        return result;
    }
	
}
