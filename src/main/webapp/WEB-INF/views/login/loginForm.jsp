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
		 const user_pw = $("#user_pw").val(); 
		 
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
		
		if(user_id != user_id || user_pw != user_pw ){
			alert("���̵� �Ǵ� ��й�ȣ�� ��Ȯ�ϰ� �Է��ϼ���");
			$("#user_id").focus();
			
			return false;
		}
		
		let params = {
				 user_id      : user_id
               , user_pw       : user_pw
       }
		
		 $.ajax({
             type : "POST",            // HTTP method type(GET, POST) �����̴�.
             url : "/loginCheck.do",      // ��Ʈ�ѷ����� ������� URL �ּ��̴�.
             data : params,            // Json ������ �������̴�.
             dataType : "JSON",
             success : function(res){ // �񵿱������ �����ϰ�� success�ݹ����� ���ɴϴ�. 'res'�� ������� �������̴�.
                 // �����ڵ� > 0000
                 console.log(res)
                 alert(res.msg);
                 location.href(res.PageName)
             },
             error : function(error){// �񵿱� ����� �����Ұ�� error �ݹ����� ���ɴϴ�.
            	 console.log(error)
                 alert("��� ����")
             }
         });
		//�� ������ �����͸� ������ �ּ�
			/* document.form.action= "${path}/login/loginCheck.do";
			document.form.submit(); */ 
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
	            <!-- <form action="loginCheck.do" method="POST"> -->
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
	                        	<input type="password" class="user_pw" name="user_pw" id="user_pw" placeholder="��й�ȣ�� �Է��ϼ���." required>
	                        </td>
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="button" class="subBtn" id="submit" value="Ȯ ��">
	                	<input type="button" class="antBtn" value="�� ��" onclick="location.href='main.do'">
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