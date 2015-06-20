<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방문 관리</title>
<style>

#꾸미기설정 {
	text-align: center;
	font-weight: bold;
	color: #FFF;
	font-size: 24px;
	width: 100%;
}

#title{
	position: absolute;
	left: 15px;
	top: 246px;
	z-index: 3;
}
#accept {
	position: absolute;
	left: 15px;
	top: 346px;
	width: 551px;
	height: 870px;
	z-index: 3;
}
</style>

<style type="text/css">
#ready {
	position: absolute;
	left: 605px;
	top: 345px;
	width: 493px;
	height: 875px;
	z-index: 4;
}
#apDiv2 {
	position: absolute;
	left: 827px;
	top: 342px;
	width: 261px;
	height: 881px;
	z-index: 5;
}
#accept #form1 table tr th {
	color: #FFF;
}
#ready form table tr th {
	color: #FFF;
}
</style>
<script type="text/javascript">
	function popUpRevise(checkedData){
		window.open("EmptyRoomRevisePopUp?formType=reviseEmptyRoom&emptyRoomCode="+checkedData, "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=450, height=500");
	}
	
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#button1").click(function(){
			$("#formType").val("deleteEmptyRoom");
		});
	});
</script>

<script type="text/javascript">
	function popUpAdd(){
		window.open("EmptyRoomAddPopUp.html", "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=450, height=500");
	}
	
</script>

</head>

<body background="../img/background_color.gif">
<%@ include file="/page/header.jsp" %> 

<div id='title'>
<table width="196" height="52">
  <tr>
    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">방문 관리</td>
  </tr>
</table>
</div>

<center>
<div id="accept">
<form method='post' action="VisitRequestManager" id='form1'>
  <table width="550" height="64" border="1">
    <tr>
      <th colspan="4" bgcolor="#0033FF" scope="row">대기 상태 여행객</th>
      </tr>
    <tr>
      <th width="36" bgcolor="#00CCFF" scope="row">선택</th>
      <th width="92" bgcolor="#00CCFF">이름</th>
      <th width="268" bgcolor="#00CCFF">자기소개</th>
      <th width="126" bgcolor="#00CCFF">email</th>
    </tr>
    
    <c:forEach var='visitRequestInfoForOwner' items='${requestScope.visitRequestInfoForOwnerList}'>
    <c:if test="${visitRequestInfoForOwner.requestState eq '대기' || visitRequestInfoForOwner.requestState eq '거절'}">
    <tr>
      <th scope="row"><input type="radio" name='touristCode' value="${visitRequestInfoForOwner.toruistEssentialInfo.touristCode }"></th>
      <td>${visitRequestInfoForOwner.toruistEssentialInfo.name}</td>
      <td>${visitRequestInfoForOwner.toruistEssentialInfo.selfIntroduction}</td>
      <td>${visitRequestInfoForOwner.toruistEssentialInfo.email}</td>
    </tr>
    </c:if>
    </c:forEach>
  </table>
  <input type='hidden' name='formType' value='accept'/>
   <input type="submit" value="수락" />
</form>
</div>

<div id="ready">
<form method="post" action="VisitRequestManager">
	<table width="550" height="64" border="1">
    <tr>
      <th colspan="4" bgcolor="#0033FF" scope="row">수락 여행객</th>
      </tr>
    <tr>
      <th width="36" bgcolor="#00CCFF" scope="row">선택</th>
      <th width="92" bgcolor="#00CCFF">이름</th>
      <th width="268" bgcolor="#00CCFF">자기소개</th>
      <th width="126" bgcolor="#00CCFF">email</th>
    </tr>
    
    <c:forEach var='visitRequestInfoForOwner' items='${requestScope.visitRequestInfoForOwnerList}'>
    <c:if test="${visitRequestInfoForOwner.requestState eq '수락'}">
    <tr>
      <th scope="row"><input type="radio" name='touristCode' value="${visitRequestInfoForOwner.toruistEssentialInfo.touristCode }"></th>
      <td>${visitRequestInfoForOwner.toruistEssentialInfo.name}</td>
      <td>${visitRequestInfoForOwner.toruistEssentialInfo.selfIntroduction}</td>
      <td>${visitRequestInfoForOwner.toruistEssentialInfo.email}</td>
    </tr>
    </c:if>
    </c:forEach>
  </table>
  	<input type='hidden' name=formType value='refuse'/>
    <input type="submit" value="거절" />
</form>
</div>
</center>
</body>
</html>