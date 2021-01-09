<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
</head>
<body>
<h1>
   Hello world!  
</h1>
<div id="here"></div>

<P>  The time on the server is ${serverTime}. </P>

<a href="#!regMember" onclick="getInto('member/goRegMember')">처음이신가요?</a>
<a href="#!glogin" onclick="getinto('member/goLogin')">로그인</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script>


$(document).ready(()=>{

	var idCheck = false;
	var pwd = false;
	var pwdCheck = false;

	$(document).on('keyup','#userPw',()=>{
		console.log("in");
		CheckPw();
		pwConfirm();
	});
	
	$(document).on('keyup','#confirmPw',()=>{
		console.log("in");
		CheckPw();
	});

	function pwConfirm(){
	   var userPw = document.getElementById("userPw").value;
	   var confirmPw = document.getElementById("confirmPw");
	   
	   // search(정규식) 문자 검색(일치하는 문자열의 인덱스(Number)반환), 
	   // replace(정규식, 대체 문자) 문자 대체 (일치하는 문자열을 대체하고 대체된 문자열(String) 반환), 
	  
	   var num = userPw.search(/[0-9]/g); // g는 모든 문자와 여러 줄 일치
	   var eng = userPw.search(/[a-z]/ig); // 영어 대소문자를 구분 않고 모든 문자와 여러 줄 일치
	   var spe = userPw.search(/[`~!@@#$%^&*|₩₩₩'₩';:₩/?]/gi); // 문자열 전역에서 대소문자 구분 없이 검색
	   
	   if(userPw.search(/\s/)!=-1){
	      pwd=false;
	      confirmPw.style.color = "#ff0000";
	      confirmPw.innerHTML = "비밀번호는 공백 없이 입력해주세요!";
	   } else if (userPw.length < 8 || userPw.length > 20){
	      pwd=false;
	      confirmPw.style.color = "#ff0000";
	      confirmPw.innerHTML = "8자리 ~ 20자리 이내로 입력해주세요!";
	   } else if( num < 0 || eng < 0 || spe < 0 ){
	      pwd=false;
	      confirmPw.style.color = "#ff0000";
	      confirmPw.innerHTML = "영문, 숫자, 특수문자를 혼합하여 입력해주세요!";
	   } else {
	      pwd=true;
	      confirmPw.style.color = "#0000ff";
	      confirmPw.innerHTML = "적절한 비밀번호 입니다!";
	   }
	}

	function CheckPw() {
	   var userPw = document.getElementById("userPw").value;
	   var userPw2 = document.getElementById("confirmPw").value;
	   var result = document.getElementById("result");
	   if (userPw==userPw2) {
	      if (userPw!="") {
	         pwdCheck=true;
	         result.style.color = "blue";
	         result.innerHTML = "비밀번호가 일치합니다";
	      }else {
	         pwdCheck=false;
	         result.style.color = "red";
	         result.innerHTML = "비밀번호를 입력해주세요.";
	      }
	   }else {
	      pwdCheck=false;
	      result.style.color = "red";
	      result.innerHTML = "비밀번호가 일치하지 않습니다.";
	   }
	}

	function gosubmit() {
	   if (idCheck==true) {
	      if (pwd==true) {
	         if (pwdCheck==true) {
	             init();
	         }else {
	            alert("비밀번호가 일치하지 않습니다.");
	            checkpwd.focus();
	         }
	      }else {
	         alert("비밀번호 양식을 맞춰주세요.");
	         upwd.focus();
	      }
	   }else {
	      alert("아이디를 확인해주세요.");
	      uid.focus();
	   }
	   
	}
});


$(document).on('change','#uid',()=>{
	console.log("asd");
    let uid = $("#uid").val();
    let result = document.querySelector('#result');
    $.ajax({
       data : {"uid":uid},
       url : 'member/checkid',
       type : 'post',
       dataType:'text',
       success:(data)=>{
          if(data==0||data==""){
             result.style.color = "skyblue";
             result.innerHTML = "사용가능한 아이디입니다.";
          }else{
             result.style.color = "red";
             result.innerHTML = "사용할수 없는 아이디입니다.";
          }
          
       },
       erorr:(data)=>{
          alert("데이터 오류");
       },
    });
});


   function getInto(address) {
      let info = address;
      fetch(info)
      .then((response)=>{
         response.text()
      .then((text)=>{
         document.querySelector('#here').innerHTML = text;
         });
      });
   };
   

   function init() {
      // do not evented submit 
      event.preventDefault();
      // get form data  
      var form = $('#regForm')[0];
      // create an form object
      var data = new FormData(form);
      // disabled the submit button
        $("#btnSubmit").prop("disabled", true);   
      
         $.ajax({
            data : data,
            url : 'member/regMember',
            type : 'post',
            dataType:'text',
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success:(result)=>{
               console.log(result);
               if(result==1){
                  alert("complete");
                  getInto('member/goLogin');
               }else{
                  alert("fail");
                      $("#btnSubmit").prop("disabled", false);
                      getInto('member/goLogin');
               }
            },
            erorr:(data)=>{
                   console.log("ERROR : ", data);
                   $("#btnSubmit").prop("disabled", false);
                   alert("fail");
                   getInto('member/goLogin');
            },
         });
   }
   
   
</script>


</html>