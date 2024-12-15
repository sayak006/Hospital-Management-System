package com.AdminServlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String fullName=req.getParameter("fullName");
		String dob=req.getParameter("dob");
		String qualification=req.getParameter("qualification");
		String  specialist=req.getParameter("specialist");
		String email=req.getParameter("email");
		String mobNo=req.getParameter("mobNo");
		String password=req.getParameter("password");
		
		Doctor d=new Doctor();
		d.setId(id);
		d.setFullName(fullName);
		d.setDob(dob);
		d.setQualification(qualification);
		d.setSpecialist(specialist);
		d.setEmail(email);
		d.setMobNo(mobNo);
		d.setPassword(password);
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		
		HttpSession session=req.getSession();
		
		if(dao.updateDoctor(d)) {
			session.setAttribute("succMsg", "Doctor Update Successfully");
			resp.sendRedirect("admin/view_doctor.jsp");
			System.out.println("Doctor Update Successfully");
		}else {
			session.setAttribute("errorMsg", "Wrong On Server");
			resp.sendRedirect("admin/view_doctor.jsp");
			System.out.println("Wrong On Server");
		}
	}

}
