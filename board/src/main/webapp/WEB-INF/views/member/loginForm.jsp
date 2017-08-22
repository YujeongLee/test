<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="/board/member/login" method="post">
		ID : <input type="text" name="id"><br>
		PWD : <input type="password" name="pwd"><br>
		<input type="submit" value="로그인"><br>
	</form>
	<a href="/board/member/accountReminderForm">ID / PASSWORD 가 기억나지 않을 때</a><br>
	<c:if test="${requestScope.result == false}">
		ID 나 PASSWARD 가 일치하지 않습니다
	</c:if>
</body>
</html>













