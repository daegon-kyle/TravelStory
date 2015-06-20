<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>공실 정보 상세보기 </TITLE>
<style type="text/css">
  
	
	.headName 
	{
		font-weight: bold;
		color: #FFF;
		font-size:35px;
		width:100%;
	} 
	.emptyRoom
	{
		width:440px;
		height:30px;
	}
	.emptyRoom2
	{
		width:130px;
		height:30px;
	}
	 
</style>  
</HEAD>

<BODY>
 


<table height="73" class="headName">
  <tr>
    <td height="69" bgcolor="#000099" ><center>공실 정보 상세보기</center></td>
  </tr>
</table>



<center>
  <table width="610" height="498" border="0">
   <tr>
    <th height="39"><img src="/TravelStory/img/empty2.png" alt="" width="136" height="37"></th>
    <th colspan="3"><fmt:formatDate value="${info.date.time}" pattern="yyyy-MM-dd" /></th>
    </tr>
     <tr>
      <th height="39" scope="col"><img src="/TravelStory/img/empty13.png" alt="" width="136" height="37"></th>
      <th colspan="3" scope="col"><a href="${info.hotelPagePath}">${info.hotelPagePath}</a></th>
    </tr>
    <tr>
    <th height="39" scope="col"><img src="/TravelStory/img/empty1.png" alt="" width="136" height="37"></th>
    <th width="154" scope="col"><input type="text" class="emptyRoom2" value="${info.hotelName }" readonly></th>
    <th width="136" scope="col"><img src="/TravelStory/img/empty14.png" alt="" width="136" height="37"></th>
    <th width="170" scope="col"><input type="text" class="emptyRoom2" value="${info.emptyRoomName }" readonly></th>
  </tr> 
    <tr>
    <th width="136" height="39" scope="col"><img src="/TravelStory/img/empty3.png" alt="" width="136" height="37"></th>
    <th colspan="3" scope="col"><input type="text" class="emptyRoom" value="${info.hotelLocation}" readonly></th>
    </tr>
  <tr>
    <th height="39"><img src="/TravelStory/img/empty4.png" alt="" width="136" height="37"></th>
    <th><input type="text" class="emptyRoom2" value="${info.oldPrice}" readonly></th>
    <th><img src="/TravelStory/img/empty5.png" alt="" width="136" height="37"></th>
    <th><input type="text" class="emptyRoom2" value="${info.discountPrice}" readonly></th>
  </tr>
  <tr>
    <th height="39"><img src="/TravelStory/img/empty6.png" alt="" width="136" height="37"></th>
    <th><input type="text" class="emptyRoom2" value="${info.checkInTime}" readonly></th>
    <th><img src="/TravelStory/img/empty7.png" alt="" width="136" height="37"></th>
    <th><input type="text" class="emptyRoom2" value="${info.checkOutTime}" readonly></th>
  </tr>
  <tr>
    <th height="39"><img src="/TravelStory/img/empty8.png" alt="" width="136" height="37"></th>
    <th><input type="text" class="emptyRoom2" value="${info.space}" readonly></th>
    <th><img src="/TravelStory/img/empty9.png" alt="" width="136" height="37"></th>
    <th><input type="text" class="emptyRoom2" value="${info.capacity}" readonly></th>
  </tr>
  <tr>
    <th height="39"><img src="/TravelStory/img/empty10.png" alt="" width="136" height="37"></th>
    <th colspan="3"><input type="text" class="emptyRoom" value="${info.facilityList}" readonly></th>
    </tr>
  <tr>
    <th height="77"><img src="/TravelStory/img/empty15.png" alt="" width="135" height="67"></th>
    <th colspan="3">
      <textarea name="textarea" id="textarea" cols="60" rows="5" readonly>${info.hotelIntroduction}</textarea></th>
  </tr>
  <tr>
    <th height="70"><img src="/TravelStory/img/empty16.png" alt="" width="135" height="67"></th>
    <th colspan="3">
      <textarea name="textarea2" id="textarea2" cols="60" rows="5" readonly>${info.etc}</textarea></th>
    </tr>
  <tr>
    <td height="15" colspan="4"><a href="javascript:self.close()"><img src="/TravelStory/img/empty12.png" alt="" width="598" height="55"></a></td>
    </tr>
</table>
</center>






 
</BODY>
</HTML>





 