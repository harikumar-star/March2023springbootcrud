<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emp details</title>
    </head>
    <body>
    
  
        <div align="center">
            <h1>EMP LIST</h1>
            <h3><a href="/newContact">Emp</a></h3>
            <table border="1">
                <th>Emp ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Experience</th>
                <th>Age</th>
                <th>Status</th>
                
                 
                <c:forEach var="name" items="${listContact}" varStatus="status">
                <tr>
              
                    <td>${name.empid}</td>
                    <td>${name.name}</td>
                    <td>${name.designation}</td>
                    <td>${name.experience}</td>
                    <td>${name.age}</td>
                     <td>${name.status}</td>
                   
                    <td>
                         
                        <a href="/editemp?empid=${name.empid}&check=${name.empid}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deletebyid?empid=${name.empid}">Delete</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                      
                    </td>
                            
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>