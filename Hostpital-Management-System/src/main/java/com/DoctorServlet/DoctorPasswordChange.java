package com.DoctorServlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DoctorPasswordChange")
public class DoctorPasswordChange extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int doctorId=Integer.parseInt(req.getParameter("doctorid"));
		String newPassword=req.getParameter("newpassword");
		String oldPassword=req.getParameter("oldpassword");
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		
		HttpSession session=req.getSession();
		
		if(dao.checkOldPassword(doctorId, oldPassword)) {
			if(dao.changePassword(doctorId, newPassword)) {
				session.setAttribute("dChangePasswordSuccMsg", "Password Change Successfully");
				resp.sendRedirect("doctor/edit_profile.jsp");
				System.out.println("Password Change Successfully");
			}else {
				session.setAttribute("dChangePasswordErrorMsg", "Something Wrong On Server");
				resp.sendRedirect("doctor/edit_profile.jsp");
				System.out.println("Something Wrong On Server");
			}
		}else {
			session.setAttribute("errorMsg", "Old Password Is Incorrect");
			resp.sendRedirect("doctor/edit_profile.jsp");
			System.out.println("Old Password Is Incorrect");
		}
	}

}
