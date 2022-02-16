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
		<h3>교육 상세</h3><br><br>
		<div class="content">
			<form action="appForm.do" method="GET">
				<table class="table">
					<tr>
						<th>번호</th>
						<td>1</td>
					</tr>
					<tr>
						<th>교육명</th>
						<td>부동산 마케팅 기획자 실무과정</td>
					</tr>
					<tr>
						<th>과정 구분</th>
						<td>2022년도 2분기</td>
					</tr>
					<tr>
						<th>과정 분류</th>
						<td>경제</td>
					</tr>
					<tr>
						<th>교육 형태</th>
						<td>집합</td>
					</tr>
					<tr>
						<th>교육 장소</th>
						<td>경기도 남양주시 경춘로 990번길</td>
					</tr>
					<tr>
						<th>교육 기간</th>
						<td>2022.04.01~2022.06.01</td>
					</tr>
					<tr>
						<th>교육 시간</th>
						<td>60시간</td>
					</tr>
					<tr>
						<th>신청 기간</th>
						<td>2022.02.01 ~ 2022.03.02</td>
					</tr>
					<tr>
						<th>모집인원</th>
						<td>20명</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>2022.02.20</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>조미세</td>
					</tr>
					<tr>
						<th>상세 설명</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							부동산 마케팅 기획자 실무과정에 대해 배워보고 싶으신 분을 위한 수업입니다.<br>
							부동산에 관심이 있거나 그에 관한 실무 과정에 대해 관심이 있으셨던 분 !<br>
							모여서 하는 수업이다 보니 최대 정원이 20명이라 금방 접수 마감됩니다 !<br>
						</td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" value="신 청">
					<input type="button" class="antBtn" onclick="location.href='courseList.do'" value="취 소">
				</div>
				
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>