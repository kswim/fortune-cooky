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

	<P> ${result} </P>

	<form action="/fortune/review" method="post">
		<br>리뷰 남기기<br>
		점수: <input type="text" name="review" ><br>
		<input type="submit" value="확인" >
	</form>

</body>
</html>
