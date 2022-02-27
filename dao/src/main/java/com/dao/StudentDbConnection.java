package com.dao;

import com.atmo.exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection with PostgreSQL database
 * 
 * @author KowsalyaSP
 */
public class StudentDbConnection {
	
	public static Connection getConnection(){
	    Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdatabase", "postgres", "root");
			return connection;
		} catch (Exception e) {
			throw new DatabaseException("Caught An SQL Exception");
		} 		
	}
}
