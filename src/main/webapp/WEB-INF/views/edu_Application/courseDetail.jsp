<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>course Detail</title>
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
		<h3 class="formTitle" style="font-weight:normal;">교 육 상 세</h3><br><br>
		<div class="content">
		<form action="appForm.do" method="POST">
			<table class="table insertTable">
				<tr>
					<th>번호</th>
					<td id="c_no">${dto.c_no}</td>
				</tr>
				<tr>
					<th>강 의 명</th>
					<td id="c_name">${dto.c_name}</td>
				</tr>
				<tr>
					<th>과정 분류</th>
					<td id="c_category">${dto.c_category}</td>
				</tr>
				<tr>
					<th>교육 형태</th>
					<td id="c_type">${dto.c_type}</td>
				</tr>
				<tr>
				<th>시작 시간</th>
					<td id="c_start_time">${dto.c_start_time}</td>
				</tr>
				<tr>
					<th>총 교육 시간</th>
					<td id="c_time">${dto.c_time} 시간</td>
				</tr>
				<tr>
					<th>교육 기간</th>
					<td>${dto.c_start_date} ~ ${dto.c_last_date}</td>
				</tr>
				<tr>
					<th>모집인원</th>
					<td id="ent_personnel">${dto.ent_personnel}명</td>
				</tr>
				<tr>
					<th>신청 기간</th>
					<td>${dto.app_start_date} ~ ${dto.app_last_date}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td id="c_regdate">${dto.c_regdate}</td>
				</tr>
				<tr>
					<th>상세 설명</th>
				</tr>
				<tr>
					<th></th>
					<td id="c_detail" style="padding-bottom:50px;">${dto.c_detail }</td>
				</tr>
			</table>

			<div class="inpBtn">
				<input type="button" class="subBtn" id="appBtn" onclick="appChk();" value="신 청">
				<input type="button" class="antBtn" onclick="location.href='courseList.do'" value="목 록">
			</div>
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#appBtn").click(function(){
				let c_name = $("#c_name").val();
				let c_category = $("#c_category").val();
				let c_type = $('#c_type').val();
				let c_time = $("#c_time").val();
				let c_start_time = $("#c_start_time").val();
				let c_start_date = $("#c_start_date").val();
				let c_last_date = $("#c_last_date").val();
				let app_start_date = $("#app_start_date").val();
				let app_last_date = $("#app_last_date").val();
				let ent_personnel = $("#ent_personnel").val();
				let c_detail = $("#c_detail").val();
				
				const param = {
					c_name : c_name,
					c_time : c_time,
					c_category : c_category,
					c_type : c_type,
					c_start_time : c_start_time,
					c_start_date : c_start_date,
					c_last_date : c_last_date,
					app_start_date : app_start_date,
					app_last_date : app_last_date,
					ent_personnel : ent_personnel,
					c_detail : c_detail
				}
	
				$.ajax({
					url:"/appInsert.do",
					type:"post",
					contentType: "application/json",
					data:JSON.stringify(param),
					
					success:function(result){
							if(result.resultCode == 0){
								alert(result.msg);
								$(location).attr("href", "<c:url value='courseList.do' />");
							}else{
								alert("관리자에게 문의해 주세요 :::: ErrorCode : " + result.resultCode);
							}
					},
					error : function(result) {
						alert("서버 통신 에러");
					}
				});
				function appChk(){
					alert('선택하신 교육을 신청하시겠습니까?');
					location.href="appForm.do?c_no=${dto.c_no}";
				}
			});
		});
	</script>
</body>
</html>