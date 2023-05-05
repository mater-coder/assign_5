<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Book Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center mb-4">Add Book Details</h2>
		<form action="addBook" method="post">
			<div class="form-group row">
				<label for="bookCode" class="col-sm-2 col-form-label">Book
					Code:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="bookCode" name="id"
						placeholder="Enter book code" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="bookName" class="col-sm-2 col-form-label">Book
					Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="bookName" name="name"
						placeholder="Enter book name" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="author" class="col-sm-2 col-form-label">Author:</label>
				<div class="col-sm-10">
					<select class="form-control" id="author" name="author" required>
						<option value="">Select author</option>
						<c:forEach var="author" items="${authorlist}">
							<option value="${author.name }">${author.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="date" class="col-sm-2 col-form-label">Date:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="date" name="date"
						value="<%=new java.text.SimpleDateFormat("dd MMM yyyy").format(new java.util.Date())%>"
						readonly>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-12 text-right">
					<button type="submit" class="btn btn-primary mr-2">Submit</button>
					<button type="button" class="btn btn-secondary"
						onclick="window.location.href='home'">Cancel</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
