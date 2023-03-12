<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>Q n A Answer</title>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
		<h3>Q n A 답변</h3><br><br>
		<div class="content">
			<form action="qnaInsert" method="POST" enctype="multipart/form-data">
				<table class="table insertTable">
					<tr>
						<th>제 목</th>
						<td><input type="text" class="insertTitle" placeholder="제목을 입력하세요" size="80" required></td>
					</tr>
					<tr>
						<th>내 용</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							<textarea class="insertContent" placeholder="내용을 입력하세요" required></textarea>
						</td>
					</tr>
					<tr>
						<th>파 일</th>
						<td style="vertical-align:middle;"><input type="file" class="insertFile" value="파일 첨부"></td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" value="등 록">
					<input type="button" class="antBtn" onclick="location.href='qnaList'" value="취 소">
				</div>
				
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>