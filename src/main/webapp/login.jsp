<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" runat="server" href="style.css">
	<title>Document</title>
</head>
<body>
	<form method="POST" action="login">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-3" style="width: 250px">
					<div class="btn-group butt" role="group"
						aria-label="Basic radio toggle button group">
						<input type="radio"  value="student" class="btn-check" name="loginas" id="student"
							autocomplete="off" checked> <label
							class="btn btn-outline-dark" for="student">Student Login</label>
	
						<input type="radio" value="staff" class="btn-check" name="loginas" id="staff"
							autocomplete="off"> <label class="btn btn-outline-dark"
							for="staff">Staff Login</label>
					</div>
				</div>
			</div>
		</div>
		<div class="container login mt-5">
	
	
			<div class="mb-3">
				<label id="ulabel" for="formGroupExampleInput" class="form-label">Student ID / Email : </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="LoginId / Email" name="uname" />
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">Password
					: </label> <input type="password" class="form-control"
					id="formGroupExampleInput2" placeholder="Password" name="password" />
			</div>
	
			<div class="row justify-content-center">
				<div class="col-5">
					<button id="login" class="btn btn-primary w-100 mt-3" type="submit">Login as Student</button>
				</div>
			</div>
			<div class="row justify-content-center text-center mt-3">
				<div class="col-5 text-white">
					<a class="text-white" href="forgetPage.jsp">Forget Password ?</a>
				</div>
			</div>
			<hr />
	
			<div class="row justify-content-center">
				<div class="col-6">
					<button class="btn btn-warning w-100 my-2">
						<a class="nav-link" href="RegisterPage.jsp">Register</a>
					</button>
				</div>
			</div>
		</div>
	</form>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<script src="script.js"></script>
	
</body>
</html>