<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
	<h1>[ 회원 목록 ]</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>PWD</th>
		</tr>
		<c:forEach items="${memberList}" var="vo">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>












