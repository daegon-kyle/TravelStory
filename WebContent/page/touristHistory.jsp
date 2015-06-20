<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

 
#관리1헤더 {
	font-weight: bold;
	font-size: 36px;
	width:100%;

}
#꾸미기설정 {
	text-align: center;
	font-weight: bold;
	color: #FFF;
	font-size: 24px;
	width: 100%;
}

#회원관리페이지최상단 {
	color: #FFF;
	font-size: 45px;
	text-align: center;
	font-weight: bold;
}

</style>

<link href="/TravelStory/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<style type="text/css">

#searchResult {
	position: absolute;
	left: 220px;
	top: 225px;
	width: 1291px;
	height: 164px;
	z-index: 2;
	color: #FFF;
	display: inherit;
}
tr {
	text-align: center;
	font-weight: bolder;
	font-size: 10px;
	color: #000;
}
th {
	color: #FFF;
	font-size: 16px;
	text-align: center;
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

</head>

<body background="../img/background_color.gif">

<c:import url="header.jsp"/> 

<div id="searchResult">
<form method='post' action="VisitRequestHistory" id="requestForm">
	<input type='hidden' name='formType' value='visitRequest'/>
	<p>&nbsp;</p>
	<br>
   <table width="865" height="76" border="1">
     <tr>
      <th width="77" height="30" bgcolor="#3399FF" scope="col" >선택</th>
      <th width="170" height="30" bgcolor="#3399FF" scope="col" >주소</th>
      <th width="80" height="30" bgcolor="#3399FF" scope="col" >방문가능 기간</th>
      <th width="80" height="30" bgcolor="#3399FF" scope="col" >직업</th>
      <th width="50" height="30" bgcolor="#3399FF" scope="col" >결혼유무</th>
    </tr>
    <c:forEach var='visitRequestInfoForTourist' items='${requestScope.visitRequestInfoForTouristList}'>
    <tr>
      <td width="395">${visitRequestInfoForTourist.houseOwnerEssentialInfo.address}</th>
      <td width="228"><fmt:formatDate value="${visitRequestInfoForTourist.houseOwnerEssentialInfo.visitStartDate.time}" dateStyle="short"/> ~ <fmt:formatDate value="${visitRequestInfoForTourist.houseOwnerEssentialInfo.visitEndDate.time}" dateStyle="short"/></th>
      <td width="96">${visitRequestInfoForTourist.houseOwnerEssentialInfo.job}</th>
      <td width="75">${visitRequestInfoForTourist.houseOwnerEssentialInfo.marriedState}</th>
    </tr>
    </c:forEach>
</table>

</form>
</div>


<p>&nbsp;</p>
<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 10px; top: 220px; z-index: 1;">
	<table width="196" height="52">
  		<tr>
    		<td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정"> 신청 내역</td>
  		</tr>
	</table>
</div>
<br/>

</body>
</html>

