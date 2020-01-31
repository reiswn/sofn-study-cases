package com.reiswn.JavaJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
	
	private static Scanner scanner = new Scanner(System.in);
	
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	System.out.println("-- Menu --\n");
    	System.out.println("1 - List movies");
    	System.out.println("2 - Create new movie");
    	System.out.println("3 - Update movie");
    	System.out.println("4 - Delete movie");
    	System.out.println(":: Digite a opção desejada: ");
    	
    	int choice = scanner.nextInt();
    	
    	switch (choice) {
		case 1: listMovies(); break;
		case 2: createMovie(); break;
		case 3: break;
		case 4: break;

		default:
			System.out.println("Invalid option");
			break;
		}
    	
    }
    
    private static void createMovie() throws ClassNotFoundException, SQLException {
    	Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO movie (id, name) VALUES (1, 'Leandro e Icaro novamente, v2'1);";
		conn.createStatement().execute(sql);

	}

	private static void listMovies() throws ClassNotFoundException, SQLException {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "SELECT * FROM movie;";
		conn.createStatement().execute(sql);
		
    	
    }
}
