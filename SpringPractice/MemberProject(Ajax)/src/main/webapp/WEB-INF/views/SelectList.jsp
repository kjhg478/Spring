<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	function memberviewAjax(mid) {
		console.log(mid);
		$.ajax({
			type:"post",
			url: "memberviewajax",
			data: {"mid" : mid},
			dataType : "json",
			success : function(result) {
				var output = "<table border='1'>";
				output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th>";
				output += "<th>PHONE</th> <th>EMAIL</th> <th>BIRTH</th></tr>";
				output += "<tr>";
				output += "<td>"+result.mid+"</td>";
				output += "<td>"+result.mpassword+"</td>";
				output += "<td>"+result.mname+"</td>";
				output += "<td>"+result.mphone+"</td>";
				output += "<td>"+result.memail+"</td>";
				output += "<td>"+result.mbirth+"</td>";
				output += "</tr>";
				output += "</table>";
				
				$("#memberviewdiv").html(output);

			},
			error : function() {
				alert("오타확인");
			}
		});
	}
</script>
</head>
<body>
	<h2>회원목록</h2>
	<c:forEach items="${selectlist }" var="list">
		<a href ="MemberView?mid=${list.mid}"> ${list.mid}</a>
		<p> ${list.mname}</p>
		<a href = "MemberDelete?mid=${list.mid }">삭제하기</a>
		<input type = "button" onclick = "memberviewAjax('${list.mid}')" value = "ajax 조회">
			
	</c:forEach>
	<div id ="memberviewdiv">
	
	</div>
</body>
</html>