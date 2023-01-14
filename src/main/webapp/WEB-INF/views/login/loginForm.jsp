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
            type : "POST",            		// HTTP method type(GET, POST) �����̴�.
            url : "/loginCheck",      	// ��Ʈ�ѷ����� ������� URL �ּ��̴�.
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(params),            
            success : function(data){ // �񵿱������ �����ϰ�� success�ݹ����� ���ɴϴ�. 'res'�� ������� �������̴�.
            
			let count = data.result.COUNT;
            let role = data.result.USER_ROLE;
            
            /* �Է��� id�� pw�� ��ġ�ϴ� ������ �ִٸ� count == '1' */
			if(count == '1'){
				/* role�� 'A'�� ������, 'U'�� �Ϲ� �̿��� */
				if(role == 'A'){
					alert('�����ڴ� �ȳ��ϼ���.');
					location.href = "adminMain";
				}else{
					alert('�α��� ����!');	
					location.href = "main";
				}
			}else{
            	alert('���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
            	$("#user_id").focus();
            }
            
            },
            error : function(req, text){ // �񵿱� ����� �����Ұ�� error �ݹ����� ���ɴϴ�.
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
	 	alert("���̵� �Է��ϼ���");
	 	$("#user_id").focus(); 
		return false;
	}
	
	if(user_pw == ""){
		alert("��й�ȣ�� �Է��ϼ���"); 
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
	                        <th>���̵�</th>
	                        <td>
	                        	<input type="text" class="user_id" name="user_id" id="user_id" placeholder="���̵� �Է��ϼ���." required>
	                        </td>
	                    </tr>
	                    <tr height="15"></tr>
	                    <tr>
	                        <th>��й�ȣ</th>
	                        <td>
	                        	<input type="password" class="user_pw" name="user_pw" id="user_pw" placeholder="��й�ȣ�� �Է��ϼ���." required>
	                        </td>
	                        <td><input type="hidden" class="user_role" name="user_role" id="user_role"></td>
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="button" class="subBtn" id="submit" value="�α���">
	                	<input type="button" class="antBtn" value="ȸ������" onclick="goBack();">
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