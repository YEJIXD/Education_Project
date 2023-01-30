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
	  <a href="receiveCert.do" class="w3-bar-item w3-button" style="font-weight:bold; font-size:13pt;">수료증 발급</a>
	  <a href="review.do" class="w3-bar-item w3-button">수강 후기</a>
	  <a href="pwConfirm.do" class="w3-bar-item w3-button">정보 수정</a>
	</div>

		<div id="main">
			<div class="w3-teal">
			  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
			  <div class="w3-container">
			    <h2>수료증 발급</h2>
			  </div>
			</div>
		
			<div class="container">
				<div class="content">
					<form name="appForm" action="myStudy.do" method="GET">
						<table class="table">
							<tr>
								<th>과정 구분</th>
								<td>2022년도 2분기</td>
							</tr>
							<tr>
								<th>과정 분류</th>
								<td>경제</td>
							</tr>
							<tr>
								<th>교육명</th>
								<td>부동산 마케팅 기획자 실무과정</td>
							</tr>
							<tr>
								<th>교육기간</th>
								<td>2022.02.24 ~ 2022.03.14</td>
							</tr>
							<tr>
								<th>신청인</th>
								<td>김동산</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>Dongsan123@naver.com</td>
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