<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
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
					aria-current="page" href="doctorIndex.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="doctorPatient.jsp">Patient</a></li>
			</ul>
			<form class="d-flex">
				<div class="dropdown">
						<button class="btn btn-light dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fa-solid fa-user"></i> ${doctorobj.fullName }</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="edit_profile.jsp">Edit Profile</a></li>
							<li><a class="dropdown-item" href="../DoctorLogout">Logout</a></li>
						</ul>
					</div>
			</form>
		</div>
	</div>
</nav>