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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			/*교육을 신청하는 회원 정보 & 신청하려는 교육 정보 필요 => 넘겨야 함*/
			$("#appBtn").on("click", function(){
				let c_no = $("#c_no").text();
				let user_no = $("#user_no").text();
				let user_name = $("#user_name").text();
				let user_id = $("#user_id").text();
				
				console.log(c_no);
				console.log(user_no);
				console.log(user_name);
				console.log(user_id);
				
				/* const param = {
					  c_no : c_no	
				} */
	
				/* $.ajax({
					url:"/appInsert",
					type:"post",
					contentType: "application/json",
					data:JSON.stringify(param),
					
					success:function(result){
							if(result.resultCode == 0){
								alert(result.msg);
								$(location).attr("href", "<c:url value='courseList' />");
							}else{
								alert("관리자에게 문의해 주세요 :::: ErrorCode : " + result.resultCode);
							}
					},
					error : function(result) {
						alert("서버 통신 에러");
					}
				}); */
				function appChk(){
					alert('선택하신 교육을 신청하시겠습니까?');
					location.href="courseList";
					//location.href="appForm?c_no=${dto.c_no}&page=${cri.page}&amount=${cri.amount}&keyword=${pageDto.keyword}";
				}
			}); 
			
			$("#list").on("click",function(){
				const c_no = $("#c_no").text();
				let page = $("#page").text();
				let amount = $("#amount").text();
				let keyword = $("#keyword").text();
				
				let listUrl = "courseList?page=${cri.page}"
							+ "&amount=${cri.amount}"
							+ "&keyword=${pageDto.keyword}";
						
				location.href = listUrl;
			});
		});
	</script>
</head>
<body>
	<div id="header">
		<%@ include file="../../common/header.jsp" %>
		<input type="hidden" id="user_no" name="user_no" value='<c:out value="${user.USER_NO}" />'>
		<input type="hidden" id="user_name" name="user_name" value='<c:out value="${user.USER_NAME}" />'>
		<input type="hidden" id="user_id" name="user_id" value='<c:out value="${user.USER_ID}" />'>
	</div>
	<input type="hidden" id="keyword" name="keyword" value='<c:out value="${pageDto.keyword}" />'>
	<input type="hidden" id="page" name="page" value='<c:out value="${cri.page}" />'>
	<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}" />'>
	<div class="container">
		<h3 class="formTitle" style="font-weight:normal;">교 육 상 세</h3><br><br>
		<div class="content">
			<table class="table insertTable">
				<tr>
					<th>강의 번호</th>
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
					<th>수강료</th>
					<td id="c_tuition"><fmt:formatNumber pattern="###,###,###" value="${dto.c_tuition}" /> 원</td>
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
				<input type="button" class="subBtn" id="appBtn" value="신 청">
				<input type="button" class="antBtn" id="list" value="목 록">
			</div>
		</div>
	</div>
	<div id="footer"><%@ include file="../../common/footer.jsp" %></div>
</body>
</html>