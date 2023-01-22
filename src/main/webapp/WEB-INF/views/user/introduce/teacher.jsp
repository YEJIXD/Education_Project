<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/infCourse.css">
<title>teacher</title>
</head>
<body>
	<div id="header">
		<%@ include file="../../common/header.jsp" %>
	</div>
	
	<div id="middle">
	<h3>강사진 소개</h3><br><br>
		<table id="content">
			<c:forEach items="${teacherList }" var="dto">
				<tr>
					<td id="teaImg"><img src="resources/images/teacher5.png"></td>
					<td>이 름 : <b>${dto.t_name }</b></td>
					<td>경력 사항: <b>${dto.t_career }</b></td>
					<td>담당 강의: <b>${course.c_name }</b></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="footer">
		<%@ include file="../../common/footer.jsp" %>
	</div>	
</body>
</html>