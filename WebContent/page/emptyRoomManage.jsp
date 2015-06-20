<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>공실관리</title>

<style type="text/css">
#꾸미기설정 {
	text-align: center;
	font-weight: bold;
	color: #FFF;
	font-size: 24px;
	width: 100%;
}
 
#emptyList {
	position: absolute;
	left: 15px;
	top: 346px;
	width: 1060px;
	height: 1165px;
	z-index: 3;
}
#menu {
	position: absolute;
	left: 800px;
	top: 0px;
	width:400px;
	height: 222px;
	z-index: 2;
}

</style>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>


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
		window.open("EmptyRoomAddPopUp.jsp", "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=450, height=500");
	}
	
</script>

</head>

<body background="../img/background_color.gif">
 
<%@ include file="/page/header.jsp" %>
<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 11px; top: 220px; z-index: 1;">
	<p>&nbsp;</p>
	<table width="196" height="52" style="margin-top:0px; margin-left:10px;">
  		<tr>
    		<td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">공실 관리</td>
  		</tr>
	</table>
</div>
 

<br/> 


<center>
<div id="emptyList">
<form method='post' action="EmptyRoomInfoManager" id='form1'>
<div id="menu"><img src="/TravelStory/img/공실추가.png" name="roomAdd" width="270" height="75" id="roomAdd" onclick="popUpAdd()">
  <input type='image' src="/TravelStory/img/공실삭제.png" name="formType" value='deleteEmptyRoom'width="270" height="75"  id='button1' ><!-- alt="Submit Form" -->
  <img src="/TravelStory/img/공실정보 수정.png" name="formType" width="270" height="75"  id='button2' onclick="popUpRevise($('.ch:checked').val())"></div>
  <table border="1">
  		<tr>
  			<th width="77" height="30" bgcolor="#3399FF" scope="col" >선택</th>
  			<th width="168" height="30" bgcolor="#3399FF" scope="col" >공실이름</th>
  			<th width="170" height="30" bgcolor="#3399FF" scope="col" >기존가격</th>
  			<th width="170" height="30" bgcolor="#3399FF" scope="col" >할인가격</th>
  		</tr>
  	<c:forEach var="emptyRoomInfo" items="${requestScope.emptyRoomInfoList }">
  		<tr>
  			<td ><input type='radio' class='ch' name='emptyRoomCode' value="${emptyRoomInfo.emptyRoomCode }"></td>
  			<td width='100'>${ emptyRoomInfo.emptyRoomName}</td>
  			<td width='100'>${ emptyRoomInfo.oldPrice}</td>
  			<td width='100'>${ emptyRoomInfo.discountPrice}</td>
  		</tr>
  	</c:forEach>
   
  </table>
  <input type="hidden" name='formType' id="formType">
  
<!--   
  <div id="menu"><img src="공실추가.png" name="roomAdd" width="270" height="75" id="roomAdd">
  <img src="공실삭제.png" name="roomDelete" width="270" height="75" id="roomDelete">
  <img src="공실정보 수정.png" name="roomRevise" width="270" height="75" id="roomRevise"></div> -->
 </form>
</div>

</center>
</body>
</html>