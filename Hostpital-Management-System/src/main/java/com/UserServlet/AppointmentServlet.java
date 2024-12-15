package com.UserServlet;

import java.io.IOException;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullName = req.getParameter("fullName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointDate = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String diseases = req.getParameter("diseases");
		int doctorId = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");

		Appointment appointment = new Appointment(userId, fullName, gender, age, appointDate, email, phno, diseases,
				doctorId, address, "Pending");

		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());

		HttpSession session = req.getSession();

		if (dao.addAppointment(appointment)) {
			session.setAttribute("succMsg", "Appointment Successfully");
			resp.sendRedirect("user_appointment.jsp");
			System.out.println("Appointment Successfully");
		} else {
			session.setAttribute("errorMsg", "Something Wrong On Server");
			resp.sendRedirect("user_appointment.jsp");
			System.out.println("Something Wrong On Server");
		}
	}

}
