<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>

<link rel="stylesheet" type="text/css" href="/board/resources/css/default.css" />
<script src="/board/resources/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<script>
	$(function() {
		$(".modify").hide();
		getReplyList();
	});
	
	if("${result}"=="true") alert("처리 완료");
	else if("${result}"=="false") alert("처리 실패");
	
	function fileSizeCheck() {
		var maxSize = 10 * 1024 * 1024;
		var uploadFile = document.getElementById("uploadFile");
		var uploadFileSize = uploadFile.files[0].size;
		
		if(uploadFileSize > maxSize) {
			alert("첨부 파일은 10MB 까지 업로드 가능합니다.");
			uploadFile.value = "";
		}
	}
	
	//폼 전환
	function changeForm() {
		$(".modify").toggle();
		$(".read").toggle();
	}
	
	function getReplyList(){
		$.ajax({
			url: "/board/board/getReplyList",
			type: "post",
			data: {"boardNum":"${vo.boardNum}"},
			dataType:"json",
			success:function(result){
				$(result).each(function(index,item){
					var addRow = '<tr><td class = "replyid">'
								 + item.id + "</td>";
						addRow += '<td class = "replytext">'
								 + item.replyText + '</td>';
						addRow += '<td class = "replydate">'
							 + item.inputdate + '</td>';	
						if("${id}" == item.id){
							addRow += '<td class = "replybutton">'
								 + '<input type = "button" value = "삭제" onclick = "deleteReply('+ item.replyNum +')">'
						}		 
						addRow += '</tr>';
						$(".reply").append(addRow);
				});
			},
			error:function(result){
				console.log(result);
			}
		});
	}
	
	function replyCheck(){
		var reply = document.getElementById('replyText');
		if(reply.value == ""){
			alert('댓글을 입력해주세요');
			reply.focus();
		}else{
			$.ajax({
				url: "/board/board/writeReply",
				type: "post",
				data:{"id":"${id}","boardNum":"${vo.boardNum}","replyText":reply.value},
				success: function(){
					$(".reply").empty();
					getReplyList();
				},
				error : function(){alert("에러 발생");}
			});
		}	
	}
	
	function deleteReply(replyNum){
		if(confirm("댓글을 삭제하시겠습니까?")){
			$.ajax({
				url: "/board/board/deleteReply",
				type: "post",
				data:{"replyNum":replyNum},
				success: function(){
					$(".reply").empty();
					getReplyList();
				},
				error : function(){alert("에러 발생");}
			});
		}else{
			
		}
	}
	
	// 수정 하기
	function boardUpdate() {
		var result = confirm("수정 하시겠습니까?");
		if(result) {
			document.fm.submit();
		}
	}
	
	// 게시글 삭제
	function boardDelete() {
		var result = confirm("정말로 삭제 하시겠습니까?");
		if(result) {
			location.href = "/board/board/delete?boardNum=${vo.boardNum}";
		}
	}
	
	// 게시글 수정 폼 이동
	function updateForm() {
		location.href = "/board/board/updateForm?boardNum=${vo.boardNum}";
	}
	
	function getBoardList() {
		location.href = "/board/board/getBoardList";
	}
</script>

<h1 class="read">[ 글 읽기 ]</h1>
<h1 class="modify">[ 글 수정 ]</h1>

<form action="/board/board/update" name="fm" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td class="right" colspan="2">
		<c:if test="${sessionScope.id == vo.id}">
			<input type="button" class="read" value="수정" onclick="changeForm()">
			<input type="button" class="read" value="삭제" onclick="boardDelete()">
			<input type="button" class="modify" value="수정 완료" onclick="boardUpdate()">
			<input type="button" class="modify" value="수정 취소" onclick="changeForm()">
		</c:if>
		<input type="button" value="목록" onclick="getBoardList()">
		</td>
	</tr>
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
		<td class="read">${vo.title}</td>
		<td class="modify"><input type="text" name="title" id="title" value="${vo.title}"></td>
	</tr>
	<tr>
		<th>첨부 파일</th>
		<td>
			<c:if test="${vo.originalFileName != null}">
				<a href="/board/board/download?boardNum=${vo.boardNum}">${vo.originalFileName}</a>
			</c:if>
			<input class="modify" type="file" id="uploadFile" name="uploadFile" onchange="fileSizeCheck()">
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea class="read" readonly="readonly">${vo.content}</textarea>
			<textarea class="modify" name="content">${vo.content}</textarea>
		</td>
	</tr>
</table>
<input type="hidden" name="boardNum" value="${vo.boardNum}">
</form>

<table>
	<tr>
		<td colspan = "2" class = "right">
			<form id = "replyForm">
				<input type = "text" id = "replyText" class = "replyText">
				<input type = "button" value = "리플달기" onclick = "replyCheck()">
			</form>
		</td>
	</tr>
</table>

<table class = "reply"></table>
</body>
</html>









