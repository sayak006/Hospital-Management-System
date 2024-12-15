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

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao=new UserDao(DBConnect.getConn());
		User user=dao.UserLogin(email, password);
		
		HttpSession session = req.getSession();

		if (user!=null) {
			session.setAttribute("userobj", user);
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "Wrong Email Or Password");
			resp.sendRedirect("user_login.jsp");
			System.out.println("Wrong Email Or Password");
		}
	}
}
