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
	form{ padding: 50px 80px 50px 160px; width:800px;}
	h5{ padding: 10px 80px 10px 30px; width:1000px;}
	th{ width:140px; }
	td{ width:300px; }
	tr{ border-bottom : none;}
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
			    <h2 align="center">비밀번호 확인</h2>
			  </div>
			</div>
		
			<div class="container">
				<div class="content">
					<form action="userUpdate.do" method="GET">
						<h5>${member.user_name}님의 소중한 정보 수정을 위해 비밀번호를 입력해주세요 : )</h5><br><br>
						<table class="table">
							<tr>
								<th>비 밀 번 호</th>
								<td><input type="password" id="pw" placeholder="비밀번호를 입력해주세요."></td>
							</tr>
						</table>
				
						<div class="twoBtn">
							<input type="submit" class="myBtn" value="확 인">
							<input type="button" class="canBtn" onclick="location.href='myRoomMain.do'" value="취 소">
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