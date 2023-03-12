<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="shortcut icon" href="#">
<title>myRoom_studyStatus</title>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<!-- 사이드 메뉴 -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none; background-color:#B0E0E6;" id="mySidebar">
	  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()"><b>&times;</b></button>
	  <a href="myStudy" class="w3-bar-item w3-button" style="font-weight:bold; font-size:13pt;">수강 교육</a>
	  <a href="review" class="w3-bar-item w3-button">수강 후기</a>
	  <a href="pwConfirm.do" class="w3-bar-item w3-button">정보 수정</a>
	</div>
	
	<div id="main">
		<div class="w3-teal" style="background-color:#B0E0E6">
		  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
		  <div class="w3-container">
		    <h2 align="center">수강 교육</h2>
		  </div>
		</div>
		
		<br><br><br><br>
		
		<div class="container">
		<h4>수강중인 과정</h4><br>
			<!-- 수강중인 과정 -->
			<div class="present">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="no">번호</th>
							<th class="Cname">과정명</th>
							<th class="term">교육기간</th>
							<th class="percent">진도율</th>
							<th class="status"></th>
						</tr>
					</thead>
					<tr></tr>
					<tbody>
						<tr>
							<td>3</td>
							<td><a href="#">위기상황 대처의 다양한 방법에 대한 학습</a></td>
							<td>2022.02.24 ~ 2022.03.14</td>
							<td>14%</td>
							<td><input type="button" class="myBtn" onclick="location.href='https://www.youtube.com/watch?v=LZeh8kxR8YA'" value="입 장"></td>
						</tr>
					</tbody>
				</table>
			</div>
			</div>
			
			<div class="container">
			<!-- 수강예정 과정 -->
			<h4>수강예정 과정</h4><br>
			<div class="future">
				<table  class="table table-hover">
					<thead>
						<tr>
							<th class="no">번호</th>
							<th class="Cname">과정명</th>
							<th class="term">교육 시작일</th>
							<th class="status">수강취소</th>
						</tr>
					</thead>
					<tr></tr>
					<tbody>
						<tr>
							<td>1</td>
							<td><a href="#">생명존중 활동에 대한 의미와 동기부여</a></td>
							<td>2022.04.03</td>
							<td><input type="button" class="myBtn" onclick="" value="취 소"></td>
						</tr>
					</tbody>
				</table>
			</div>
			</div>
		
			<div class="container">
			<!-- 수강완료 과정 -->	
			<h4>수강완료 과정</h4><br>
			<div class="past">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="no">번호</th>
							<th class="Cname">과정명</th>
							<th class="term">교육기간</th>
							<th class="percent">진도율</th>
							<th class="status">수료여부</th>
							<th class="review">후기</th>
						</tr>
					</thead>
					<tr></tr>
					<tbody>
						<tr>
							<td>1</td>
							<td><a href="#">부동산 마케팅 기획자 실무과정</a></td>
							<td>2021.10.02 ~ 2021.12.01</td>
							<td>100%</td>
							<td><input type="button" class="myBtn" onclick="location.href='receiveCert.do'" value="발 급"></td>
							<td><input type="button" class="myBtn" onclick="location.href='reviewInsertPage.do'" value="등 록"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
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