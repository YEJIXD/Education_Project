<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/login/regist.css">
<link rel="shortcut icon" href="#">
<title>Regist Form</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	//���̵� �ߺ�üũ
	function idCheck(){
		$("#id_chk_unavailable").hide();
		$("#id_chk_available").hide();
		$("#id_chk_blank").hide();
		
		let inputIdCheck = $("#user_id").val();
		
		/* if(�Լ�(return���� true false)){
			alert("����")
			return false;
		} */
		
		
		$.ajax({
			url:"idCheck.do",
			type:"POST",
			dataType:"JSON",
			data:{"user_id" : $("#user_id").val()},
			success: function(data){
				console.log($("#user_id").val())
				console.log(data)
					if(data == 1){					
						$("#id_chk_unavailable").show();
					}else if(data == 0){
						$("#id").attr("title", "y");
						$("#id_chk_available").show();
						$("#user_name").focus();
					}else{
						$("#id_chk_blank").show();
					}
			}
		})
	}

	//���̵� �ߺ�üũ Ȯ��
	function idChkConfirm(){
		const chk = document.getElementById("id").title;
		if(chk=="n"){
			alert("���̵� �ߺ�üũ�� ���ּ���.");
			document.getElementById("id").focus();
			// return false ������ alert�� �ߴµ� �״�� ȸ������ �����
			return false;
		}
	}
	
	//��й�ȣ ��ġ
	$(function(){
		$("#pw_chk_available").hide();
		$("#pw_chk_unavailable").hide();
		
		$("#pw_chk").keyup(function(){
			const pw = $("#pw").val();
			const pw_chk = $("#pw_chk").val();
			
			if(pw != "" || pw_chk != ""){
				if(pw == pw_chk){
					$("#pw_chk_available").show();
					$("#pw_chk_unavailable").hide();
					$("#pw").attr("title", "y");
				}else{
					$("#pw_chk_available").hide();
					$("#pw_chk_unavailable").show();
				}
			}
		});
	});
	
	//��й�ȣ ��ġ Ȯ��
	function pwChkConfirm(){
		const chk = document.getElementById("pw").title;
		if(chk=="n"){
			alert("��й�ȣ�� Ȯ�����ּ���.");
			document.getElementById("pw").focus();
		}
	}
	
	let code = "";	//�̸������� ������ȣ ����
	//�̸��� ����
	function emailCheck(){
		const user_email = $(".user_email").val();   // �Է��� �̸���
		const checkBox = $(".user_email_num");		 // ������ȣ �Է¶�

		 $.ajax({
		 	type:"GET",
		 	url:"emailCheck.do?user_email=" + user_email,
		 	success:function(data){
		 		if(user_email != ''){
		 			$("#email_chk_blank").hide();
			 		checkBox.attr("disabled", false);
			 		checkBox.attr("id","user_email_num_true");
			 		$(".user_email_num").focus();
			 		code = data;
		 		}else{
		 			$("#email_chk_blank").show();
		 		}
		 	}
		 });
	}
	
	//������ȣ ��
	$(function(){
		$(".user_email_num").keyup(function(){
			const inputCode = $(".user_email_num").val();		//�Է� �ڵ�
			
			$("#email_chk_available").hide();
			$("#email_chk_unavailable").hide();
			
			if(inputCode == code){
				$("#email_chk_available").show();
				$("#email_chk_unavailable").hide();
				$("#user_email").attr("title", "y");
			}else{
				$("#email_chk_unavailable").show();
				$("#email_chk_available").hide();
			}
		});
	});
	
	//������ȣ ��ġ Ȯ��
	function emailChkConfirm(){
		const chk = document.getElementById("user_email").title;
		if(chk=="n"){
			alert("�̸��� ������ ���ּ���.");
			document.getElementById("user_email").focus();
		}
	}
	
	//null�� ����
	$(document).ready(function(){
		$(".cancle").on("click", function(){
			location.href="/main.do";
		})
		
		$("#submit").on("click", function(){
			if($("#id").val()==""){
				alert("���̵� �Է����ּ���.");
				$("#id").focus();
				return false;
			}
			if($("#user_name").val()==""){
				alert("�̸��� �Է����ּ���.");
				$("#user_name").focus();
				return false;
			}
			if($("#pw").val()==""){
				alert("��й�ȣ�� �Է����ּ���.");
				$("#pw").focus();
				return false;
			}
			if($("#user_email").val()==""){
				alert("�̸����� �Է����ּ���.");
				$("#user_email").focus();
				return false;
			}
			if($("#user_addr").val()==""){
				alert("�ּҸ� �Է����ּ���.");
				$("#user_addr").focus();
				return false;
			}
			if($("#user_phone").val()==""){
				alert("�ڵ��� ��ȣ�� �Է����ּ���.");
				$("#user_phone").focus();
				return false;
			}
		});
	})
</script>

<!-- Daum �ּ� API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function addr_search() {
    	daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	let addr = ''; 	  // ���θ� �ּ� ����
	
	                if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
	                    addr = data.roadAddress;
	                } else { // ����ڰ� ���� �ּҸ� �������� ���(J)
	                    addr = data.jibunAddress;
	                }
	
	                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ֱ�
	                document.getElementById("user_addr").value = addr;
	                // focus�� ���ּ� �ʵ�� �̵�
	                document.getElementById("user_addr_sub").focus();
	            }
	        }).open();
    	});
    }
</script>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp"%>
	</div>
	
    <div class="login_regist_wrap">
        <div class="regist_wrap">
            <div class="container">
                <a>ȸ �� �� ��</a>
                <hr>
            </div>
            
            <div class="regist_form">
            <form action="registRes.do" method="post">
                <table width="550px">
                    <tr>
                        <col width="150px"> <col width="300px">
                    </tr>
                    <tr>
                        <th>���̵�</th>
                        <td>
                            <input type="text" class="user_id" name="user_id" id="user_id" title="n" required="required" placeholder="���̵� �Է��ϼ���." autofocus>
                            <input type="button" class="user_id_chk" value="�ߺ�Ȯ��" onclick="idCheck();"><br>
                            <span class="divSpan" id="id_chk_available">��밡���� ���̵��Դϴ�.</span>
                            <span class="divSpan" id="id_chk_unavailable">�ߺ��� ���̵��Դϴ�.</span>
                            <span class="divSpan" id="id_chk_blank">���̵� �Է��ϼ���.</span>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>�� ��</th>
                        <td><input type="text" class="user_name" name="user_name" id="user_name" required placeholder="�̸��� �Է��ϼ���." onclick="idChkConfirm();"></td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>��й�ȣ</th>
                        <td><input type="password" class="user_pw" name="user_pw" id="pw" title="n" required placeholder="��й�ȣ�� �Է��ϼ���." onclick="idChkConfirm();"></td>
                    </tr>
                    <tr>
                        <th>��й�ȣ Ȯ��</th>
                        <td>
                        	<input type="password" class="user_pw_chk" name="pw_chk" id="pw_chk" required onclick="idChkConfirm();"><br>
                        	<span class="divSpan" id="pw_chk_available">��й�ȣ�� ��ġ�մϴ�.</span>
                            <span class="divSpan" id="pw_chk_unavailable">��й�ȣ�� ��ġ���� �ʽ��ϴ�.</span>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>Email</th>
                        <td>
                        	<input type="text" class="user_email" name="user_email" id="user_email" title="n" placeholder="�̸����� �Է��ϼ���." onclick="pwChkConfirm();" required>
                        	<input type="button" class="user_email_chk" value="������ȣ" onclick="emailCheck();"><br>
                        	<input type="text" class="user_email_num" name="user_email_num" id="user_email_num_false" disabled="disabled" required><br>
                        	<span class="divSpan" id="email_chk_blank">�̸����� �Է��ϼ���.</span>
                        	<span class="divSpan" id="email_chk_available">������ȣ�� ��ġ�մϴ�.</span>
                            <span class="divSpan" id="email_chk_unavailable">������ȣ�� ��ġ���� �ʽ��ϴ�.</span>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>�� ��</th>
                        <td>
                            <input type="text" class="user_addr" name="user_addr" id="user_addr" placeholder="�ּҸ� �Է��ϼ���." readonly required>
                            <input type="button" class="user_addr_chk" value="�ּҰ˻�" onclick="addr_search();"><br>
                            <input type="text" class="user_addr_sub" name="user_addr_sub" id="user_addr_sub" placeholder="���ּҸ� �Է��ϼ���." onclick="emailChkConfirm();" required>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>��ȭ��ȣ</th>
                        <td>
                            <input type="text" class="user_phone" name="user_phone" id="user_phone" placeholder="'-' ��ȣ ���� ���ڸ� �Է��ϼ���." required>
                        </td>
                    </tr>
                </table>
                    <div class="regist_btn">
                        <input type="submit" class="subBtn" id="submit" value="�� ��">
                        <input type="button" class="antBtn" value="�� ��" onclick="location.href='index.do'">
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