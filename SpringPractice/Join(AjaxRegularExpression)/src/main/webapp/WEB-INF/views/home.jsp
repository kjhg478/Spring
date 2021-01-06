<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form action = "Login">
아이디 : <input type = "text" name = "stuid">
비밀번호 : <input type = "password" name ="stupw">
<input type = "submit" value="로그인">
<input type = "button" onClick = "location.href='MemberJoin'" value = "회원가입">

</form>
</body>
</html>
