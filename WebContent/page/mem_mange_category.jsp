<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</style>

<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script>  
<script language="javascript">
  function open_win(){
    window.open('category_add_fake.jsp','popup', 'width=500px, height=450px, left=400px,top=200px');
  }
  
  function open_win2(){
    window.open('category_delete_fake.jsp','popup', 'width=500px, height=450px, left=400px,top=200px');
  }
  
  function open_win3(){
    window.open('category_modify_fake.jsp','popup', 'width=500px, height=450px, left=400px,top=200px');
  }

function disp(el) {
    el.children[1].style.display = (el.children[1].style.display=='' ? 'block' : '')
}

function checkKey(el) {
    if (event.keyCode==13)
        el.click()
} 

</script>

<link rel="stylesheet" href="../css/jquery.treeview.css" />
<link rel="stylesheet" href="../css/screen.css" />
<script src="../lib/jquery.js" type="text/javascript"></script>
<script src="../lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../lib/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript">
        $(function() {
            $("#tree").treeview({
                collapsed: true,
                animated: "medium",
                control:"#sidetreecontrol",
                persist: "location"
            });
        })
        
</script>

</head>

<body background="../img/background_color.gif">

<c:import url="header.jsp"/> 
<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 11px; top: 220px; z-index: 1;">
<table width="202" height="52">
  <tr>
    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">카테고리 관리</td>
  </tr>
</table>
</div>

<div id="sidetree">
 <div class="treeheader">&nbsp;</div>
    
    <div id="sidetreecontrol"><a class="categoryhead" href="?#">전체 닫기</a> | <a class="categoryhead" href="?#">전체 열기</a></div>
    <ul class="category" id="tree">
        <c:forEach var="mainCategory" items="${mainCategoryList }">    
        	<li>
        		<a class="category" href="#">${mainCategory.categoryName }</a>
        		<ul>
        		<c:forEach var="subCategory" items="${subCategoryList }">
        			<c:if test="${subCategory.parentCategoryCode eq mainCategory.categoryCode}">
        				<li><a class="category" href="#">${subCategory.categoryName }</a></li>
        			</c:if>
        		</c:forEach>
        		</ul>
        	</li>
        </c:forEach>
    </ul>
</div>

<div id="layer1" style="width: 363px; height: 254px; position: absolute; left: 362px; top: 308px; z-index: 1;">
  
  <!--이미지링크-->
	<a href="javascript:open_win()"><img src="../img/categoryadd.png" width="273" height="75" /></a>
  <a href="javascript:open_win2()"><img src="../img/categorydelete.png" width="273" height="75" /></a>
  <a href="javascript:open_win3()"><img src="../img/categorymodify.png" width="273" height="75" /></a>
  
</div>

<script type="text/javascript">
var TabbedPanels2 = new Spry.Widget.TabbedPanels("TabbedPanels1");
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"../SpryAssets/SpryMenuBarDownHover.gif", imgRight:"../SpryAssets/SpryMenuBarRightHover.gif"});
var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2", {imgDown:"../SpryAssets/SpryMenuBarDownHover.gif", imgRight:"../SpryAssets/SpryMenuBarRightHover.gif"});
</script>
</body>
</html>
