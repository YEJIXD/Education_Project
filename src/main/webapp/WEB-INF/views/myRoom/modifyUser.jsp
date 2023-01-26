<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/login/regist.css">
<link rel="shortcut icon" href="#">
<title>user Update</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	let code = "";	//이메일전송 인증번호 저장
	//이메일 인증
	function emailCheck(){
		const user_email = $(".user_email").val();   // 입력한 이메일
		const checkBox = $(".user_email_num");		 // 인증번호 입력란

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
	
	//인증번호 비교
	$(function(){
		$(".user_email_num").keyup(function(){
			const inputCode = $(".user_email_num").val();		//입력 코드
			
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
	
	//인증번호 일치 확인
	function emailChkConfirm(){
		const chk = document.getElementById("user_email").title;
		if(chk=="n"){
			alert("이메일 인증을 해주세요.");
			document.getElementById("user_email").focus();
		}
	}
	
	//비밀번호 일치
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
	
	//비밀번호 일치 확인
	function pwChkConfirm(){
		const chk = document.getElementById("pw").title;
		if(chk=="n"){
			alert("비밀번호를 확인해주세요.");
			document.getElementById("pw").focus();
		}
	}
</script>

<!-- Daum 주소 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function addr_search() {
    	daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	let addr = ''; 	  // 도로명 주소 변수
	
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣기
	                document.getElementById("user_addr").value = addr;
	                // focus를 상세주소 필드로 이동
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
                <a>회 원 정 보 수 정</a>
                <hr>
            </div>
            
            <div class="regist_form">
            <form action="registRes.do" method="post">
                <table width="550px">
                    <tr>
                        <col width="150px"> <col width="300px">
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>
                            <input type="text" class="user_id" name="user_id" id="id" title="n" readonly>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>이 름</th>
                        <td>
                        	<input type="text" class="user_name" name="user_name" id="user_name" readonly>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>비밀번호 수정</th>
                        <td>
                        	<input type="password" class="user_pw" name="user_pw" id="pw" title="n" required placeholder="비밀번호를 입력하세요.">
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <td>
                        	<input type="password" class="user_pw_chk" name="pw_chk" id="pw_chk" required><br>
                        	<span class="divSpan" id="pw_chk_available">비밀번호가 일치합니다.</span>
                            <span class="divSpan" id="pw_chk_unavailable">비밀번호가 일치하지 않습니다.</span>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>Email</th>
                        <td>
                        	<input type="text" class="user_email" name="user_email" id="user_email" title="n" placeholder="이메일을 입력하세요." onclick="pwChkConfirm();" required>
                        	<input type="button" class="user_email_chk" value="인증번호" onclick="emailCheck();"><br>
                        	<input type="text" class="user_email_num" name="user_email_num" id="user_email_num_false" disabled="disabled" required><br>
                        	<span class="divSpan" id="email_chk_blank">이메일을 입력하세요.</span>
                        	<span class="divSpan" id="email_chk_available">인증번호가 일치합니다.</span>
                            <span class="divSpan" id="email_chk_unavailable">인증번호가 일치하지 않습니다.</span>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>주 소</th>
                        <td>
                            <input type="text" class="user_addr" name="user_addr" id="user_addr" placeholder="주소를 입력하세요." readonly required>
                            <input type="button" class="user_addr_chk" value="주소검색" onclick="addr_search();"><br>
                            <input type="text" class="user_addr_sub" name="user_addr_sub" id="user_addr_sub" placeholder="상세주소를 입력하세요." onclick="emailChkConfirm();" required>
                        </td>
                    </tr>
                    <tr height="15"></tr>
                    <tr>
                        <th>전화번호</th>
                        <td>
                            <input type="text" class="user_phone" name="user_phone" id="user_phone" placeholder="'-' 부호 없이 숫자만 입력하세요." required>
                        </td>
                    </tr>
                    <tr>
                    	<th>활 성 화</th>
                    	<td style="vertical-align:middle;">
                    		<input type="radio" name="rBtn" value="Y" checked>활성화&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="rBtn" value="N">비활성화
                    	</td>
                    </tr>
                    <tr>
                    	<th>회원 탈퇴</th>
                    	<td style="vertical-align:middle;">
                    		<input type="button" class="antBtn" onclick="location.href='memberDelete.do'" value="탈 퇴">
                    	</td>
                    </tr>
                </table>
                    <div class="regist_btn">
                        <input type="submit" class="subBtn" id="submit" value="가 입">
                        <input type="button" class="antBtn" value="취 소" onclick="location.href='main.do'">
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