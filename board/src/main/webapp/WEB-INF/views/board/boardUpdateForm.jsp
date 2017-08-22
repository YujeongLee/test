<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>
<link rel="stylesheet" type="text/css" href="/board/resources/css/default.css" />
</head>
<body>
<script>
	function boardUpdate() {
		var result = confirm("수정 하시겠습니까?");
		if(result) {
			document.fm.submit();
		}
	}
</script>

<h1>[ 글 수정 ]</h1>
<form action="/board/board/update" name="fm" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>번호</th>
			<td>${vo.boardNum}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.inputdate}</td>
		</tr>
		<tr>
			<th>조회</th>
			<td>${vo.hit}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" id="title" value="${vo.title}" required="required"></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td>
				<c:if test="${vo.originalFileName != null}">
					${vo.originalFileName }<br>
				</c:if>
				<input type="file" name="uploadFile">
			</td>
		</tr>
		<tr>
			<th>내용</th>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			
			<td><textarea name="content" required="required">${vo.content}</textarea></td>
		</tr>
		<tr>
			<td class="right" colspan="2">
				<input type="button" value="수정" onclick="boardUpdate()">
				<input type="button" value="취소" onclick="history.go(-1)">
			</td>
		</tr>
	</table>
	<input type="hidden" name="boardNum" value="${vo.boardNum}">
</form>
</body>
</html>
