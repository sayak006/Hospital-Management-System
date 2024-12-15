package com.AdminServlet;

import java.io.IOException;

import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession session=req.getSession();
		
		if("admin@gmail.com".equals(email) && "admin123".equals(password)) {
			session.setAttribute("adminobj", new User());
			resp.sendRedirect("admin/adminIndex.jsp");
		}else {
			session.setAttribute("errorMsg", "Wrong Email Or Password");
			resp.sendRedirect("admin_login.jsp");
			System.out.println("Wrong Email Or Password");
		}
	}
}
