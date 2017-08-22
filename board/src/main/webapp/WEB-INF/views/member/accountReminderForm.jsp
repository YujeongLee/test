<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID / PASSWORD 확인</title>
</head>
<body>
	<form action="/board/member/accountReminder" method="post">
		가입시 등록한 e-mail 을 입력하세요<br>
		<input type="email" name="email"><br>
		<input type="submit" value="전송"><br>
	</form>
	<c:if test="${result != null && result == false}">
		입력하신 e-mail이 존재하지 않습니다.
	</c:if>
	<c:if test="${result != null && result == true}">
		ID / PASSWORD 를 등록하신 e-mail로 전송했습니다.
	</c:if>
</body>
</html>













