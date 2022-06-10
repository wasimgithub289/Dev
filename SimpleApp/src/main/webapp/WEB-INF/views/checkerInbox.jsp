<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<b>This is Checker Inbox</b>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Amount</th>
			<th>Approve</th>
			<th>Reject</th>
		</tr>

		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.amount}</td>
				<td><a href="${pageContext.request.contextPath}/inbox">Approve</a></td>
				<td><a href="${pageContext.request.contextPath}/inbox">Reject</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>