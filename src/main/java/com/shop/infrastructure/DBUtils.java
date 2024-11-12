package com.shop.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static String jdbcUrl;
	private static String jdbcUser;
	private static String jdbcPass;
	
	public static  Connection getConnection() throws SQLException{
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
		return connection;
	}
	public static void closeConnection (Connection connection) {
		if(connection !=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void setJdbcUrl(String jdbcUrl) {
		DBUtils.jdbcUrl = jdbcUrl;
	}

	public static void setJdbcUser(String jdbcUser) {
		DBUtils.jdbcUser = jdbcUser;
	}

	public static void setJdbcPass(String jdbcPass) {
		DBUtils.jdbcPass = jdbcPass;
	}
	
	
}
