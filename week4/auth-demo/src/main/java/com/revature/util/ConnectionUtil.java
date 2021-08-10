package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
private static Connection conn;
	
	
	public static Connection getConnectionFromEnv() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
        	conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pokemon", "postgres", "746233077");
            }
 
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return conn;
	}
}
