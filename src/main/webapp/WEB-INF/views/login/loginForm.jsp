<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<%@ page import="com.edu.java.dao.MemberDao" %>

<!DOCTYPE html>
<html>
<head>
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
		 const pw = $("#pw").val(); 
		 
		 if(user_id == ""){
		 	alert("���̵� �Է��ϼ���");
		 	$("#user_id").focus(); 
	
			return false;
		}
		 
		if(pw == ""){
			alert("��й�ȣ�� �Է��ϼ���"); 
			$("#pw").focus();
			
			return false;
		}
		
		if(user_id != ${member.user_id} || pw != ${member.user_pw} ){
			alert("���̵� �Ǵ� ��й�ȣ�� ��Ȯ�ϰ� �Է��ϼ���");
			$("#user_id").focus();
			
			return false;
		}
		
		//�� ������ �����͸� ������ �ּ�
			document.form.action= "${path}/login/loginCheck.do";
			document.form.submit(); 
		});
	});
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
	            <form action="loginCheck.do" method="POST">
	                <table style="width:550px">
	                    <tr>
	                        <td width="150px" /> <td width="300px" />
	                    </tr>
	                    <tr>
	                        <th>���̵�</th>
	                        <td>
	                            <input type="text" class="user_id" name="user_id" id="user_id" placeholder="���̵� �Է��ϼ���." autofocus required>
	                        </td>
	                    </tr>
	                    <tr height="15"></tr>
	                    <tr>
	                        <th>��й�ȣ</th>
	                        <td>
	                        	<input type="password" class="user_pw" name="user_pw" id="pw" placeholder="��й�ȣ�� �Է��ϼ���." required>
	                        </td>
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="submit" class="subBtn" id="submit" value="Ȯ ��">
	                	<input type="button" class="antBtn" value="�� ��" onclick="location.href='main.do'">
	            	</div>
	            </form>
          </div>
        </div> 
    </div>
    
    <div id="footer">
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>