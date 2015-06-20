<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인화면</title>

<style>
	#headmaintable
	{ 
		width:100%;
		margin:0px auto;
		font-size:70px; 
		font-weight:bold;
		color: #FFF;
	}
	#maintable
	{
		width:800px;
		margin:0px auto;
	} 
</style>


<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
 
</head>
 

<body background="../img/background_color.gif">


<table height="99" id="headmaintable">
	<tr>
    <th height="74" colspan="2" bgcolor="#3366CC" class="title" scope="col"><p id="headmaintable">Travel Story</p></th>
  </tr>
</table>

	<c:choose>
		<c:when test="${success ne null }">
			<script>window.onload=function(){window.alert("${success}");};</script>
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
		
		<c:when test="${ noEmail ne null}">
			<script>window.onload=function(){window.alert("${noEmail}");};</script>
		</c:when>
		
		<c:when test="${wrongPassword ne null}">
			<script>window.onload=function(){window.alert("${wrongPassword}");};</script>
		</c:when>
	</c:choose>


<form id="form" name="form" method="post" action="login" >
<p>&nbsp;</p>
<p>&nbsp;</p>
<table id="maintable" width="100%" border="0"> 
  <tr>
    <td width="50%" height="425" class="mainImage"><p><img src="/TravelStory/img/프로그램이미지.png" width="365" height="343" /></p>
    <p><img src="/TravelStory/img/productBlog.gif" width="185" height="177" /><img src="/TravelStory/img/travel.gif" width="188" height="180" /></p></td>
    <td align=center width="50%" class="centeMain"><table width="190" border="0">
      <tr>
        <td height="26" colspan="2"><input name="email" type="text" placeholder="E-mail 주소" required />        


        <th scope="col" rowspan="3">
        	<input type="image" src="/TravelStory/img/login.png" width="98" height="88" />
        
        </th>
       
      <tr>
        <td height="15" colspan="2"><input name="password" type="password" placeholder="비밀번호" required/>
        </td>
      </tr>
      
       
  </table>
  <table align=center width="240" border="0">
        <tr>
          <th scope="col">
          	<a href="memberJoin"><img src="/TravelStory/img/회원가입.png" width="89" height="33"/></a>
          </th>
        
          <th scope="col">
          <a href=""><img src="/TravelStory/img/아이디비밀번호찾기.png" width="166" height="33"/></a></th>
        </tr>
    </table>
    <p>&nbsp;</p></td>
  </tr>
</table>
</form>
</body>
</html>