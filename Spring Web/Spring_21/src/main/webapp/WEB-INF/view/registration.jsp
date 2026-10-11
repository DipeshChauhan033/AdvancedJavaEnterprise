<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${welcomemessage}</h1>
	
	<form action="registration.do" method="post">
        <input type="text" name="id" placeholder="Enter Id">
        <br><br>
		<input type="text" name="name" placeholder="Enter Name">
		<br><br>
		<input type="text" name="address" placeholder="Enter Address">
        <br><br>
        <input type="text" name="salary" placeholder="Enter Salary">
        <br><br>

        <input type="submit" value="Register"><br><br>
        
        <h3>${InvalidUser}</h3>
    </form>

</body>
</html>