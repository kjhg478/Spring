<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> ${mid} 님 환영합니다.</h2>
	<c:if test = "${mid eq 'ADMIN' }">
	<a href = "SelectList">회원목록 보기</a>
	</c:if>
	<a href = "MemberInfo?mid=${mid }">회원수정하기</a>
</body>
</html>