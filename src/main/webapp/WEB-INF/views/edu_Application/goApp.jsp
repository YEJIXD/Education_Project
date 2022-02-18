<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<title>go_App</title>
<style type="text/css">
	table{
		width:30%;
		text-align:left;
	}
	
	.content{
		width: 100%;
		margin-left:10%;
		margin-right:10%;
	}
	
	.subBtn{ margin-left:22%; }

</style>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="container">
		<form  action="courseList.do" method="GET">
			<div class="content">
				<div class="beforeApp">
					<h3 id="beforeTitle">💙 교육신청 전 확인사항</h3><br>
					<p>CUBe Academy <b>로그인 후</b>에 교육신청이 가능합니다. <b id="strong"> (회원가입제)</b><br></p>
				</div>
				<br><br>
				
				<div class="beforeApp">
					<h3 id="beforeTitle">💜 교육신청 방법</h3><br>
					
					<p class="stepText">① 상단 메뉴 '교육 신청' 버튼 클릭 → 🚩 안내 사항 숙지 🚩</p>
					<p class="stepImg"><img src="resources/images/appStep/step1.png"></p><br>
					<hr>
					
					<p class="stepText">② 하단의 '교육 보러가기' 클릭 → 교육 강의 목록으로 이동</p>
					<p class="stepImg"><img src="resources/images/appStep/step2.PNG"></p><br>
					<hr>	
					
					<p class="stepText">③ 원하는 강의 클릭 → 교육 상세보기 목록으로 이동<br><br>※ 접수 상태 확인 후 <b style="color:blue;">"접 수 중"</b>인 강의를 신청해주세요 : )</p>
					<p class="stepImg"><img src="resources/images/appStep/step3.PNG"></p><br>
					<p class="stepText">★ 강의 모집인원이 다 차면 접수가 마감될 수 있습니다.<br>
					<hr>
					
					<p class="stepText">④ 교육 상세보기에서 교육 종류, 과정 정보, 교육비 등 안내사항을 반드시 확인<br>※ 안내 미확인 또는 착오로 인한 불이익은 신청자 본인에게 있음<br></p>	
					<p class="stepText">★ 강의 정보 확인 후, 하단의 신청 버튼 클릭 → 신청 완료<br>
					<p class="stepImg"><img src="resources/images/appStep/step4.PNG" style="height:600px;"></p><br>
					<hr>
									
					<p class="stepText">⑤ 신청 완료 창이 뜨면서 신청 정보 확인 → 확인 버튼 클릭 시, 내 강의실의 수강내역으로 이동<br></p>
					<p class="stepImg"><img src="resources/images/appStep/step5.PNG"></p><br>
					<hr>
								
					<p class="stepText">⑥ My Class에서 신청 내역 확인<br></p>
					<p class="stepImg"><img src="resources/images/appStep/step6.PNG"></p><br>
					<hr>
					
					<p class="stepText">* 수강 신청 취소를 원할 시, 수강 취소 아래의 취소 버튼 클릭 <br>→ '수강 신청을 취소하시겠습니까?' 알림창에서 '확인'버튼을 누르면 취소 완료<br><br>※ 안내 미확인 또는 본인 실수로 인한 불이익은 신청자 본인에게 있음<br></p>
					<p class="stepImg"><img src="resources/images/appStep/step7.PNG"></p><br>
					<hr>
									
				</div>
				<br><br>
				
				<div class="beforeApp">
					<h3 id="beforeTitle">💙 교육 대상 및 안내</h3><br>
					<p><b>교육 대상</b> : 만 18세 이상 만 70세 이하<br></p>
					<p><b>교육 수료증 발급</b>은 수강률 85% 이상이어야 가능합니다.<br></p>
					<p>교육 신청은 <b>접수중인 교육만 가능</b>합니다.<br></p>
				</div>				
				<br><br>
							
							
				<div class="beforeApp">
					<h3 id="beforeTitle">💜 교육 전 알아두어야 할 사항</h3><br>
					<p>중간에 포기하실 경우, 해당 수업 종료일로부터 1분기 간 다른 교육을 들으실 수 없습니다.<br><br></p>
				</div>		
	
				<input type="submit" class="subBtn" value="교육 보러가기">
			</div>
		</form>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>	
</body>
</html>