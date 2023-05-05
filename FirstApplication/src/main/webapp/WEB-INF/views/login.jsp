<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>login form</title>
</head>
<body class="bg-secondary">
	<div class="container mt-5 ">
		<div class="row justify-content-center">
			<div class="col-sm-8 col-md-6 col-lg-4">
				<div class="card">
					<div class="card-header bg-light">
						<h4 class="mb-0">Login</h4>
					</div>
					<div class="card-body">
						<form method="post" action="userlogin">
							<c:if test="${not empty loginMssg}">
								<div class="alert alert-danger" role="alert">${loginMssg }
								</div>
							</c:if>
							<c:if test="${not empty successMssg}">
								<div class="alert alert-success" role="alert">
									${successMssg }</div>
							</c:if>
							<div class="form-group">
								<label for="userId">User ID</label> <input type="text"
									class="form-control" id="userId" name="userId" minlength="5"
									maxlength="50" required>
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									class="form-control" id="password" name="password"
									minlength="5" maxlength="30" required>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Login</button>
								<a href="register" class="btn btn-link">Register</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>