<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>

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
</head>
<body>
   <table>
      <colgroup>
         <col width="100px">
         <col width="300px">
         <col width="100px">
         <col width="100px">
      </colgroup>

      <tr>
         <td>${Boardinfo.bnum} </td>
         <td>${Boardinfo.bwriter}</td>
         <td>${Boardinfo.btitle}</td>
         <td>${Boardinfo.bcontents}</td>
         <td>${Boardinfo.bdate}</td>
         <td>${Boardinfo.bhits}</td>
         <td><img src="resources/uploadfile/${Boardinfo.bfilename}" height="200" width="200" ></td>
      </tr>

   </table>
      <div>
   <textarea rows="3" cols="40" style="resize: none;" name="breply" style="margin-top:20px;" id="breply"></textarea>
   <input type="button" onclick="insReply(${Boardinfo.bnum})" value="댓글달기" style="height:40px;">
   </div>
   
   <div id="here"></div>
   <a href="writelist">목록</a>
   <a href="writelistpage?page=${page }">페이징 목록</a>
   <a href="writeupdate?bnum=${Boardinfo.bnum}">수정</a>
   <a href="writedelete?bnum=${Boardinfo.bnum}">삭제</a>
   <a href="./">홈으로가기</a>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	function insreply(${Boardinfo.bnum}) {
		
		   $.ajax({
			   type: "post", 
			   url : "getreply",
			   data: {"bnum" : inputId}, // 전송 데이터
			   dataType : "text", // 리턴 데이터 형식
			   success : function(result) {
				   if(result=="ok") {
					   checkResult.style.color = "green";
					   checkResult.innerHTML = "사용 가능한 ID 입니다";
				   }else {
					   checkResult.style.color = "red";
					   checkResult.innerHTML = "이미 사용중인 ID 입니다";
				   }
			   },
			   error: function() {
				   alert("틀렸다");
			   }
		   });
	   }
	
	   function reply(data){
		      let out = "";
		      out += '<table>';

		      for (var i = 0; i < data.length; i++) {
		         out += '<tr>';   
		         out += '<td>';
		         out += data[i].breply;
		         out += '</td>';
		         out += '<tr>';
		      }

		      out += '</table>';
		      return out;
		   }	
</script>
</html>