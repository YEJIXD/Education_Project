<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=IBM+Plex+Sans+KR:wght@200&family=Nanum+Myeongjo&display=swap" rel="stylesheet">
</head>
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
							<li><a class="header-a" href="teacher.do">강사진</a></li>
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
							<li><a class="header-a" href="faq.do">F A Q</a></li>
							<li><a class="header-a" href="qnaList.do">Q N A</a></li>
						</ul>
					</li>
					<li class="nav-menu"><a class="header-a" href="myRoomMain.do" onclick="service();">My Class</a></li>
				</ul>
			</div>
			
			<!-- Login area -->
			<div class="col-sm-3" align="right" style="padding: 20px 6% 0 0;">
				<c:choose>
					<c:when test="${USER.USER_NAME != null}">
						<c:choose>
						<c:when test="${USER.USER_ROLE == 'U'}">
							<span id="user-name">${USER.USER_NAME}님 반가워요😃</span>&nbsp;&nbsp;&nbsp;
							<span style="color: gray" id="logout-btn" onclick="return logoutCheck();">로그아웃</span>
						</c:when>
						<c:otherwise>
							<span id="user-name">${USER.USER_NAME}님 반가워요😃</span>&nbsp;&nbsp;&nbsp;
							<span style="color: gray" id="logout-btn" onclick="return logoutCheck();">로그아웃</span>&nbsp;|&nbsp;
							<span style="color: gray" id="logout-btn" onclick="location.href='adminMain.do'">admin</span>
						</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise> 
						<span id="login" class="nav-menu" style="color: gray;" onclick="location.href='loginForm.do'">로 그 인</span> &nbsp;|&nbsp;
						<span id="regist" class="nav-menu" style="color: gray;" onclick="location.href='registForm.do'">회원가입</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script type="text/javascript" src=""></script>
	<script type="text/javascript">
		function logoutCheck(){
			alert('로그아웃하시겠습니까?');
			location.href="logout.do";
		}
	</script>
</body>
</html>