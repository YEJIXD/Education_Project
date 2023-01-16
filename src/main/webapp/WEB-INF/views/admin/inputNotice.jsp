<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>Notice Insert</title>
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
		<h3>공지사항 등록</h3><br><br>
		<div class="content">
			<form action="adminNoticeInsertRes.do" method="POST" enctype="multipart/form-data">
				<table class="table insertTable">
					<tr>
						<th>제 목</th>
						<td><input type="text" class="insertTitle" id="title" placeholder="제목을 입력하세요" size="80" required></td>
					</tr>
					<tr>
						<th>내 용</th>
					</tr>
					<tr>
						<th></th>
						<td style="padding-bottom:50px;">
							<textarea class="insertContent" id="noti_content" placeholder="내용을 입력하세요" required></textarea>
						</td>
					</tr>
					<tr>
						<th>파 일</th>
					</tr>
					<tr>
						<th></th>
						<td class="file_input" style="vertical-align:middle;">
							<input type="file" class="insertFile" id="uploadFile" value="파일 첨부"><br><br>
							<div class="file_input">
	    	      				<div class="select_img"><img src=""></div><br><br>
	          				</div>
						</td>
					</tr>
				
				</table>
				
				<div class="inpBtn">
					<input type="submit" class="subBtn" id="btnInsert" value="등 록">
					<input type="button" class="antBtn" onclick="location.href='adminNoticeList.do'" value="취 소">
				</div>
				
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function check_frm(){
		if(confirm('작성하신 게시글을 등록하시겠습니까?')==true){
			return true;
		}else{
			return false;
		}
	}
	
	// 사진 첨부 시 아래 영역에 선택한 사진 띄우기
	$("#uploadFile").change(function(){
		if(this.files && this.files[0]) {
			const reader = new FileReader;
			reader.onload = function(data){
				$(".select_img img").attr("src", data.target.result).width(300);
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	$("#btnInsert").click(function(){
		let data = new FormData(document.getElementById("f"));
	
		$.ajax({
			url:"/admin/adminNoticeInsertRes.do",
			type:"post",
			processData:false,
			contentType:false,
			data:data,
			success:function(){
				adminNoticeList();
			}
		});
	});
</script>
</body>
</html>