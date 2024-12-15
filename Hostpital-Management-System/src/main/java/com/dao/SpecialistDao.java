package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specialist;

public class SpecialistDao {
	Connection conn;

	public SpecialistDao(Connection conn) {
		// TODO Auto-generated constructor stub
		super();
		this.conn = conn;
	}

	public boolean addSpecialist(String s) {
		boolean f = false;

		try {
			String sql = "insert into specialist(specialist_name)values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			int rs = ps.executeUpdate();
			if (rs == 1)
				f = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Specialist> getAllSpecialist() {
		List<Specialist> list = new ArrayList<Specialist>();
		Specialist s = null;

		try {
			String sql = "select * from specialist";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Specialist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
