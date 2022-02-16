<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="shortcut icon" href="#">
<title>Receive Certificate</title>
</head>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
</style>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<!-- 사이드 메뉴 -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none; background-color:#B0E0E6;" id="mySidebar">
	  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()"><b>&times;</b></button>
	  <a href="myStudy.do" class="w3-bar-item w3-button">수강 교육</a>
	  <a href="review.do" class="w3-bar-item w3-button">수강 후기</a>
	  <a href="pwConfirm.do" class="w3-bar-item w3-button" style="font-weight:bold; font-size:13pt;">정보 수정</a>
	</div>

		<div id="main">
			<div class="w3-teal">
			  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
			  <div class="w3-container">
			    <h2 align="center">회원 정보 수정</h2>
			  </div>
			</div>
		
			<div class="container">
				<div class="content">
					<form action="" method="GET">
						<table class="table">
							<tr>
								<th>이 름</th>
								<td>김동산</td>
							</tr>
							<tr>
								<th>I D</th>
								<td>Dongsan123</td>
							</tr>
							<tr>
								<th>비밀번호 수정</th>
								<td><input type="password"></td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password"></td>
							</tr>
							<tr>
								<th>e-mail</th>
								<td><input type="email"></td>
							</tr>
							<tr>
                        <th style="vertical-align:middle">주소</th>
                        <td>
                            <input type="text" class="user_addr" name="user_addr" id="user_addr" required="required" placeholder="우편번호를 입력하세요." readonly="readonly">
                            <input type="button" class="canBtn" value="주소 검색" onclick="addr_search();"><br>
                            <input type="text" class="user_addr_sub" name="user_addr_sub" id="user_addr_sub" required="required" placeholder="상세주소를 입력하세요." onclick="emailChkConfirm();">
                        </td>
                    </tr>
							<tr>
								<th>휴대전화</th>
								<td>Dongsan123@naver.com</td>
							</tr>
							<tr>
								<th>활성화</th>
								<td><input type="radio" name="rBtn" value="Y" checked>활성화&nbsp;&nbsp;&nbsp;<input type="radio" name="rBtn" value="N">비활성화</td>
							</tr>
						</table>
				
						<div class="inpBtn">
							<input type="submit" class="subBtn" value="완 료">
							<input type="button" class="antBtn" onclick="location.href='myRoomMain.do'" value="홈으로 가기">
						</div>
					</form>
				</div>
			</div>
			<div id="footer">
				<%@ include file="../common/footer.jsp" %>
			</div>
		</div>


<script>
	function w3_open() {
	  document.getElementById("main").style.marginLeft = "25%";
	  document.getElementById("mySidebar").style.width = "25%";
	  document.getElementById("mySidebar").style.display = "block";
	  document.getElementById("openNav").style.display = 'none';
	}
	function w3_close() {
	  document.getElementById("main").style.marginLeft = "0%";
	  document.getElementById("mySidebar").style.display = "none";
	  document.getElementById("openNav").style.display = "inline-block";
	}
</script>
</body>
</html>