<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
 
	#꾸미기설정 {
		text-align: center;
		font-weight: bold;
		color: #FFF;
		font-size: 24px;
		width: 100%;
	}
	 
	.posting_choose
	{
		font-size:45px;
	}
	 
	#posting_list {
		font-size: 24px;
	}
	 
	#scroll
	{
		width:575px;
		height:420px;
		overflow:auto; 
	}
	#sidetree {
		position: absolute;
		left: 33px;
		top: 305px;
		width: 280px;
		height: 563px;
		z-index: 11;
		font-size: 16px;
	}
	.categoryhead
	{
		text-decoration:none;
		color:black; 
	}
	.category
	{
		text-decoration: none;
	
		color: #36C;
	}
	#postingList {
	position: absolute;
	left: 15px;
	top: 346px;
	width: 1060px;
	height: 1165px;
	z-index: 3;
}
</style>

<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"../SpryAssets/SpryMenuBarDownHover.gif", imgRight:"../SpryAssets/SpryMenuBarRightHover.gif"});
</script>


<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	//추가화면 보여주기
	function open_win(){
    window.open('posting_add_fake.jsp','popup', 'width=450px, height=650px, left=400px,top=200px');
    }
	//삭제부분 - 포스팅 코드 값 넘겨주기
	function reLoad(checkedData){
		var postingCode = encodeURI(checkedData);
		location.href='postingDelete?postingCode='+postingCode;
	}
	//수정부분 - 포스팅 코드 값 넘겨주기
	function popUp(checkedData){
		var postingCode = encodeURI(checkedData);
		window.open("posting_revise_fake.jsp?postingCode="+postingCode, "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=450, height=500");
	}
</script>

<!-- 검색-->
<script>
	function selectView(obj){
		if( (obj.value)=='23' ){
			document.getElementById('23').style.display='';
			document.getElementById('24').style.display='none';
			document.getElementById('34').style.display='none';
			document.getElementById('35').style.display='none';
		}
		else if((obj.value)=='24'  ){
			document.getElementById('23').style.display='none';
			document.getElementById('24').style.display='';
			document.getElementById('34').style.display='none';
			document.getElementById('35').style.display='none';
		}
		else if( (obj.value)=='34'  ){
			document.getElementById('23').style.display='none';
			document.getElementById('24').style.display='none';
			document.getElementById('34').style.display='';
			document.getElementById('35').style.display='none';
		}
		else if( (obj.value)=='35'  ){
			document.getElementById('23').style.display='none';
			document.getElementById('24').style.display='none';
			document.getElementById('34').style.display='none';
			document.getElementById('35').style.display='';
	}
}
</script>
<!-- --------------------------------------------------------------------------------------------------------------------------------------------------------- -->
<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
</head>

<body background="../img/background_color.gif"> 
<c:import url="header.jsp"/>

<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 11px; top: 290px; z-index: 1;">
	<table width="202" height="52">
  		<tr>
    		<td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">포스팅 관리</td>
  		</tr>
	</table>
<br />
</div>


<div id="scroll" style=" position: absolute; left: 220px; top: 362px; z-index: 1;">
<select name="category" onChange="selectView(this);">
  	<option value="null" selected>카테고리</option>
  	<c:forEach var="subCategory" items="${subCategoryList }">
  		<option value="${subCategory.categoryCode }" label="${subCategory.categoryName }">${subCategory.categoryName }</option>
    </c:forEach>
</select> 

<br/>
<br/> 




<table id="searchTable" width="572"  border="1" >
  <tbody>
  <tr>
  <th width="77" height="30" bgcolor="#3399FF" scope="col" ><span id="posting_list">선택</span></th>
    <th width="168" height="30" bgcolor="#3399FF" scope="col" ><span id="posting_list">제목</span></th>
    <th width="250" height="30" bgcolor="#3399FF" scope="col" style="TABLE-LAYOUT: fixed"><span id="posting_list">내용</span></th>
    <th width="130" height="30" bgcolor="#3399FF" scope="col"><span id="posting_list">작성날짜</span></th>
  </tr>
  
 
  <c:forEach var="posting" items="${postingList }">
  	<tr id="${positng.categoryCode }">
  		<td height="30"><input type="radio" class="ch" name="postingCode" value="${posting.postingCode }"/></td>
    	<td height="30">${posting.title }</td>
    	<td height="30">${posting.content }</td>
    	<td height="30"><fmt:formatDate type="both" value="${posting.writingDate.time }" pattern="yyyy.MM.dd"/></td>
  	</tr>
  </c:forEach>
   </tbody>
  
</table>  
</div>

<div id="layer1" style="width: 273px; height: 200px; position: absolute; left: 900px; top: 362px; z-index: 1;">

<form action="selfSearchPostingInManage" method="post">
	<table width="320">
		<tr>
			<td><label for="search"> <strong>Search Box</strong></label></td>
    		<td><input type="text" id="keyword" name="keyword" /></td>
			<td><input type="submit" value="검색"></td>    
		</tr>
</table>
</form>

<br />
</div>

<div id="layer2" style="width: 240px; height: 416px; position: absolute; left: 900px; top: 411px; z-index: 1;">

<!--이미지링크-->
	<img src="../img/posting_add.png" onclick="javascript:open_win()"/>
    <img src="../img/posting_delete.png" onclick="reLoad($('.ch:checked').val())"/>
    <img src="../img/posting_modify.png" onclick="popUp($('.ch:checked').val())"/>

    
    <p>&nbsp;</p>
</div>
 


</body>
</html>
