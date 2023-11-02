<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Add User Details</h1>
<form method="post" action="/save">
Username<input type="text" name="userName">
Contact<input type="text" name="contact">
Adress<input type="text" name="address">
<input type="submit" value="Save">
</form>
</center>
</body>
</html>