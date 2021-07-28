package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection con;
	
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:postgresql://database-2.cllvqmegtmuc.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "p4ssw0rd";
		/*
		 * return a connection if one exist (static Connection con), else create one
		 */
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		} 
		
		return con;
	}
	
	
	/*
	 * Can use .gitignore in order to prevent .properties file from being pushed to GitHub
	 */
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("prop.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		} 
		
		return con;
	}
	
	public static Connection getConnectionFromEnv() throws SQLException {
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		} 
		
		return con;
	}
}
