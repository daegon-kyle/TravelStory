<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml"> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>집주인 등록 페이지</title>
		<style>
			#꾸미기설정 
			{
				text-align: center;
				font-weight: bold;
				color: #FFF;
				font-size: 24px;
				width: 100%;
			}
			.house
			{
				width:300px; 
				height:30px;
			}
			.house2
			{
				
				width:135px;
				height:30px;
			}
		</style>
		 
	</head>
	
	
	<body>
		
		<c:import url="header.jsp"/> 
		<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 11px; top: 220px; z-index: 1;">
		<table width="202" height="52">
		  <tr>
		    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">집정보 등록</td>
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
		<form method="post" action="houseFormAdd">
			<table width="1121" border="0">
			  <tr>
			    <th width="621" colspan="scope=" rowspan="8" col"><img src="/TravelStory/img/ownerPicture.png" alt="" width="633" height="589" /></th>
			   
			  </tr>
			  <tr>
			  	<td width="186" height="42"><center>
			  	  <img src="/TravelStory/img/houseAddress.png" alt="" width="180" height="52" />
			  	</center></td>
			    <td width="300"><center>
			       
			      <input class="house" name="address" type="text" placeHolder="집 주소를 입력하세요"></center></td>
			  </tr>
			  
			  <tr>
			  <td height="42"><center>
			    <img src="/TravelStory/img/houseInviteDate.png" alt="" width="180" height="52" />
			  </center></td>
			    <td><center>
			         
			        <input class="house2" type="date" name="visitStartDate">
			        ~ 
			        <input class="house2"type="date" name="visitEndDate">
			      </center></td>
			  </tr>
			  
			  <tr>
			      <td height="42">
			        <center>
			          <img src="/TravelStory/img/houseJob.png" alt="" width="180" height="52" />
			        </center>
			      </td>  
			      <td>
			        <center> <input class="house" type="text" name="job" placeHolder="본인의 직업을 입력하세요"></center>
			       </td>				
			   </tr>
			   
			   <tr>
			      <td height="42">
			        <center>
			          <img src="/TravelStory/img/houseMarry.png" alt="" width="180" height="52" />
			        </center>
			      </td>  
			      <td>
			        <center>
			        
			        미혼<input type="radio" name="marriedState" id="gender" value="미혼" required/>
			        
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        
			        기혼<input type="radio" name="marriedState" id="gender2" value="기혼"  required/>
			          
			        </center>
			       </td>				
			   </tr>
			   
			   <tr>
			      <td height="42">
			        <center>
			          <img src="/TravelStory/img/houseSelfIntroduction.png" alt="" width="180" height="130" />
			        </center>
			      </td>  
			      <td>
			        <center>
			          <textarea name="selfIntroduction" id="textarea2" cols="40" rows="8" placeholder="자기소개를 입력하세요"></textarea>
			        </center>
			      </td>				
			   </tr>
			  
			  
			  
			  <tr>
			    <td><center>
			      <img src="/TravelStory/img/houseIntroduction.png" alt="" width="180" height="130" />
			    </center></td>
			    <td><center> 
			      
			        <label for="textarea"></label>
			        <textarea name="etc" id="textarea" cols="40" rows="8" placeholder="집에대한 소개 및 초대목적 등을 입력하세요"></textarea>
			      </center></td>
			  </tr>
			  <tr>
			  
			  <td height="74" colspan="2"><center>
			    <input type="image" src="/TravelStory/img/houseAddbutton.png" alt="" width="488" height="80" />
			  </center></td>
			  </tr>
			  
			</table>
			</form>
		</center>
		
		
		
	</body>
	
</html>