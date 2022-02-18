<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/infCourse.css">
<title>teacher</title>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div id="middle">
	<h3>교수진 소개</h3><br><br>
		<table id="content">
			<tr>
				<td id="teaImg"><img src="resources/images/teacher5.png"></td>
				<td id="intro">
					<ul>이 름 : <b>김시사</b></ul>
					<ul>경력 사항: <b>A회사 근무(2020.02 ~ 2020.10)</b></ul>
					<ul>담당 강의: <b>생명존중 활동에 대한 의미와 동기부여</b></ul>
				</td>
			</tr>
			<tr><td height="60"></td></tr>
			<tr>
				<td><img src="resources/images/teacher2.png"></td>
				<td>
					<ul>이 름: <b>박동아</b></ul>
					<ul>경력 사항: <b>B대학 강연(2020.08 ~)</b></ul>
					<ul>담당 강의: <b>위기상황 대처의 다양한 방법에 대한 학습</b></ul>
				</td>
			</tr>
			<tr>
				<td height="60"></td>
			</tr>
			<tr>
				<td><img src="resources/images/teacher3.png"></td>
				<td>
					<ul>이 름: <b>이정글</b></ul>
					<ul>경력 사항: <b>응급의료지도의사(2015.06 ~ 2021.12)</b></ul>
					<ul>담당 강의: <b>응급의료지도의사 양성과정</b></ul>
				</td>
			</tr>
			<tr>
				<td height="60"></td>
			</tr>
			<tr>
				<td><img src="resources/images/teacher4.png"></td>
				<td>
					<ul>이 름: <b>전자신</b></ul>
					<ul>경력 사항: <b>응급 교육 강사활동(2019.04 ~ 2021.10)</b></ul>
					<ul>담당 강의: <b>소아 응급질환과 손상의 이해와 처치</b></ul>
				</td>
			</tr>
			<tr>
				<td height="60"></td>
			</tr>
			<tr>
				<td><img src="resources/images/teacher6.png"></td>
				<td>
					<ul>이 름: <b>조미세</b></ul>
					<ul>경력 사항: <b>공인중개사 경력(2018.01 ~)</b></ul>
					<ul>담당 강의: <b>부동산 마케팅 기획자 실무과정</b></ul>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>	
</body>
</html>