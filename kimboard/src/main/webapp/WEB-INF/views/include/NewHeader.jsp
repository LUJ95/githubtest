<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<!--boot strap css link -->

<!-- cdn css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>HEADER</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-warning text-success"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand text-danger" href="#">Logo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<ul>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Language</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">KOR</a> <a class="dropdown-item"
							href="#">ENG</a>
						<div class="dropdown-divider"></div>
					</div>
			</ul>
			&nbsp;&nbsp;
			<form class="d-flex">
				<input class="form-control me-sm-2" type="search"
					placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				&nbsp;&nbsp;&nbsp;
			</form>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<table class="text-success offset-md-9" >
					<tr>
						<th><a href="">login</a>&nbsp;</th>
						<!-- login -->
						<th><a href="">logout</a>&nbsp;</th>
						<!-- logout -->
						<th><a href="">My profile</a>&nbsp;</th>
						<!-- my profile -->
						<th><a href="">장바구니</a>&nbsp;</th>
						<!-- 장바구니 -->
					</tr>
				</table>
			</div>
		</div>
	</nav>
</body>
</html>