<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{color:red}
</style>
</head>
<body>
<form action="add" method="post">
<p>Username:
<input type="text" name="username" id="username">
</p>
<p>Password:
<input type="password" name="password" id="password">
</p>
<p>ID:
<input type="text" name="id" id="id" required>
</p>
<p>Name:
<input type="text" name="name" id="name" required>
</p>
<p>Gender:
<input type="radio" id="male" name="gender" value="male">
<label for="male">Male</label>
<input type="radio" id="female" name="gender" value="female">
<label for="female">Female</label>
<input type="radio" id="other" name="gender" value="other">
<label for="other">Other</label>
</p>
<p>Designation:
<input type="text" name="designation" id="designation">
</p>
<p>Salary:
<input type="number" name="salary" id="salary">
</p>
<p>City:
<input type="text" name="city" id="city">
</p>
<p>Email Id:
<input type="email" name="email" id="email">
</p>
<p>Mobile number:
<input type="number" name="mobile" id="mobile">
</p>
<p>
<input type="submit" value="submit">
</form>
</body>
</html>