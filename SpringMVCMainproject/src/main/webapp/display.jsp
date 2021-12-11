<%@page import="com.techpalle.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- read all students from request object -->

<table border="1">
	<tr>
		<th>name</th>
		<th>email</th>
		<th>pw</th>
		<th>mobile</th>
	</tr>
	<%
		ArrayList<Student> all = (ArrayList<Student>)request.getAttribute("students");
		for(Student stud : all)
		{
			String name = stud.getName();
			String email = stud.getEmail();
			String pw = stud.getPw();
			String mobile = stud.getMobile();%>
			<tr>
				<td><%=name %></td>
				<td><%=email %></td>
				<td><%=pw %></td>
				<td><%=mobile %></td>
			</tr>
		<% }
	%>
</table>

</body>
</html>