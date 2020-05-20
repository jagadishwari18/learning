<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.card-section {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.heading {
	font-family: verdana;
	font-size: 18px;
	text-align: center;
}

.card {
	width: 800px;
	height: 600px;
}

table {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black !important;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
	
</script>
</head>
<body>
	<section class="card-section">
		<div class="card">
			<h6 class="heading">Submitted Property Tax Form For year
				${yearOfAssessment}</h6>
			<div class="card-content">
				<table>
					<tr>
						<td>Owner Name :</td>
						<td style="text-align: center;">${ownerName}</td>
					</tr>
					<tr>
						<td>Email :</td>
						<td style="text-align: center;">${email}</td>
					</tr>
					<tr>
						<td>Address:</td>
						<td style="text-align: center;">${address}</td>
					</tr>
					<tr>
						<td>Zone Classification:</td>
						<td style="text-align: center;">${zone}</td>
					</tr>
					<tr>
						<td>Property Type:</td>
						<td style="text-align: center;">${propertyType}</td>
					</tr>
					<tr>
						<td>Build Year:</td>
						<td style="text-align: center;">${buildYear}</td>
					</tr>
					<tr>
						<td>Area:</td>
						<td style="text-align: center;">${buildArea}</td>
					</tr>
					<tr>
						<td>Tax Amount:</td>
						<td style="text-align: center;">${tax}</td>
					</tr>
				</table>

				<a style="float: right; margin-top: 10px"
					class="waves-effect waves-light btn" href="/Spring201">Continue</a>
			</div>
		</div>
	</section>

</body>
</html>