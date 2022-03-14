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
		 	alert("���̵� �Է��ϼ���");
		 	$("#user_id").focus(); 
			return false;
			
		}else if(user_pw == ""){
			alert("��й�ȣ�� �Է��ϼ���"); 
			$("#user_pw").focus();
			return false;
		}
		
		const params = {
				 user_id      : user_id
               , user_pw      : user_pw
       }
		
		console.log(user_id +","+ user_pw)
		
		 $.ajax({
             type : "POST",            		// HTTP method type(GET, POST) �����̴�.
             url : "/loginCheck.do",      	// ��Ʈ�ѷ����� ������� URL �ּ��̴�.
             contentType: 'application/json; charset=utf-8',
             data : JSON.stringify(params),            
             success : function(data){ // �񵿱������ �����ϰ�� success�ݹ����� ���ɴϴ�. 'res'�� ������� �������̴�.
             /*    console.log(res)
                 alert(res.msg);
                 location.href(res.PageName)
             */
             
				if(data.COUNT == '1'){
					alert('�α��� ����!');
					window.location.href="index.jsp";
					console.log(user_id +","+ user_pw)
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
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="button" class="subBtn" id="submit" value="�α���">
	                	<input type="button" class="antBtn" value="�� ��" onclick="goBack();">
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