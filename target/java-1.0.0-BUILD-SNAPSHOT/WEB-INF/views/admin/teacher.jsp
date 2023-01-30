<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin_Teacher</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="resources/css/admin/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
	    	// 전체 선택 및 선택 게시물 삭제
		    $(function(){
		    	var chkObj = document.getElementsByName("RowCheck[]");
		    	var rowCnt = chkObj.length;
		    	
		    	$("input[name='allCheck']").click(function(){
		    		var chk_listArr = $("input[name='RowCheck[]']");
		    		for(var i = 0 ; i<chk_listArr.length; i++){
		    			chk_listArr[i].checked = this.checked;
		    		}
		    	});
		    	$("input[name='RowCheck[]']").click(function(){
		    		if($("input[name='RowCheck[]']:checked").length == rowCnt){
		    			$("input[name='allCheck']")[0].checked = true;
		    		}else{
		    			$("input[name='allCheck']")[0].checked = false;
		    		}
		    	});
		    });
	     
	     //수 정
	     function goUpdate(){
	    	 if(confirm('선택하신 강사 정보를 수정하시겠습니까?')==true){
	    		 return true;
	    	 }else{
	    		 return false;
	    	 }
	     }
	     
		  //삭 제
			function delete_frm(){
	    	 if(confirm('선택하신 강사 정보를 삭제하시겠습니까?')==true){
	    		 return true;
	    	 }else{
	    		 return false;
	    	 }
	     }
		  
		  // 로그아웃 체크
		  function logoutCheck(){
		 	alert('로그아웃하시겠습니까?');
		 	location.href="logout";
		 }
        </script>
    </head>
    <style type="text/css">
	table{ border-bottom:none; }
</style>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-info p-2 text-dark bg-opacity-25 justify-content-between">
    	<a class="navbar-brand ps-3" href="index.jsp"><img id="logoPng" src="../resources/images/cube.png"></a>
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
                        <a class="nav-link home" href="/admin/main" style="color: black;"><i class="fa fa-home" aria-hidden="true"></i><span>HOME</span></a>
                        <a class="nav-link notice" href="/admin/notice" style="color: #9966FF;"><div class="sb-nav-link-icon"><i class="fa fa-flag" aria-hidden="true"></i></div><span>Notice</span></a>
                        <a class="nav-link qna" href="/admin/qna" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Q n A</span></a>
                        <a class="nav-link faq" href="/admin/faq" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-bars" aria-hidden="true"></i></div><span>F A Q</span></a>
                        <a class="nav-link course" href="/admin/course" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-book" aria-hidden="true"></i></div><span>Course</span></a>
                        <a class="nav-link teacher" href="/admin/teacher" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></div><span>Teacher</span></a>
                        <a class="nav-link member" href="/admin/member" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-user" aria-hidden="true"></i></div><span>Member</span></a>
                        <a class="nav-link application" href="/admin/application" style="color: black;"><div class="sb-nav-link-icon"><i class="fa fa-shoe-prints" aria-hidden="true"></i></div><span>Application</span></a>
					</div>
				</div>
			</nav>
		</div>
		
        <div id="layoutSidenav_content">
        	<main>
            <br>
            	<div class="container-fluid px-4">
            		<h1 class="title_tab">강사 관리</h1>
                	<br><br>
                	<div class="card mb-4">
                    	<div class="card-header"><i class="fas fa-table me-1"></i>강사진 리스트</div>
                        <div class="card-body">
                        <form action="" method="">
                        	<table id="datatablesSimple" class="table table:hover">
                            	<col width="50px"><col width="200px">
                                <thead>
                                	<tr>
                                		<th class="chkBtn"><input type="checkbox" name="allCheck" value="selectall" onclick="selectAll(this)"></th>                                            
                                        <th>이미지</th>
                                        <th class="writer">강사명</th>
                                        <th class="title">강의명</th>
                                        <th class="date">등록일</th>
									</tr>
                                </thead>
                                <tbody>
									<c:forEach items="${teacherList}" var="dto">
			                        	<tr>
			                            	<td style='vertical-align:middle;' ><input type="checkbox" name="RowCheck[]" value="${dto.t_no}"></td>
			                                <td style='vertical-align:middle;'><a onclick="return goUpdate();" href="adminTeacherUpdate?t_no=${dto.t_no}" style="text-decoration:none; cursor:pointer; font-weight:bold;">${dto.t_name}</a></td>
			                                <td><a href="adminTeacherUpdate?p_id=${dto.t_no}"><img src="${dto.t_img}" style="width: 20%; height: 20%;"></a></td>
			                                <td>${dto.t_course }</td>
			                                <td>${dto.t_regdate }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form> 
						
                        <div class="inpBtn">
                        	<input type="submit" class="adm_insert" value="등 록">
                            <button class="adm_delete" onsubmit="return delete_frm();" value="delete">삭 제</button>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="resources/admin/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="resources/admin/js/datatables-simple-demo.js"></script>
    </body>
</html>
