package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			 String sql="insert into user_detail(full_name,email,password) values(?,?,?)";
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
	
	public User UserLogin(String email, String password) {
		User u=null;
		 try {
			 String sql="Select * from user_detail where email=? and password=?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setString(1, email);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 u=new User();
				 u.setId(rs.getInt(1));
				 u.setFullName(rs.getString(2));
				 u.setEmail(rs.getString(3));
				 u.setPassword(rs.getString(4));
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return u;
	}
	
	public boolean checkOldPassword(int userId,String oldPassword)
	{
		try {
			String sql="Select * from user_detail where id=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, userId);
			 ps.setString(2, oldPassword);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 return true;
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changePassword(int userId,String newPassword)
	{
		try {
			String sql="update user_detail set password=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, newPassword); 
			ps.setInt(2, userId);
			 if(ps.executeUpdate()==1) {
				 return true;
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
