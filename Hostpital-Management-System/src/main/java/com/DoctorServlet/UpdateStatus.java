package com.DoctorServlet;

import java.io.IOException;

import com.dao.AppointmentDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		int d_id = Integer.parseInt(req.getParameter("d_id"));
		String comm = req.getParameter("comm");

		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());

		HttpSession session = req.getSession();

		if (dao.updateCommentstatus(id, d_id, comm)) {
			session.setAttribute("succMsg", "Comment Updated");
			resp.sendRedirect("doctor/doctorPatient.jsp");
			System.out.println("Comment Updated");
		} else {
			session.setAttribute("errorMsg", "Something Wrong On Server");
			resp.sendRedirect("doctor/doctorPatient.jsp");
			System.out.println("Something Wrong On Server");
		}
	}

}
