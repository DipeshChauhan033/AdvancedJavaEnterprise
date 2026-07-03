<%@page import="com.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Crud"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int start = 0;
		String startsend = request.getParameter("startsend");
		if(startsend!=null){
			start = Integer.parseInt(startsend);
		}
		Crud crud = new Crud();
		List<Employee> list = crud.read(start);
		
		for(Employee data : list){
			
	%>
			<h3>ID : <%=data.getEid()%></h3>
			<h3>Name : <%=data.getEname()%></h3>
			<h3>Address : <%=data.getEaddress()%></h3>
			<h3>Salary : <%=data.getEsalary()%></h3> <br><br>
			
			
	<% start++;} %>
	<form action="index.jsp">
		<input type="hidden" name = "startsend" value="<%=start%>">
		<%
		if(start<20){
		%>
			<button>Next</button>
		<%}%>
			
	
	</form>
	
	<form action="index.jsp">
		<input type="hidden" name = "startsend" value="<%=start-8%>">
		<%
		if(start!=4){
		%>
			<button>Previous</button>
		<%}%>
			
	
	</form>
	
</body>
</html>