package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.User;

public class UserDao {
	private Connection conn;
	
	public UserDao(Connection conn) {
		this.conn=conn;
	}
	
	public boolean UserRegister(User u) {
		boolean f=false;
		 try {
			 String sql="insert into user_details(full_name,email,password) values(?,?,?)";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setString(1, u.getFullName());
			 ps.setString(2, u.getEmail());
			 ps.setString(3, u.getPassword());
			 int rs=ps.executeUpdate();
			 if(rs==1) {
				 f=true;
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return f;
	}
}
