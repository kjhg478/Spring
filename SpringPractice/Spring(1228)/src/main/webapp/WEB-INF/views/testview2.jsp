<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>testview2.jsp</h2>
	<h2>Controller에서 넘어온 값</h2>
	첫번째 : <p>${pa1 }</p>
	두번째 : <p>${pa2 }</p>
	
	<a href="./">홈으로 가기</a>
	<!-- 절대경로와 상대경로라는건데 ./로 홈으로 가기 버튼 활용 가능 ! -->
	
	<form action = "insert" method= "post">
		DB에 저장할 데이터 : <input type="text" name="data1"> <br/>
		<input type ="submit" value="DB 저장">
	
	</form>


</body>
</html>