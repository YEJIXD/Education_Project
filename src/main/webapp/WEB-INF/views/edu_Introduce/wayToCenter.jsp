<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wayToCenter</title>
<style type="text/css">
	#title{
		text-align:center;
		height:100px;
		padding-top:50px;
	}
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	<div id="title">
		<h2>오시는 길</h2>
	</div>
	<div id="content">
		<!-- 지도 -->
		<table>
			<tr>
				<td height="500"></td>
			</tr>
		</table>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>