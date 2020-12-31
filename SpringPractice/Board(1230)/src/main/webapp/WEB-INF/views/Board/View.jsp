<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table, tr, td {
	text-align: center;
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

body {
	text-align: center;
}
</style>
<body>
	<form action="regBoard" method="post">
		<table>
			<tr>
				<td>글번호</td>
				<td>${board.bnum}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${board.btitle}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.bwriter}</td>
			</tr>
			<tr>
				<td>글조회수</td>
				<td>${board.bhits}</td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${board.bdate}</td>
			</tr>
			<tr>
				<td colspan="2" style="padding: 0"><textarea rows="15" cols="40" style="resize: none;" name="bcontents">${board.bcontents}</textarea></td>
			</tr>

		</table>
	</form>
	<a href="./">홈으로가기</a>
</body>
</html>













