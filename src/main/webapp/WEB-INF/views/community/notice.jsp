<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.css">
<title>Notice</title>
<style type="text/css">
	.subBtn{ float:right; }
	table{ width:60%; }
</style>
</head>
<body>
	<div id="header"><%@ include file="../common/header.jsp" %></div>
	<div class="container">
		<h3>공 지 사 항</h3><br><br>
		<form action="inputNotice" method="GET">
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="no">NO</th>
						<th class="title">제 목</th>
						<th class="date">작성일</th>
						<th class="count">조회수</th>
					</tr>
				</thead>		
				<tr></tr>
				<tbody>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.seq }</td>
							<td><a href="noticeDetail">${dto.title }</a></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.input_date}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pagination"></div>
		</form>
	</div>
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	<script src="/resources/js/bootstrap/jquery-3.1.1.js"></script>
	<script src="/resources/js/bootstrap/bootstrap.js"></script>
</body>
</html>