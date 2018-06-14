<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>No title</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Patients</h2>
	<table>
		<tr>
			<td>Id</td><td>First Name</td><td>Last Name</td><td></td>
		</tr>
		<c:forEach items="${patients}" var="patient">
			<tr>
			<td>${patient.id}</td>
			<td>${patient.firstName}</td>
			<td>${patient.lastName}</td>
			<td><a href="<c:url value='/delete-${patient.id}-patient' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new-patient' />">Add New Patient</a>
</body>
</html>