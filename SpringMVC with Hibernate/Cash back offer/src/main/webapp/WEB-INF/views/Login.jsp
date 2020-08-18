<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color:#DE5050;
}
</style>
</head>
<body>
<h1>Enter your Login Details</h1>
<form action="loginCheck" method="post">
<table>
<tr>
<th>Customer ID:</th>
<td><input type="text" name="CustomerID" id="CustomerID" required></td>
</tr>
<tr>
<th>Password:</th>
<td><input type="password" name="Password" id="Password" required></td>
</table>
<p>
<input type="submit" value="LOGIN">
</p>
</form>
<div><c:out value="${error}" /></div>
</body>
</html>