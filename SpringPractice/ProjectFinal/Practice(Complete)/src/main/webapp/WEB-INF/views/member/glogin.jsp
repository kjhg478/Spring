<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello Guys!  
</h1>
<div id="here"></div>

<input id="mid" type="text">
<input id="mpwd" type="text">
<button onclick="login()">로그인하기</button>


<a href="#!regMember" onclick="getInto('member/goRegMember')">처음이신가요?</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</html>
