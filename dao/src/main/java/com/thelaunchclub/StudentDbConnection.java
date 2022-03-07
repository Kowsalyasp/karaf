package com.thelaunchclub;

import org.osgi.service.component.annotations.Component;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Connection with PostgreSQL database
 * 
 * @author KowsalyaSP
 */
@Component
public class StudentDbConnection {
	
	public  Connection getConnection(){
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
