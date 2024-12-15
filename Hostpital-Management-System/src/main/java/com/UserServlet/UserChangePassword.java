package com.UserServlet;

import java.io.IOException;

import com.dao.UserDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserChangePassword")
public class UserChangePassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(req.getParameter("userid"));
		String newPassword=req.getParameter("newpassword");
		String oldPassword=req.getParameter("oldpassword");
		
		UserDao dao=new UserDao(DBConnect.getConn());
		
		HttpSession session=req.getSession();
		
		if(dao.checkOldPassword(userId, oldPassword)) {
			if(dao.changePassword(userId, newPassword)) {
				session.setAttribute("succMsg", "Password Change Successfully");
				resp.sendRedirect("changePassword.jsp");
				System.out.println("Password Change Successfully");
			}else {
				session.setAttribute("errorMsg", "Something Wrong On Server");
				resp.sendRedirect("changePassword.jsp");
				System.out.println("Something Wrong On Server");
			}
		}else {
			session.setAttribute("errorMsg", "Old Password Is Incorrect");
			resp.sendRedirect("changePassword.jsp");
			System.out.println("Old Password Is Incorrect");
		}
	}

}
