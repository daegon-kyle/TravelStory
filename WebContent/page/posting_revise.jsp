<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/redmond/jquery-ui.css" />

<!-- 도,시,군 -->
<!-- <script type="text/javascript" src="../javascript/mainBlogJS.js" charset='utf-8'></script>

<!--  달력 -->
<script type="text/javascript" src="../js/like.js"></script>

<!-- 그래프 표시 -->
<style type="text/css">@import url(../css/like.css);</style>


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
 .title{
	display:title;
 }
#posting_list {
	font-size: 24px;
}

#category{
	display:inline;
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
<style>
.ui-datepicker{
	font-size:12px;
	width:200px;;
	border:0px solid #555;
}
div.ui-datepicker-header{
	margin-top:5px;
	text-align:center;
	border:0px;
	font-size:14px;
}
.test{
	width:65%;
}
</style>
<script type="text/javascript">
	$(function(){
		// startDate를 오늘 날짜로 자동 세팅 but 그러면 endDate가 막히지 않는다.
		$('#start').val($.datepicker.formatDate($.datepicker.ATOM, new Date()));
		$( "#start" ).datepicker({ 
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
		/* 날짜 유효성 체크 */ 
		onClose: function( selectedDate ) { 
			$('#end').datepicker("option","minDate", selectedDate); 
		} 
	}); 
      $( "#end" ).datepicker({ 
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
  		/* 날짜 유효성 체크 */ 
  		onClose: function( selectedDate ) { 
  			$('#start').datepicker("option","maxDate", selectedDate); 
  		} 
  	});
});
	$(function(){
		// startDate를 오늘 날짜로 자동 세팅 but 그러면 endDate가 막히지 않는다.
		$('#start2').val($.datepicker.formatDate($.datepicker.ATOM, new Date()));
		$( "#start2" ).datepicker({ 
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
		/* 날짜 유효성 체크 */ 
		onClose: function( selectedDate ) { 
			$('#end2').datepicker("option","minDate", selectedDate); 
		} 
	}); 
      $( "#end2" ).datepicker({ 
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
  		/* 날짜 유효성 체크 */ 
  		onClose: function( selectedDate ) { 
  			$('#start2').datepicker("option","maxDate", selectedDate); 
  		} 
  	});
});
</script>


<script language="javascript" type="text/javascript">
	function otherSubmit(value){
		if(value==1){
			document.getElementsByName("categoryPurposeCode")[0].value="1";
		}
		else if(value==2){
			document.getElementsByName("categoryPurposeCode")[0].value="2";
		}
		else if(value==3){
			document.getElementsByName("categoryPurposeCode")[0].value="3";
		}
		else {
			document.getElementsByName("categoryPurposeCode")[0].value="4";
		}
		
		document.otherForm.action="postingRevise";
		document.otherForm.submit();
		opener.location.reload(); //부모창 리프레쉬
	    self.close(); //현재창 닫기
	}
</script>
</head>

<body background="../img/background_color.gif">

	<table id="관리1헤더" width="1667" >
  		<tr>
    		<th width="1657" height="80" bgcolor="#1E1283" align="left" scope="col"><strong id="회원관리페이지최상단"> &nbsp;포스팅 수정하기</strong></th>
  		</tr>
	</table>
	
	
	<form method="post" name="otherForm">  
     	<!--순서대로 hidden tag안 값들 기입=1은 여행일정, 2은 여행준비물, 3은 동행자 찾기, 4는 일반글  -->
  	 	<!-- Hidden Tag 집어 넣기 -->
<input type="hidden" value="${requestScope.postingCode }" name="postingCode"/>
    	<!-- Hidden Tag 집어 넣기 -->
    	
    	<c:if test="${requestScope.postingPurposeCode eq '1'}">
    	<div id="tourPlan" style="width: 500px; height: 156px;  z-index: 1; ">
    	<input type="radio" name="divide" value="tourPlan" onclick="div_OnOff(this.value, 'tourPlan');" checked>여행일정</input>
    	<br></br>
    		<table>
    			<tr>
    				<td>
    				<select name="subCategoryCode">
      					<option  disabled="disabled" selected><카테고리></option>
      					<c:forEach var="category" items="${subCategoryList }">
      					<option value='${category.categoryCode}' label='${category.categoryName }' ></option>
      					</c:forEach>
      				</select>
      				</td>
      				<td colspan='4'>
      					<input type="text" name="tourPlanTitle" size="44" placeholder="제목을 입력하세요" required/>
      				</td>
      			</tr>
      			<tr>
					<td>
						<select name='widget1' id='destination1'>
    						<option disabled="disabled" selected>여행장소(시)</option>
    						<option value='서울특별시'>서울특별시</option>
    						<option value="인천광역시">인천광역시</option>
    						<option value="경기도">경기도</option>
    					</select>
					</td>
					<td>
						<select name='widget3' id='destination3'>  
    						<option disabled="disabled" value="수지구"selected>여행장소(구)</option>  
    						<option value='용인시'>용인시</option>  	
    					</select>
					</td>
				</tr>
    		</table>
    		 
    		<table width="410" border="0" cellpadding="5" id="like">
      			<tr>
    				<td height="110"><img src="../img/graph2.jpg" width="20" height="0" id='rstrG'/><br/></td>
    				<td><img src="../img/graph2.jpg" width="20" height="0" id='hlG'/><br/></td>
    				<td><img src="../img/graph2.jpg" width="20" height="0" id='atrtG'/><br/></td>
    				<td><img src="../img/graph2.jpg" width="20" height="0" id='shpG'/><br/></td>
    				<td><img src="../img/graph2.jpg" width="20" height="0" id='etcG'/><br/></td>
  				</tr>
  				<tr>
    				<td><input type='text' value="0" readonly size="1" name="rstrNum" id="rstrNum" class="score" /></td>
    				<td><input type='text' value="0" readonly size="1" name="hlNum" id="hlNum" class="score"/></td>
    				<td><input type='text' value="0" readonly size="1" name="atrtNum" id="atrtNum" class="score"/></td>
    				<td><input type='text' value="0" readonly size="1" name="shpNum" id="shpNum" class="score"/></td>
    				<td><input type='text' value="0" readonly size="1" name="etcNum" id="etcNum" class="score"/></td>
  				<tr>
    				<th><img src="../img/맛집.png" width="40" height="40" id='rstr'/><br/>맛집</th>
    				<th><img src="../img/힐링.png" width="40" height="40" id='hl'/><br/>힐링</th>
    				<th><img src="../img/관광명소.png" width="40" height="40" id="atrt"/><br/>관광명소</th>
    				<th><img src="../img/쇼핑.png" width="40" height="40" id='shp'/><br/>쇼핑</th>
    				<th><img src="../img/기타.png" width="40" height="40" id='etc'/><br/>기타</th>
  				</tr>
  			</table>
  			<img src="../img/tourplanWrite.png"/>
  			<textarea rows="10" cols="55" name="tourPlanContent"></textarea>
  			
  			<div style="float:right" class="test"><input type="button" value="등 록" id="save" onclick="otherSubmit(1)"/></div>
			<input type="hidden" name="categoryPurposeCode" value="1"/><!-- 여행 일정 -->
    	</div>
  		</c:if>
    	<!-- ---------------------------------------------다음버젼이에요-------------------------------------------------- -->
    	<c:if test="${requestScope.postingPurposeCode eq '2'}">
    	<div id="tourPreparation" style="width: 500px; height: 156px;  z-index: 1; ">
    	<input type="radio" name="divide" value="tourPreparation" onclick="div_OnOff(this.value, 'tourPreparation');" checked>여행준비물</input>
    		<br></br>
    		<table>
    			<tr>
    				<td>
    				<select name="subCategoryCode">
      					<option  disabled="disabled" selected><카테고리></option>
      					<c:forEach var="category" items="${subCategoryList }">
      					<option value='${category.categoryCode}' label='${category.categoryName }' ></option>
      					</c:forEach>
      				</select>
      				</td>
      				<td colspan='4'>
      					<input type="text" name="tourPreparationTitle" size="45" placeholder="제목을 입력하세요" required/>
      				</td>
      			</tr>
      			<tr>
					<td colspan='2'>
						<select name='widget1' id='destination1'>
    						<option disabled="disabled" selected>여행장소(시)</option>
    						<option value='서울특별시'>서울특별시</option>
    						<option value="인천광역시">인천광역시</option>
    						<option value="경기도">경기도</option>
    					</select>
					</td>
					<td colspan='2'>
						<select name='widget3' id='destination3'>  
    						<option disabled="disabled" value="수지구"selected>여행장소(구)</option>  
    						<option value='용인시'>용인시</option>	
    					</select>
					</td>
				</tr>
				<tr>
					<td>여행시작일</td>
					<td><input type="text" id="start" size="12" name="start" readonly></td>
					<td>여행종료일</td>
					<td><input type="text" id="end" size="12" name="end" readonly></td>
				</tr>
    		</table>
    		
    			<img src="../img/tourPreparation.png"/>
    			<textarea rows="10" cols="55" name="tourPreparationContent"></textarea>
    			
				<div style="float:right" class="test"><input type="button" value="등 록" id="save" onclick="otherSubmit(2)"/></div>
    			<input type="hidden" name="categoryPurposeCode" value="2"/><!-- 여행 준비물 -->
    			
      	</div>
      	</c:if>
      	<!-- ---------------------------------------------다음버젼이에요-------------------------------------------------- -->
      	<c:if test="${requestScope.postingPurposeCode eq '3'}">
      	<div id="companion" style="width: 500px; height: 156px;  z-index: 1; ">
      	<input type="radio" name="divide" value="companion" onclick="div_OnOff(this.value, 'companion');" checked>동행자찾기</input>
    		<br></br>
    		<table>
    			<tr>
    				<td>
    				<select name="subCategoryCode">
      					<option  disabled="disabled" selected><카테고리></option>
      					<c:forEach var="category" items="${subCategoryList }">
      					<option value='${category.categoryCode}' label='${category.categoryName }' ></option>
      					</c:forEach>
      				</select>
      				</td>
      				<td colspan='4'>
      					<input type="text" name="companionTitle" size="45" placeholder="제목을 입력하세요" required/>
      				</td>
      			</tr>
      			<tr>
					<td colspan='2'>
						<select name='widget1' id='destination1'>
    						<option disabled="disabled" selected>여행장소(시)</option>
    						<option value='서울특별시'>서울특별시</option>
    						<option value="인천광역시">인천광역시</option>
    						<option value="경기도">경기도</option>
    					</select>
					</td>
					<td colspan='2'>
						<select name='widget3' id='destination3'>  
    						<option disabled="disabled" value="수지구"selected>여행장소(구)</option>  
    						<option value='용인시'>용인시</option>
    					</select>
					</td>
				</tr>
				<tr>
					<td>여행시작일</td>
					<td><input type="text" id="start2" size="12" name="start2" readonly></td>
					<td>여행종료일</td>
					<td><input type="text" id="end2" size="12" name="end2" readonly></td>
				</tr>
				<tr>
					<td>상대 성별</td>
					<td>
						<input type="radio" name="gender" value="male" ">남</input>
						<input type="radio" name="gender" value="female">여</input>
					</td>
					<td>나이대</td>
					<td><input type="text" name="age" size="12"/></td>
				</tr>
    		</table>
    		
    		<img src="../img/companionPosting.png"/>
    		<textarea rows="10" cols="55" name="companionContent"></textarea>
			<div style="float:right" class="test"><input type="button" value="등 록" id="save" onclick="otherSubmit(3)"/></div>
    		<input type="hidden" name="categoryPurposeCode" value="3"/>
      	</div>
      	</c:if>
      	<!-- ---------------------------------------------다음버젼이에요-------------------------------------------------- -->
      	<c:if test="${requestScope.postingPurposeCode eq '4'}">
      	<div id="etcPosting" style="width: 500px; height: 156px;  z-index: 1; ">
      	<input type="radio" name="divide" value="etcPosting" onclick="div_OnOff(this.value, 'etcPosting');" checked>일반글</input>
      	<br></br>
    		<table>
    			<tr>
    				<td>
    				<select name="subCategoryCode">
      					<option  disabled="disabled" selected><카테고리></option>
      					<c:forEach var="category" items="${subCategoryList }">
      					<option value='${category.categoryCode}' label='${category.categoryName }' ></option>
      					</c:forEach>
      				</select>
      				</td>
      				<td colspan='4'>
      					<input type="text" name="etcTitle" size="45" placeholder="제목을 입력하세요" required/>
      				</td>
      			</tr>
      		</table>
      			
				<img src="../img/etcPosting.png"/>
    			<textarea rows="10" cols="55" name="etcContent"></textarea>
				<div style="float:right" class="test"><input type="button" value="등 록" id="save" onclick="otherSubmit(4)"/></div>
    			<input type="hidden" name="categoryPurposeCode" value="4"/>
      	</div>
      	</c:if>
    </form>
    
</body>
</html>