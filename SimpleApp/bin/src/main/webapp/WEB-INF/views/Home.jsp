<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored = "false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="saveUser" modelAttribute="user">
		Name<form:input path="name" />
		<form:errors path="name" style="color:red" />
		<p/>
		Address<form:input path="address" />
		<form:errors path="address" style="color:red" />
		<p/>
		<p/>
		Amount<form:input path="amount" />
		<form:errors path="amount" style="color:red" />
		<p/>
		<input type="submit" value="submit" />
	</form:form>

</body>
</html>