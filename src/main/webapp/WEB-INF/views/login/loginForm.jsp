<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<%@ page import="com.edu.java.dao.MemberDao" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="<%=request.getContextPath() %>"></c:set>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/login/regist.css">
<link rel="shortcut icon" href="#">
<title>Login Form</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#submit").click(function(){
		 const user_id = $("#user_id").val();
		 const user_pw = $("#user_pw").val(); 
		 const user_role = $("#user_role").val();
		 
		 if(user_id == ""){
		 	alert("아이디를 입력하세요");
		 	$("#user_id").focus(); 
			return false;
			
		}else if(user_pw == ""){
			alert("비밀번호를 입력하세요"); 
			$("#user_pw").focus();
			return false;
		}
		
		const params = {
				 user_id      : user_id
               , user_pw      : user_pw
       }
		
		console.log(user_id +","+ user_pw)
		
		 $.ajax({
             type : "POST",            		// HTTP method type(GET, POST) 형식이다.
             url : "/loginCheck.do",      	// 컨트롤러에서 대기중인 URL 주소이다.
             contentType: 'application/json; charset=utf-8',
             data : JSON.stringify(params),            
             success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
             /*    console.log(res)
                 alert(res.msg);
                 location.href(res.PageName)
             */
             
				if(data.COUNT == '1'){
					alert('로그인 성공!');
					window.location.href="index.jsp";
					console.log(user_id +","+ user_pw)
				}else{
	            	alert('아이디나 비밀번호가 일치하지 않습니다.');
	            	$("#user_id").focus();
	            }
             
             },
             error : function(req, text){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                 alert(text + " : " + req.status);
             }
         });
		});
	});
	
	function goBack(){
		window.history.back();
	}
</script>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp"%>
	</div>
	
    <div class="login_regist_wrap">
        <div class="regist_wrap">
            <div class="container">
                <a>L O G I N</a>
                <hr>
            </div>
            
            <div class="regist_form">
	            <!-- <form action="loginCheck.do" method="POST"> -->
	                <table style="width:550px">
	                    <tr>
	                        <td width="150px" /> <td width="300px" />
	                    </tr>
	                    <tr>
	                        <th>아이디</th>
	                        <td>
	                        	<input type="text" class="user_id" name="user_id" id="user_id" placeholder="아이디를 입력하세요." required>
	                        </td>
	                    </tr>
	                    <tr height="15"></tr>
	                    <tr>
	                        <th>비밀번호</th>
	                        <td>
	                        	<input type="password" class="user_pw" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요." required>
	                        </td>
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="button" class="subBtn" id="submit" value="로그인">
	                	<input type="button" class="antBtn" value="취 소" onclick="goBack();">
	            	</div>
	            <!-- </form> -->
          </div>
        </div> 
    </div>
    
    <div id="footer">
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>