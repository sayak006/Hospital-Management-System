<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin|Edit Doctor</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3)
}
</style>
</head>
<body>
	<%@include file="adminNavbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Update Doctor</p>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fw-bold fs-6">${succMsg }</p>
							<c:remove var="succMsg" />
						</c:if>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fw-bold fs-6">${errorMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDao dao = new DoctorDao(DBConnect.getConn());
						Doctor d = dao.getDoctorById(id);
						%>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fw-bold fs-6">${succMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fw-bold fs-6">${errorMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>
						<form action="../UpdateDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label><input
									type="text" required name="fullName" value="<%=d.getFullName()%>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">DOB</label><input
									type="date" required name="dob" value="<%=d.getDob()%>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="qualification"  value="<%=d.getQualification()%>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label"></label>Specialist<select
									required name="specialist" class="form-control">
									<option><%=d.getSpecialist()%></option>
									<%
									SpecialistDao dao1 = new SpecialistDao(DBConnect.getConn());
									List<Specialist> list1 = dao1.getAllSpecialist();
									for (Specialist s : list1) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label><input
									type="text" required name="email" value="<%=d.getEmail()%>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Mob No</label><input
									type="text" required name="mobNo" value="<%=d.getMobNo()%>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label><input
									type="password" required name="password" value="<%=d.getPassword() %>" class="form-control">
							</div>
							<input type="hidden" name="id" value=<%=d.getId()%>>
							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>