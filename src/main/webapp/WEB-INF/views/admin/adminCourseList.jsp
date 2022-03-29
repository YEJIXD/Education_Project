<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ page session="false" %>

<%@ page import="com.edu.java.dto.CourseDto"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin_Course_List</title>
        <link href="resources/css/admin/admin_styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-info p-2 text-dark bg-opacity-25 justify-content-between">
            <a class="navbar-brand ps-3" href="index.jsp"><img id="logoPng" src="resources/images/cube.png"></a>
            
            <div>
	            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
	                <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color:black;"><i class="fas fa-user fa-fw" style="color:black;"></i></a>
	                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
	                        <li><a class="dropdown-item" href="logout.do" onclick="logoutCheck();">LogOut</a></li>
	                        <li><a class="dropdown-item" href="main.do">Main</a></li>
	                    </ul>
	                </li>
	            </ul>
            </div>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav bg-info p-2 text-dark bg-opacity-25" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav" style="text-align: center;">
                            <div class="sb-sidenav-menu-heading">
                                <a href=""><img src="resources/images/advisor.png" style="width: 60%; height: 60%;"></a>
                                <br>
                                <a href="#" style="text-decoration:none; color: black; text-align: center;">관리자 님<br>반갑습니다 : )</a>
                            </div>
                            <a class="nav-link home" href="adminMain.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-home" aria-hidden="true"></i></div><span>HOME</span></a>
                            <a class="nav-link notice" href="adminNoticeList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-flag" aria-hidden="true"></i></div><span>Notice</span></a>
                            <a class="nav-link qna" href="adminQnaList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Q n A</span></a>
                            <a class="nav-link faq" href="adminFaqList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-bars" aria-hidden="true"></i></div><span>F A Q</span></a>
                            <a class="nav-link course" href="adminCourseList.do" style="color: #9966FF;"><div class="sb-nav-link-icon"><i class="fa fa-book" aria-hidden="true"></i></div><span>Course</span></a>
                            <a class="nav-link teacher" href="adminTeacherList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></div><span>Teacher</span></a>
                        	<a class="nav-link member" href="adminMemberList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Member</span></a>
                        	<a class="nav-link application" href="adminAppList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-shoe-prints" aria-hidden="true"></i></div><span>Application</span></a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                	<br>
                    <div class="container-fluid px-4 courseList">
                        <h1 class="title_tab">교육 강의 관리</h1>
                        <br><br>
                        <div class="card mb-4">
                            <div class="card-header"><i class="fas fa-table me-1"></i>강좌 목록</div>
                            <div class="card-body">
                            
                            <!-- 게시물 검색 -->
							<div id="searchKeyword" style="height: 60px; margin: 0px auto; text-align: center;">
									<label for="condition"></label>
									<select name="searchType" id="searchType">
										<option value="title" <c:if test="${condition eq 'title'}"> selected</c:if>>제 목</option>
									</select> 
									
									<input type="text" name="keyword" id="keyword" value="${pageDto.keyword}" placeholder="검색어를 입력하세요"/> 
									<input type="button" name="searchBtn" id="searchBtn" value="검 색">
									
									<!-- 검색 후 화면에 보여질 게시글 수와 페이지 넘버 (hidden 사용) -->
									<input type="hidden" name="page" value="1">
									<input type="hidden" name="amount" value="10">
									
									<!-- keyword를 저장할 수 있는 input 태그 작성 -->
									<input type="hidden" name="keyword" value="${pageDto.keyword}">
									
							</div>
                            	<form name="adminCourseList" action="adminCourseInsert.do" method="GET">
	                            	<input type="hidden" id="keyword" name="keyword" value='<c:out value="${pageDto.keyword}" />'>
									<input type="hidden" id="page" name="page" value='<c:out value="${cri.page}" />'>
									<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}" />'>
									
	                                <table id="datatablesSimple" class="table table-hover courseList">
	                                    <thead>
	                                        <tr>
	                                            <th class="no">NO</th>
	                                            <th class="title">강의명</th>
	                                            <th class="writer">신청 / 모집 인원</th>
	                                            <th class="date">등록일</th>
	                                            <th class="term">교육 기간</th>
	                                        </tr>
	                                    </thead>
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
						                                	<td>${cdto.rnum }</td>
						                                    <td style="vertical-align:middle;"><a href="javascript:;" class="courseDetail" id="${cdto.c_no}">${cdto.c_name}</a></td>
						                                    <td style="vertical-align:middle;">${cdto.app_personnel}명 / ${cdto.ent_personnel}명</td>
						                                    <td style="vertical-align:middle;">${cdto.c_regdate}</td>
						                                    <td style="vertical-align:middle;">${cdto.c_start_date} ~ ${cdto.c_last_date}</td>
						                            	</tr>
						                        	</c:forEach>
					                        	</c:otherwise>
				                        	</c:choose>
	                                    </tbody>
	                                </table>
	                                <div class="listBottom">
		                                <div class="inpBtn">
		                                	<input type="submit" class="adm_insert" id="submit" value="등 록">  
		                            	</div>
		                            	
		                            	<div class="coursePaging">
											<!-- paging -->
											<div class="m-paging">
												<ul>
													<c:if test="true">
														<li>
															<a href='<c:url value="adminCourseList.do?page=${dto.startPage-1 }"/>' id="pre" class='oiBtn prev'>◀</a>
														</li>
													</c:if>
													
													<c:forEach begin="${dto.startPage}" end="${dto.endPage}" var="page">
														<li>
															<a href='<c:url value="adminCourseList.do?page=${page}"/>' class='num <c:if test="${dto.cri.page eq page}"> active </c:if>'>${page}</a>
														</li>
													</c:forEach>
													
													<c:if test="${dto.next && dto.endPage>0}">
														<li>
															<a href='<c:url value="adminCourseList.do?page=${dto.endPage+1 }"/>' id="next" class='oiBtn next'>▶</a>
														</li>
													</c:if>
												</ul>
											</div>
										</div>
									</div>
                            	</form>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
			$("#pre, .num, #next, #searchBtn").click(function(){
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
				let amount = 10;
				const c_no = $(this).attr('id');

				let form= $("<form></form>");
				form.attr("name", "courseDetail");
				form.attr("method", "get");
				form.attr("action", "<c:url value='adminCourseDetail.do'/>");
				
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

    </body>
</html>
