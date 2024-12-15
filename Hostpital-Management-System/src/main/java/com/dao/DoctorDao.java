package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;
import com.entity.User;

public class DoctorDao {

	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public boolean registerDotor(Doctor d) {
		boolean f = false;

		try {
			String sql = "insert into doctor(full_name,dob,qualification,specialist,email,mobno,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			int rs = ps.executeUpdate();
			if (rs == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;

		try {
			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Doctor getDoctorById(int id) {
		Doctor d = null;
		try {
			String sql = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean updateDoctor(Doctor d) {
		try {
			String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setInt(7, d.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteDoctor(int id) {
		try {
			String sql = "delete from doctor where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Doctor DoctorLogin(String email, String password) {
		Doctor d = null;
		try {
			String sql = "Select * from doctor where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	public int countDoctor()
	{
		int i=0;
		try {
			String sql="select * from doctor";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countUser()
	{
		int i=0;
		try {
			String sql="select * from user_detail";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countAppointment()
	{
		int i=0;
		try {
			String sql="select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countAppointmentByDoctorId(int d_id)
	{
		int i=0;
		try {
			String sql="select * from appointment where doctor_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, d_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countSpecialist()
	{
		int i=0;
		try {
			String sql="select * from specialist";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean checkOldPassword(int userId,String oldPassword)
	{
		try {
			String sql="Select * from doctor where id=? and password=?";
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
			String sql="update doctor set password=? where id=?";
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
