<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-house-medical"></i> Medi Home</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="adminIndex.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="doctor.jsp">Doctor</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="view_doctor.jsp">View Doctor</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="adminPatient.jsp">Patient</a></li>
			</ul>
			<form class="d-flex">
				<div class="dropdown">
					<button class="btn btn-success dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">Admin</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="../AdminLogout">Logout</a></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>