<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#꾸미기설정 {
	text-align: center;
	font-weight: bold;
	color: #FFF;
	font-size: 24px;
	width: 100%;
}
	.number {
		width: 1.5cm;
	}
#touristEssentialform {
	position: absolute;
	left: 51px;
	top: 61px;
	width: 338px;
	height: 404px;
	z-index: 1;
}
#touristEssentialform {
	font-size: 16px;
}
#touristEssentialform {
	color: #FFF;
}
th {
	color: #FFF;
}
#apDiv1 {
	position: absolute;
	left: 99px;
	top: 67px;
	width: 401px;
	height: 406px;
	z-index: 1;
}
</style>

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
</style>

</head>


<body background="../img/background_color.gif">
<div id="apDiv1">
<form method="post" action="VisitRequest" id="touristEssentialForm">
	<input type="hidden" name="houseOwnerCode" value="${requestScope.checkedCode}"/>
	<input type='hidden' name='formType' value='visitRequest'/>
    <table width="335" height="169" border="0">
      <tr>
        <th width="101" height="23" bgcolor="#0066FF" scope="row">투숙시작일 </th>
        <td width="218"><input type="text" name='startDate' id="start" size="12" readOnly></td>
      </tr>
      <tr>
        <th height="20" bgcolor="#0066FF" scope="row">투숙종료일</th>
        <td><input type="text" name='endDate' id="end" size="12" readOnly></td>
      </tr>
      <tr>
        <th height="20" bgcolor="#0066FF" scope="row">동행자수</th>
        <td><input type="number" name='companionNum'></td>
      </tr>
      <tr>
        <th height="20" bgcolor="#0066FF" scope="row">직업</th>
        <td><input name="job" type="text" value=""></td>
      </tr>
      <tr>
        <th bgcolor="#0066FF" scope="row">자기소개</th>
        <td><textArea rows="5" cols="30" name="selfIntroduction"></textArea></td>
      </tr>
       
    </table>
    <p><center><input type="submit" value="전송"></center></p>
  </form>
</div>
</body>
</html>