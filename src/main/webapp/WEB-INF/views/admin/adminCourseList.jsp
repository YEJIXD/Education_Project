<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin_Main</title>
        <link href="resources/css/admin/admin_styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
		</script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-info p-2 text-dark bg-opacity-25 justify-content-between">
            <a class="navbar-brand ps-3" href="index.jsp"><img id="logoPng" src="resources/images/cube.png"></a>
            
            <div>
	            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
	                <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color:black;"><i class="fas fa-user fa-fw" style="color:black;"></i></a>
	                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
	                        <li><a class="dropdown-item" href="logout.do">LogOut</a></li>
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
                                <a href="#" style="text-decoration:none; color: black; text-align: center;">${member.user_name} 님<br>반갑습니다 : )</a>
                            </div>
                            <a class="nav-link home" href="adminMain.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-home" aria-hidden="true"></i></div><span>HOME</span></a>
                            <a class="nav-link notice" href="adminNoticeList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-flag" aria-hidden="true"></i></div><span>Notice</span></a>
                            <a class="nav-link qna" href="adminQnaList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Q n A</span></a>
                            <a class="nav-link faq" href="adminFaqList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-bars" aria-hidden="true"></i></div><span>F A Q</span></a>
                            <a class="nav-link course" href="adminCourseList.do" style="color: #9966FF;"><div class="sb-nav-link-icon"><i class="fa fa-book" aria-hidden="true"></i></div><span>Course</span></a>
                            <a class="nav-link teacher" href="adminTeacherList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></div><span>Teacher</span></a>
                        	<a class="nav-link member" href="adminMemberList.do" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Member</span></a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                	<br>
                    <div class="container-fluid px-4">
                        <h1 class="title_tab">교육 강의 관리</h1>
                        <br><br>
                        <div class="card mb-4">
                            <div class="card-header"><i class="fas fa-table me-1"></i>강좌 목록</div>
                            <div class="card-body">
                            <div>
								<div id="searchMember" style="height: 100px; margin: 0px auto; text-align: center;">
									<form method='get' action='search.do'>
										<select name="searchType">
											<option value="" disabled selected>검색타입</option>
											
											<option value="subject"
												<c:if test="${searchType eq 'subject'}">selected</c:if>>제목
											</option>
											
											<option value="content"
												<c:if test="${searchType eq 'content'}">selected</c:if>>내용
											</option>
										</select> 
										<input type="text" name="keyword" value="${keyword!=null?keyword:''}" /> 
										<input type="submit" value="검색">
									</form>
								</div>
							</div>
                            	<form action="adminCourseInsert.do" method="GET">
	                                <table id="datatablesSimple" class="table table-hover">
	                                    <thead>
	                                        <tr>
	                                            <th class="no">NO</th>
	                                            <th class="title">강의명</th>
	                                            <th class="writer">모집 인원</th>
	                                            <th class="date">등록일</th>
	                                            <th class="term">교육 기간</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
											<c:forEach items="${list}" var="dto">
				                            	<tr>
				                                	<td>${dto.c_no }</td>
				                                    <td style="vertical-align:middle;"><a href="c_detail.do?c_no=${dto.c_no}" style="text-decoration:none; color:rgb(90, 197, 108); font-weight:bold;">${dto.c_name}</a></td>
				                                    <td style="vertical-align:middle;">${dto.ent_personnel }</td>
				                                    <td style="vertical-align:middle;"><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_regdate}"/></td>
				                                    <td style="vertical-align:middle;"><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_start_date }"/> ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${dto.c_last_date }"/></td>
				                            	</tr>
				                        	</c:forEach>
	                                    </tbody>
	                                </table>
	                                <div class="inpBtn">
	                                	<input type="submit" class="adm_insert" id="submit" value="등 록">
		                            	<!-- <button class="adm_delete" onclick="" value="delete">삭 제</button> -->
	                            	</div>
                            	</form>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    </body>
</html>
