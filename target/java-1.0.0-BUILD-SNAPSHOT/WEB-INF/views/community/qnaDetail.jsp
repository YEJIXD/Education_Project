<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>course Detail</title>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
		<h3>Q n A 상세</h3><br><br>
		<div class="content">
			<form action="qnaAnswer.do" method="GET">
				<table class="table">
					<tr>
						<th>번호</th>
						<td>1</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td>궁금합니다.</td>
					</tr>
					<tr>
						<th>작 성 자</th>
						<td>김동산</td>
					</tr>
					<tr>
						<th>등 록 일</th>
						<td>2022.01.13</td>
					</tr>
					<tr>
						<th>수 정 일</th>
						<td>2022.02.14</td>
					</tr>
					<tr>
						<th>답변 여부</th>
						<td style="color:blue;">대 기</td>
					</tr>
					<tr>
						<th>조 회 수</th>
						<td>24</td>
					</tr>
					<tr>
						<th>공개 여부</th>
						<td>Y</td>
					</tr>
					<tr>
						<th>내 용</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							교육 신청을 하고싶습니다.<br>
							그런데 어떻게 하는지 모르겠습니다.<br>
							제발 알려주세요<br>
						</td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" value="답 글">
					<input type="button" class="antBtn" onclick="location.href='qnaList.do'" value="목 록">
				</div>
				
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>