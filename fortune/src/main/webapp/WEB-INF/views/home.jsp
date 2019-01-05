<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>fortune cookie</title>
</head>
<body>
<h1>
	Hello fortune cookies!  
</h1>
	<form action="/fortune/submit" method="post">
		<br>포춘쿠키를 확인하세요!<br>
		이름 : <input type="text" name="name" ><br>
		<input type="submit" value="확인" >
	</form>
</body>
</html>
