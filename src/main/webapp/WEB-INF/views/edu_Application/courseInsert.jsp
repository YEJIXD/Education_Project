<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>Q n A Insert</title>
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
		<h3 class="formTitle">Q n A 등록</h3><br><br>
		<div class="content">
			<form action="courseInsertRes.do" method="POST" enctype="multipart/form-data">
				<table class="table insertTable">
					<tr>
						<th>교육명</th>
						<td><input type="text" class="insertTitle" placeholder="제목을 입력하세요" size="80" required></td>
					</tr>
					<tr>
						<th>과정 분류</th>
						<td>
							<input type="radio" name="c_category" value="1" checked >&nbsp;경 영&nbsp;&nbsp;|&nbsp;
							<input type="radio" name="c_category" value="2">&nbsp;경 제&nbsp;&nbsp;|&nbsp;
							<input type="radio" name="c_category" value="3">&nbsp;요 식&nbsp;&nbsp;|&nbsp;
							<input type="radio" name="c_category" value="4">&nbsp;심 리&nbsp;&nbsp;|&nbsp;
							<input type="radio" name="c_category" value="5">&nbsp;의 료&nbsp;&nbsp;|&nbsp;
							<input type="radio" name="c_category" value="6">&nbsp;취 미&nbsp;&nbsp;|&nbsp;
							<input type="radio" name="c_category" value="7">&nbsp;기 타
						</td>
					</tr>
					<tr>
						<th>교육 형태</th>
						<td>
							<input type="radio" name="c_type" value="G" checked>집 합&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="c_type" value="O">온라인
						</td>
					</tr>
					<tr>
						<th>교육 시간</th>
						<td>
							<input type="time" name="c_time" required>
						</td>
					</tr>
					<tr>
						<th>교육 기간</th>
						<td>
							<input type="date" name="c_period" required> ~ <input type="date" name="c_period" required>
						</td>
					</tr>
					<tr>
						<th>모집 인원</th>
						<td>
							<input type="text" name="ent_personnel" size="5" required> 명
						</td>
					</tr>
					<tr>
						<th>상세 설명</th>
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
					<input type="button" class="antBtn" onclick="location.href='adminCourseList.do'" value="취 소">
				</div>
				
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>