<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<title>course List</title>
<style type="text/css">
	.subBtn{ float:right; }
	
	table{ width:60%; }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
		
	<div class="container">
		<h3>교육 강의 목록</h3><br><br>
		<form action="courseInsert.do" method="GET">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="width:50px;">NO</th>
						<th style="width:900px;">제 목</th>
						<th style="width:200px;">신청인원/모집인원</th>
						<th style="width:100px;">접수 상태</th>
						<th style="width:150px;">작성일</th>
						<th style="width:80px;">조회수</th>
					</tr>
				</thead>		
				<tr></tr>
				<tbody>
					<c:forEach items="${courseList }" var="dto">
						<tr>
							<td>${dto.c_no}</td>
							<td><a href="courseDetail.do?c_no="${dto.c_no }>${dto.c_name }</a></td>
							<td>/ ${dto.ent_personnel}</td>
							<td style="color:blue;">접수중</td>
							<td>2022.02.17</td>
							<td>26</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<c:if test="${not empty sessionScope.user_id }">
				<div class="Btn">
					<input type="submit" class="subBtn" value="등 록">
				</div>
			</c:if>
						
			<div class="pagination">
	
			</div>
		</form>
	</div>
		
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>