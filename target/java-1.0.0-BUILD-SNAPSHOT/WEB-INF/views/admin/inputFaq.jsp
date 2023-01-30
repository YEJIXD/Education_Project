<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>F A Q Insert</title>
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
		<h3>F A Q 등록</h3><br><br>
		<div class="content">
			<form action="adminFaqInsertRes.do" method="POST">
				<table class="table insertTable">
					<tr>
						<th>제 목</th>
						<td><input type="text" class="insertTitle" id="faq_title" name="faq_title" placeholder="제목을 입력하세요" size="80" required></td>
					</tr>
					<tr>
						<th>분 류</th>
						<td style="text-align:left;">
							<select id="faq_category">
								<option value="전체"  ${faqDto.faq_category == "전체" ? "selected" : "" } selected>전체</option>
								<option value="교육"  ${faqDto.faq_category == "교육" ? "selected" : "" }>교육</option>
								<option value="비용"  ${faqDto.faq_category == "비용" ? "selected" : "" }>비용</option>
								<option value="사이트" ${faqDto.faq_category == "사이트" ? "selected" : "" }>사이트</option>
								<option value="기타"  ${faqDto.faq_category == "기타" ? "selected" : "" }>기타</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>내 용</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							<textarea class="insertContent" id="faq_content" name="faq_content" placeholder="내용을 입력하세요" required></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" id="user_no"name="user_no" value="${member.user_no }">
						</td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" value="등 록">
					<input type="button" class="antBtn" onclick="location.href='adminFaqList.do'" value="취 소">
				</div>
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>