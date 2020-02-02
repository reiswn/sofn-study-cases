package com.reiswn.JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Factory Design Pattern
public class ConnectionFactory {

	private final String URL = "jdbc:mysql://localhost:3306/movies";
	private final String USER = "root";
	private final String PASS = "root";
	private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	private Connection createConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName(DRIVER_CLASS);
		conn = DriverManager.getConnection(URL, USER, PASS);
		
		return conn;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		return createConnection();
	}

}