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
			<form action="courseInsertRes.do" method="POST" enctype="multipart/form-data">
				<table class="table insertTable">
					<tr>
						<th>교 육 명</th>
						<td><input type="text" class="c_name" id="c_name" placeholder="제목을 입력하세요" size="80" required></td>
					</tr>
					
						<tr>
							<th>과정 분류</th>
							<td>
								<select class="c_category" id="c_category" onChange="categorySelect(this.value);">
									<option value="경영" id="c_category" ${courseDto.c_category == "경영" ? "selected" : "" } selected>경 영</option>
									<option value="경제" id="c_category" ${courseDto.c_category == "경제" ? "selected" : "" }>경 제</option>
									<option value="요식" id="c_category" ${courseDto.c_category == "요식" ? "selected" : "" }>요 식</option>
									<option value="심리" id="c_category" ${courseDto.c_category == "심리" ? "selected" : "" }>심 리</option>
									<option value="미술" id="c_category" ${courseDto.c_category == "미술" ? "selected" : "" }>미 술</option>
									<option value="음악" id="c_category" ${courseDto.c_category == "음악" ? "selected" : "" }>음 악</option>
									<option value="취미" id="c_category" ${courseDto.c_category == "취미" ? "selected" : "" }>취 미</option>
									<option value="의료" id="c_category" ${courseDto.c_category == "의료" ? "selected" : "" }>의 료</option>
									<option value="기타" id="c_category" ${courseDto.c_category == "기타" ? "selected" : "" }>기 타</option>
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
							<input type="text" class="c_time" id="c_time" size="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" max="3" required> 시간
						</td>
					</tr>
					
					<tr>
						<th>교육 시작 시간</th>
						<td>
							<input type="time" class="c_start_time" id="c_start_time" value="09:00:00" min="07:00:00" max="18:00:00" required>
						</td>
					</tr>
					
					<tr>
						<th>교육 기간</th>
						<td>
							<input type="date" class="c_start_date" id="c_start_date" min="2022-03-25" required> ~ <input type="date" id="c_last_date" class="c_last_date" onclick="startDateConfirm();" required>
						</td>
					</tr>
					
					<tr>
						<th style="vertical-align:middle;">주 소</th>
                        <td>
                            <input type="text" class="c_addr" name="c_addr" id="c_addr" placeholder="주소를 입력하세요." size="5" readonly required>
                            <input type="button" class="c_addr_chk" value="검색" title="n" onclick="addr_search();"><br>
                            <input type="text" class="c_addr_sub" name="c_addr_sub" id="c_addr_sub" placeholder="상세주소를 입력하세요." size="5" title="n" onclick="addrConfirm();" required>
                        </td>
					</tr>
					
					<tr>
						<th>모집 인원</th>
						<td>
							<input type="text" class="ent_personnel" id="ent_personnel" size="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required> 명
						</td>
					</tr>
					
					<tr>
						<th>상세 설명</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							<textarea class="c_detail" id="c_detail" placeholder="내용을 입력하세요" required></textarea>
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
	

	
<!-- Daum 주소 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function addr_search() {
    	daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	let addr = ''; 	  // 도로명 주소 변수
	
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣기
	                document.getElementById("c_addr").value = addr;
	                // focus를 상세주소 필드로 이동
	                document.getElementById("c_addr_sub").focus();
	            }
	        }).open();
    	});
    }

	
 	<!-- input에 오늘날짜 기본값으로 넣기 -->
		window.onload = function() {
			today = new Date();
			console.log("today.toISOString() >>>" + today.toISOString());
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
</script>
</body>
</html>