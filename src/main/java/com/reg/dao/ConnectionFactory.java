package com.reg.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	static String DB_URL;
	static String DB_USER;
	static String DB_PASSWORD;
	static Properties props;
	
	static {
		try(FileInputStream fis = new FileInputStream("C:\\Users\\harik\\eclipse-workspace\\WEB_STD_REGISTERATION\\props.properties")){
		
				Class.forName("com.mysql.cj.jdbc.Driver");
			 
			props = new Properties();
			props.load(fis);
			DB_URL = props.getProperty("url");
			DB_USER = props.getProperty("user");
			DB_PASSWORD = props.getProperty("password");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
}
