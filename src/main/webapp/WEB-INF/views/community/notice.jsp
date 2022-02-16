<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.css">
<title>Notice</title>
<style type="text/css">
	.subBtn{ 
		float:right;
	}
	
	table{ width:60%; }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
		
	<div class="container">
		<h3>공 지 사 항</h3><br><br>
		<form action="courseInsert.do" method="GET">
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
					<tr>
						<td>2</td>
						<td><a href="courseDetail.do">강의입니다.</a></td>
						<td>2022.01.12</td>
						<td>88</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">제목입니다.</a></td>
						<td>2022.02.15</td>
						<td>30</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="courseDetail.do">강의입니다.</a></td>
						<td>2022.01.12</td>
						<td>88</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">제목입니다.</a></td>
						<td>2022.02.15</td>
						<td>30</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="courseDetail.do">강의입니다.</a></td>
						<td>2022.01.12</td>
						<td>88</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">제목입니다.</a></td>
						<td>2022.02.15</td>
						<td>30</td>
					</tr>
				</tbody>
			</table>
			<div class="pagination">
	
			</div>
		</form>
	</div>
		
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	<script src="/resources/js/bootstrap/jquery-3.1.1.js"></script>
	<script src="/resources/js/bootstrap/bootstrap.js"></script>
</body>
</html>