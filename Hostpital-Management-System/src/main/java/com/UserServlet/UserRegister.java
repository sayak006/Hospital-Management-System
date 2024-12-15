package com.UserServlet;

import java.io.IOException;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User u=new User(fullName,email,password);
		UserDao dao=new UserDao(DBConnect.getConn());
		boolean f=dao.UserRegister(u);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "Registration Successful...");
			resp.sendRedirect("signup.jsp");
			System.out.println("Registration successful");
		}else {
			session.setAttribute("errorMsg", "Something Wrong On Server...");
			resp.sendRedirect("signup.jsp");
			System.out.println("Something wrong on server");
		}
	}

}
