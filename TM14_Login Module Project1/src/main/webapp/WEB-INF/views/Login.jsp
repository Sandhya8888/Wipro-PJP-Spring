<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter your Login Details</h1>
<form action="loginCheck" method="post">
<table>
<tr>
<th>Username:</th>
<td><input type="text" name="username" id="username" required></td>
</tr>
<tr>
<th>Password:</th>
<td><input type="password" name="password" id="password" required></td>
</table>
<p>
<input type="submit" value="LOGIN">
</p>
</form>
<div><c:out value="${error}" /></div>
</body>
</html>