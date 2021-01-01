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
	<h2>회원상세보기</h2>

		<p> ${memberView.mid }</p>
		<p> ${memberView.mname }</p>
		<p> ${memberView.mphone }</p>
		<p> ${memberView.memail }</p>
		<p> ${memberView.mbirth }</p>
		
			

</body>
</html>