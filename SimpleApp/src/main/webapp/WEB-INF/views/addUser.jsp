<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored = "false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Total Users: ${userCount}
<a href="${pageContext.request.contextPath}/getAllUsers">Show All Users</a> <br>

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


<b>${message}</b>


	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Amount</th>
		</tr>

		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.amount}</td>
			</tr>
		</c:forEach>
	</table>	

</body>
</html>