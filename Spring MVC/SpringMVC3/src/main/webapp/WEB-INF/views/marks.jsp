<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="result">
<p>Enter Science Marks:
<input type="number" id="scienceMarks" name="scienceMarks">
</p>
<p>Enter English Marks:
<input type="number" id="englishMarks" name="englishMarks">
</p>
<p>Enter Maths Marks:
<input type="number" id="mathsMarks" name="mathsMarks">
</p>
<p>
<input type="submit" name="submit" value="submit">
</p>
</form>


</body>
</html>