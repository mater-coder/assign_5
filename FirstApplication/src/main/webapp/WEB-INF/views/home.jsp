<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Books Listing</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="#">Books Listing</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><span
						class="nav-link text-dark font-weight-bold">Welcome
							${username }</span></li>
					<li class="nav-item">
						<button class="nav-link btn btn-outline-info" onclick="logout()"
							style="background-color: transparent;">Logout</button>

					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Body -->
	<div class="container mt-3">
		<h3 class="text-center my-3">Books Listing</h3>
		<div class=" text-center mb-3">
			<form action="add">
				<button type="submit" class="btn btn-primary">Add a Book</button>
			</form>

		</div>
		<table class="table">
			<c:if test="${not empty booklist}">
				<thead>
					<tr>
						<th>Book Code</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Date Added</th>
						<th>Actions</th>
					</tr>
				</thead>
			</c:if>
			<c:if test="${empty booklist}">
				<div class="text-center" role="alert">
					<h1>${mssg }</h1>
				</div>
			</c:if>
			<c:if test="${not empty booklist }">
				<tbody>
					<c:forEach var="book" items="${booklist}">
						<tr>
							<td>${book.id }</td>
							<td>${book.name }</td>
							<td>${book.author }</td>
							<td>${book.date }</td>
							<td>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<button type="submit" onclick="editBook(${book.id})"
												class="btn btn-sm btn-primary btn-block">Edit</button>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<button type="submit" onclick="deleteBook(${book.id})"
												class="btn btn-sm btn-danger btn-block">Delete</button>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
		</table>
	</div>

	<!-- Footer -->
	<footer class="bg-light py-3">
		<div class="container">
			<span>&copy; 2023 Books Listing</span> <span class="float-right">All
				rights reserved.</span>
		</div>
	</footer>

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
		integrity="sha384-gmS7H2lTHz5Yvgdx5g5i4V7q3umfmlLTo7yzW8ITG/gJIXc71ZnMVd9ejopWncCm"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script>
  function editBook(id) {
    window.location.href = "edit-book?id=" + id;
  } 

  function deleteBook(id) {
    if (confirm("Are you sure you want to delete this book?")) {
      window.location.href = "delete-book?id=" + id;
    }
  }
  function logout() {
	    if (confirm("Are you sure you want to Logout?")) {
	      window.location.href = "login";
	    }
	  }
</script>
</body>
</html>
