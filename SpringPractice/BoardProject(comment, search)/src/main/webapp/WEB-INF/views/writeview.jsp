<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(document).ready(function(){
		$("#commentWriteBtn").click(function(){
			var cwriter = $("#cwriter").val();
			var ccontents = $("#ccontents").val();
			var cbnumber = '${Boardinfo.bnum}';
			$.ajax({
				type : "post",
				url :"comment/commentwrite",
				//"cwriter" : {"aa":aa,"bb":bb},
				data : {
					"cwriter" : cwriter,
					"ccontents" : ccontents,
					"cbnumber" : cbnumber},
				dataType : "json",
				success: function(result) {
					console.log(result);
					var output = "<table boarder='1'>";
					output += "<tr><th>작성자</th>";
					output += "<th>내용</th></tr>";
					for(var i in result){
						output += "<tr>";
						output += "<td>"+result[i].cwriter+"</td>";
						output += "<td>"+result[i].ccontents+"</td>";
						output += "</tr>";
					}
					output += "</table>";
					$("#commentArea").html(output);
					$("#cwriter").val("");
					$("#ccontents").val("");

				},
				error : function() {
					console.log("댓글 등록 실패");
				}
			});
		});
	});
	
	$(document).ready(()=>{
	         $.ajax({
	            data : {'bnum' : ${Boardinfo.bnum}},
	            type : 'post',
	            dataType : 'JSON',
	            url : "comment/commentlist",
	            success : (result)=>{
	               $('#commentArea').html(reply(result));

	            },
	            error : ()=>{
	               console.log("데이터 없음");
	               
	            },
	         });
	   });
	   function reply(data){
		      let out = "";
		      out += '<table>';
				out += "<tr><th>작성자</th>";
				out += "<th>내용</th></tr>";

		      for (var i = 0; i < data.length; i++) {
		         out += '<tr>';   
		         out += '<td>';
		         out += data[i].cwriter;
		         out += '</td>';
		         out += '<td>';
		         out += data[i].ccontents;
		         out += '</td>';
		         out += '<tr>';
		      }

		      out += '</table>';
		      return out;
		   }
</script>
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
    <div id="commentwrite">
   		작성자 : <input type="text" id ="cwriter"><br/>
   		내용 : <input type="text" id="ccontents"><br/>
   		<button id="commentWriteBtn">댓글작성</button>
   </div>
   <!-- 댓글은 폼태그 ㄴㄴ 폼태그를 하면 화면이 바뀌어버림 바로바로 보이게 -->
   <div id="commentArea">
   
   </div>
   <div id="here"></div>
   <a href="writelist">목록</a>
   <a href="writelistpage?page=${page }">페이징 목록</a>
   <a href="writeupdate?bnum=${Boardinfo.bnum}">수정</a>
   <a href="writedelete?bnum=${Boardinfo.bnum}">삭제</a>
   <a href="./">홈으로가기</a>
</body>

</html>