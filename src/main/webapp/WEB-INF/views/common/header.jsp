<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUBe Academy</title>
<link href="resources/css/common/header.css" rel="stylesheet">
<link href="resources/css/common/footer.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="resources/css/login/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Cute+Font&family=IBM+Plex+Sans+KR:wght@200&family=Nanum+Myeongjo&display=swap"
	rel="stylesheet">
</head>
<style type="text/css">
body {
	font-family:'Gowun Dodum', sans-serif;
	color: #2e363e;
	min-width: 1400px;
	height: auto;
	margin: 0px;
}
.header {
	height: 155px;
	background-color: rgb(248, 249, 250);
	border-bottom: 1px rgb(232, 229, 229) solid;
}
.top-header {
	height: 75px;
	padding-top: 10px;
}
.bottom-header {
	height: 45px;
}
.img-div {
	padding-top: 10px;
}
#logo {
	width: 7%;
	height: 7%;
	margin-left:0%;
}
.header-ul {
	margin-left: 120px;
	padding: 0px;
	height: 100%;
	list-style: none;
	font-size: larger;
	padding-top: 15px;
}
.header-ul .nav-menu {
	float: left;
}
.nav-menu {
	width: 11%;
	height: 100%;
	padding-left: 1%;
}
.nav-menu ul {
	list-style: none;
	height: 100%;
}
.sub-menu li {
	padding: 10px 0 0 10px;
	width: 100px;
	height: 40px;
	clear: left;
	background-color: rgb(250, 251, 252);
}
.header-a {
	text-decoration: none;
	color: gray;
}
.sub-menu {
	padding: 0px;
}
.nav-list>.header-ul>.nav-menu>.sub-menu {
	display: none;
}
.nav-list>.header-ul>.nav-menu:hover>.sub-menu {
	display: block;
}
#login:hover {
	cursor: pointer;
}
#modal_close_btn:hover, #logout-btn:hover {
	cursor: pointer;
}
#user-name {
	letter-spacing: 1px;
}
.banner-text {
	text-decoration: none;
	color: black;
	font-size: small;
	padding-top: 5px;
}
.header-a, .banner-text, #login, #logout-btn {
	font-family: 'Gowun Dodum', sans-serif;;
	font-family: 'Gowun Dodum', sans-serif;;
	font-family: 'Gowun Dodum', sans-serif;;
}
</style>
<script type="text/javascript">
    function loginModalIn() {
		$(".login_wrap1").fadeIn();
    }
    function loginModalOut() {
		$(".login_wrap1").fadeOut();
    }
</script>
<body style="margin-top: 155px; min-width:1400px;">
	<!-- 상단 이벤트 게시 -->
	<div class="container-fluid header" style="position: fixed; top: 0; right: 0; left: 0; z-index: 1;">
		<div class="row top-banner" align="center" style="background-color:#B0E0E6; height: 32px">
			<a href="/main.do" class="banner-text"> CUBe Academy에 오신 걸 환영합니다 : )</a>
		</div>
		
		<!-- Navibar Logo -->
		<div class="row top-header">
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
				<div class="img-div">
					<a href="main.do"> <img id="logo" src="resources/images/cube.png" style="z-index: 1;"></a>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
		
		<!-- Navibar Menu -->
		<div class="row bottom-header">
			<div class="col-sm-1"></div>
			<div class="col-sm-8 nav-list">
				<ul class="header-ul">
					<li class="nav-menu"><a class="header-a" href="greeting.do">교육 소개</a>
						<ul class="sub-menu">
							<li><a class="header-a" href="greeting.do">인사말</a></li>
							<li><a class="header-a" href="teacher.do">교수진</a></li>
							<li><a class="header-a" href="wayToCenter.do">오시는 길</a></li>
						</ul>
					</li>
						
					<li class="nav-menu"><a class="header-a" href="goal.do">교육 목표</a></li>
					
					<li class="nav-menu"><a class="header-a" href="goApp.do">교육 신청</a>
						<ul class="sub-menu">
							<li><a class="header-a" href="courseInsert.do">교육 등록</a></li>
						</ul>
					</li>
					
					<li class="nav-menu"><a class="header-a" href="notice.do">Community</a>
						<ul class="sub-menu">
							<li><a class="header-a" href="notice.do">공지사항</a></li>
							<li><a class="header-a" href="faq.do">FAQ</a></li>
							<li><a class="header-a" href="qnaList.do">QNA</a></li>
						</ul>
					</li>
					<li class="nav-menu"><a class="header-a" href="myRoomMain.do">My Class</a></li>
				</ul>
			</div>
			
			<!-- Login area -->
			<div class="col-sm-3" align="right" style="padding: 20px 6% 0 0;">
				<c:choose>
					<c:when test="${user != null}">
						<span id="user-name">${user.user_name}님 반가워요😃</span>&nbsp;&nbsp;&nbsp;
						<span style="color: gray" id="logout-btn"
							onclick="location.href='logout.do'">로그아웃</span>
					</c:when>
					<c:otherwise>
						<span id="login" style="color: gray;" onclick="loginModalIn()">로그인</span>
					</c:otherwise>
				</c:choose>
				
				<!-- Login 창 -->
				<div class="login_wrap1" style="z-index: -1;">
					<div class="login_wrap">
						<div class="login">
							<div class="login_modal_close">
								<a id="modal_close_btn" onclick="loginModalOut()">X</a>
							</div>
							<form action="loginCheck.do" method="post" class="login_form">
								<div class="logo">
									<img src="resources/images/locker.png" width="70" height="70">
								</div>
								<div class="login_id">
									<span>ID</span><br> <input type="text" name="user_id" id="user_id">
								</div>
								<div class="login_pw">
									<span>Password</span><br> <input type="password" name="user_pw" id="user_pw">
								</div>
								<div class="login_btn">
									<input type="submit" id="submitBtn" value="L O G I N">
								</div>
								<div class="login_regist" align="center">
									<br> <a href="registForm.do" style="text-decoration:none; color:#4169E1;">회 원 가 입</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${msg == 'fail' }">
		<script type="text/javascript">
			alert('로그인 실패');
		</script>
	</c:if>
</body>
</html>