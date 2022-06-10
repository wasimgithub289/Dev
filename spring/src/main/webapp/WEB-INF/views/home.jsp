<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Please click to login

<a href = "https://accounts.google.com/o/oauth2/auth?scope=email
&redirect_uri=http://localhost:8080/success
&response_type=code&client_id=954608993195-917bc4lkjvjst7m2vq344c3ul2totfu9.apps.googleusercontent.com
&approval_prompt=force">Login</a>


<form:form method="post" action="/addUser" modelAttribute="user">
      <table>
         <tr>
             <td><form:label path="name">Name</form:label></td>
             <td><form:input path="name"/></td>
         </tr>
         <tr>
             <td><form:label path="id">Id</form:label></td>
             <td><form:input path="id"/></td>
         </tr>
         <tr>
             <td><form:label path="address">
               Address</form:label></td>
             <td><form:input path="address"/></td>
         </tr>
         <tr>
             <td><input type="submit" value="Submit"/></td>
         </tr>
     </table>
 </form:form>

</body>
</html>