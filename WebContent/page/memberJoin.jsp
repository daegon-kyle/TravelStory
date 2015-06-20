<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 화면</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/redmond/jquery-ui.css" />

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
	 .ui-datepicker
	 {
	font-size:12px;
	width:200px;;
	border:0px solid #555;
	}
	div.ui-datepicker-header
	{
	margin-top:5px;
	text-align:center;
	border:0px;
	font-size:14px;
	}
	#birthDate
	{
		width:150px; 
	}
</style>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script type="text/javascript">
$(function()
		{
		// birthDate 오늘 날짜로 자동 세팅 but 그러면 endDate가 막히지 않는다.
		
		$( "#birthDate" ).datepicker({ 
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
		});  
});
</script>
<%--
<script>
var str;
var length;

str=document.getElementById("password").value;

function checkLength()
{
	
	if(document.getElementById("password").value.length<6)
	{
		window.alert("비밀번호를 6자 이상 입력해주세요");
		document.getElementById('form').action='';
	}
	else if(document.getElementById("passwordCheck").value.length<6)
	{
		window.alert("비밀번호확인을 6자 이상 다시 입력해주세요");
		document.getElementById('form').action='';
	}
	else if(document.getElementById("password").value!=document.getElementById("passwordCheck").value)
	{
		window.alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
		document.getElementById('form').action='';
	}
	if
	{
		document.getElementById('form').action='memberJoin';
	}
	
}
</script>--%>
 </head>
 
 
<body background="/TravelStory/img/background_color.gif">

<table height="99" id="headmaintable">
	<tr>
    <th height="74" colspan="2" bgcolor="#3366CC" class="title" scope="col"><p id="headmaintable">Travel Story</p></th>
  </tr>
</table>

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
	
	<c:if test="${emailProblem ne null }">
		<c:set var="show2" value="${emailProblem}"/>
		<script>window.onload=function(){window.alert("${show2}");};</script>
	</c:if>


<form id="form" name="form" method="post" action="memberJoin">
<p>&nbsp;</p>
<p>&nbsp;</p>
<table id="maintable" width="100%" border="0"> 
  <tr>
    <td width="50%" height="425" class="mainImage"><p><img src="/TravelStory/img/프로그램이미지.png" width="365" height="343" /></p>
    <p><img src="/TravelStory/img/productBlog.gif" width="185" height="177" /><img src="/TravelStory/img/travel.gif" width="188" height="180" /></p></td>
    <td align=center width="50%" class="centeMain"><table width="190" border="0">
      <tr>
        <td height="26" colspan="2"><img src="/TravelStory/img/join.png" width="161" height="49" />
        <th scope="col" rowspan="9"><input type="image" src="/TravelStory/img/joinIcon.png" width="167" height="296" border="0">
        </th>
      </tr>
      
      <tr>
        <td height="15" colspan="2"></td>
      </tr> 
      
        <tr>
        <td height="15" colspan="2">
          <input name="email" type="text"   placeholder="E-mail 주소"  required/></td>
      </tr>
      <tr>
        <td colspan="2">
          <input name="password" type="password"  id="password" placeholder="비밀번호(6~16)" required maxlength="16" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <input name="passwordCheck" type="password"  id="passwordCheck" placeholder="비밀번호확인" required maxlength="16" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <input name="name" type="text"  placeholder="이름" required maxlength="16" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="text" id="birthDate" size="12" name="birthDate" placeholder="생년월일" required></td>
      </tr>
      <tr>
        <td colspan="2">
          <input name="contactNumber" type="text" placeholder="전화번호(-생략)" required/></td>
      </tr>
      <tr>
        <td>남<input type="radio" name="radio" id="gender" value="남"  required/>
          </td>
        <td>여
          <input type="radio" name="radio" id="gender2" value="여"  required/></td>
        <%--    <td><input type="submit" name="join" id="join" value="회원가입" onClick="checkLength();"/></td> --%>
        
      </tr>
      <tr>
      <td colspan="3">
      	<table align=center width="240" border="0">
        <tr>
          <th scope="col">	
          	<a href="login"><img src="/TravelStory/img/login2.png" width="100" height="33"/></a>
          </th>
        
          <th scope="col">
          <a href=""><img src="/TravelStory/img/아이디비밀번호찾기.png" width="210" height="33"/></a></th>
        </tr>
    	</table>
        </td>
      </tr>
        <%--    <td><input type="submit" name="join" id="join" value="회원가입" onClick="checkLength();"/></td> --%>
        
      
  </table>
    <p>&nbsp;</p></td>
  </tr>
</table>
</form>
</body>
</html>


