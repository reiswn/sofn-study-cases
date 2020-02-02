package com.reiswn.JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {
    public static void main( String[] args ) throws SQLException {
        
    	//Describe
    	//com.mysql.jdbc.Driver deprecated
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Loaded");
    	} catch(ClassNotFoundException e) {
    		System.out.println("Fail to Load");
    		e.printStackTrace();
    	}
    	
    	Connection conn = null;
    	
    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");
		System.out.println("Connection ok");
		
    	
    	Statement statement = conn.createStatement();
			
		String sql = "CREATE TABLE movie (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, PRIMARY KEY (id));";
		//String sql = "DROP TABLE movie";
			
		/*
		 * executeQuery() for DML
		 * executeUpdate() for DDL
		 */
		statement.execute(sql);
		System.out.println("Statement executed");
    }
}
