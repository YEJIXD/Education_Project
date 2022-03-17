<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
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
			<form action="courseInsertRes.do" method="POST">
				<table class="table insertTable">
					<tr>
						<th>강 의 명</th>
						<td><input type="text" class="c_name" id="c_name" name="c_name" placeholder="강의명을 입력하세요" size="80" required></td>
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
							<input type="radio" class="c_type" id="c_type" name="c_type" value="G" checked>집 합&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" class="c_type" id="c_type" name="c_type" value="O">온라인
						</td>
					</tr>
					
					<tr>
						<th>총 교육 시간</th>
						<td>
							<input type="text" class="c_time" id="c_time" size="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required> 시간
						</td>
					</tr>
					
					<tr>
						<th>시작 시간</th>
						<td>
							<input type="time" class="c_start_time" id="c_start_time" name="c_start_time" value="09:00:00" min="07:00:00" max="18:00:00" required>
						</td>
					</tr>
					
					<tr>
						<th>교육 기간</th>
						<td>
							<input type="date" class="c_start_date" id="c_start_date" name="c_start_date" min="2022-03-25" required> ~ <input type="date" id="c_last_date" name="c_last_date" class="c_last_date" required>
						</td>
					</tr>
					
					<tr>
						<th>모집 인원</th>
						<td>
							<input type="text" class="ent_personnel" id="ent_personnel" name="ent_personnel" size="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required> 명
						</td>
					</tr>
					
					<tr>
						<th>상세 설명</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							<textarea class="c_detail" id="c_detail" name="c_detail" placeholder="내용을 입력하세요" required></textarea>
						</td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" id="submit" value="등 록">
					<input type="button" class="antBtn" onclick="location.href='adminCourseList.do'" value="취 소">
				</div>
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	

	
<script type="text/javascript">
 	<!-- input에 오늘 날짜 기본값으로 넣기 -->
		window.onload = function() {
			today = new Date();
			today = today.toISOString().slice(0, 10);
			console.log("today >>>> " + today);
			bir = document.getElementById("c_start_date");
			bir.value = today;
		} 
		
		/* function valueSave(){
			const cTime = document.querySelector("#c_time").value;
			const startDate = document.querySelector("#c_start_date").value;
			const lastDate = document.querySelector("#c_last_date").value;
			
			console.log("c_time : " + cTime + ", c_start_date : " + startDate + ", c_last_date : " + lastDate);
		} */
		
		$("#submit").click(function(){
			let data = new FormData(document.getElementById("f"));
			
			$.ajax({
				url:"/admin/adminCourseInsertRes.do",
				type:"post",
				processData:false,
				contentType:false,
				data:data,
				success:function(){
					adminCourseList();
			}
			});
		});

		
		
			//let category = document.getElementById("c_category");
			//alert("value : " + category.options[category.selectedIndex].value);
			
			//const sDay = document.getElementById("#c_start_date").value;
			//console.log(sDay);
</script>
</body>
</html>