<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>admin Course Detail</title>
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
			<form action="adminCourseUpdate.do" method="GET">
				<table class="table insertTable">
						<tr>
							<th>번호</th>
							<td><input type="hidden" id="c_no" value="${dto.c_no }"></td>
						</tr>
						<tr>
							<th>강 의 명</th>
							<td id="c_name">${dto.c_name }</td>
						</tr>
						<tr>
							<th>과정 분류</th>
							<td id="c_category">${dto.c_category }</td>
						</tr>
						<tr>
							<th>교육 형태</th>
							<td id="c_type">${dto.c_type }</td>
						</tr>
						<tr>
							<th>시작 시간</th>
							<td id="c_start_time">${dto.c_start_time }</td>
						</tr>
						<tr>
							<th>총 교육 시간</th>
							<td id="c_time">${dto.c_time }</td>
						</tr>
						<tr>
							<th>교육 기간</th>
							<td id=""><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_start_date }"/> ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_last_date }"/></td>
						</tr>
						<tr>
							<th>모집인원</th>
							<td id="ent_personnel">${dto.ent_personnel }명</td>
						</tr>
						<tr>
							<th>신청 기간</th>
							<td id=""><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.app_start_date }"/> ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${dto.app_last_date }"/></td>
						</tr>
						<tr>
							<th>등록일</th>
							<td id="c_regdate"><fmt:formatDate value="${dto.c_regdate }" pattern="yyyy-mm-dd HH:mm" /></td>
						</tr>
						<tr>
							<th>상세 설명</th>
						</tr>
						<tr>
							<th></th>
							<td  id="c_detail" style="padding-bottom:50px;">${dto.c_detail }</td>
						</tr>
				</table>
				
				<div class="inpBtn">
					<input type="button" class="antBtn" onclick="location.href='adminCourseList.do'" value="목 록">
				</div>
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>