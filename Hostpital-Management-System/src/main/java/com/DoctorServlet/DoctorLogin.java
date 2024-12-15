package com.DoctorServlet;

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

@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		Doctor doctor=dao.DoctorLogin(email, password);
		HttpSession session=req.getSession();
		
		if(doctor!=null) {
			session.setAttribute("doctorobj", doctor);
			resp.sendRedirect("doctor/doctorIndex.jsp");
		}else {
			session.setAttribute("errorMsg", "Wrong Email Or Password");
			resp.sendRedirect("doctor_login.jsp");
			System.out.println("Wrong Email Or Password");
		}
	}

}
