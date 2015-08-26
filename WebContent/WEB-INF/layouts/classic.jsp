<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<tilesx:useAttribute name="current" />
<body>
	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand ${current=='index'?'active':'' }"
					href='<spring:url value="/index"/>'>JPA</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="${current=='index'?'active':'' }"><a
						href='<spring:url value="/index"/>'>Home</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current=='usersList'?'active':'' }"><a
							href='<spring:url value="/usersList"/>'>Users</a></li>
					</sec:authorize>
					<li class="${current=='usersRegister'?'active':'' }"><a
						href='<spring:url value="/register"/>'>Register</a></li>
					<sec:authorize access="! isAuthenticated()">
						<li class="${current=='login'?'active':'' }"><a
							href='<spring:url value="/login.html"/>'>Login</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
					<li class="${current=='account'?'active':'' }"><a
							href='<spring:url value="/account"/>'>My Account</a></li>
						<li><a href='<spring:url value="/logout"/>'>Logout</a></li>
					</sec:authorize>
					<li><a href="#">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>

		<tiles:insertAttribute name="body" />
		<br> <br>
		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>
</body>
</html>