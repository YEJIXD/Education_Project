<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/course/appCourse.css">
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<title>course List</title>
<style type="text/css">
	.subBtn{ float:right; }
	table{ width:60%; }
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#pre, .num, #next, #searchBtn").on("click", function(){
		let keyword = $("#keyword").val();
		let searchType = $("#searchType option:selected").val();
		let page = $("#page").val();
		let amount = 10;
		
		let form= $("<form></form>");
		form.attr("name", "SearchForm");
		form.attr("method", "get");
		form.attr("action", "<c:url value='/adminCourseList.do'/>");
		
		form.append($("<input />", {type: "hidden", name: "keyword", value: keyword}));
		form.append($("<input />", {type: "hidden", name: "searchType", value: searchType}));
		form.append($("<input />", {type: "hidden", name: "page", value: page}));
		form.append($("<input />", {type: "hidden", name: "amount", value: amount}));
		form.appendTo("body");
		
		form.submit(); 
	});	

	$(".courseDetail").on("click", function(){
		let keyword = $("#keyword").val();
		let searchType = $("#searchType option:selected").val();
		let page = $("#page").val();
		//let amount = 10;
		let amount = $("#amount").val();
		let c_no = $(this).attr('id');
		
		let form= $("<form></form>");
		form.attr("name", "courseDetail");
		form.attr("method", "get");
		form.attr("action", "<c:url value='/courseDetail.do'/>");
		
		form.append($("<input />", {type: "hidden", name: "keyword", value: keyword}));
		form.append($("<input />", {type: "hidden", name: "searchType", value: searchType}));
		form.append($("<input />", {type: "hidden", name: "page", value: page}));
		form.append($("<input />", {type: "hidden", name: "amount", value: amount}));
		form.append($("<input />", {type: "hidden", name: "c_no", value: c_no}));
		form.appendTo("body");
		
		form.submit(); 
	});
});
      
function searchValidator(searchType, keyword){
	if(keyword == ""){
		alert("검색 내용을 입력하세요");
		$("#keyword").focus();
		return false;
	}
      	return true;
}
</script>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
		
	<div class="container">
		<h3>교육 강의 목록</h3><br><br>
			<div id="searchKeyword" style="height: 60px; margin: 0px auto; text-align: center;">
				<select name="searchType" id="searchType">
					<option value="title" <c:if test="${condition eq 'title'}"> selected</c:if>>제 목</option>
				</select> 
				<input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="검색어를 입력하세요"/> 
				<input type="button" name="searchBtn" id="searchBtn" value="검 색">
				<input type="hidden" name="page" value="${cri.page}">
				<input type="hidden" name="amount" value="${cri.amount}">
				<input type="hidden" name="keyword" value="${dto.keyword }">
			</div>
			<form name="courseList" method="GET">
				<input type="hidden" id="keyword" name="keyword" value='<c:out value="${pageDto.keyword}" />'>
				<input type="hidden" id="page" name="page" value='<c:out value="${cri.page}" />'>
				<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}" />'>
				<input type="hidden" id="user_no" name="user_no" value='<c:out value="${member.user_no}" />'>
				<input type="hidden" id="user_name" name="user_name" value='<c:out value="${member.user_name}" />'>
				<input type="hidden" id="user_email" name="user_email" value='<c:out value="${member.email}" />'>
				<table class="table table-hover">
					<thead>
						<tr>
							<th style="width:50px;">NO</th>
							<th style="width:500px;">제 목</th>
							<th style="width:200px;">신청 / 모집인원</th>
							<th style="width:100px;">상 태</th>
							<th style="width:200px;">교육 기간</th>
						</tr>
					</thead>		
					<tr></tr>
					<tbody>
						<c:choose>
							<c:when test="${empty list}">
								<div class="col-md-12">
									<p class="fontSize" style="text-align:center;">검색 결과가 없습니다.</p>
								</div>
							</c:when>
							
				            <c:otherwise>
								<c:forEach items="${list}" var="cdto">
									<tr>
								    	<td>${cdto.rnum}</td>
								        <td style="vertical-align:middle;"><a href="javascript:;" class="courseDetail" id="${cdto.c_no}">${cdto.c_name}</a></td>
								        <td style="vertical-align:middle;">${cdto.app_personnel}명 / ${cdto.ent_personnel}명</td>
								        <td style="vertical-align:middle;">
								        	<span class="divSpan" id="ing"> 접수중 </span>
								        	<span class="divSpan" id="complete"> 신청완료 </span>
								        	<span class="divSpan" id="finish"> 신청마감 </span>
								        </td>
								        <td style="vertical-align:middle;">${cdto.c_start_date} ~ ${cdto.c_last_date}</td>
								    </tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</form>
			<div class="m-paging">
				<ul>
					<c:if test="true">
						<li>
							<a href='<c:url value="courseList.do?page=${dto.startPage-1 }&keyword=${dto.keyword}"/>' id="pre" class='oiBtn prev'>◀</a>
						</li>
					</c:if>
												
					<c:forEach begin="${dto.startPage}" end="${dto.endPage}" var="page">
						<li>
							<a href='<c:url value="courseList.do?page=${page}&amount=${cri.amount}&keyword=${dto.keyword}"/>' class='num <c:if test="${dto.cri.page eq page}"> active </c:if>'>${page}</a>
						</li>
					</c:forEach>
												
					<c:if test="${dto.next && dto.endPage>0}">
						<li>
							<a href='<c:url value="courseList.do?page=${dto.endPage+1 }&keyword=${dto.keyword}"/>' id="next" class='oiBtn next'>▶</a>
						</li>
					</c:if>
				</ul>
			</div>
	</div>
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>