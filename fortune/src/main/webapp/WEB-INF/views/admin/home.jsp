<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>fortune cookie</title>
</head>
<body>
<h1>
	[administrator]  
</h1>

	<c:if test="${empty adminId}">
		<form action="/fortune/admin/login" method="post">
			<br>관리자로 로그인하세요. <br>
			ID: <input type="text" name="id" ><br>
			PW: <input type="text" name="password" ><br>
			<input type="submit" value="LOGIN" >
		</form>
	</c:if>
	
	<c:if test="${!empty adminId}">
		<br>관리자로 접속되었습니다.<br><br>
		<a href="${cp}/fortune/admin/check">DATABASE 조회</a> &nbsp;&nbsp; 
		<a href="${cp}/fortune/admin/register">DATABASE 등록 및 삭제</a> &nbsp;&nbsp; 
		<a href="${cp}/fortune/admin/logout">LOGOUT</a> &nbsp;&nbsp;
	</c:if>
</body>
</html>
