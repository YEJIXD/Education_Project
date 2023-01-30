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
		<div id="searchKeyword" style="height: 60px; margin: 0px auto; text-align: center;">
			<select name="searchType" id="searchType">
				<option value="title" <c:if test="${condition eq 'title'}"> selected</c:if>>제 목</option>
			</select> 
			<input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="검색어를 입력하세요"/> 
			<input type="button" name="searchBtn" id="searchBtn" value="검 색">
			<input type="hidden" name="page" value="${cri.page}">
			<input type="hidden" name="amount" value="${cri.amount}">
			<input type="hidden" name="keyword" value="${dto.keyword }">
		</div>
		<form action="inputNotice" method="GET">
			<input type="hidden" id="keyword" name="keyword" value='<c:out value="${pageDto.keyword}" />'>
			<input type="hidden" id="page" name="page" value='<c:out value="${cri.page}" />'>
			<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}" />'>
			<input type="hidden" id="user_no" name="user_no" value='<c:out value="${member.user_no}" />'>
			<input type="hidden" id="user_name" name="user_name" value='<c:out value="${member.user_name}" />'>
			<input type="hidden" id="user_email" name="user_email" value='<c:out value="${member.email}" />'>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="no">NO</th>
						<th class="title">제 목</th>
						<th class="date">작성일</th>
					</tr>
				</thead>		
				<tr></tr>
				<tbody>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.seq }</td>
							<td><a href="/community/noticeDetail?blog_no=${dto.user_no}">${dto.title }</a></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.input_date}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="m-paging">
				<ul>
					<c:if test="true">
						<li>
							<a href='<c:url value="courseList.do?page=${dto.startPage-1 }&keyword=${dto.keyword}"/>' id="pre" class='oiBtn prev'>◀</a>
						</li>
					</c:if>
					<c:forEach begin="${dto.startPage}" end="${dto.endPage}" var="page">
						<li>
							<a href='<c:url value="courseList.do?page=${page}&amount=${cri.amount}&keyword=${dto.keyword}"/>' class='num <c:if test="${dto.cri.page eq page}"> active </c:if>'>${page}</a>
						</li>
					</c:forEach>
					<c:if test="${dto.next && dto.endPage>0}">
						<li>
							<a href='<c:url value="courseList.do?page=${dto.endPage+1 }&keyword=${dto.keyword}"/>' id="next" class='oiBtn next'>▶</a>
						</li>
					</c:if>
				</ul>
			</div>
		</form>
	</div>
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	<script src="/resources/js/bootstrap/jquery-3.1.1.js"></script>
	<script src="/resources/js/bootstrap/bootstrap.js"></script>
</body>
</html>