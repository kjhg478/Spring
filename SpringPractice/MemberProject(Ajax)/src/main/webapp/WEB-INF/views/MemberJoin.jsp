<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	/* ajax 어싱크로노스(asynchronous)
	   동기적 쿼리  : 클라이언트 입장에서 모든 과정을 내가 다 볼 수 있다.
	   		        화면전환의 동작들이 내 눈에 보임
	   비동기적 쿼리 : 일종의 백그라운드에서 프로세스가 일어나기 때문에
	   				화면 전환 없이 작업 수행
	   				
	   아이디 중복확인 과정
	   아이디 입력창에 있는 값을 스크립트 함수에 가져옴
	   입력 값을 ajax를 이용해 서버(백엔드(컨트롤러))로 보내고 결과값을 가져옴
	   결과값에 따라 사용가능 여부 메시지를 아이디 입력칸 옆에 출력
	*/
	
	function idOverlap() {
		   var inputId = $("#mid").val();
		   // var checkResult = ${"#checkresult"};
		   var checkResult = document.getElementById("checkresult");
		   console.log(inputId);
		   /* JSON(Javascript Object Notation) */
		   $.ajax({
			   type: "post", 
			   url : "idoverlap",
			   data: {"mid" : inputId}, // 전송 데이터
			   dataType : "text", // 리턴 데이터 형식
			   success : function(result) {
				   if(result=="ok") {
					   checkResult.style.color = "green";
					   checkResult.innerHTML = "사용 가능한 ID 입니다";
				   }else {
					   checkResult.style.color = "red";
					   checkResult.innerHTML = "이미 사용중인 ID 입니다";
				   }
			   },
			   error: function() {
				   alert("틀렸다");
			   }
		   });
	   }
</script>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action = "join">
	
	아이디<input type = "text" name = "mid" id="mid" onkeyup="idOverlap()" >
		<span id="checkresult"></span><br/>
	비밀번호<input type = "password" name = "mpwd" ><br/>
	이름<input type = "text" name = "mname"><br/>

	폰번호<input type = "text" name = "mphone" ><br/>

	이메일<input type = "email" name = "memail"><br/>
	생년월일<input type = "date" name = "mbirth" ><br/>
	
	<input type = "submit" value = "회원가입">
	
	</form>
	

</body>
</html>