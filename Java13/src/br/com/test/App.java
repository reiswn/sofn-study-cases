package br.com.test;

import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		//Old
		Set<String> listSet = new HashSet<String>();
		listSet.add("item1");
		listSet.add("item2");
		listSet.add("item3");
		
		//New
		Set<String> newListSet = Set.of("item1","item2","item3");
	}
	
	
}
