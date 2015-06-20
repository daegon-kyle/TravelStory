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
</style>

<script language="javascript" type="text/javascript">
	function save_close(){
 		opener.location.reload(); // 부모창 리프레쉬  
		self.close(); // 현재창 닫기 
	};
</script>

</head>
<body background="../img/background_color.gif">
<table width="196" height="52">
  <tr>
    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">공실 추가</td>
  </tr>
</table>
<br>

<form method="post" action="EmptyRoomInfoManager" id= 'addEmptyRoom'> 
<table width='600'>
	<tr>
    	<td>공실이름</td>
        <td><input type="text" name='emptyRoomName'></td>
    </tr>
    <tr>
    	<td>할인전 가격</td>
        <td><input type="text" name='oldPrice'></td>
    </tr>
    <tr>
    	<td>할인 가격</td>
        <td><input type="text" name='discountPrice'></td>
    </tr>
    <tr>
    	<td>체크인</td>
        <td><input type='time' name="checkInTime"></td>
    </tr>
     <tr>
    	<td>체크아웃</td>
        <td><input type='time' name="checkOutTime"></td>
    </tr>
    <tr>
    	<td>평수(평)</td>
        <td><input type='number' name='space' class='number'></td>
    </tr>
    <tr>
    	<td>수용인원(명)</td>
        <td><input type='number' name='capacity' class='number'></td>
    </tr>
    <tr>
    	<td>이용시설목록</td>
        <td><input type='text' name='facilityList'></td>
    </tr>
    <tr>
    	<td>기타</td>
        <td><textarea rows='2' cols='20' name='etc' form='addEmptyRoom'></textarea></td>
    </tr>
    <input type="hidden" name='formType' value='addEmptyRoom' />
</table>
<input type="image" src="/TravelStory/img/confirm.png" width="77px" height="32px" id="save" onclick="save_close()">
<input type="reset" value="" style="background: url(/TravelStory/img/cancle.png); width:77px; height:32px; border:0px">
<!-- <input type="image" src="/TravelStory/img/close.png" id="close" onclick='close()'> -->
</form>

</body>
</html>
