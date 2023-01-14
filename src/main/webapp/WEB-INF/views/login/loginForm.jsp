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
	 
		if(!loginValidator(user_id, user_pw)) {
			return false;
		}

		const params = {
			user_id	: user_id
          , user_pw : user_pw
      	}
	
	 $.ajax({
            type : "POST",            		// HTTP method type(GET, POST) 형식이다.
            url : "/loginCheck",      	// 컨트롤러에서 대기중인 URL 주소이다.
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(params),            
            success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            
			let count = data.result.COUNT;
            let role = data.result.USER_ROLE;
            
            /* 입력한 id와 pw가 일치하는 정보가 있다면 count == '1' */
			if(count == '1'){
				/* role이 'A'면 관리자, 'U'면 일반 이용자 */
				if(role == 'A'){
					alert('관리자님 안녕하세요.');
					location.href = "adminMain";
				}else{
					alert('로그인 성공!');	
					location.href = "main";
				}
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
	$('#submit').submit();
});

function goBack(){
	window.history.back();
}

function loginValidator(user_id, user_pw){
 	if(user_id == ""){
	 	alert("아이디를 입력하세요");
	 	$("#user_id").focus(); 
		return false;
	}
	
	if(user_pw == ""){
		alert("비밀번호를 입력하세요"); 
		$("#user_pw").focus();
		return false;
	}
	return true;
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
	            <!-- <form action="loginCheck" method="POST"> -->
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
	                        <td><input type="hidden" class="user_role" name="user_role" id="user_role"></td>
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="button" class="subBtn" id="submit" value="로그인">
	                	<input type="button" class="antBtn" value="회원가입" onclick="goBack();">
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