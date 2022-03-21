<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>Course Detail</title>
<style type="text/css">
	th{ width:150px; }
	td{ width:500px; }
	.subBtn, .antBtn{ width:130px; }
	.inpBtn{ width: 500px; }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<input type="hidden" value="${dto.c_no}">
	<!-- <input type="text" value="${dto.c_count }"> -->
	
	<div class="container">
		<h3 class="formTitle" style="font-weight:normal;">교 육 상 세</h3><br><br>
		<div class="content">
			<table class="table insertTable">
				<tr>
					<th>번호</th>
					<td id="c_no">${dto.c_no}</td>
				</tr>
				<tr>
					<th>강 의 명</th>
					<td id="c_name">${dto.c_name}</td>
				</tr>
				<tr>
					<th>과정 분류</th>
					<td id="c_category">${dto.c_category}</td>
				</tr>
				<tr>
					<th>교육 형태</th>
					<td id="c_type">${dto.c_type}</td>
				</tr>
				<tr>
					<th>시작 시간</th>
					<td id="c_start_time">${dto.c_start_time}</td>
				</tr>
				<tr>
					<th>총 교육 시간</th>
					<td id="c_time">${dto.c_time} 시간</td>
				</tr>
				<tr>
					<th>교육 기간</th>
					<td>${dto.c_start_date} ~ ${dto.c_last_date}</td>
				</tr>
				<tr>
					<th>모집인원</th>
					<td id="ent_personnel">${dto.ent_personnel}명</td>
				</tr>
				<tr>
					<th>신청 기간</th>
					<td>${dto.app_start_date} ~ ${dto.app_last_date}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td id="c_regdate">${dto.c_regdate}</td>
				</tr>
				<tr>
					<th>상세 설명</th>
				</tr>
				<tr>
					<th></th>
					<td id="c_detail" style="padding-bottom:50px;">${dto.c_detail }</td>
				</tr>
			</table>
				
			<div class="inpBtn">
				<input type="button" class="subBtn" id="update" onclick="location.href='adminCourseUpdate.do?c_no=${dto.c_no}'" value="수 정">
				<input type="button" class="subBtn" id="delete" onclick="deleteChk();" value="삭 제">
				<input type="button" class="antBtn" onclick="location.href='adminCourseList.do'" value="목 록">
			</div>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#delete").click(function(){
			function deleteChk(){
				alert('선택하신 글을 정말 삭제하시겠습니까?');
				location.href="adminCourseDelete.do?c_no=${dto.c_no}";
			}
		});
	});
	</script>
</body>
</html>