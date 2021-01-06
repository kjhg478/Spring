<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>여기는 회원가입</h1>

<form action = "memberJoin" name ="join">
아이디 : <input type="text" name="stuid" id="userid" onchange = "changeid()">
<input type="button" id="idcheck" value ="중복체크"><br/>
비밀번호 : <input type="password" name="stupw" id="userpw" onchange="pwcheck1()"><br/>
비밀번호 체크 : <input type="password" id="userpw2" onchange="pwcheck1()"><br/>
<h4 id="msg"></h4>
이름 : <input type = "text" name="stuname"><br/>
조 : <select name="groupno">
		<option value="">조</option>
		<option value="01">1</option>
		<option value="02">2</option>
	</select>
<br/><br/>
<input type ="button" onclick="checkidpw()" value="회원가입"> 
</form>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script >
		let checkid = false;
		let checkpw = false;
		var pw1;
		var pw2;
		
		$(document).ready(function(){ // Jquery 문법 html 페이지가 화면에 뿌려지고 ready안에 서술 된 이벤트들이 동작준비를 함
			$('#idcheck').click(function click(){ // #안에 아이디가 클릭되어지면 실행된다
				console.log("실행");
				var userid = $('#userid').val();
				console.log(userid);
				
				$.ajax({
					async : true,
					data:{id : userid},
					url : "idCheck",
					type : 'post',
					dataType : "json",
					
					
					success : function(data) {
						if(data > 0) {
							alert("중복");
							checkid = false;
							console.log(checkid);
						}else {
							alert("사용가능");
							checkid = true;
							console.log(checkid);
						}
					},
					error : function(data) {
						alert("데이터 없는디?")
					}
				});
			});
		});
		
		function pwcheck1() {
		
			pw1 = document.querySelector("#userpw").value;
			pw2 = document.querySelector("#userpw2").value;
			console.log(pw1);
			console.log(pw2);
			
			if(pw1.length < 4 || pw1.length > 16) {
				window.alert('비밀번호 4자리 이상 16자리 이하 입력');
				document.querySelector("#userpw").value="";
			}
			
			var msg = document.querySelector("#msg");
			if(pw1==pw2) {
				msg.innerHTML = "가능한 비밀번호";
				checkpw = true;
				console.log(checkpw);
			}else {
				msg.innerHTML = "불가능한 비밀번호";
				
				checkpw = false;
				console.log(checkpw);
			}

		}
		
		function checkidpw() {
			if(!checkid) {
				alert("아이디 중복체크 해라");
			}else if(!checkpw) {
				alert("비밀번호 확인하셈");
			}else {
				alert("회원가입 성공");
				join.submit();
			}		
		}
		function changeid() {
			if(!checkid) {
				alert("아이디 중복체크 해라");
			}
		}
</script>
</html>