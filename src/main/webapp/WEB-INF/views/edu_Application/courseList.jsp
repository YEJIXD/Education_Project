<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<tr>
						<td>2</td>
						<td><a href="courseDetail.do">강의입니다.</a></td>
						<td>32/60</td>
						<td style="color:blue;">접수중</td>
						<td>2022.01.12</td>
						<td>88</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">제목입니다.</a></td>
						<td>21/50</td>
						<td style="color:red;">접수마감</td>
						<td>2022.02.15</td>
						<td>30</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="courseDetail.do">강의입니다.</a></td>
						<td>32/60</td>
						<td style="color:blue;">접수중</td>
						<td>2022.01.12</td>
						<td>88</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">제목입니다.</a></td>
						<td>21/50</td>
						<td style="color:red;">접수마감</td>
						<td>2022.02.15</td>
						<td>30</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="courseDetail.do">강의입니다.</a></td>
						<td>32/60</td>
						<td style="color:blue;">접수중</td>
						<td>2022.01.12</td>
						<td>88</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">제목입니다.</a></td>
						<td>21/50</td>
						<td style="color:red;">접수마감</td>
						<td>2022.02.15</td>
						<td>30</td>
					</tr>
				</tbody>
			</table>
			<div class="Btn">
				<input type="submit" class="subBtn" value="등 록">
			</div>
						
			<div class="pagination">
	
			</div>
		</form>
	</div>
		
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>