<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>table,tr,td,th{
border: solid 1px;
}</style>
</head>
<body>
	<center>
		<h1 style="color: red">Spring MVC User Managament Application</h1>
		<div><button><a href="/add">ADD USER</a></button></div>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Contact</th>
				<th>Adress</th>
			</tr>

			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${ user.userName}</td>
					<td>${ user.contact}</td>
					<td>${ user.address}</td>
			</c:forEach>
			</tr>
		</table>
	</center>
</body>
</html>