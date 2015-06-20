<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>숙박업체 등록</title>
		<style>
			#꾸미기설정 
			{
				text-align: center;
				font-weight: bold;
				color: #FFF;
				font-size: 24px;
				width: 100%;
			}
		</style>
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
		
		
		<c:if test="${HotelSaveFail ne null}">
			<script>window.onload=function(){window.alert("${HotelSaveFail}");};</script>
		</c:if>	
		
				
		<center>
			<table id="hotelInfo" width="200" border="0">
			  <tr>
			    <th colspan="scope=" rowspan="2"col"><img src="/TravelStory/img/hotelPicture.png" alt="" width="670" height="532" /></th>
			    <th scope="col"><img src="/TravelStory/img/hotelIntro.png" alt="" width="603" height="185" /></th>
			  </tr>
			  <tr>
			    <td><center><a href="hotelAdd"><img src="/TravelStory/img/hotelAdd.png" alt="" width="311" height="307" /></a></center></td>
			  </tr>
			</table>
		</center>
		
		
		
	</body>
	
</html>