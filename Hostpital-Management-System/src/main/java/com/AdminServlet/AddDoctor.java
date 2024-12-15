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

@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName=req.getParameter("fullName");
		String dob=req.getParameter("dob");
		String qualification=req.getParameter("qualification");
		String  specialist=req.getParameter("specialist");
		String email=req.getParameter("email");
		String mobNo=req.getParameter("mobNo");
		String password=req.getParameter("password");
		
		Doctor d=new Doctor(fullName,dob,qualification,specialist,email,mobNo, password);
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		boolean f=dao.registerDotor(d);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "Doctor Added Successfully");
			resp.sendRedirect("admin/doctor.jsp");
			System.out.println("Doctor Added Successfully");
		}else {
			session.setAttribute("errorMsg", "Something Wrong On Server");
			resp.sendRedirect("admin/doctor.jsp");
			System.out.println("Something Wrong On Server");
		}
	}

}
