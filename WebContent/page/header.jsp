<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<style>
 			#관리1헤더 
 			{
				font-weight: bold;
				font-size: 36px;
				width:100%;
			}
			#회원관리페이지최상단 
			{
				color: #FFF;
				font-size: 45px;
				text-align: center;
				font-weight: bold;
			}
			.회원관리페이지상단 
			{
				font-size: 20px;
				color: #FFF;
			}
			
			.topmenu
			{
				text-decoration:none;
				color:white;
			}
		</style>
		 
	<link href="/TravelStory/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<script src="/TravelStory/SpryAssets/SpryMenuBar.js" type="text/javascript"></script> 
	
		<table id="관리1헤더" width="1667" >
  <tr>
    <th width="1657" height="106" bgcolor="#1E1283" align="left" scope="col"><strong id="회원관리페이지최상단"> &nbsp;회원 관리페이지</strong><strong id="회원관리페이지최상단2"></strong></th>
  </tr>
  <tr>
    <th height="70" bgcolor="#0F57C4" class="회원관리페이지상단" scope="col"><a class="topmenu" href="mem_mange_category_fake.jsp">카테고리 관리</a> | <a class="topmenu" href="mem_mange_customizing.jsp">꾸미기 설정</a> | <a class="topmenu" href="mem_mange_posting_fake.jsp">포스팅 관리</a> | <a class="topmenu" href="VisitRequestHistory">방문신청확인</a> | <a class="topmenu" href='EmptyRoomInfoManager'>공실 관리</a> | <a class="topmenu" href="VisitRequestManager">방문 관리</a> | <a class="topmenu" href="hotelRegistration">숙박업체 관리</a> | <a class="topmenu" href="houseRegistration">집정보 관리</a></th>
  </tr>
</table>
<div id="layer3" style="width: 143px; height: 45px; margin:	30px auto; position:relative; left: 450px; top: -210px; z-index: 1;">  
<img src="../img/default_profile.png" width="96" height="91" />
</div>
<div id="layer4" style="width: 143px; height: 45px; margin:	30px auto; position:relative; left: 550px; top: -250px; z-index: 1;">  


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
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"/TravelStory/SpryAssets/SpryMenuBarDownHover.gif", imgRight:"/TravelStory/SpryAssets/SpryMenuBarRightHover.gif"});
</script>
</div> 