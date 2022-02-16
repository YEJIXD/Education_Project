<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/course/infCourse.css">
<title>greeting</title>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div id="middle">
		<h3>인 사 말</h3><br><br>
	</div>
	
	<div id="greeting" align="center">
		<div id="top">
			<img src="resources/images/advisor.png">
		</div>
		<div id="bottom">
			<p>안녕하세요<br>CUBe Academy 대표 김철수입니다.</p>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>	
</body>
</html>