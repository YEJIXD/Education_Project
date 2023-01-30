<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="resources/css/course/insertForm.css" rel="stylesheet">
<title>myRoom_reviewInsert</title>
</head>
<body>
	<div id="header">
		<%@ include file="../common/header.jsp" %>
	</div>
	
	<div class="review_insert_wrap">
        <div class="regist_wrap">
            <div class="container">
                <a>후 기 등 록</a>
                <hr>
            </div>
            
			<div class="regist_form">
	            <form action="reviewInsert.do" method="post">
	            	<table width="550px">
	                	<tr height="15"></tr>
	                    <tr>
	                        <th>회원명</th>
	                        <td>이양고</td>
	                    </tr>
	                    <tr height="15"></tr>
	                    <tr>
	                        <th>I D</th>
	                        <td>Nyang123</td>
	                    </tr>
	                    <tr>
	                        <th>강의 선택</th>
	                        <td>
	                        	<select>
	                        		<option >1</option>
	                        		<option >2</option>
	                        		<option >3</option>
	                        	</select>
	                        </td>
	                    </tr>
	                    <tr height="15"></tr>
	                    <tr>
	                        <th>내 용</th>
	                        <td>
	                            <textarea class="review_content" name="review_content" id="review_content" required placeholder="후기를 입력하세요"></textarea>
	                        </td>
	                    </tr>
	                </table>
	                <div class="regist_btn">
	                	<input type="submit" class="subBtn" id="submit" value="등 록">
	                    <input type="button" class="antBtn" value="취 소" onclick="location.href='index.do'">
	                </div>
	            </form>
	          </div>
	        </div> 
	    </div>
	<div id="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>