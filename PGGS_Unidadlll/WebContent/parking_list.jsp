<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="ParkingController">
					<input type="submit" name="btn_new" value = "New"/>
				</form>
			</th>
			 <th>Id</th>
			 <th>Type</th>
			 <th>Number of cars</th>
			 <th>Company</th>
		</tr>
		<c:forEach var="parking" items="${parkings}">
			<tr>
				<td>
					<form action= "ParkingController">
					<input type = "hidden" name = "id" value= "${parking.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
				</td>
			<td> ${parking.id}</td>
			<td> ${parking.type}</td>
			<td> ${parking.num_cars}</td>
			<td> ${parking.company}</td>
			</tr>
			</c:forEach>
	</table>
	
	<form action="ParkingReport">
				
					<input type = "submit" name = "btn_reporte" value = "Generar reporte"/>
				</form>

</body>
</html>