<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>회원관리페이지-포스팅 관리</title>


<style type="text/css">
 
	#posting_list {
		font-size: 20px;
	}
	 
	#scroll
	{
		width:930px;
		height:420px;
		overflow:auto; 
	}
	.headName 
	{
		font-weight: bold;
		color: #FFF;
		font-size:50px;
		width:100%;
		height:83px;
	} 
</style>


<!-- 검색-->
<script language="javascript"  type="text/javascript"
             src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script language="javascript" type="text/javascript">

            $(document).ready(function() {
                        $('#search').keyup(function() {
                                    searchTable($(this).val());
                        });
            });
            function searchTable(inputVal) {
                        var table = $('#searchTable');
                        table.find('tr').each(function(index, row) {
                                    var allCells = $(row).find('td');
                                    if (allCells.length > 0) {
                                                var found = false;
                                                allCells.each(function(index, td) {
                                                            var regExp = new RegExp(inputVal, 'i');
                                                            if (regExp.test($(td).text())) {
                                                                        found = true;
                                                                        return false;
                                                            }
                                                });
                                                if (found == true)
                                                            $(row).show();
                                                else
                                                            $(row).hide();
                                    }
                        });
            }
 
$(function(){
	$(".line").hover(
		function(){  //마우스가 올라갔을때
			$(this).css('background', 'pink');
			$(this).css('color', '#000080');
		},
		function(){	// 마우스가 떨어졌을 떄
			$(this).css('background', 'none');
			$(this).css('color', 'black');
		}
	);
	
});


function popUp(checkedData){
	var emptyRoomCode = encodeURI(checkedData);
	if(emptyRoomCode != "undefined")
	{
		window.open("emptyRoomDetail?emptyRoomCode="+emptyRoomCode, "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=637, height=667");
	}
	else
	{
		window.alert("목록을 선택하십시오!");
	}
}
</script>  



<body>

<table class="headName">
  <tr>
    <td bgcolor="#000099" ><center>공실 정보 검색결과</center></td>
  </tr>
</table>
<p>&nbsp;</p>




<table width="273" style="margin-left:656px ;">
		<tr>
		    <td><label for="search"> <strong>Search Box</strong></label></td>
		     <td> <input type="text" id="search" /></td> 
  </tr>
</table>





<center>
<form >
<table>
<tr>
<td>

<div id="scroll">
 
<table id="searchTable" width="907"  border="1">
  <tbody>
  
  

  
  <tr>
  <th width="53" height="42" bgcolor="#A7FCFC" scope="col"><span id="posting_list">선택</span></th>
    <th width="91" height="42" bgcolor="#A7FCFC" scope="col"><p><span id="posting_list">숙박업체</span></p></th>
    <th width="86" height="42" bgcolor="#A7FCFC" scope="col"><span id="posting_list">기존가격</span></th>
    <th width="88" height="42" bgcolor="#A7FCFC" scope="col"><span id="posting_list">할인가격</span></th>
    <th width="86" height="42" bgcolor="#A7FCFC" scope="col"><span id="posting_list">사용날짜</span></th>
    <th width="94" height="42" bgcolor="#A7FCFC" scope="col"><span id="posting_list">수용인원</span></th>
    <th width="363" height="42" bgcolor="#A7FCFC" scope="col"><span id="posting_list">숙박업체 위치</span></th>
  </tr>

<c:choose>
  <c:when test="${noresult eq null}">
		
		<c:forEach var="resultList" items="${result}">
				<tr class="line">
				  	<td height="30"><center><input type="radio" class="ch" name="emptyRoomCode" value="${resultList.emptyRoomCode}"/></center></td>
				    <td height="30"><center>${resultList.hotelName}</center></td>
				    <td height="30"><center>${resultList.oldPrice }</center></td>
				    <td height="30"><center>${resultList.discountPrice }</center></td>
				    <td height="30"><center><fmt:formatDate value="${resultList.availableDate.time}" pattern="yyyy-MM-dd" /></center> </td>
				    <td height="30"><center>${resultList.capacity }</center></td>
				    <td height="30">${resultList.hotelLocation }</td>
			   </tr>
		</c:forEach>
  </c:when>
  <c:otherwise>
  		
  		<script>window.onload=function(){window.alert("${noresult}");};</script>
  </c:otherwise>  
</c:choose> 
   </tbody>
    
  
</table>   
</div>
</td>
</tr>
<tr>
<td><center>
  <p>&nbsp;</p>
  <p><img src="/TravelStory/img/seeReserve.png" width="220" height="63" id="request" onclick="popUp($('.ch:checked').val())" style="cursor:pointer"/></p>

</center></td>
</tr>
</table>
</form>
</center>
</body>
</html>
 