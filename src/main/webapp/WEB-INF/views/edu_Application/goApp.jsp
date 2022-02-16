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
					<h3 id="beforTitle">💙 교육신청 전 확인사항</h3><br>
					<p>CUBe Academy <b>로그인 후</b>에 교육신청이 가능합니다. <b id="strong"> (회원가입제)</b><br></p>
				</div>
				<br><br>
				
				<div class="beforeApp">
					<h3 id="beforTitle">💜 교육신청 방법</h3><br>
					<p>① 상단 메뉴 '교육 신청' 버튼 클릭 → 전체 교육목록 페이지로 이동<br></p>
							
					<p>② 신청할 교육 제목 클릭 → 해당 과정 상세페이지로 이동<br></p>
						
					<p>③ 교육종류, 과정정보, 교육비 납부 등 안내사항을 반드시 확인<br>
						※ 개인정보수집·이용에 동의 시 신청가능하며, ‘*’표시는 필수 기재 정보<br></p>
						
					<p>④ 하단의 참가신청 버튼 클릭하여 '참가 신청서' 작성<br>※ 안내 미확인 또는 착오로 인한 불이익은 신청자 본인에게 있음<br></p>	
									
					<p>⑤ 작성완료 후 우측 하단에 참가신청 버튼 클릭 시 팝업창이 뜸<br></p>
								
					<p>⑥ '교육담기'클릭 시 신청이 완료됨<br></p>
									
					<p>⑦ 신청이 정상적으로 완료되면 하단의 창이 로드됨<br></p>
								
					<p>⑧ '내 강의실'로 이동 시, 신청한 교육내역 확인 가능<br></p>
				</div>
				<br><br>
				
				<div class="beforeApp">
					<h3 id="beforTitle">💙 교육 대상 및 안내</h3><br>
					<p><b>교육 대상</b> : 만 18세 이상 만 70세 이하<br></p>
					<p><b>교육 수료증 발급</b>은 수강률 85% 이상이어야 가능합니다.<br></p>
					<p>교육 신청은 <b>접수중인 교육만 가능</b>합니다.<br></p>
				</div>				
				<br><br>
							
							
				<div class="beforeApp">
					<h3 id="beforTitle">💜 교육 전 알아두어야 할 사항</h3><br>
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