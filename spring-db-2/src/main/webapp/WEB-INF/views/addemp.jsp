<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
 ${message}<br><br> 
	
	<div align="center">
		<form action="addemp" method="post">

			<label for="fname"> Name:</label><br> <input type="text"
				id="lname" name="name"><br>
			<br> <label for="fname">Designation:</label><br> <input
				type="text" id="lname" name="designation"><br>
			<br> <label for="fname">Experience:</label><br> <input
				type="text" id="lname" name="experience"><br>
			<br> <label for="fname">Age:</label><br> <input type="text"
				id="lname" name="age"><br>
				<label for="fname">Status:</label><br> <input type="text" id="lname"
				name="status"><br> <br>
			<br> <input type="submit" value="Submit">
		</form>
	</div>



</body>
</html>