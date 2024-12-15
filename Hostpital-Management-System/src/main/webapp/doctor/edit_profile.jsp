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
<title>Doctor|Edit Profile</title>
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

	<div class="container p-4">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Change Password</p>
						<c:if test="${not empty dChangePasswordSuccMsg }">
							<p class="text-center text-success fw-bold fs-6">${dChangePasswordSuccMsg }</p>
							<c:remove var="dChangePasswordSuccMsg" />
						</c:if>
						<c:if test="${not empty dChangePasswordErrorMsg }">
							<p class="text-center text-danger fw-bold fs-6">${dChangePasswordErrorMsg }</p>
							<c:remove var="dChangePasswordErrorMsg" />
						</c:if>
						<form action="../DoctorPasswordChange" method="post">
							<div class="mb-3">
								<label>Enter New Password</label><input type="password"
									name="newpassword" class="form-control" required>
							</div>
							<div class="mb-3">
								<label>Enter Old Password</label><input type="password"
									name="oldpassword" class="form-control" required>
							</div>
							<input type="hidden" name="doctorid" value="${doctorobj.id }">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-6 offset-md-2">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor</p>
						<%--
						int id = Integer.parseInt(request.getParameter("id));
						DoctorDao dao = new DoctorDao(DBConnect.getConn());
						Doctor d = dao.getDoctorById(id);
						--%>
						<c:if test="${not empty dEditProfileSuccMsg }">
							<p class="text-center text-success fw-bold fs-6">${dEditProfileSuccMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>
						<c:if test="${not empty dEditProfileErrorMsg }">
							<p class="text-center text-danger fw-bold fs-6">${dEditProfileErrorMsg }</p>
							<c:remove var="dEditProfileErrorMsg" />
						</c:if>
						<form action="../DoctorEditProfile" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullName" value="${doctorobj.fullName }"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">DOB</label><input type="date" required
									name="dob" value="${doctorobj.dob }" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="qualification"
									value="${doctorobj.qualification }" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label"></label>Specialist<select required
									name="specialist" class="form-control">
									<option>${doctorobj.specialist }</option>
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
								<label class="form-label">Email</label><input type="text"
									required name="email" value="${doctorobj.email }"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Mob No</label><input type="text"
									required name="mobNo" value="${doctorobj.mobNo }"
									class="form-control">
							</div>
							<input type="hidden" name="id" value="${doctorobj.id }">
							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>