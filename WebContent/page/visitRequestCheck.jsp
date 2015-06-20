<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

 
#관리1헤더 {
	font-weight: bold;
	font-size: 36px;
	text-align: left;
	width:100%;

}
#꾸미기설정 {
	font-weight: bold;
	color: #FFF;
	font-size: 24px;
	width: 100%;
}

#회원관리페이지최상단 {
	color: #FFF;
	font-size: 45px;
	font-weight: bold;
	text-align: left;
}

#searchResult #requestForm #resultForm tr th {
	text-align: center;
}
</style>

<link href="/TravelStory/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<style type="text/css">

#searchResult {
	position: absolute;
	left: 16px;
	top: 225px;
	width: 1291px;
	height: 164px;
	z-index: 2;
	color: #FFF;
	display: inherit;
}
tr {
	text-align: left;
	font-weight: bolder;
	font-size: 14px;
	color: #000;
}
th {
	color: #FFF;
	font-size: 16px;
	text-align: left;
}
#apDiv2 {
	position: absolute;
	left: 954px;
	top: 29px;
	width: 140px;
	height: 120px;
	z-index: 3;
}
</style>
<script src="/TravelStory/SpryAssets/SpryMenuBar.js" type="text/javascript"></script><script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
 $(document).ready(function(){
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
                    reader.onload = function (e) { 
                    //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                        $('#check_profile').attr('src', e.target.result);
                        //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                        //(아래 코드에서 읽어들인 dataURL형식)
                    };                    
                    reader.readAsDataURL(input.files[0]);
                    //File내용을 읽어 dataURL형식의 문자열로 저장
                }
            }//readURL()--
    
            //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
            $("#background").change(function(){
                 
                readURL(this);
            });
         }); 

</script>

<!-- 방문신청, 다시 검색 버튼  -->
<script>
$(document).ready(function(){
	  $("#reSearch").click(function(){
	    location.assign("visitRequestAdd.html");
	  });
	  /* $("#request").click(function(){
	    $("#requestForm").submit();
	  });   */
});
</script>


<script type="text/javascript">
	function popUp(checkedData){
		var hoseOwnerCode = encodeURI(checkedData);
		window.open("VisitRequest?checkedCode="+hoseOwnerCode, "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=450, height=500");
	}
	
</script>

</head>

<body>



<div id="searchResult">
<form method='post' action="VisitRequest" id="requestForm">
	<input type='hidden' name='formType' value='visitRequest'/>
	<div id="apDiv2">
  <p><img src="/TravelStory/img/방문신청.png" width="135" height="42" alt="visit request" id="request" onclick="popUp($('.ch:checked').val())"></p>
  <p><img src="/TravelStory/img/다시검색.png" width="136" height="38" alt="re-search" id="reSearch"></p>
</div>
   <p>&nbsp;</p>
	<br>
   <table width="865" height="76" id="resultForm" >
     <tr>
      <th width="37" height="25" align="center" bgcolor="#0066FF" scope="col">선택</th>
      <th width="395" align="center" bgcolor="#0066FF" scope="col">주소</th>
      <th width="228" align="center" bgcolor="#0066FF" scope="col">방문가능 기간</th>
      <th width="96" align="center" bgcolor="#0066FF" scope="col">직업</th>
      <th width="75" align="center" bgcolor="#0066FF" scope="col">결혼유무</th>
    </tr>
    <c:forEach var='houseOwner' items='${requestScope.houseOwnerList}'>
    <tr>
      <td width="37"><input type="radio" class="ch" name="houseOwnerCode" value="${houseOwner.houseOwnerCode}"></td>
      <td width="395">${houseOwner.address}</td>
      <td width="228"><fmt:formatDate value="${houseOwner.visitStartDate.time}" dateStyle="short"/> ~ <fmt:formatDate value="${houseOwner.visitEndDate.time}" dateStyle="short"/></td>
      <td width="96">${houseOwner.job}</td>
      <td width="75">${houseOwner.marriedState}</td>
    </tr>
    </c:forEach>
</table>
</form>
</div>

<div id="apDiv1"></div>
<table id="관리1헤더"width="1667" >
  <tr>
    <th width="1657" height="106" bgcolor="#1E1283" align="left" scope="col"><strong id="회원관리페이지최상단"> 방문 신청</strong></th>
  </tr>
</table>
<p>&nbsp;</p>
<table width="196" height="52">
  <tr>
    <td width="255" height="46" align="center" bgcolor="#3C84F0" id="꾸미기설정">검색 결과</td>
  </tr>
</table>

<br/>
<div id="layer4" style="width: 143px; height: 45px; position: absolute; left: 1066px; top: 55px; z-index: 1;">  

<ul id="MenuBar1" class="MenuBarHorizontal">
  <li><a class="MenuBarItemSubmenu" href="#">${sessionScope.name}</a>
    <ul>
      <li><a href="#">로그아웃</a></li>
      <li><a href="#">회원정보수정</a></li>
      <li><a href="#">쪽지함</a></li>
      <li><a href="mem_mange_category.html">관리</a></li>
      <li><a href="mainBlog.html">홈으로</a></li>
    </ul>
  </li>
   
</ul>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"/TravelStory/SpryAssets/SpryMenuBarDownHover.gif", imgRight:"/TravelStory/SpryAssets/SpryMenuBarRightHover.gif"});
</script>
</div>

</body>
</html>



