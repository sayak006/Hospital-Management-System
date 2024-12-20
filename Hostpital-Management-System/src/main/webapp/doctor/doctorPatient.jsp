<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.dao.AppointmentDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor|Patient</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3)
}
</style>
</head>
<body>
	<c:if test="${empty doctorobj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@include file="doctorNavbar.jsp"%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fw-bold fs-6">${succMsg }</p>
							<c:remove var="succMsg" />
						</c:if>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fw-bold fs-6">${errorMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Diseases</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor doctor = (Doctor) session.getAttribute("doctorobj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
								ArrayList<Appointment> list = dao.getAllAppointmentByLoginDoctor(doctor.getId());
								for (Appointment ap : list) {
								%>
								<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppointdate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhNo()%></td>
									<td><%=ap.getDiseases()%>
									<td><%=ap.getStatus()%></td>
									<td>
									<%
								if("Pending".equals(ap.getStatus())){%>
									<a href="comment.jsp?id=<%=ap.getId() %>" class="btn btn-success btn-sm">Comment</a>
								<%}else{%>
									<a href="#" class="btn btn-success btn-sm disabled">Comment</a>
								<%}
							%>
									</td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>