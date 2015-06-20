<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
#관리1헤더 {
	font-weight: bold;
	font-size: 36px;
	width:100%;

}
#꾸미기설정 {
	text-align: center;
	font-weight: bold;
	color: #FFF;
	font-size: 24px;
	width: 100%;
}

#회원관리페이지최상단 {
	color: #FFF;
	font-size: 45px;
	text-align: center;
	font-weight: bold;
}
.회원관리페이지상단 {
	font-size: 20px;
	color: #FFF;
}
.posting_choose
{
	font-size:45px;
}
 
#posting_list {
	font-size: 24px;
}

A:link
{
	text-decoration:none;
	color:white;
}
A:visited
{
	text-decoration:none;
	color:white;
}
A:hover
{
	text-decoration:none;
	color:yellow;
}

#scroll
{
	width:575px;
	height:420px;
	overflow:auto; 
}
</style>
<script language="javascript" type="text/javascript">
	function div_OnOff(v,id){
 	// 라디오 버튼 value 값 조건 비교
 	if(v == "child"){
 	 	document.getElementById(id).style.display = ""; // 보여줌
 	 	document.getElementById("parent").style.display = "none"; // 숨김
 	}
 	else {
  		document.getElementById(id).style.display = ""; // 보여줌
  		document.getElementById("child").style.display = "none"; // 숨김
 	}
}
	function otherSubmit(){
		document.otherForm.action="categoryModify";
		document.otherForm.submit();
		opener.location.reload(); //부모창 리프레쉬
	    self.close(); //현재창 닫기
	}
</script>
</head>

<body background="../img/background_color.gif">


<table id="관리1헤더" width="1667" >
  <tr>
    <th width="1657" height="80" bgcolor="#1E1283" align="left" scope="col"><strong id="회원관리페이지최상단"> &nbsp;카테고리 수정</strong></th>
  </tr>

</table>


<p>&nbsp;</p>
<table width="202" height="52">
  <tr>
    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">카테고리 수정</td>
  </tr>
</table>
<p>&nbsp;</p>

<div id="layer1" style="width: 260px; height: 156px; position: absolute; left: 91px; top: 175px; z-index: 1;">
    <p>&nbsp;</p>

	<form action="categoryModify" method="post" name="otherForm">  
    
    	<input type="radio" name="divide" value="parent" onclick="div_OnOff(this.value, 'parent');" >상위</input>
		<input type="radio" name="divide" value="child" onclick="div_OnOff(this.value, 'child');">하위</input>
  	 	<br></br>
  	 	
    	<div id="parent" style="width: 252px; height: 156px;  z-index: 1; display:none;">
    		<select name="mainCategoryCode" >
      			<option  disabled="disabled" selected><상위 카테고리></option>
      			<c:forEach var="category" items="${mainCategoryList }">
      			<option value='${category.categoryCode}' label='${category.categoryName }'></option>
      			</c:forEach>
      		</select><br>
      		<label>카테고리명</label>
    	<input type="text" width:"20px" name="mainCategoryName" required/>
    	<input type="button" value="수 정" id="modify" onclick="otherSubmit(1)"/>
    	</div>
    	
    	<div id="child" style="width: 252px; height: 156px;  z-index: 1; display:none;">
    		<select name="subCategoryCode" >
      			<option  disabled="disabled" selected><하위 카테고리></option>
      			<c:forEach var="category" items="${subCategoryList }">
      			<option value='${category.categoryCode}' label='${category.categoryName }'></option>
      			</c:forEach>
      		</select><br>
      		<label>카테고리명</label>
    	<input type="text" width:"20px" name="subCategoryName" required/>
    	<input type="button" value="수 정" id="modify" onclick="otherSubmit(2)"/>
      	</div>
      	
      	
    </form>
 	
</div>

</body>
</html>
