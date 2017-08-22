<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" type="text/css" href="/board/resources/css/default.css" />
</head>
<body>
<h1>[ 글쓰기 ]</h1>
<form action="/board/board/write" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>작성자</th>
			<td>${sessionScope.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" id="title" required="required"></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td><input type="file" name="uploadFile"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" required="required"></textarea></td>
		</tr>
		<tr>
			<td class="right" colspan="2">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="history.go(-1)">
			</td>
		</tr>
	</table>
	<input type="hidden" name="id" value="${sessionScope.id}">
</form>
</body>
</html>
