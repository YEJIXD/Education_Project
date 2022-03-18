<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

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
		<h3 class="formTitle" style="font-weight:normal;">교육 상세</h3><br><br>
		<div class="content">
			<form>
				<table class="table insertTable">
					<tr>
						<th>번호</th>
						<td><input type="text" value="${COURSE.C_NO }"></td>
					</tr>
					<tr>
						<th>강 의 명</th>
						<td>${COURSE.C_NAME }</td>
					</tr>
					<tr>
						<th>과정 분류</th>
						<td>${COURSE.C_CATEGORY }</td>
					</tr>
					<tr>
						<th>교육 형태</th>
						<td>${COURSE.C_TYPE }</td>
					</tr>
					<tr>
						<th>시작 시간</th>
						<td>${COURSE.C_START_TIME }</td>
					</tr>
					<tr>
						<th>총 교육 시간</th>
						<td>${COURSE.C_TIME }</td>
					</tr>
					<tr>
						<th>교육 기간</th>
						<td>${COURSE.C_START_DATE} ~ ${COURSE.C_LAST_DATE }</td>
					</tr>
					<tr>
						<th>모집인원</th>
						<td>${COURSE.ENT_PERSONNEL }</td>
					</tr>
					<tr>
						<th>신청 기간</th>
						<td>${APPLICATION.APP_START_DATE} ~ ${APPLICATION.APP_LAST_DATE }</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${COURSE.C_REGDATE }</td>
					</tr>
					<tr>
						<th>상세 설명</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">${COURSE.C_DETAIL }</td>
					</tr>
				</table>
				
				<div class="inpBtn">
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