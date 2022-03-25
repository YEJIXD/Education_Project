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
			<!-- 게시물 검색 -->
			<div id="searchKeyword" style="height: 60px; margin: 0px auto; text-align: center;">
				<select name="searchType" id="searchType">
					<option value="" disabled selected>선 택</option>					
					<option value="title">제 목</option>
					<option value="content" <c:if test="${dto.keyword eq 'content'}">selected</c:if>>내 용</option>
				</select> 

				<input type="text" name="keyword" id="keyword" value="${cri.keyword}" placeholder="검색어를 입력하세요"/> 
				<input type="button" name="searchBtn" id="searchBtn" value="검 색">
									
				<!-- 검색 후 화면에 보여질 게시글 수와 페이지 넘버 (hidden 사용) -->
				<!--  <input type="hidden" name="pageNum" value="1">
				<input type="hidden" name="amount" value="10">-->
									
				<!-- keyword를 저장할 수 있는 input 태그 작성 -->
				<!-- <input type="hidden" name="keyword" value="${cri.keyword }"> -->
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="width:50px;">NO</th>
						<th style="width:750px;">제 목</th>
						<th style="width:200px;">신청인원/모집인원</th>
						<th style="width:100px;">접수 상태</th>
						<th style="width:150px;">등록일</th>
					</tr>
				</thead>		
				<tr></tr>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.c_no}</td>
							<td><a href="courseDetail.do?c_no=${dto.c_no}">${dto.c_name}</a></td>
							<td>${dto.app_personnel}명 / ${dto.ent_personnel}명</td>
							<td style="color:blue;">${app.c_status}</td>
							<td>${dto.c_regdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
						
			<div class="pagination">
	
			</div>
	</div>
		
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>