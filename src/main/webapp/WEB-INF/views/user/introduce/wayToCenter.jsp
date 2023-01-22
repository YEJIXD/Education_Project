<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wayToCenter</title>
<style type="text/css">
	#title{
		text-align:center;
		height:100px;
		padding-top:50px;
	}
	
	#map{
		width:600px;
		height:400px;
		padding : 2px 10px 5px 10px;
	}
</style>
</head>
<body>
	<div id="header">
		<%@ include file="../../common/header.jsp" %>
	</div>
	<div id="title">
		<h2>오시는 길</h2>
	</div>
	<div style="height:50px"></div>
	<!-- 지도 -->
	<div id="map" style="width:820px; height:500px; margin:0 auto;"></div>
	<div style="height:50px"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=11b01667022efb1fa1e26c7caf784f11"></script>		
	<script>
		const container = document.getElementById('map');
		const options = {
				center : new kakao.maps.LatLng(37.52955256993816, 126.91816790936167),
				level: 3
		};
		
		const map = new kakao.maps.Map(container,options);
		
		// 마커가 표시될 위치
        const markerPosition  = new kakao.maps.LatLng(37.52955256993816, 126.91816790936167); 
		
        // 마커 생성
        const marker = new kakao.maps.Marker({
            position: markerPosition
        });
 
        // 마커가 지도 위에 표시되도록 설정
        marker.setMap(map);
 
        // 아래 코드는 지도 위의 마커를 제거하는 코드
        // marker.setMap(null);  
        
    </script>
	
	<div id="footer">
		<%@ include file="../../common/footer.jsp" %>
	</div>
</body>
</html>