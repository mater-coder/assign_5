<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body class="bg-secondary">
	<div class="card w-50 mx-auto mt-5">
		<div class="card-header bg-light">
			<h4>Register</h4>
		</div>
		<div class="card-body">
			<form action="registerUser" method="post">
				<c:if test="${not empty user.responseMssg}">
					<div class="alert alert-danger" role="alert">
						${user.responseMssg }</div>
				</c:if>
				<div class="form-group">
					<label for="userId">User ID:</label> <input type="text"
						value="${user.userId }" class="form-control" id="userId"
						name="userId" minlength="5" maxlength="30" required>
				</div>
				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						value="${user.name }" class="form-control" id="name" name="name"
						minlength="2" maxlength="30" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						value="${user.email }" class="form-control" id="email"
						name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						class="form-control" id="password" name="password" minlength="5"
						maxlength="30" required>
				</div>
				<button type="submit" class="btn btn-primary">Register</button>
			</form>
		</div>
	</div>


</body>
</html>