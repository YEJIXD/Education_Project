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
		<h3 class="formTitle">교 육 등 록</h3><br><br>
		<div class="content">
			<form action="courseInsertRes.do" onsubmit="return check_frm();" method="POST" enctype="multipart/form-data">
				<table class="table insertTable">
					<tr>
						<th>교육명</th>
						<td><input type="text" class="insertTitle" id="insertTitle" title="n" placeholder="제목을 입력하세요" size="80" required></td>
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
							<input type="time" name="c_time" id="c_time" title="n" onclick="titleConfirm();" required>
						</td>
					</tr>
					<tr>
						<th>교육 기간</th>
						<td>
							<input type="date" name="c_start_date" id="c_start_date" title="n" onclick="timeConfirm();" required> ~ <input type="date" id="c_last_date" name="c_last_date" onclick="startDateConfirm();" required>
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
						<th>파 일</th>
						<td style="vertical-align:middle;">
							<label><input type="file" name="uploadFile" id="uploadFile" class="insertFile" value="파일 첨부"></label>
							<div class="select_img"><img src=""></div>
						</td>
					</tr>
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" id="submit" value="등 록">
					<input type="button" class="antBtn" onclick="location.href='courseList.do'" value="취 소">
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
</script>
</body>
</html>