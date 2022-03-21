package com.thelaunchclub.databaseconnection;

import com.thelaunchclub.databaseconnection.dbexception.DatabaseException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Connection with PostgreSQL database
 * 
 * @author KowsalyaSP
 */
public class StudentDbConnection {

	public static Connection getConnection() {

		try {
			InputStream s = new FileInputStream("C:/karaf/etc/system.properties");
			Properties prop = new Properties();

			prop.load(s);
			String url = prop.getProperty("karaf.jdbc.url");
			String userName = prop.getProperty("karaf.jdbc.user");
			String password = prop.getProperty("karaf.jdbc.password");
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (Exception exception) {
			System.out.println(exception);
			throw new DatabaseException("Failed To Connect Database");
		}
	}
}
