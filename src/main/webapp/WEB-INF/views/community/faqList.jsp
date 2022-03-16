<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.css">
<title>F A Q</title>
<style type="text/css">
	table{ width:60%; }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
		
	<div class="container">
		<h3>F A Q</h3><br>
		<div class="tab_container" id="faq_category" style="width:97%; padding:5px 5px 5px 5px; font-weight:bold; font-size:14pt;">
			<ul class="tabs">
				<li><a href="hashTagSearch(this)">전 체&nbsp;&nbsp;</a>|</li>
				<li><a href="hashTagSearch(this)">교 육&nbsp;&nbsp;</a>|</li>
				<li><a href="hashTagSearch(this)">비 용&nbsp;&nbsp;</a>|</li>
				<li><a href="hashTagSearch(this)">이용문의&nbsp;&nbsp;</a>|</li>
				<li><a href="hashTagSearch(this)">기 타</a></li>
			</ul>
		</div>
		<br>
		<form action="adminFaqInsert.do" method="GET">
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="no">NO</th>
						<th class="date">분 류</th>
						<th class="title">제 목</th>
						<th class="date">작성일</th>
						<th class="date">조회수</th>
					</tr>
				</thead>		
				<tr></tr>
				<tbody>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.faq_no }</td>
							<td>${dto.faq_category }</td>
							<td><a href="faq_detail.do?faq_no=${dto.faq_no }" style="text-decoration:none; font-weight:bold;">${dto.faq_title }</a></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.faq_date}"/></td>
							<td>${dto.faq_count }</td>
						</tr>
					</c:forEach>
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