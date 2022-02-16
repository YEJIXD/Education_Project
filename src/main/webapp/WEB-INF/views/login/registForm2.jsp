<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="shortcut icon" href="#">
<title>Receive Certificate</title>
</head>
<style type="text/css">
	th{ width:150px; }

	td{ width:500px; }
	
	h2{ padding-top:30px; }
	
	.inpBtn{ margin:50px 0 5px 300px; }
</style>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>

	<div id="main">
		  <div class="">
		    <h2 align="center">회원가입</h2><hr>
		  </div>
	
		<div class="container">
			<div class="content">
				<form action="" method="GET">
					<table class="table">
						<tr>
							<th>I D</th>
							<td>
								<input type="text" placeholder="아이디를 입력하세요" required>
								<input type="button" class="myBtn" value="중복 확인" onclick="idCheck();"><br>
                            	<span id="id_chk_available">사용가능한 아이디입니다.</span>
                            	<span id="id_chk_unavailable">중복된 아이디입니다.</span>
                            	<span id="id_chk_blank">아이디를 입력하세요.</span>
							</td>
							
						</tr>
						<tr>
							<th>이 름</th>
							<td><input type="text" required></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" required></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" required></td>
						</tr>
						<tr>
							<th>e-mail</th>
							<td><input type="text" required></td>
						</tr>
						<tr>
                       <th style="vertical-align:middle">주소</th>
                       <td>
                           <input type="text" class="user_addr" name="user_addr" id="user_addr" required="required" placeholder="우편번호를 입력하세요." readonly="readonly">
                           <input type="button" class="canBtn" value="주소 검색" onclick="addr_search();"><br>
                           <input type="text" class="user_addr_sub" name="user_addr_sub" id="user_addr_sub" required="required" placeholder="상세주소를 입력하세요." onclick="emailChkConfirm();">
                       </td>
                   </tr>
						<tr>
							<th>휴대전화</th>
							<td><input type="text" required></td>
						</tr>
					</table>
			
					<div class="inpBtn">
						<input type="submit" class="subBtn" value="가 입">
						<input type="button" class="antBtn" onclick="location.href='main.do'" value="취 소">
					</div>
				</form>
			</div>
		</div>
		
		<div id="footer">
			<%@ include file="../common/footer.jsp" %>
		</div>
		
	</div>

</body>
</html>