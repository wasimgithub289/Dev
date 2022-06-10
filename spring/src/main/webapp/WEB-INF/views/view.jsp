<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
User Info

Id: ${user_info.id}  <br>
Email: ${user_info.email}  <br>
Verified Email: ${user_info.verified_email}  <br>
Picture: <img src= "${user_info.picture}">  <br>
</body>
</html>