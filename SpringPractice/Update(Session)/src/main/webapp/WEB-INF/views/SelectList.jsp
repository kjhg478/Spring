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
	<h2>회원목록</h2>
	<c:forEach items="${selectlist }" var="list">
		<a href ="MemberView?mid=${list.mid}"> ${list.mid}</a>
		<p> ${list.mname}</p>
		<a href = "MemberDelete?mid=${list.mid }">삭제하기</a>

			
	</c:forEach>
	
</body>
</html>