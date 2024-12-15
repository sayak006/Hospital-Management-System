package com.AdminServlet;

import java.io.IOException;


import com.dao.SpecialistDao;
import com.db.DBConnect;
import com.entity.Specialist;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddSpecialist")
public class AddSpecialist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String specialistName=req.getParameter("specialistName");
		
		SpecialistDao dao=new SpecialistDao(DBConnect.getConn());
		boolean f=dao.addSpecialist(specialistName);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "Specialist Successfully Added");
			resp.sendRedirect("admin/adminIndex.jsp");
		}else {
			session.setAttribute("errorMsg", "Wrong on Server");
			resp.sendRedirect("admin/adminIndex.jsp");
			System.out.println("Wrong on Server");
		}
	}

}
