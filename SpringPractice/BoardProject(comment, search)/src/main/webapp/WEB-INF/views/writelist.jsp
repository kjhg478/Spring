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
         <td>글번호</td>
         <td>제목</td>
         <td>작성자</td>
         <td>글내용</td>
         <td>글쓴날짜</td>
         <td>조회수</td>
      </tr>
      <c:forEach var="i" items="${boardlist}">
         <tr>
            <td>${i.bnum}</td>
            <td><a href="writeview?bnum=${i.bnum}">${i.btitle}</a></td>
            <td>${i.bwriter}</td>
            <td>${i.bcontents}</td>
            <td>${i.bdate}</td>
            <td>${i.bhits}</td>
         </tr>
      </c:forEach>
   </table>
   <a href="./">홈으로가기</a>
</body>
</html>