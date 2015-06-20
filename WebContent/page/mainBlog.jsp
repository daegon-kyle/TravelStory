<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/TravelStory/css/mainBlog.css" />
<style type='text/css'>@import url(/TravelStory/css/mainBlog.css);</style>
<style>@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);</style>
<style>@import url(http://fonts.googleapis.com/earlyaccess/kopubbatang.css);</style>

<link href="/TravelStory/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<script src="/TravelStory/SpryAssets/SpryMenuBar.js" type="text/javascript"></script> 
<!-- <script type="text/javascript">
function disp(el) {
    el.children[1].style.display = (el.children[1].style.display=='' ? 'block' : '')
}

function checkKey(el)
{
    if (event.keyCode==13)
        el.click()
}
</script> -->
<script src = "http://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="/TravelStory/css/jquery.treeview.css" />
<link rel="stylesheet" href="/TravelStory/css/screen.css" />
<script src = "http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <script src="/Travel_Story/javascript/mainBlogJS.js" type="text/javascript" charset='utf-8'></script>   --><!-- 주석 -->
<script src="/TravelStory/lib/jquery.js" type="text/javascript"></script>
<script src="/TravelStory/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="/TravelStory/lib/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
        $(function() {
            $("#tree").treeview({
                collapsed: true,
                animated: "medium",
                control:"#sidetreecontrol",
                persist: "location"
            });
        })
        
</script>
    
 <!-- 지도 위젯 스크립트  -->
  <style>
      #map_canvas {
        width: 270px; /* 지도의 가로세로 크기 */ 
        height: 320px;
		background-color: #CCC;
      }
 </style>
 <script src="https://maps.googleapis.com/maps/api/js"></script> <!-- 구글 지도 디스플레이를 위한 코드 다운로드 -->  
<script>
	/*  */
	 function initialize() {
		var map_canvas = document.getElementById('map_canvas'); // 지도가 로딩될 div태그에 대한 참조 
		var map_options = {
		  center: new google.maps.LatLng(37.492243, 126.984648), // center : 어디가 지도의 중심인지 지도api에 알려주는 LatLng 객체 
		  zoom: 6, // zoom : 줌레벨  0~22 사이 
		  mapTypeId: google.maps.MapTypeId.ROADMAP // mapTypeId :  사용할 지도의 타입 (ROADMAP, SATELLITE, HYBRID, or TERRAIN) 
		}
	 	// 마우스 이벤트 
		var map = new google.maps.Map(map_canvas, map_options); // 맵객체 생성자 
		google.maps.event.addListener(map, 'click', function(event) {
			var lat = document.getElementById('latitude');
			var long = document.getElementById('longitude');
			lat.setAttribute('value',event.latLng.lat());
			long.setAttribute('value',event.latLng.lng());
		});
		
		var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';	
		var image1 = new google.maps.MarkerImage('/TravelStory/img/myPic.png',
		// This marker is 32 pixels wide by 37 pixels tall.
		  new google.maps.Size(78, 78),	
		// The origin for this image is 0,0.
		  new google.maps.Point(0,0),
		 // The anchor for this image is the base of the flagpole at 0,37.
		  new google.maps.Point(0, 37));
		
		
		var image2 = new google.maps.MarkerImage('',
		// This marker is 32 pixels wide by 37 pixels tall.
		  new google.maps.Size(78,78),	
		// The origin for this image is 0,0.
		  new google.maps.Point(0,0),
		 // The anchor for this image is the base of the flagpole at 0,37.
		  new google.maps.Point(0, 37));


		var marker1 = new google.maps.Marker({
			 position: new google.maps.LatLng(37.492192, 126.985003),
			map: map,
			icon: image1
		});
		var marker2 = new google.maps.Marker({
			 position: new google.maps.LatLng(37.489161, 126.985324),
			map: map,
			icon: image2
		});
	 }
	 google.maps.event.addDomListener(window, 'load', initialize); // initialize함수가 실행되기전 html요소가 페이지에 로딩될때 까지 기다리는 역할을 하는 함수 
	</script>

<style>
	body{
		background-color: ${requestScope.blogInfo["bg"][0]};
		font-family: '${resuestScop.blogInfo["font"][0]}';
	}
	body{
		
	}
	#rr{
		
	}
	</style>
</head>


<body background="../img/background_color.gif">


<div id="bannerDiv"><img src="/TravelStory/img/배너.PNG" width="1250" height="120" alt="banner" /></div>
<div id="profileDiv"><img src="/TravelStory/img/default_profile.png" alt="profile_photo" width="135" height="150" /></div>
<div id="profileMenu">
  <form id="form1" name="form1" method="post" action="">
    <label for="select"></label>
    <ul id="MenuBar1" class="MenuBarHorizontal">
      <li><a class="MenuBarItemSubmenu" href="#">${sessionScope.name}님</a>
        <ul>
          <li><a href="logout">로그아웃</a></li>
          <li><a href="revise">회원정보수정</a></li>
          <li><a href="letter">쪽지함</a></li>
          <li><a href="mem_mange_customizing.jsp">관리</a></li>
          <li><a href="mainBlog.jsp">홈으로</a></li>
        </ul>
      </li>
    </ul>
  </form>
</div>

<div id="nameDiv">${sessionScope.name}
  <hr align="center" />
</div>

<div id="profileSearch">	<!-- 자기 블로그 내부에서 키워드 검색 -->
  <form id="form2" name="form2" method="post" action="selfSearchPostingInBlog">
    <input type="text" size="7" id="keyword" name="keyword" />
    <input type="submit"  value="검색" />
  </form>
</div>

<div id="adminDiv">
	<a href="mem_mange_customizing.jsp"><img src="/TravelStory/img/관리.png" width="65" height="35"/></a>
	<a href="mem_mange_posting_fake.jsp"><img src="/TravelStory/img/글쓰기.png" width="65" height="35"/></a>
</div>

<div id="searchDiv">	<!--  전체 블로그에서 키워드 검색 -->
  <form id="form5" name="form5" method="post" action="totalSearchPosting">
    <input type="text" id="totalKeyword" name="totalKeyword" size="15" />
    <input type="submit" value="검색" />
  </form>
</div>

<div id="sidetree">
 <div class="treeheader">&nbsp;</div>

    <div id="sidetreecontrol"><a href="?#">전체 닫기</a> | <a href="?#">전체 열기</a></div>
    <ul id="tree">
    	<li><a href='#'>전체보기</a></li>
        <li>
            <a href='#'>좋은</a>
            <ul>
                <li><a href="#">카페, 그곳</a></li>
                <li><a href="#">밥 먹는, 그곳</a></li>
                <li><a href="#">Take-Out dessert</a></li>
            </ul>
        </li>
        <li>
            <a href='#'>뚜벅과 터벅사이</a>
            <ul>
                <li><a href="#">뚜벅</a></li>
                <li><a href="#">터벅</a></li>
            </ul>
        </li>
    </ul>
</div>


<div id="widget" style=" border-color: #3CF; text-align: center; font-weight: bold; font-size: 15px;">
<c:import url="aco.jsp"/>
<a href="visitRequestAdd.jsp">방문신청</a>

</div>
<!--  지도 위젯 -->
<div id="mapWidget" style="border:2px dashed; border-color:#3CF;">
<div id="map_canvas"></div>
<br />
<form method="post" action="TourPreparation">
  <center>
  <input type='text' id='latitude' name='latitude' value='위도' /> <input type="text" id='longitude' name='longitude' value="경도"/> <br /> 
  <input type="file" name="button5" id="button5" value="사진업로드" /> <input type='submit' value='저장'/>
  </center>
</form>
</div>


<strong id="회원관리페이지최상단2"><span style="width: 103px; height: 84px; position: absolute; left: 11px; top: 21px; z-index: 1;"></span></strong>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"/TravelStory/SpryAssets/SpryMenuBarDownHover.gif", imgRight:"/TravelStory/SpryAssets/SpryMenuBarRightHover.gif"});
</script>

</body>
</html>
