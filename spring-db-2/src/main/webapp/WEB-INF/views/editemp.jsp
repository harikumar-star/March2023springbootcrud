<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Employee</title>
</head>
<body>
	<div align="center">
		<h1>EDIT EMP</h1>
		<form:form action="saveemp" method="post" modelAttribute="contact">
			<table>
				<form:hidden path="empid" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name"  /></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><form:input path="designation" /></td>
				</tr>
				<tr>
					<td>Experience:</td>
					<td><form:input path="experience" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>

					<td>Status:
					<td>
					<td>NO <form:radiobutton path="status" value="no" />
					 YES <form:radiobutton path="status" value="yes"/>  
       
					</td>




				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>