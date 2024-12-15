package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/hospital";
	private static String user="root";
	private static String password="sayak";
	
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();		
		}
		return conn;
	}
}
