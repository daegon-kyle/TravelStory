<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml"> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>숙박업체 등록 페이지</title>
		<style>
			#꾸미기설정 
			{
				text-align: center;
				font-weight: bold;
				color: #FFF;
				font-size: 24px;
				width: 100%;
			}
			.hotel
			{
				width:300px; 
				height:30px;
			}
		</style>
		
<link href="/TravelStory/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
	</head>
	
	
	<body background="../img/background_color.gif">
		
		<c:import url="header.jsp"/> 
		<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 11px; top: 220px; z-index: 1;">
		<table width="202" height="52">
		  <tr>
		    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">숙박업체 등록</td>
		  </tr>
		</table>
		<br />
		</div>
		
				
			
		
		<c:if test="${problems ne null}">
			<c:forEach var="problem" items="${problems }">
				<c:forEach var="myproblem" items="${problem}">
					<c:if test="${myproblem ne null}">
						<c:set var="show" value="${myproblem }"/>
							<script>window.onload=function(){window.alert("${show}");};</script>
					</c:if>
				</c:forEach>
			</c:forEach>
		</c:if>
				
				
		<center>
		<form method="post" action="hotelFormAdd">
			<table width="1149" border="0">
			  <tr>
			    <th width="670" colspan="scope=" rowspan="6" col"><img src="/TravelStory/img/hotelPicture.png" alt="" width="620" height="497" /></th>
			   
			  </tr>
			  <tr>
			  	<td width="133" height="42"><center>
			  	  <img src="/TravelStory/img/숙박업체이름.png" alt="" width="181" height="62" />
			    </center></td>
			    <td width="332"><center>
			       
			      <input class="hotel" name="hotelName" type="text" placeHolder="숙박업체 이름을 입력하세요"></center></td>
			  </tr>
			  
			  <tr>
			  <td height="42"><center>
			    <img src="/TravelStory/img/숙박업체위치.png" alt="" width="181" height="62" />
			  </center></td>
			    <td><center>
			         
			        <input class="hotel" type="text" name="hotelLocation" placeHolder="숙박업체 위치를 입력하세요"></center></td>
			  </tr>
			  
			  <tr>
			  <td height="42"><center>
			    <img src="/TravelStory/img/숙박업체홈페이지주소.png" alt="" width="181" height="79" />
			  </center></td>
			    <td><center>
			        <input class="hotel" type="text" name="hotelReservationPagePath" placeHolder="숙박업체 홈페이지 주소를 입력하세요"></center></td>
			  </tr>
			  <tr>
			    <td><center>
			      <img src="/TravelStory/img/숙박업체소개.png" alt="" width="180" height="217" />
			    </center></td>
			    <td><center> 
			        <label for="textarea"></label>
			        <textarea name="hotelIntrodution" id="textarea" cols="40" rows="13" placeholder="숙박업체에대한 소개를 입력하세요"></textarea>
			      </center></td>
			  </tr>
			  <tr>
			  
			  <td colspan="2"><input type="image" src="/TravelStory/img/숙박업체등록.png" alt="" width="507" height="79" /></td>
			  </tr>
			  
			</table>
		</form>
		</center>
		
		
		
	</body>
	
</html>