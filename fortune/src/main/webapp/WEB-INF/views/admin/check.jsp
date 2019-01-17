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
	<a href="${cp}/fortune/admin/check">DATABASE 조회</a> &nbsp;&nbsp; 
	<a href="${cp}/fortune/admin/register">DATABASE 등록 및 삭제</a> &nbsp;&nbsp; 
	<a href="${cp}/fortune/admin/logout">LOGOUT</a> &nbsp;&nbsp;
	<br>
	<br> FORTUNE LIST <br>
	<c:forEach items="${fortunes}" var="fortunes">        
         <br>${fortunes.sentence}
   	</c:forEach>

</body>
</html>
