<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 수정</h2>
	<form action = "MemberModify">
	<input type = "text" name = "mpwd" value="${MemberInfo.mid }" readonly>
	비밀번호 변경<input type = "password" name = "mpwd" >
	<p>${MemberInfo.mname }</p>
	이름<input type = "text" name = "mname">
	<p>${MemberInfo.mphone }</p>
	폰번호<input type = "text" name = "mphone">
	
	<p>${MemberInfo.memail }</p>
	이메일<input type = "text" name = "memail">
	<p>${MemberInfo.mbirth }</p>
	생년월일<input type = "text" name = "mbirth">
	<input type = "submit" value ="수정하기">
	</form>
	
</body>
</html>