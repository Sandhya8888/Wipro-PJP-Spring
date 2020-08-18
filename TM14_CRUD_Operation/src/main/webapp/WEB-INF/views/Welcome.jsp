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
<h1>Welcome <c:out value="${name}" /></h1>
<h1>MENU</h1>
<p>
<a href="register">ADD Employee</a>
</p>
<p>
<a href="delete">DELETE Employee</a>
</p>
<p>
<a href="modify">MODIFY Personal details</a>
</p>
<p>
<a href="select">SELECT Employee by Id</a>
</p>
<p>
<a href="all">SELECT ALL Employee</a>
</p>
</body>
</html>