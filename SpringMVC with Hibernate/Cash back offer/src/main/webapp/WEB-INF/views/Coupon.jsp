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
<h1>Your Current Balance is : <c:out value="${balance}" /></h1>
<h2>Claim your Cash Back here</h2>
<form action="validCoupon" method="post">
<p>Enter Coupon Code:
<input type="text" name="CouponCode" required>
</p>
<input type="hidden" name="id" value='<c:out value="${id}"></c:out>'>
<p>
<input type="submit" value="CLAIM">
</p>
</form>
<div><c:out value="${error}" /></div>
</body>
</html>