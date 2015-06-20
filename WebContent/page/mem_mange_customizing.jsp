<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>블로그 커스터마이징</title>

<style type="text/css">
 
	#꾸미기설정 {
		text-align: center;
		font-weight: bold;
		color: #FFF;
		font-size: 24px;
		width: 100%;
	}
	.TabbedPanels1
	{
		width:80%;
	}
</style>

<link href="../SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<script src="../SpryAssets/SpryMenuBar.js" type="text/javascript"></script> 
<link href="../SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<script src="../SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
 $(document).ready(function(){
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
                    reader.onload = function (e) { 
                    //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                        $('#check_profile').attr('src', e.target.result);
                        //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                        //(아래 코드에서 읽어들인 dataURL형식)
                    }                    
                    reader.readAsDataURL(input.files[0]);
                    //File내용을 읽어 dataURL형식의 문자열로 저장
                }
            }//readURL()--
    
            //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
            $("#background").change(function(){
                 
                readURL(this);
            });
         }); 

</script>






</head>

<body background="../img/background_color.gif"/>
<c:import url="header.jsp"/> 
<div id="cate_name" style="width: 260px; height: 156px; position: absolute; left: 11px; top: 220px; z-index: 1;">
<table width="196" height="52">
  <tr>
    <td width="255" height="46" bgcolor="#3C84F0" id="꾸미기설정">꾸미기 설정</td>
  </tr>
</table>
</div>


<center>
<div id="TabbedPanels1" class="TabbedPanels">
  <ul class="TabbedPanelsTabGroup">
    <li class="TabbedPanelsTab" tabindex="0">회원사진 변경</li>
    <li class="TabbedPanelsTab" tabindex="1">배경색상 변경</li>
    <li class="TabbedPanelsTab" tabindex="2">글꼴 변경</li>
	<li class="TabbedPanelsTab" tabindex="3">레이아웃 변경</li>
	<li class="TabbedPanelsTab" tabindex="4">위젯 변경</li>
</ul>
  <div class="TabbedPanelsContentGroup">
    <div class="TabbedPanelsContent">
     <p>&nbsp;</p>
    	<p>&nbsp;</p>
	       
    
    
<p><img id="check_profile" src="../img/default_profile.png" width="200" height="200"   /></p>
<input type='file' id="background" /><br/>
<!--src에 회원사진이 들어감-->

    
    
    
    
    
    
    	<p>&nbsp;</p>
	 
	      <input type="submit" value="저 장" />
	 
	 
     
        
    </div>
    
    <div class="TabbedPanelsContent">
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      
      
      <form action="saveBackgroundColor">
      	배경색상  <input type="color" name="bgColor" />
      	<p>&nbsp;</p>
    	<p>&nbsp;</p>
	    <p>&nbsp;</p>
        <input type="submit" value="저 장" />
      </form>  
    </div>
    
    
    
    <div class="TabbedPanelsContent">
		<p>&nbsp;</p>
		<p>&nbsp;</p>
      
      
      	<form action="fontColor">
        글꼴
        <select name="font" size="1" id="select">
        	<option name="font" value="arial">arial</option>
        	<option name="font" value="bold">bold</option>
        	<option name="font" value="italic">italic</option>
        </select>
<p>&nbsp;</p>
    	<p>&nbsp;</p>
	    <p>&nbsp;</p>
        <input type="submit" value="저 장" />
      </form>
    </div>
    	

	<form action="layout">
    <div class="TabbedPanelsContent">
    	<br/>
        <br/>
        <img src="../img/layout1.png" width="209" height="215" alt="layout1" />&emsp;
        <img src="../img/layout2.png" alt="layout2" width="208" height="215" />&emsp;
        <img src="../img/layout3.png" alt="layout3" width="209" height="215" />
        <br>
        <input name="layout" type="radio" value="1" />
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        &emsp;&emsp;&emsp;&emsp;
		<input name="layout" type="radio" value="2" />
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        &emsp;&emsp;&emsp;&emsp; 
        <input name="layout" type="radio" value="3" />
	    <br/>
        <br/>
        <input type="submit" value="저 장" />    
    </div>
    </form>
    
    <form action="widget">
    <div class="TabbedPanelsContent">
      <p>&nbsp;</p> 
      <img src="../img/wi1.png" width="394" height="56" />    
      <input type="checkbox" name="widget" value="1"  checked/>
      <br/>
      
      
      <img src="../img/wi2.png" width="394" height="56" /> 
      <input type="checkbox" name="widget" value="2"  checked/>
      <br/>
      
      <img src="../img/wi3.png" width="394" height="56" />
      <input type="checkbox" name="widget" value="3" checked/>
      <br/>
      
      <img src="../img/wi4.png" width="394" height="56" />
      <input type="checkbox" name="widget" value="4"/>
      <br/>
      <p>
        <input type="submit" value="저 장" />
      </p>
    </div>
    </form>
</div>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<script type="text/javascript">
var TabbedPanels2 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>

</center>

 

</body>
</html>
