<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="/board/resources/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<script>
	$(function() {
		$("#checkId").click(function() {
			$.ajax({
				url: "/board/member/checkId",
				type: "post",
				data: {"id":$("#id").val()},
				dataType: "text",	//true or false를 문자열로 전송받는 방법
				success: function(result) {
					if (result == "false") {
						alert("사용 가능한 아이디입니다.");
						$("#joinBtn").removeAttr("disabled");
					} else {
						alert("이미 사용 중인 아이디입니다.");
						$("#joinBtn").attr("disabled", "disabled");
					}
				}
			});
		});
	});
	/* 
	function check(){
		var id = document.getElementById("check_id");
		if(id.value == ""){
			alert('중복체크할 아이디를 입력해 주세요.');
		}else{
			$.ajax({
				url: "/board/member/check_id",
				type: "post",	
				data: {"id":id.value},
				success: function(result){
					if(result == 1){
						alert('중복된 아이디입니다.');
						id.value = "";
						$("#checked_id").focus();
					}else{
						alert('사용 가능한 아이디');
						$("#checked_id").value = id.value;
					}
				},
				error: function(){
					alert('에러발생');
				}	
			});
			}
		}
	*/
	</script>
	<form action="/board/member/join" method="post">
		ID : <input type="text" name="id" id="id">
		<input type = "button" id="checkId" value="중복확인"><br>
		PASSWORD : <input type="password" name="pwd"><br>
		EMAIL : <input type="email" name="email"><br>
		<input type="submit" id="joinBtn" value="가입" disabled="disabled">
	</form>
</body>
</html>
