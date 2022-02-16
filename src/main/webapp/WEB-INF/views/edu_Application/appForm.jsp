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
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
	<h3>신청 확인</h3><br><br>
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
						<th>신청일</th>
						<td>2022.02.24</td>
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
					<input type="button" class="antBtn" onclick="location.href='courseList.do'" value="목 록">
				</div>
			</form>
		</div>
	</div>

	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>