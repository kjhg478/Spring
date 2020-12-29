<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action = "join">
	
	아이디<input type = "text" name = "mid"><br/>
	비밀번호<input type = "password" name = "mpassword" ><br/>
	이름<input type = "text" name = "mname"><br/>

	폰번호<input type = "text" name = "mphone" ><br/>

	이메일<input type = "email" name = "memail"><br/>
	생년월일<input type = "date" name = "mbirth" ><br/>
	
	<input type = "submit" value = "회원가입">
	
	</form>
	

</body>
</html>