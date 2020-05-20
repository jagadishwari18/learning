<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zone wise report</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
	
</script>
<style>
.card-section {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.card {
	width: 700px;
	height: 500px;
	outline: 1px solid red;
	padding: 5px;
}

h6 {
	text-transform: capitalize;
	font-family: sans-serif;
	font-size: 18px;
	text-align: center;
}

.zone>table {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #666666;
	color: white;
}

td, th {
	border: 1px solid #ddd;
	padding: 8px;
}

.zone>tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$
								.ajax({
									type : 'GET',
									contentType : 'application/json',
									url : '/Spring201/reports/',
									dataType : 'json',
									async : true,
									success : function(response) {
										console.log(response);

										for (j = 0; j < response.length; j++) {
											console.log("Inside for loop");
											if (response[j].statusId === 1) {
												console.log("qqqq");
												document
														.getElementById("owner_amount"
																+ response[j].zoneId).innerHTML = response[j].zoneAmount === null ? 0
														: response[j].zoneAmount;
											} else if (response[j].statusId === 2) {
												console.log("kkkkk");
												document
														.getElementById('tenated_amount'
																+ response[j].zoneId).innerHTML = response[j].zoneAmount === null ? 0
														: response[j].zoneAmount;
											}

										}

									},
									error : function(data) {
										console.log(data);
									}

								});
					});
</script>
</head>
<body>
	<section class="card-section">
		<div class="card">
			<h6>Zone wise collection of property tax for the year 2019</h6>
			<div class="card-content">
				<table class="zone">
					<thead>
						<tr>
							<th>ZONE NAME</th>
							<th>PROPERTY TYPE</th>
							<th>AMOUNT COLLECTED</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${zones}" var="zone">
							<tr>
								<td style="text-align: center"><span>${zone.zoneName}</span></td>
								<td>
									<table>
										<tr>
											<td id="owner">OWNER</td>

										</tr>
										<tr>
											<td id="tenated">TENATED</td>
										</tr>
									</table>
								</td>
								<td>
									<table>
										<tr>
											<td><span>&#8377;&nbsp;&nbsp;</span><span
												id="owner_amount${zone.zoneId}"></span></td>

										</tr>
										<tr>
											<td><span>&#8377;&nbsp;&nbsp;</span><span
												id="tenated_amount${zone.zoneId}"></span></td>
										</tr>
									</table>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</body>
</html>