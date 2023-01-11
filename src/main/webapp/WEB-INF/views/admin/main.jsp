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
	<link href="https://cdn.jsdelivr.net/npm/simple-latestdatatables@/dist/style.css" rel="stylesheet" />
	<link href="resources/css/admin/admin_styles.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-info p-2 text-dark bg-opacity-25 justify-content-between">
    	<a class="navbar-brand ps-3" href="main"><img id="logoPng" src="resources/images/cube.png"></a>
        
        <div>
	    	<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
	        	<li class="nav-item dropdown">
	            	<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color:black;"><i class="fas fa-user fa-fw" style="color:black;"></i></a>
	                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
	                	<li><a class="dropdown-item" href="logout" onclick="logoutCheck();">LogOut</a></li>
	                	<li><a class="dropdown-item" href="main">Main</a></li>
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
                        <a class="nav-link home" href="adminMain" style="color: #9966FF"><div class="sb-nav-link-icon"><i class="fa fa-home" aria-hidden="true"></i></div><span>HOME</span></a>
                        <a class="nav-link notice" href="adminNoticeList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-flag" aria-hidden="true"></i></div><span>Notice</span></a>
                        <a class="nav-link qna" href="adminQnaList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Q n A</span></a>
                        <a class="nav-link faq" href="adminFaqList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-bars" aria-hidden="true"></i></div><span>F A Q</span></a>
                        <a class="nav-link course" href="adminCourseList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-book" aria-hidden="true"></i></div><span>Course</span></a>
                        <a class="nav-link teacher" href="adminTeacherList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></div><span>Teacher</span></a>
                        <a class="nav-link member" href="adminMemberList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Member</span></a>
                        <a class="nav-link application" href="adminAppList" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-shoe-prints" aria-hidden="true"></i></div><span>Application</span></a>
					</div>
				</div>
			</nav>
		</div>
        <div id="layoutSidenav_content">
        	<main>
            <br>
                <div class="container-fluid px-4">
            	<h1 class="mt-4">HOME</h1>
                <br><br>
					<div class="row">
                    	<div class="col-xl-3 col-md-6">
                        	<div class="card bg-primary text-white mb-4">
                            	<div class="card-body">새 게시물</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                		<a class="small text-white stretched-link" href="adminPostBlog" style="text-decoration:none;">${newBlogCount} 건 / ${blogCount} 건</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
						<div class="col-xl-3 col-md-6">
                        	<div class="card bg-warning text-white mb-4">
                            	<div class="card-body">수강 취소</div>
                                	<div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="adminOrder" style="text-decoration:none;">${newAdminOrderCount} 건 / ${adminOrderCount} 건</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                            </div>
						</div>
                        
                        <div class="col-xl-3 col-md-6">
                        	<div class="card bg-success text-white mb-4">
                            	<div class="card-body">회원 수</div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                	<a class="small text-white stretched-link" href="adminUser" style="text-decoration:none;">${newUserCount} 명 / ${userCount} 명</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
								</div>
							</div>
						</div>
                        <div class="col-xl-3 col-md-6">
                        	<div class="card bg-danger text-white mb-4">
                            	<div class="card-body">Q & A</div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                	<a class="small text-white stretched-link" href="adminReport" style="text-decoration:none;">${newReportCount} 건 / ${reportCount} 건</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
								</div>
							</div>
						</div>
					</div>
					<br><br>
                   
				</div>    
			</main>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="resources/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function logoutCheck(){
		alert('로그아웃하시겠습니까?');
		location.href="logout";
	}
</script>
</body>
</html>
