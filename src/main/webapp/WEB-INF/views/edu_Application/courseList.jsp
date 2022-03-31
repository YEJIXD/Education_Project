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
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
		
	<div class="container">
		<h3>교육 강의 목록</h3><br><br>
			<!-- 게시물 검색 -->
			<div id="searchKeyword" style="height: 60px; margin: 0px auto; text-align: center;">
				<select name="searchType" id="searchType">
					<option value="title" <c:if test="${condition eq 'title'}"> selected</c:if>>제 목</option>
				</select> 

				<input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="검색어를 입력하세요"/> 
				<input type="button" name="searchBtn" id="searchBtn" value="검 색">
									
				<!-- 검색 후 화면에 보여질 게시글 수와 페이지 넘버 (hidden 사용) -->
				<input type="hidden" name="page" value="${cri.page}">
				<input type="hidden" name="amount" value="${cri.amount}">
									
				<!-- keyword를 저장할 수 있는 input 태그 작성 -->
				<input type="hidden" name="keyword" value="${dto.keyword }">
			</div>
			
			<form name="courseList" method="GET">
				<input type="hidden" id="keyword" name="keyword" value='<c:out value="keyword : ${pageDto.keyword}" />'>
				<input type="hidden" id="page" name="page" value='<c:out value="page : ${cri.page}" />'>
				<input type="hidden" id="amount" name="amount" value='<c:out value="amount : ${cri.amount}" />'>
				
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
								        <td style="vertical-align:middle;" id="courseTitle"><a href="courseDetail.do?c_no=${cdto.c_no}&page=${dto.cri.page}&amount=${dto.cri.amount}&keyword=${pageDto.keyword}" style="text-decoration:none; color:#9966FF; font-weight:bold;">${cdto.c_name}</a></td>
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
						
			<!-- paging -->
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
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
			$("#searchBtn").click(function(){
				let keyword = $("#keyword").val();
				let searchType = $("#searchType option:selected").val();
				
				if(!searchValidator(searchType, keyword)){
					return false;
				}
				
				const param = {
					keyword : keyword,
					searchType : searchType
				}
				
				let form= $("<form></form>");
				form.attr("name", "SearchForm");
				form.attr("method", "get");
				form.attr("action", "<c:url value='/courseList.do'/>");
				
				form.append($("<input />", {type: "hidden", name: "keyword", value: keyword}));
				form.append($("<input />", {type: "hidden", name: "searchType", value: searchType}));
				
				form.appendTo("body");
				
				form.submit();
				
			});	
			
			$("#pre, .num, #next").click(function(){
				let keyword = $("#keyword").val();
				let searchType = $("#searchType option:selected").val();
				let page = $(this).text();
				
				const param = {
					keyword : keyword,
					searchType : searchType,
					page : page
				}
				
				let form= $("<form></form>");
				form.attr("name", "SearchForm");
				form.attr("method", "get");
				form.attr("action", "<c:url value='/courseList.do'/>");
				
				form.append($("<input />", {type: "hidden", name: "keyword", value: keyword}));
				form.append($("<input />", {type: "hidden", name: "searchType", value: searchType}));
				form.append($("<input />", {type: "hidden", name: "page", value: page}));

				form.appendTo("body");
				
				form.submit(); 
			});	
			
			$("#courseTitle").on("click", function(){
				let keyword = $("#keyword").val();
				let searchType = $("#searchType option:selected").val();
				let page = $(this).text();
				let amount = $("#amount").text();
				
				const param = {
					keyword : keyword,
					searchType : searchType,
					page : page,
					amount : amount
				}
				
				let form= $("<form></form>");
				form.attr("name", "adminCourseList");
				form.attr("method", "get");
				form.attr("action", "<c:url value='/courseList.do'/>");
				
				form.append($("<input />", {type: "hidden", name: "keyword", value: keyword}));
				form.append($("<input />", {type: "hidden", name: "searchType", value: searchType}));
				form.append($("<input />", {type: "hidden", name: "page", value: page}));
				form.append($("<input />", {type: "hidden", name: "amount", value: amount}));

				form.appendTo("body");
				
				form.submit(); 
			});
        });
        
		function searchValidator(searchType, keyword){
			if(searchType == "" || typeof searchType == "undefined"){
				alert("검색 조건을 선택하세요");
				return false;
			}
			
			if(keyword == ""){
				alert("검색 내용을 입력하세요");
				$("#keyword").focus();
				return false;
			}
        	return true;
		}
	       /* $(document).on('click', '#searchBtn', function(e){
				if(!searchForm.find("option:selected").val()){
					alert("검색 타입을 선택하세요");
					return false;
				}
				
				if(!searchForm.find("input[name='keyword']").val()){
					alert("검색할 내용을 입력하세요");
					return false;
				}
				
				//searchForm.find("input[name='pageNum']").val("1");
				e.preventDefault();
					
				let url = "${pageContext.request.contextPath}/admin/adminCourseList";
				
				url = url + "?searchType=" + $('#searchType').val();
				url = url + "&keyword=" + encodeURIComponent($('#keywordInput').val());
				//url = url + "&keyword=" + $('#keyword').val();
		
				location.href = url;
		
				searchForm.submit();
				
				console.log(url);
			}); */
		</script>
</body>
</html>