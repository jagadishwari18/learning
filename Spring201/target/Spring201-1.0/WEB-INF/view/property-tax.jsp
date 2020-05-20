<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<style>
.footer-btn {
	float: right
}

.card-section {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.card {
	width: 800px;
	height: 620px;
	overflow: auto;
}

.form-heading {
	font-family: verdana;
	font-size: 18px;
	text-align: center;
}

.row, .input-field {
	margin-bottom: 11px !important;
}

input {
	height: 2.3rem !important;
	margin-bottom: 10px !important;
}

textarea.materialize-textarea {
	overflow-y: hidden;
	resize: none;
	height: .6rem !important;
	padding-top: .5rem !important;
	padding-bottom: .5rem !important;
}

::-webkit-scrollbar {
	width: 6px;
}

::-webkit-scrollbar-thumb {
	border-radius: 12px;
	box-shadow: inset 0 0 3px;
	background: #ccc;
}

::-webkit-scrollbar-track {
	border-radius: 15px;
	box-shadow: inset 0 0 5px grey;
}
</style>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- Compiled and minified CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css"
	rel="stylesheet" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});

	function getFormData() {
		var formData = document.getElementById("myForm").submit();
		console.log("Form Data" + formData);
		if (document.getElementById("tax").value === 0) {
			alert("Compute the Tax");
		}
	}

	function computeTax() {
		var zone = document.getElementById("zone");
		var status = document.getElementById("status");
		var propertyType = document.getElementById("propertyType");
		console.log(zone.options[zone.selectedIndex].value + " " + " "
				+ propertyType.options[propertyType.selectedIndex].value);
		var taxData = {
			zone : '',
			status : '',
			propertyType : '',
			buildYear : '',
			buildArea : '',
			yearOfAssessment : '',
		};

		var data = new Object();
		data.zone = zone.options[zone.selectedIndex].value;
		data.status = status.options[status.selectedIndex].value;
		data.propertyType = propertyType.options[propertyType.selectedIndex].value
		data.buildYear = document.getElementById("buildYear").value;
		data.buildArea = document.getElementById("buildArea").value;
		data.yearOfAssessment = document.getElementById("yearOfAssessment").value;

		console.log(data);
		if (data.zone != '' && data.status != '' && data.propertyType != ''
				&& data.buildYear != '' && data.buildArea != ''
				&& data.yearOfAssessment != '') {
			console.log("Making an AJAZ call to computeTax")
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : '/Spring201/computeTax/',
				dataType : 'json',
				data : data,
				async : true,
				success : function(response) {
					console.log(response);
					$("#tax").val(response);
				},
				error : function(data) {
					console.log(data);
				}

			});
		} else {
			alert("All  required fields are not entered");
		}

	}
</script>
</head>
<body>
	<section class="card-section">
		<div class="card">
			<h6 class="form-heading">Self Assessment of Property Tax Form</h6>
			<div class="card-content">
				<form action="propertyTaxFormSubmission" name="myForm" id="myForm"
					method="post">
					<div class="row">
						<div class="input-field col s12">
							<input type="text" id="yearOfAssessment"
								placeholder="Year of assessment" name="yearOfAssessment"
								readonly="readonly" value="2019" class="validate" required
								aria-required="true"> <label for="yearOfAssessment">Year
								of Assessment:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="text" id="ownerName" name="ownerName"
								placeholder="Owner Name" class="validate" required
								aria-required="true" pattern="[A-Za-z\s]+"> <label
								for="owner-name" data-error="Invalid Input">Owner Name:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="email" id="email" name="email" class="validate"
								required aria-required="true" placeholder="name@example.com">
							<label for="email" data-error="InvaildEmail">Email:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<textarea id="address" name="address"
								class="materialize-textarea" placeholder="Address"
								class="validate" required aria-required="true"></textarea>
							<label for="address" data-error="Invalid Input">Address:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s3">
							<select name="zone" class="validate" required id="zone"
								aria-required="true">
								<c:forEach items="${zones}" var="zone">
									<option value="${zone.zoneId}">${zone.zoneName}</option>
								</c:forEach>
							</select> <label>Zonal Classification:</label>
						</div>
						<div class="input-field col s6">
							<select name="propertyType" class="validate" required
								id="propertyType" aria-required="true">
								<option value="1">RCC buildings</option>
								<option value="2">RCC buildings with cement or
									red-oxide flooring</option>
								<option value="3">Tiled/Sheet of all kind</option>
							</select> <label>Description of property:</label>
						</div>

						<div class="input-field col s3">
							<select name="status" class="validate" required id="status"
								aria-required="true">
								<option value="1">Owner</option>
								<option value="2">Tenated</option>
							</select> <label>Status:</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="text" id="buildYear" name="buildYear"
								placeholder="2004" class="validate" required
								aria-required="true" pattern="^([0-9]{4})$"><label
								for="buildYear" data-error="Invalid Input">Building
								constructed year:</label>
						</div>

						<div class="input-field col s6">
							<input type="text" id="buildArea" name="buildArea"
								placeholder="1200" class="validate" required
								aria-required="true" pattern="[0-9]+" maxlength="7"><label
								for="buildArea" data-error="Invalid Input">Build up area
								(square feet):</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="text" name="tax" placeholder="payable tax" id="tax"
								required aria-required="true" readonly="readonly"> <label
								for="tax" data-error="Invalid Input"> Total Tax Payable:</label>
						</div>
						<div class="input-field col s6">
							<button type="button" onclick="computeTax()"
								class="btn-small waves-effect waves-teal btn"
								style="background-color: blue; font-size: 12px;">Compute</button>
						</div>
					</div>
					<div class="row card-action">
						<div class="footer-btn ">
							<button type="reset" class="btn" style="background-color: red;">Cancel</button>
							<button type="submit" class="btn"
								style="background-color: green;">Pay Tax</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>