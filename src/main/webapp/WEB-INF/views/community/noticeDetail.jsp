<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>NOTICE Detail</title>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
</style>
</head>
<body>
	<div id="header"><%@ include file="../common/header.jsp" %></div>
	<div class="container">
		<h3>공 지 사 항</h3><br><br>
		<div class="content">
			<form action="appForm" method="GET">
				<table class="table">
					<tr>
						<th>번호</th>
						<td>1</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td>공지합니다.</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>2022.02.20</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>관리자</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>3</td>
					</tr>
					<tr>
						<th>내 용</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							홈페이지를 이용하시면서 불편하신 점은 커뮤니티 게시판을 통해<br>
							QNA로 질문을 남겨주시면<br>
							불편함을 해소하실 수 있도록 답변을 남겨 돕겠습니다 : )<br>
						</td>
					</tr>
				</table>
				<div class="inpBtn">
					<input type="button" class="antBtn" onclick="location.href='notice'" value="목 록">
				</div>
			</form>
		</div>
	</div>
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
</body>
</html>