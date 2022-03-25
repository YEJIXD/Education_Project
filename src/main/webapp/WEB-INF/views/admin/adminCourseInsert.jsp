<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<title>Course Insert</title>
<style type="text/css">
	th{ width:150px; }

	td{ 
		width:500px; 
		text-align:left;
		padding:1px 1px 1px 50px;
	}
	
	.c_detail{
		width:600px;
		height:6.25em;
		border:none;
	}
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
		<h3 class="formTitle" style="font-weight:normal;">교 육 등 록</h3><br><br>
		<div class="content">
			<table class="table insertTable">
				<tr>
					<th>강 의 명</th>
					<td><input type="text" class="c_name" id="c_name" name="c_name" placeholder="강의명을 입력하세요" size="80"></td>
				</tr>
				
				<tr>
					<th>과정 분류</th>
					<td>
						<select class="c_category" id="c_category" name="c_category">
							<option value="경영" ${dto.c_category == "경영" ? "selected" : "" } selected>경 영</option>
							<option value="경제" ${dto.c_category == "경제" ? "selected" : "" }>경 제</option>
							<option value="심리" ${dto.c_category == "심리" ? "selected" : "" }>심 리</option>
							<option value="취미" ${dto.c_category == "취미" ? "selected" : "" }>취 미</option>
							<option value="의료" ${dto.c_category == "의료" ? "selected" : "" }>의 료</option>
							<option value="기타" ${dto.c_category == "기타" ? "selected" : "" }>기 타</option>
							</select>
						</td>
					</tr>
					
				<tr>
					<th>교육 형태</th>
					<td>
						<input type="radio" class="c_type" id="c_type" name="c_type" value="집합" checked>집 합&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" class="c_type" id="c_type" name="c_type" value="온라인">온라인
					</td>
				</tr>
					
				<tr>
					<th>총 교육 시간</th>
					<td>
						<input type="text" class="c_time" id="c_time" size="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"> 시간
					</td>
				</tr>
				
				<tr>
					<th>시작 시간</th>
					<td>
						<input type="time" class="c_start_time" id="c_start_time" name="c_start_time" value="09:00:00" min="07:00:00" max="18:00:00">
					</td>
				</tr>
					
				<tr>
					<th>접수 기간</th>
					<td>
						<input type="text" class="aStartDatepicker" id="app_start_date" name="app_start_date" autocomplete="off"> ~ <input type="text" id="app_last_date" name="app_last_date" class="aEndDatepicker" autocomplete="off">
					</td>
				</tr>
	
				<tr>
					<th>교육 기간</th>
					<td>
						<input type="text" class="cStartDatepicker" id="c_start_date" name="c_start_date" autocomplete="off"> ~ <input type="text" id="c_last_date" name="c_last_date" class="cEndDatepicker" autocomplete="off">
					</td>
				</tr>
					
				
				<tr>
					<th>모집 인원</th>
					<td>
						<input type="text" class="ent_personnel" id="ent_personnel" name="ent_personnel" size="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"> 명
					</td>
				</tr>
				
				<tr>
					<th>수강료</th>
					<td>
						<input type="text" class="c_tuition" id="c_tuition" name="c_tuition" size="5" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"> 원
					</td>
				</tr>
				
				<tr>
					<th>상세 설명</th>
				</tr>
				<tr>
					<th></th>
					<td style="padding-bottom:50px;">
						<textarea class="c_detail" id="c_detail" name="c_detail" placeholder="내용을 입력하세요"></textarea>
					</td>
				</tr>
			</table>
			
			<div class="inpBtn">
				<input type="button" class="subBtn" id="insert" onclick="insertChk();" value="등 록">
				<input type="button" class="antBtn" onclick="location.href='adminCourseList.do'" value="취 소">
			</div>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			$("#insert").click(function(){
				let c_name = $("#c_name").val();
				let c_category = $("#c_category option:selected").val();
				let c_type = $('input[name=c_type]:checked').val();
				let c_time = $("#c_time").val();
				let c_start_time = $("#c_start_time").val();
				let c_start_date = $("#c_start_date").val();
				let c_last_date = $("#c_last_date").val();
				let app_start_date = $("#app_start_date").val();
				let app_last_date = $("#app_last_date").val();
				let ent_personnel = $("#ent_personnel").val();
				let c_detail = $("#c_detail").val();
				let c_tuition = $("#c_tuition").val();
				
				if(!insertValidator(c_name, c_time, c_start_time, c_last_date, app_last_date, ent_personnel, c_detail ,c_tuition)){
					return false;
				}
				
				const param = {
					  c_name : c_name
					, c_time : c_time
					, c_category : c_category
					, c_type : c_type
					, c_start_time : c_start_time
					, c_start_date : c_start_date
					, c_last_date : c_last_date
					, app_start_date : app_start_date
					, app_last_date : app_last_date
					, ent_personnel : ent_personnel
					, c_detail : c_detail
					, c_tuition : c_tuition
				}

				$.ajax({
					url:"/courseInsertRes.do",
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
				
				function insertChk(){
					alert('작성하신 글을 등록하시겠습니까?');
					location.href="adminCourseInsert.do";
				}
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
			
			// 접수 기간 최대 날짜 < 교육 기간 최소 날짜
			/* 접수 기간 */
			$(".aStartDatepicker").datepicker({
				onClose: function(data) {
					$('.aEndDatepicker').datepicker('option', 'minDate', data);
				}
			});
			
			$(".aEndDatepicker").datepicker({
				onClose: function(data) {
					$('.aStartDatepicker').datepicker('option', 'maxDate', data);
					$('.cStartDatepicker').datepicker('option', 'minDate', data);
				}
			});
			
			/* 교육 기간 */
			$(".cStartDatepicker").datepicker({
				onClose: function(data) {
					$('.aEndDatepicker').datepicker('option', 'maxDate');
					$('.cEndDatepicker').datepicker('option', 'minDate', data);
				}
			});
			
			$(".cEndDatepicker").datepicker({
				onClose: function(data) {
					$('.cStartDatepicker').datepicker('option', 'maxDate', data);
				}
			});
			
			$(".cStartDatepicker").datepicker().css({ "z-index": 999 });
			$(".cEndDatepicker").datepicker().css({ "z-index": 999 });
			
			$(".aStartDatepicker").datepicker().css({ "z-index": 999 });
			$(".aEndDatepicker").datepicker().css({ "z-index": 999 });
			
			/* 교육 기간 & 접수 기간 시작일 설정 */
			aToday = new Date();
			aToday = aToday.toISOString().slice(0, 10);
			$("#app_start_date").val(aToday);
		});
		
		function insertValidator(c_name, c_time, c_start_time, c_last_date, app_last_date, ent_personnel, c_detail, c_tuition){
			if(c_name == ""){
				alert("강의명을 입력하세요.");
				$("#c_name").focus();
				return false;
			}
			if(c_time == ""){
				alert("총 교육 시간을 입력하세요.");
				$("#c_time").focus();
				return false;
			}
			if(c_start_time == ""){
				alert("시작 시간을 입력하세요.");
				$("#c_start_time").focus();
				return false;
			}
			if(c_last_date == ""){
				alert("교육 종료일을 입력하세요.");
				$("#c_last_date").focus();
				return false;
			}
			if(app_last_date == ""){
				alert("접수 마감일을 입력하세요.");
				$("#app_last_date").focus();
				return false;
			}
			if(ent_personnel == ""){
				alert("모집 인원을 입력하세요.");
				$("#ent_personnel").focus();
				return false;
			}
			if(c_tuition == ""){
				alert("수강료를 입력하세요.");
				$("#c_tuition").focus();
				return false;
			}
			if(c_detail == ""){
				alert("교육 상세 설명을 입력하세요.");
				$("#c_detail").focus();
				return false;
			}
			return true;
		}
</script>
</body>
</html>