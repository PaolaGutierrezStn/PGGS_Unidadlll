<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Form</title>
</head>
<body>
	<form action="ParkingController">
		<label>Type:</label><br>
		<input type="text" name="type" value="${parking.type}"><br>
		
		<label>Number of cars:</label><br>
		<input type="number" name="num_cars" value="${parking.num_cars}"><br>
		
		<label>Company:</label><br>
		<input type="text" name="company" value="${parking.company}"><br>
		
		<input type="submit" name="btn_save" id="btn_save" value="Save">
	</form>

</body>
</html>