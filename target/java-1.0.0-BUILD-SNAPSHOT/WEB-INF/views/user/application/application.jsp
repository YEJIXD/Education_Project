<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>app Form</title>
</head>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
</style>
<body>
	<div id="header"><%@ include file="../../common/header.jsp" %></div>
	<div class="container">
	<h3>신청 정보 확인</h3><br><br>
		<div class="content">
			<form name="appForm" action="myStudy" method="GET">
				<table class="table">
					<tr>
						<th>과정 분류</th>
						<td>${dto.c_category}</td>
					</tr>
					<tr>
						<th>강의명</th>
						<td>${dto.c_name}</td>
					</tr>
					<tr>
						<th>신청일</th>
						<td>${APPLICATION.app_date }</td>
					</tr>
					<tr>
						<th>신청인</th>
						<td>${member.user_name}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${member.user_email}</td>
					</tr>
				</table>
				<div class="inpBtn">
					<input type="submit" class="subBtn" value="완 료">
					<input type="button" class="antBtn" onclick="location.href='courseList.do'" value="목 록">
				</div>
			</form>
		</div>
	</div>
	<div id="footer"><%@ include file="../../common/footer.jsp" %></div>
</body>
</html>