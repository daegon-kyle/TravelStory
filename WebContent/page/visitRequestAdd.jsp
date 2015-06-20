<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- <link rel="stylesheet" href="/TravelStory/css/ownerSearch.css" /> --> 
<style type='text/css'>@import url(/TravelStory/css/ownerSearch.css);</style>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/redmond/jquery-ui.css" />
<script type="text/javascript">
	$(function(){
		// startDate를 오늘 날짜로 자동 세팅 but 그러면 endDate가 막히지 않는다.
		$('#start').val($.datepicker.formatDate($.datepicker.ATOM, new Date()));
		$( "#start" ).datepicker({ 
		inline: true, 
		dateFormat: "yy-mm-dd",    /* 날짜 포맷 */ 
		prevText: 'prev', 
		nextText: 'next',  
		showOtherMonths: true,    /* 이전/다음 달 일수 보이기 */ 
		selectOtherMonths: true,    /* 이전/다음 달 일 선택하기 */ 
		minDate: '-30y', 
		closeText: '닫기', 
		currentText: '오늘', 
		showMonthAfterYear: true,        /* 년과 달의 위치 바꾸기 */ 
		/* 한글화 */ 
		monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
		monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
		dayNames : ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort : ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin : ['일', '월', '화', '수', '목', '금', '토'],
		/* 날짜 유효성 체크 */ 
		onClose: function( selectedDate ) { 
			$('#end').datepicker("option","minDate", selectedDate); 
		} 
	}); 
      $( "#end" ).datepicker({ 
  		inline: true, 
  		dateFormat: "yy-mm-dd",    /* 날짜 포맷 */ 
  		prevText: 'prev', 
  		nextText: 'next',  
  		showOtherMonths: true,    /* 이전/다음 달 일수 보이기 */ 
  		selectOtherMonths: true,    /* 이전/다음 달 일 선택하기 */ 
  		minDate: '-30y', 
  		closeText: '닫기', 
  		currentText: '오늘', 
  		showMonthAfterYear: true,        /* 년과 달의 위치 바꾸기 */ 
  		/* 한글화 */ 
  		monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
  		monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
  		dayNames : ['일', '월', '화', '수', '목', '금', '토'],
  		dayNamesShort : ['일', '월', '화', '수', '목', '금', '토'],
  		dayNamesMin : ['일', '월', '화', '수', '목', '금', '토'],
  		/* 날짜 유효성 체크 */ 
  		onClose: function( selectedDate ) { 
  			$('#start').datepicker("option","maxDate", selectedDate); 
  		} 
  	}); 
	
});
</script>

<style>
.ui-datepicker{
	font-size:12px;
	width:200px;;
	border:0px solid #555;
}
div.ui-datepicker-header{
	margin-top:5px;
	text-align:center;
	border:0px;
	font-size:14px;
}
#apDiv1 {
	position: absolute;
	left: 393px;
	top: 176px;
	width: 899px;
	height: 426px;
	z-index: 3;
}
</style>
</head>

<body>

<div id="searchForm">
<form method="post" action="VisitRequest">
	<input type='hidden' name="formType" value="search"/>
  <table width="336" height="121" border="0">
    <tr>
      <td width="103" height="28" bgcolor="#0000FF">여행 지역</td>
      <td width="217"> <input type="text" name='address' /></td>
    </tr>
    <tr>
      <td height="28" bgcolor="#0000FF">여행 시작일 </td>
      <td><input type="text" id='start' name="visitStartDate" /></td>
    </tr>
    <tr>
      <td height="26" bgcolor="#0000FF">여행 종료일</td>
      <td><input type="text" id='end' name="visitEndDate" /></td>
    </tr>
    <tr>
      <td height="29" colspan="2"><center><input type="submit" value="Search"/></center></td>
    </tr>
  </table>
  
</form>
</div>

<div id="apDiv1"><img src="/TravelStory/img/worldmap.png" width="800" height="391" alt="worldmap"></div>

<table width="1667" align="center" id="관리1헤더" >
  <tr>
    <th width="1657" height="80" align="left" scope="col"><strong id="회원관리페이지최상단">방문 신청</strong></th>
  </tr>

</table>


<p>&nbsp;</p>
<table width="202" height="52">
  <tr>
    <td width="255" height="46" align="center" bgcolor="#3C84F0" id="꾸미기설정">집주인 검색</td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>