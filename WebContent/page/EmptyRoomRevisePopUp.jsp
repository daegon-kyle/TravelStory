<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공실 정보 수정</title>

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
</style>

<script>
	function save_close(){
 		opener.location.reload(); // 부모창 리프레쉬  
		self.close(); // 현재창 닫기 
	}
</script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/redmond/jquery-ui.css" />

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
<table width="196" height="52">
  <tr>
    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">공실 수정</td>
  </tr>
</table>
<br>

<form method="post" action="EmptyRoomInfoManager" id= 'reviseEmptyRoom'>
	<input type="hidden" name='emptyRoomCode' value="${requestScope.emptyRoomDetailInfo.emptyRoomCode }">
<table width='600'>
	<tr>
    	<td>공실이름</td>
        <td><input type="text" name='emptyRoomName' value='${requestScope.emptyRoomDetailInfo.emptyRoomName }'></td>
    </tr>
    <tr>
    	<td>할인전 가격</td>
        <td><input type="text" name='oldPrice' value='${requestScope.emptyRoomDetailInfo.oldPrice }'></td>
    </tr>
    <tr>
    	<td>할인 가격</td>
        <td><input type="text" name='discountPrice' value='${requestScope.emptyRoomDetailInfo.discountPrice }'></td>
    </tr>
    <tr>
    	<td>체크인</td>
        <td><input type='time' name="checkInTime" value='${requestScope.emptyRoomDetailInfo.checkInTime }'></td>
    </tr>
     <tr>
    	<td>체크아웃</td>
        <td><input type='time' name="checkOutTime" value='${requestScope.emptyRoomDetailInfo.checkOutTime }'></td>
    </tr>
    <tr>
    	<td>평수(평)</td>
        <td><input type='number' name='space' class='number' value='${requestScope.emptyRoomDetailInfo.space }'></td>
    </tr>
    <tr>
    	<td>수용인원(명)</td>
        <td><input type='number' name='capacity' class='number' value='${requestScope.emptyRoomDetailInfo.capacity }'></td>
    </tr>
    <tr>
    	<td>이용시설목록</td>
        <td><input type='text' name='facilityList' value='${requestScope.emptyRoomDetailInfo.facilityList }'></td>
    </tr>
    <tr>
    	<td>기타</td>
        <td><textarea rows='2' cols='20' name='etc' form='reviseEmptyRoom' value='${requestScope.emptyRoomDetailInfo.etc }'></textarea></td>
    </tr>
    
</table>
	<input type="hidden" name='formType' value='reviseEmptyRoom'>
<input type="image" src="/TravelStory/img/confirm.png" width="77px" height="32px" id="save" onclick="save_close()">
<input type="reset" value="" style="background: url(/TravelStory/img/cancle.png); width:77px; height:32px; border:0px">
<!-- <input type="image" src="/TravelStory/img/close.png" id="close" onclick='close()'> -->
</form>
<body background="../img/background_color.gif">
</body>
</html>
