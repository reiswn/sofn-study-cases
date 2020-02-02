package com.reiswn.JavaJDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class App {
	
	private static Scanner scanner = new Scanner(System.in);
		
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	
    	MovieDAO dao = new MovieDAO();
    	
    	System.out.println("-- Menu --\n");
    	System.out.println("1 - List movies");
    	System.out.println("2 - Create new movie");
    	System.out.println("3 - Update movie");
    	System.out.println("4 - Delete movie");
    	System.out.println(":: Digite a opção desejada: ");
    	
    	int choice = scanner.nextInt();
    	
    	switch (choice) {
		case 1: 
			List<Movie> data = dao.read();
			
			for(Movie m : data) {
				System.out.println(m.toString());
			}
			
			break;
		case 2: 
			
			System.out.println("Enter Name: ");
			String name = scanner.next();
			dao.create(new Movie(name));
			
			break;
		case 3: 
			System.out.println("Enter id: ");
			int id = scanner.nextInt();
			Movie movieExists = dao.findById(id);
			
			if(movieExists != null) {
				System.out.println("Enter new movie name: ");
				String newName = scanner.next();
				
				Movie newMovie = new Movie(movieExists.getId(), newName);
				
				dao.update(movieExists, newMovie);
				
			}else {
				System.out.println("Does not exists");
			}
			
			break;
		case 4: 
			
			System.out.println("Enter id: ");
			int idDelete = scanner.nextInt();
			Movie movieExistsDelete = dao.findById(idDelete);
			
			if(movieExistsDelete != null) {
				dao.delete(movieExistsDelete);
			}else {
				System.out.println("Does not exists");
			}
			
			break;

		default:
			System.out.println("Invalid option");
			break;
		}
    	
    }
   
}