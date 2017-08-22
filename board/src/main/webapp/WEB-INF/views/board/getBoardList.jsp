<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="/board/resources/css/default.css" />
</head>
<body>
<script>
	if("${result}"=="true") alert("처리 완료");
	else if("${result}"=="false") alert("처리 실패");
	
	function pageProc(currentPage, searchCondition, searchKeyword) {
		location.href = "/board/board/getBoardList?currentPage=" + currentPage + "&searchCondition=" + searchCondition + "&searchKeyword=" + searchKeyword;
	}
</script>
	<h1>[ 게시판 ]</h1>
	<table>
		<tr>
			<td colspan="4">
				<form action="/board/board/getBoardList" method="get">
					<select name="searchCondition">
						<option value="TITLE" selected="selected">제목</option>
						<option value="ID">작성자</option>
						<option value="CONTENT">내용</option>
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</form>
			</td>
			<td class="right"><a href="/board/board/writeForm"><img src="/board/resources/img/write_64.png"></a></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${boardList}" var="vo">
			<tr>
				<td class="center">${vo.boardNum}</td>
				<td class="center">${vo.id}</td>
				<td id="title"><a href="/board/board/read?boardNum=${vo.boardNum}">${vo.title}</a></td>
				<td class="center">${vo.hit}</td>
				<td id="inputdate">${vo.inputdate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" id="navigator">
				<a href="javascript:pageProc(${navi.currentPage - navi.pagePerGroup }, '${searchCondition}', '${searchKeyword}' )">◁◁</a>
				<a href="javascript:pageProc(${navi.currentPage - 1 }, '${searchCondition}', '${searchKeyword}' )">◀</a>
				<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}" var="counter">
					<c:if test="${counter == navi.currentPage}"><b></c:if>
					<a href="javascript:pageProc(${counter}, '${searchCondition}', '${searchKeyword}' )">${counter}</a>
					<c:if test="${counter == navi.currentPage}"></b></c:if>
				</c:forEach>
				<a href="javascript:pageProc(${navi.currentPage + 1 }, '${searchCondition}', '${searchKeyword}' )">▶</a>
				<a href="javascript:pageProc(${navi.currentPage + navi.pagePerGroup }, '${searchCondition}', '${searchKeyword}' )">▷▷</a>
			</td>
		</tr>
	</table>
</body>
</html>













