<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	${message}
	${msg}
	<br> ${edit}
	<br>
	<br>
	<br>
	<br>
	<h1>LIST DETAILS</h1>
	<a href="/viewempdetails">SHOW EMPLOYEE DETAILS</a>
	<br>
	<a href="/jsppageto?value=specificrecord">FIND SPECIFIC EMPLOYEE DETAILS</a>
	<br>
	<a href="/jsppageto?value=add">ADD EMPLOYEE DETAILS IN DATABASE AND WRITE IT TO FILE</a>
	&nbsp;&nbsp;&nbsp;&nbsp;

	<br>
	<a href="/deleteall">DELETE ALL EMPLOYEE DETAILS IN
		DATABASE</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<br>
	
==========================


<h1>EMPLOYEE ACTIVITIES</h1>


<br>
	<a href="/jsppageto2?value=emplogin">EMPLOYEE LOGIN</a>
	<br>
	
	
	<br>
	<a href="/downloadCSV">DOWNLOAD CSV FILE</a>
	<br>
	

	<br>
	<a href="/readdatafromfile">SHOW NOTEPAD OF DB DATA</a>
	<br>

    <br>
	<a href="/writecsv">Read from db and Write to Csv File </a>
	<br>


<br>
	<a href="/insertbatch">Insert Batch </a>
	<br>




<br>
	<a href="/updatebatch">Update Batch </a>
	<br>



</body>
</html>