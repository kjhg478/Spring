<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<form action="member/regMember" method="post" enctype="multipart/form-data" id="regForm">
		아이디 : <input type="text" name="uid" id="uid"><span id="result"></span><br>
		비밀번호 : <input type="password" name="upwd" id="userPw"><br>
		비밀번호 확인 : <input type="password" id="confirmPw"><br>
		이름 : <input type="text" name="uname"><br>
		생년월일 : <input type="date" name="ubirth"><br>
		이메일 : <input type="email" name="uemail"><br>
		주소 : <input type="text" name="uadd"><br>
		전화번호 : <input type="text" name="uphone" placeholder="-없이 숫자만" id="uphone"
		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="11"><br>
		프로필사진 : <input type="file" name="uprofile"><br>
		남자 <input type="radio" value="남자" name="ugender">
		여자 <input type="radio" value="여자" name="ugender"><br>
		
		<input type="submit" id="btnSubmit" onclick="goinit()" value="제출하기!">
	
	</form>
	
</body>

</html>