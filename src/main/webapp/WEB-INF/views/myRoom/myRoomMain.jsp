<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/myRoom/myRoom.css">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="shortcut icon" href="#">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>myRoom_Main</title>
</head>
<style type="text/css">
	.subBtn{ margin-left:50%; }
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
	  <a href="pwConfirm.do" class="w3-bar-item w3-button">정보 수정</a>
	</div>

	<div id="main">
		<div class="w3-teal">
		  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
		  <div class="w3-container">
		    <h1>My Class</h1>
		  </div>
		</div>
		
		<img src="resources/images/4.jpg" alt="myRoomMain" style="width:100%; height:400px; align:center;">
		
		<br><br><br><br>
		
		<div class="w3-container" align="center">
			<p>${member.user_name}님 반갑습니다 : )</p>
			<p>좌측 상단의 三 을 클릭해 원하시는 메뉴를 선택해주세요.</p>
			<p>언제나 좋은 강의를 제공하는 CUBe Academy가 되겠습니다 💜</p>
		</div>
		<br>
			<input type="button" class="subBtn" onclick="location.href='myStudy.do'" value="강의실 입장하기">
		<br><br><br>
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