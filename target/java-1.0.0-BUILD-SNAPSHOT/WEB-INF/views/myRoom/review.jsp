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
<title>Review</title>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<!-- 사이드 메뉴 -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none; background-color:#B0E0E6;" id="mySidebar">
	  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()"><b>&times;</b></button>
	  <a href="myStudy.do" class="w3-bar-item w3-button">수강 교육</a>
	  <a href="review.do" class="w3-bar-item w3-button" style="font-weight:bold; font-size:13pt;">수강 후기</a>
	  <a href="pwConfirm.do" class="w3-bar-item w3-button">정보 수정</a>
	</div>
	
	<div id="main">
		<div class="w3-teal" style="background-color:#B0E0E6">
		  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
		  <div class="w3-container">
		    <h2 align="center">수강 후기</h2>
		  </div>
		</div>
		
		<br><br><br><br>
		
		<div class="container">
			<!-- 수강 후기 리스트 -->
			<div class="reviewlist">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="no">번호</th>
							<th class="Cname">과정명</th>
							<th class="term">교육기간</th>
						</tr>
					</thead>
					<tr></tr>
					<tbody>
						<tr>
							<td>1</td>
							<td><a href="#">부동산 마케팅 기획자 실무과정</a></td>
							<td>2022.02.24 ~ 2022.03.14</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a href="#">부동산 마케팅 기획자 실무과정</a></td>
							<td>2022.02.24 ~ 2022.03.14</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a href="#">부동산 마케팅 기획자 실무과정</a></td>
							<td>2022.02.24 ~ 2022.03.14</td>
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