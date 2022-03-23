package com.thelaunchclub.databaseconnection;

import com.thelaunchclub.databaseconnection.dbexception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * Connection with PostgreSQL database
 *
 * @author KowsalyaSP
 */
public class StudentDbConnection {

    private static Map<String, String> prop;

    public static void databaseProperty(Map<String, String> properties) {
        prop = properties;
    }

    /**
     * Getting connection through database.
     */
    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(prop.get("karaf.jdbc.url"), prop.get("karaf.jdbc.user"), prop.get("karaf.jdbc.password"));

            return connection;
        } catch (Exception exception) {
            System.out.println(exception);
            throw new DatabaseException("Failed To Connect Database");
        }
    }
}
