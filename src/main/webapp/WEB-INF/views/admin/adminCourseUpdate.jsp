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
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
		<h3 class="formTitle">교 육 등 록</h3><br><br>
		<div class="content">
			<form action="courseInsertRes.do" onsubmit="return check_frm();" method="POST" enctype="multipart/form-data">
				<table class="table insertTable">
					<tr>
						<th>교 육 명</th>
						<td><input type="text" class="insertTitle" id="insertTitle" title="n" placeholder="제목을 입력하세요" size="80" required></td>
					</tr>
					
						<tr>
							<th>과정 분류</th>
							<td>
								<select id="c_category" onChange="categorySelect(this.value);">
									<option value="경영" ${courseDto.c_category == "경영" ? "selected" : "" } selected>경 영</option>
									<option value="경제" ${courseDto.c_category == "경제" ? "selected" : "" }>경 제</option>
									<option value="요식" ${courseDto.c_category == "요식" ? "selected" : "" }>요 식</option>
									<option value="심리" ${courseDto.c_category == "심리" ? "selected" : "" }>심 리</option>
									<option value="미술" ${courseDto.c_category == "미술" ? "selected" : "" }>미 술</option>
									<option value="음악" ${courseDto.c_category == "음악" ? "selected" : "" }>음 악</option>
									<option value="취미" ${courseDto.c_category == "취미" ? "selected" : "" }>취 미</option>
									<option value="의료" ${courseDto.c_category == "의료" ? "selected" : "" }>의 료</option>
									<option value="기타" ${courseDto.c_category == "기타" ? "selected" : "" }>기 타</option>
								</select>
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
							<input type="time" name="c_time" id="c_time" required>
						</td>
					</tr>
					
					<tr>
						<th>교육 기간</th>
						<td>
							<input type="date" name="c_start_date" id="c_start_date" required> ~ <input type="date" id="c_last_date" name="c_last_date" onclick="startDateConfirm();" required>
						</td>
					</tr>
					
					<tr>
						<th style="vertical-align:middle;">주 소</th>
                        <td>
                            <input type="text" class="c_addr" name="c_addr" id="c_addr" placeholder="주소를 입력하세요." readonly required>
                            <input type="button" class="c_addr_chk" value="주소검색" title="n" onclick="addr_search();"><br>
                            <input type="text" class="c_addr_sub" name="c_addr_sub" id="c_addr_sub" placeholder="상세주소를 입력하세요." title="n" onclick="addrConfirm();" required>
                        </td>
					</tr>
					
					<tr>
						<th>모집 인원</th>
						<td>
							<input type="text" name="ent_personnel" id="ent_personnel" size="4" title="n" onclick="addrSubConfirm();" required> 명
						</td>
					</tr>
					
					<tr>
						<th>상세 설명</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							<textarea class="insertContent" placeholder="내용을 입력하세요" id="insertContent" title="n" onclick="entConfirm();" required></textarea>
						</td>
					</tr>
					
					<tr>
						<th style="vertical-align:middle;">파 일</th>
						<td style="vertical-align:middle;">
							<label><input type="file" name="uploadFile" id="uploadFile" class="insertFile" value="파일 첨부"></label>
							<div class="select_img"><img src=""></div>
						</td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" id="submit" onclick="valueSave();" value="등 록">
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
    
 // 사진 첨부 시 아래 영역에 선택한 사진 띄우기
	$("#uploadFile").change(function(){
		if(this.files && this.files[0]) {
			const reader = new FileReader;
			reader.onload = function(data){
				$(".select_img img").attr("src", data.target.result).width(500);
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	$("#btnInsert").click(function(){
		let data = new FormData(document.getElementById("f"));
	
		$.ajax({
			url:"/admin/adminCourseInsertRes.do",
			type:"post",
			processData:false,
			contentType:false,
			data:data,
			success:function(){
				adminNoticeList();
			}
		});
	});
	
	<!-- input에 오늘날짜 기본값으로 넣기 -->
		window.onload = function() {
			today = new Date();
			console.log("today.toISOString() >>>" + today.toISOString());
			today = today.toISOString().slice(0, 10);
			console.log("today >>>> " + today);
			bir = document.getElementById("c_start_date");
			bir.value = today;
		}
		
		function valueSave(){
			const cTime = document.querySelector("#c_time").value;
			const startDate = document.querySelector("#c_start_date").value;
			const lastDate = document.querySelector("#c_last_date").value;
			
			console.log("c_time : " + cTime + ", c_start_date : " + startDate + ", c_last_date : " + lastDate);
		}
</script>
</body>
</html>