<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>admin Course Detail</title>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
	
	.myBtn:hover{ background-color:#E9CFEC; }
	
	.canBtn:hover{
		background-color:gray;
		color:#efefef;
	}
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
		<h3 class="formTitle" style="font-weight:normal;">교육 상세</h3><br><br>
		<div class="content">
				<table class="table insertTable">
						<tr>
							<th>번호</th>
							<td><input type="hidden" id="c_no" value="${dto.c_no }"></td>
						</tr>
						<tr>
							<th>강 의 명</th>
							<td id="c_name">${dto.c_name }</td>
						</tr>
						<tr>
							<th>과정 분류</th>
							<td id="c_category">${dto.c_category }</td>
						</tr>
						<tr>
							<th>교육 형태</th>
							<td id="c_type">${dto.c_type }</td>
						</tr>
						<tr>
							<th>시작 시간</th>
							<td id="c_start_time">${dto.c_start_time }</td>
						</tr>
						<tr>
							<th>총 교육 시간</th>
							<td id="c_time">${dto.c_time } 시간</td>
						</tr>
						<tr>
							<th>교육 기간</th>
							<td id=""><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_start_date }"/> ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_last_date }"/></td>
						</tr>
						<tr>
							<th>모집인원</th>
							<td id="ent_personnel">${dto.ent_personnel }명</td>
						</tr>
						<tr>
							<th>신청 기간</th>
							<td id=""><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.app_start_date }"/> ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${dto.app_last_date }"/></td>
						</tr>
						<tr>
							<th>등록일</th>
							<td id="c_regdate"><fmt:formatDate value="${dto.c_regdate }" pattern="yyyy-MM-dd HH:mm" /></td>
						</tr>
						<tr>
							<th>상세 설명</th>
						</tr>
						<tr>
							<th></th>
							<td  id="c_detail" style="padding-bottom:50px;">${dto.c_detail }</td>
						</tr>
				</table>
				
				<div class="inpBtn">
					<input type="button" class="myBtn" id="update" value="수 정">
					<input type="button" class="myBtn" id="delete" value="삭 제">
					<input type="button" class="canBtn" onclick="location.href='adminCourseList.do'" value="목 록">
				</div>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#update").click(function(){
				let c_name = $("#c_name").val();
				let c_time = $("#c_time").val();
				let c_category = $("#c_category option:selected").val();
				let c_type = $('input[name=c_type]:checked').val();
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
					url:"courseUpdateRes.do",
					type:"get",
					contentType: "application/json",
					data:JSON.stringify(param),
					
					success:function(result){
							if(result.resultCode == 0){
								alert(result.msg);
								$(location).attr("href", "<c:url value='/admin/adminCourseUpdate.do?c_no=${dto.c_no}' />");
							}else{
								alert("관리자에게 문의해 주세요 :::: ErrorCode : " + result.resultCode);
							}
					},
					error : function(result) {
						alert("서버 통신 에러");
					}
				});
			});
			
			$.datepicker.setDefaults({
				dateFormat: 'yy-mm-dd',
				prevText: '이전 달',
				nextText: '다음 달',
				monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				dayNames: ['일', '월', '화', '수', '목', '금', '토'],
				dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
				dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
				showMonthAfterYear: true,
				yearSuffix: '년'
			});
			
			$(".startDatepicker").datepicker({
				onClose: function(data) {
					$('.endDatepicker').datepicker('option', 'minDate', data);
				}
			});
			
			$(".endDatepicker").datepicker({
				onClose: function(data) {
					$('.startDatepicker').datepicker('option', 'maxDate', data);
				}
			});
			
			$(".startDatepicker").datepicker().css({ "z-index": 999 });
			$(".endDatepicker").datepicker().css({ "z-index": 999 });
			
			cToday = new Date();
			cToday = cToday.toISOString().slice(0, 10);
			$("#c_start_date").val(cToday);
			
			aToday = new Date();
			aToday = aToday.toISOString().slice(0, 10);
			$("#app_start_date").val(aToday);
			
			
			$("#delete").click(function(){
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
					url:"courseInsertRes.do",
					type:"post",
					contentType: "application/json",
					data:JSON.stringify(param),
					
					success:function(result){
							if(result.resultCode == 0){
								alert(result.msg);
								$(location).attr("href", "<c:url value='adminCourseList.do' />");
							}else{
								alert("관리자에게 문의해 주세요 :::: ErrorCode : " + result.resultCode);
							}
					},
					error : function(result) {
						alert("서버 통신 에러");
					}
				});
			});
		});
	</script>
</body>
</html>