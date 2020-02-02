package com.reiswn.JavaJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

	private Connection conn = null;
	private PreparedStatement statement = null;
	
	public MovieDAO() throws ClassNotFoundException, SQLException {
		conn = new ConnectionFactory().getConnection();
	}
	
	public void create(Movie m) throws SQLException {
		String query = "INSERT INTO movie (name) VALUES (?)";
		
		statement = conn.prepareStatement(query);
		statement.setString(1, m.getName());
		
		statement.execute();
	}
	
	public List<Movie> read() throws SQLException{
		String query = "SELECT * FROM movie";
		
		List<Movie> movies = new ArrayList<Movie>();
		
		statement = conn.prepareStatement(query);
		
		ResultSet res = statement.executeQuery();
		
		while(res.next()) {
			movies.add(new Movie(res.getInt("id"), res.getString("name")));
		}
		
		return movies;
	}
	
	public void update(Movie m_old, Movie m_new) throws SQLException {
		String query = "UPDATE movie SET name = ? WHERE id = ?";
		
		statement = conn.prepareStatement(query);
		statement.setString(1, m_new.getName());
		statement.setInt(2, m_old.getId());
		
		statement.execute();
	}
	
	public void delete(Movie m) throws SQLException {
		String query = "DELETE FROM movie WHERE id = ?";
		
		statement = conn.prepareStatement(query);
		statement.setInt(1, m.getId());
		
		statement.execute();
	}
	
	public Movie findById(int id) throws SQLException{
		String query = "SELECT * FROM movie WHERE id = ?";
		

		statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();

		Movie movie = null;
		
		while(res.next()) {
			movie = new Movie(res.getInt("id"), res.getString("name"));
		}
		
		return movie;
	}
	
}