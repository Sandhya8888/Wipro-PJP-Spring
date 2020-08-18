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
<h1>Congratulations</h1>
<h2>You received a <c:out value="${cash}" />% cash back offer</h2>
<h3>Your Updated Balance is : <c:out value="${ubal}" /></h3>
</body>
</html>