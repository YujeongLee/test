<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
	<c:if test="${sessionScope.id == null}">
		<h1><a href="/board/member/joinForm">회원 가입</a></h1>
		<h1><a href="/board/member/loginForm">로그인</a></h1>
	</c:if>
	<c:if test="${sessionScope.id != null}">
		<h1>${sessionScope.id}님 반갑습니다!</h1>
		<c:if test="${sessionScope.id == 'admin'}">
			<h1><a href="/board/member/memberList">회원 목록</a></h1>
		</c:if>
		<h1><a href="/board/board/getBoardList">게시판</a></h1>
		<h1><a href="/board/member/logout">로그 아웃</a></h1>
	</c:if>
</body>
</html>