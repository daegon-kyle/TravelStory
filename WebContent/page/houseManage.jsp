<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
		<title>집 정보 등록</title>
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
		<link href="/TravelStory/SpryAssets/SpryAccordion.css" rel="stylesheet" type="text/css" />
	<script src="/TravelStory/SpryAssets/SpryAccordion.js" type="text/javascript"></script>
</head>
	
<body>
		
        
        
        
        
        
        
        
        
        
        
        
        
        
       <c:import url="header.jsp"/> 
        
        
        
        <c:choose>
	        <c:when test="${deleteResult ne null}">
					<script>window.onload=function(){window.alert("${deleteResult}");};</script>
			</c:when>	
			
			<c:when test="${HouseSaveResult ne null}">
					<script>window.onload=function(){window.alert("${HouseSaveResult}");};</script>
			</c:when>	
			
	        <c:when test="${problems ne null}">
				<c:forEach var="problem" items="${problems }">
					<c:forEach var="myproblem" items="${problem}">
						<c:if test="${myproblem ne null}">
							<c:set var="show" value="${myproblem }"/>
								<script>window.onload=function(){window.alert("${show}");};</script>
						</c:if>
					</c:forEach>
				</c:forEach>
			</c:when>
		</c:choose>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
<div id="cate_name" style="width: 260px; height: 126px; position: absolute; left: 11px; top: 220px; z-index: 1;">
		<table width="202" height="52">
		  <tr>
		    <td width="255" height="26" bgcolor="#3C84F0" id="꾸미기설정">집 정보 관리</td>
		  </tr>
		</table>
		<br />
		</div>
		
		
		 
		
<div id="cate_name2" style="maring:0 auto; position: relative; top: -105px; z-index: 1;">	 				
		<center>
			<table width="1238" height="694" border="0" id="hotelInfo">
			  <tr>
			    <td width="1232" height="690"><div id="Accordion1" class="Accordion" tabindex="0">
			      <div class="AccordionPanel">
			        <div class="AccordionPanelTab">집 정보 수정</div>
			        <div class="AccordionPanelContent">
			          
                      
                      
                      
                      
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                   
            
            <center>
		<form method="post" action="houseModify">
			<table width="1121" border="0">
			  <tr>
			    <th width="621" colspan="scope=" rowspan="8" col"><img src="/TravelStory/img/handsome.png" alt="" width="633" height="589" /></th>
			   
			  </tr>
			  <tr>
			  	<td width="186" height="42"><center>
			  	  <img src="/TravelStory/img/houseAddress.png" alt="" width="180" height="52" />
			  	</center></td>
			    <td width="300"><center>
			       
			      <input class="house" name="address" type="text" value="${address}"></center></td>
			  </tr>
			  
			  <tr>
			  <td height="42"><center>
			    <img src="/TravelStory/img/houseInviteDate.png" alt="" width="180" height="52" />
			  </center></td>
			    <td><center>
			         
			        <input class="house2" type="date" name="visitStartDate" value="${visitStartDate }">
			        ~ 
			        <input class="house2"type="date" name="visitEndDate" value="${visitEndDate }">
			      </center></td>
			  </tr>
			  
			  <tr>
			      <td height="42">
			        <center>
			          <img src="/TravelStory/img/houseJob.png" alt="" width="180" height="52" />
			        </center>
			      </td>  
			      <td>
			        <center> <input class="house" type="text" name="job" value="${job}"></center>
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
			        
			        <c:choose>
			        	<c:when test="${marriedState eq '미혼'}">
			        		  미혼<input type="radio" name="marriedState" id="gender" value="미혼" checked="checked" required/>
			        
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        
			        기혼<input type="radio" name="marriedState" id="gender2" value="기혼"  required/>
			        		
			        	</c:when>
			        	
			        	<c:otherwise>
			        	  미혼<input type="radio" name="marriedState" id="gender" value="미혼"  required/>
			        
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        
			        기혼<input type="radio" name="marriedState" id="gender2" value="기혼" checked="checked"  required/>	
			        	</c:otherwise>
			        </c:choose>
			        
			        
			        
			      
			          
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
			          <textarea name="selfIntroduction" id="textarea2" cols="40" rows="8">${selfIntroduction}</textarea>
			        </center>
			      </td>				
			   </tr>
			  
			  
			  
			  <tr>
			    <td><center>
			      <img src="/TravelStory/img/houseIntroduction.png" alt="" width="180" height="130" />
			    </center></td>
			    <td><center> 
			      
			        <label for="textarea"></label>
			        <textarea name="etc" id="textarea" cols="40" rows="8" >${etc}</textarea>
			      </center></td>
			  </tr>
			  <tr>
			  
			  <td height="74" colspan="2"><center>
			    <input type="image" src="/TravelStory/img/houseModifyButton.png" alt="" width="488" height="80" />
			  </center></td>
			  </tr>
			  
			</table>
			</form>
		</center>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
			        </div>
		          </div>
			      <div class="AccordionPanel">
			        <div class="AccordionPanelTab">집 정보 삭제</div>
			        <div class="AccordionPanelContent">
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    <center>
            	      <table width="1231" height="539" border="0">
            	        <tr>
            	          <th width="589" rowspan="2" scope="col"><img src="/TravelStory/img/byebye.png" width="589" height="491"></th>
            	          <th width="632" height="166" scope="col"><img src="/TravelStory/img/byehouse.png" alt="" width="586" height="154"></th>
          	          </tr>
            	        <tr>
            	          <td height="315"><center><a href="houseDelete"><img src="/TravelStory/img/deleteHouse.png" alt="" width="295" height="291"></a></center></td>
          	          </tr>
          	        </table>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    </div>
		          </div>
			      </div>
                
                
                
                
                
                
                
                </td>
			  </tr>
			</table>
</center>
<script type="text/javascript">
var Accordion1 = new Spry.Widget.Accordion("Accordion1");
        </script>
 </div>
</body>
	
</html>