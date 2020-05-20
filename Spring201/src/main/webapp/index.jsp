<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<style>
a {
	margin-top: 10px;
	margin-bottom: 15px;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 90vh;
}

.card {
	width: 300px;
	padding: 10px;
	display: flex;
	justify-content: center;
	align-items: center;
	display: flex;
	outline: 1px solid red;
}
</style>
</head>
<body>
	<section class="container">
		<div class="card">
			<div class=card-content>
				<a class="waves-effect waves-light btn-small" href="propertyTaxForm">Property
					Tax Form</a><br /> <a class="waves-effect waves-light btn-small"
					href="ZoneReport">Zonal Wise Report</a>
			</div>
		</div>
	</section>
</html>
