<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../javascript/jquery.cookie.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/redmond/jquery-ui.css" />
<script>
$(function(){
	$( "#accordion" ).accordion({
	      collapsible: true,
	      heightStyle: "content"
	    });
	/*동행자 추천을 위한 jQeury*/
	
	$( "#start-c" ).datepicker({ 
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
			$('#end-c').datepicker("option","minDate", selectedDate); 
		} 
	 }); 
     $( "#end-c" ).datepicker({ 
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
  			$('#start-c').datepicker("option","maxDate", selectedDate); 
  		} 
  	});  
    $("#btn-c").button().bind("click", function() {
    	loadSearch_c();
    }); 
 	// 다이아 로그를 띄 울려면 ready안에 있어야 함
	// 바깥 쪽에 있으면 처음부터 나와 버림;;;;;;
	$("#dialog-form-c").dialog({
	    	autoOpen:false,
	    	height:400,
	    	width:460,
	    	//modal:true,
	    	buttons:{
		    	"닫기":function(){
		    		$(this).dialog("close");
		    	}
		   	},
		   	close:function(){
		    		
		    }
	});
	//////////////////////////////////////////////////////////////////////////////////////////////////////여행 준비물
	$( "#start-p" ).datepicker({ 
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
			$('#end-p').datepicker("option","minDate", selectedDate); 
		} 
	}); 
    $( "#end-p" ).datepicker({ 
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
  			$('#start-p').datepicker("option","maxDate", selectedDate); 
  		} 
  	}); 
    $("#dialog-form-p").dialog({
    	autoOpen:false,
    	height:400,
    	width:460,
    	//modal:true,
    	buttons:{
	    	"♥":addLike_p,
	    	"닫기":function(){
	    		$("#dialog-form-p").dialog("close");
	    	}
	   	},
	   	close:function(){
	    		
	    }
	});
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	$("#btn-t-s").button().bind("click", function(){
		loadSearch_t();
	});
	$("#dialog-form-t").dialog({
    	autoOpen:false,
    	height:600,
    	width:460,
    	//modal:true,
    	buttons:{
	    	"♥":addLike_t,
	    	"닫기":function(){
	    		$("#dialog-form-t").dialog("close");
	    	}
	   	},
	   	close:function(){
	    		
	    }
	});
	////////////////////////////////////////////////////////////////////////////////////////////////////////공실 찾기
	$('#emptyRoomDate').val($.datepicker.formatDate($.datepicker.ATOM, new Date()));
	$( "#emptyRoomDate" ).datepicker({ 
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
/////////////////////////////////////////////////////////////////////////////////////////////////////공실 찾기
function popUpEmptyRoom(checkedData, checkedData2)
{
	var hotelLocation = checkedData;
	var availableDate = checkedData2;
	alert(hotelLocation+", "+availableDate);
	window.open("emptyRoomSearchButton?availableDate="+availableDate+"&hotelLocation="+hotelLocation, "_blank", "toolbar=no, scrollbars=no, resizable=no, top=50, left=500, width=970, height=757");
} 
////////////////////////////////// 쿠키 관련 함수 //////////////////////////////////////////////////////////
var cookieList = function(cookieName){
	var cookie = $.cookie(cookieName);
	var items = cookie ? cookie.split(/,/) : new Array();
	
	return{
		"add": function(val){
			// items에 더하기
			items.push(val);
			$.cookie(cookieName, items.join(','));
		},
		"clear": function(){
			items = null;
			// 쿠키 지우기
			$.cookie(cookieName, null);
		},
		"items": function(){
			// items가져오기
			return items;
		}
	};
};
function check_cookie(key){
	var cookie = new cookieList("doneLike");
	var list = cookie.items();
	if($.inArray(key, list)==-1)
	{// 쿠키에 없음
		return false;	
	}
	else{ // 쿠키에 있음
		return true;
	}
}
function add_cookie(key){
	var cookie = new cookieList("doneLike");
	cookie.add(key);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
function row_hover(){
	$(".search-result").hover(
			function(){  //마우스가 올라갔을때
				$(this).css('background', '#FF8C00');
				$(this).css('color', '#000080');
			},
			function(){	// 마우스가 떨어졌을 떄
				$(this).css('background', 'none');
				$(this).css('color', 'black');
			}
	);
}
	var seoul = ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"];
	var busan = ["강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군"];

/////////////////////////////////////////////////////////////////////////////////////////////////////동행자 찾기
	var main=""; // 동행자 찾기의 메인
function si_change(){
	var sel = $(".si-c option:selected").val();  // 선택된 값 받아오기
	var op = "";
	if(sel=="서울"){
		$.each(seoul, function(index, item){
			op += "<option value="+item+">"+item+"</option>";
		});
	}
	else if(sel=="부산"){
		$.each(busan, function(index, item){
			op += "<option value="+item+">"+item+"</option>";
		});
	}
	$(".gu-c").html(op);
}
// 입력한 조건을 가지고 검색하기
function loadSearch_c(){
	var si = $(".si-c option:selected").val();
	var gu = $(".gu-c option:selected").val();
	var sd = $("#start-c").val();
	var ed = $("#end-c").val();
	var gender = $(".ra-c:checked").val();
	var age = $("#age-c option:selected").val();
	var result="<form><h1 class='result-title'><span id='back-c' onclick='backPage_c()'>◀&nbsp;&nbsp;</span>동행자 추천 목록</h1><table id='companionT' class='ui-widget ui-widget-content result-contain'><thead><tr class='ui-widget-header'><th>제목</th><th>작성일</th><th>작성자</th><th>신뢰도</th></thead><tbody>";
	$.ajax({
		type:"POST",
		url:"CompanionRecommend",
		dataType:"json",
		data:{
			destination1:si,
			destination2:gu,
			startDate:sd,
			endDate:ed,
			otherGender:gender,
			otherAge:age
		},
		error:function(r){
			alert("error");
		},
		success:function(data){
			if(data==""){
				result+="<tr><td colspan='4'>검색결과가 없습니다.</td></tr>";
			}
			else{
			$.each(data, function(index, item){
				result+="<tr class='search-result'>";
				result+=("<td><input type='radio' value="+item.postingCode+" class='ch-c' name='ch-c'>"+item.title+"</td>");
				result+=("<td>"+item.writingDate+"</td>");
				result+=("<td>"+item.writerName+"</td>");
				result+=("<td class='m-like-c'>"+item.likeNum+"</td></tr>");
			});
			}
			result+="</tbody></table><button type='button' id='btn-c-2' class='ui-state-default ui-corner-all' onclick='companionRecodataload()'>상세보기</button></form>";
			main=$("#companion-w").html();
			$("#companion-w").html(result);
		}
	});
}
function companionRecodataload(){
	var postingCode = $(".ch-c:checked").val();
	$.getJSON(
            'CompanionRecommend?postingCode='+postingCode, 
            {format: 'json'},                
            function(data) {
                    $("#postingCode-c").val(data.postingCode);
                	$("#title-c").val(data.title);
                	$("#i-rel-c").html(data.reliability);
                	$("#destination1-c").val(data.destination1);
                	$("#destination2-c").val(data.destination2);
                	$("#writingDate-c").html(data.writingDate);
                	$("#writerName-c").html(data.writerName);
                	$("#startDate-c").html(data.startDate);
                	$("#endDate-c").html(data.endDate);
                	$("#gender-c").html(data.otherGender);
                	$("#age-c").html(data.otherAge);
                	$("#content-c").html(data.content);
                	$("#dialog-form-c").dialog("open");
            });
}
// 결과 목록에서 다시 검색 창으로 돌아가기
function backPage_c(){
	//alert(main);
	$("#companion-w").html(main);
	/* 달력 다시 달기 */
	if($("#start-c").hasClass('hasDatepicker') == true) {
         $("#start-c").siblings('.ui-datepicker-trigger,.ui-datepicker-apply').remove();
         $("#start-c")
         .removeClass('hasDatepicker')
         .removeData('datepicker')
         .unbind().datepicker({ 
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
    			$('#end-c').datepicker("option","minDate", selectedDate); 
    		} 
    	 });
    }
	if($("#end-c").hasClass('hasDatepicker') == true) {
        $("#end-c").siblings('.ui-datepicker-trigger,.ui-datepicker-apply').remove();
        $("#end-c")
        .removeClass('hasDatepicker')
        .removeData('datepicker')
        .unbind().datepicker({ 
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
   			$('#start-c').datepicker("option","maxDate", selectedDate); 
   		} 
   	 });
    }
	
	$("#btn-c").removeClass("ui-button").removeClass("ui-widget").removeClass("ui-state-default").removeClass("ui-corner-all").removeClass("ui-button-text-only").removeClass("ui-state-hover").removeClass("ui-state-focus").html("동행구하기");
	$("#btn-c").button().bind("click", function() {
    	loadSearch_c();
    });
	$(".gu-c").empty();
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////여행 일정 추천
function si_change_t(){
	var sel = $(".si-t option:selected").val();  // 선택된 값 받아오기
	var op = "";
	if(sel=="서울"){
		$.each(seoul, function(index, item){
			op += "<option value="+item+">"+item+"</option>";
		});
	}
	else if(sel=="부산"){
		$.each(busan, function(index, item){
			op += "<option value="+item+">"+item+"</option>";
		});
	}
	$(".gu-t").html(op);
}
/* 여행 일정 추천에서 취향 선택을 위한 jQeurt*/
var restaurantCnt=0;
var healingCnt=0;
var attractionCnt=0;
var shoppingCnt=0;
var etcCnt=0;
function up_restaurant(){
	if(restaurantCnt==5){
		restaurantCnt=0;
	}
	else{
		restaurantCnt++;
	}
	$("#rstrNum").html(restaurantCnt);
	$("#rstrG").attr("height", restaurantCnt*15);
}
function up_healing(){
	if(healingCnt==5){
		healingCnt=0;
	}
	else{
		healingCnt++;
	}
	$("#hlNum").html(healingCnt);
	$("#hlG").attr("height", healingCnt*15);
}
function up_attraction(){
	if(attractionCnt==5){
		attractionCnt=0;
	}
	else{
		attractionCnt++;
	}
	$("#atrtNum").html(attractionCnt);
	$("#atrtG").attr("height", attractionCnt*15);
}
function up_shopping(){
	if(shoppingCnt==5){
		shoppingCnt=0;
	}
	else{
		shoppingCnt++;
	}
	$("#shpNum").html(shoppingCnt);
	$("#shpG").attr("height", shoppingCnt*15);
}
function up_etc(){
	if(etcCnt==5){
		etcCnt=0;
	}
	else{
		etcCnt++;
	}
	$("#etcNum").html(etcCnt);
	$("#etcG").attr("height", etcCnt*15);
}
var main_t = ""; // 여행 일정의 메인
function loadSearch_t(){
	var si = $(".si-t option:selected").val(); // 시/도
	var gu = $(".gu-t option:selected").val(); // 구/군
	var rstr = $("#rstrNum").html(); // 맛집
	var hl = $("#hlNum").html(); // 힐링
	var atrt = $("#atrtNum").html(); // 관광명소
	var shp = $("#shpNum").html(); // 쇼핑
	var etc = $("#etcNum").html();    // 기타
	var result = "<form><h1 class='result-title'><span id='back-t' onclick='backPage_t()'>◀&nbsp;&nbsp;</span>여행 일정 추천 목록</h1><table id='tourPlanT' class='ui-widget ui-widget-content result-contain'><thead><tr class='ui-widget-header'><th>제목</th><th>작성일</th><th>작성자</th><th>좋아요</th></tr></thead><tbody>";
	$.ajax({
		type:"POST",
		url:"../TourPlan",
		dataType:"json",
		data:{
			destination1:si,
			destination2:gu,
			restaurant:rstr,
			healing:hl,
		 	attraction:atrt,
		 	shopping:shp,
		 	etcNum:etc
		},
		error:function(){
			alert("error");
		},
		success:function(data){
			if(data==""){
				result+="<tr><td colspan='4'>검색결과가 없습니다.</td></tr>";
			}
			else{
				$.each(data, function(index, item){
					result+="<tr class='search-result'>";
					result+=("<td><input type='radio' value="+item.postingCode+" class='ch-t' name='ch-t'>"+item.title+"</td>");
					result+=("<td>"+item.writingDate+"</td>");
					result+=("<td>"+item.writerName+"</td>");
					result+=("<td class='m-like-t'>"+item.likeNum+"</td></tr>");
				});
			}
			result+="</tbody></table><button type='button' id='btn-t-2' class='ui-state-default ui-corner-all' onclick='tourPlanRecodataload()'>상세보기</button></form>";
			main_t=$("#tourPlan-w").html();
			$("#tourPlan-w").html(result);
		}
	});
}
function tourPlanRecodataload(){
	var postingCode=$(".ch-t:checked").val(); // 선택된 포스팅 코드
	$.getJSON(
		'TourPlan?postingCode='+postingCode,
		{format: 'json'},
		function(data){
			$("#postingCode-t").val(data.postingCode);
        	$("#title-t").val(data.title);
        	$("#i-like-t").html(data.likeNum);
        	$("#destination1-t").val(data.destination1);
        	$("#destination2-t").val(data.destination2);
        	$("#writingDate-t").html(data.writingDate);
        	$("#writerName-t").html(data.writerName);
        	$("#rstrG-t").attr('height', data.restaurantPreference*20);
        	$("#hlG-t").attr('height', data.healingPreference*20);
        	$("#atrtG-t").attr('height', data.attractionPreference*20);
        	$("#shpG-t").attr('height', data.shoppingPreference*20);
        	$("#etcG-t").attr('height', data.etcPreference*20);
        	$("#rstrNum-t").html(data.restaurantPreference);
        	$("#hlNum-t").html(data.healingPreference);
        	$("#atrtNum-t").html(data.attractionPreference);
        	$("#shpNum-t").html(data.shoppingPreference);
        	$("#etcNum-t").html(data.etcPreference);
        	$("#content-t").html(data.content);
        	$("#dialog-form-t").dialog("open");
		});
}
function addLike_t(){  // 여행 일정 포스팅에 쿠키로 막기
	var postingCode=$("#postingCode-t").val(); 
	var re = check_cookie(postingCode);
	if(re==false){
	$.getJSON(
    	'../likeUp?likeAdd='+postingCode,
    	{format: 'json'},
    	function(data){
    		$("#i-like-t").html(data.likeNum);
    	}
    );
	add_cookie(postingCode);
	}
	else{
		alert("이미 좋아요를 한 포스팅 입니다.");
	}
}
function backPage_t(){
	$("#tourPlan-w").html(main_t);  // 원래의 html문으로..
	$("#btn-t-s").removeClass("ui-button").removeClass("ui-widget").removeClass("ui-state-default").removeClass("ui-corner-all").removeClass("ui-button-text-only").removeClass("ui-state-hover").removeClass("ui-state-focus").html("추천받기");
	$("#btn-t-s").button().bind("click", function() {
    	loadSearch_t();
    });
	$(".gu-t").empty();   // 여행 장소(구/군) 지우기
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////여행 준비물 추천
var main_p=""; // 여행 준비물 추천의 메인
function si_change_p(){
	var si = $(".si-p option:selected").val();
	var gu="";
	if(si=='서울'){
		$.each(seoul, function(index, item){
			gu += "<option value="+item+">"+item+"</option>"; 
		});
	}
	else if(si=='부산'){
		$.each(busan, function(index, item){
			gu += "<option value="+item+">"+item+"</option>"; 
		});
	}
	$(".gu-p").html(gu);
}
function loadSearch_p(){
	var si = $(".si-p option:selected").val();
	var gu = $(".gu-p option:selected").val();
	var start = $("#start-p").val();
	var end = $("#end-p").val();
	var result="<form><h1 class='result-title'><span id='back-p' onclick='backPage_p()'>◀&nbsp;&nbsp;</span>여행 준비물 추천 목록</h1><table id='tourPreparation' class='ui-widget ui-widget-content result-contain'><thead><tr class='ui-widget-header'><th>제목</th><th>작성일</th><th>작성자</th><th>좋아요</th></thead><tbody>";
	$.ajax({
		type:"POST",
		url:"TourPreparation",
		dataType:"json",
		data:{
			destination1:si,
			destination2:gu,
			startDate:start,
			endDate:end
		},
		error:function(){
			alert("error");
		},
		success:function(data){
			if(data==""){
				result+="<tr colspan='4'>검색결과가 없습니다.</td></tr>";
			}
			else{
				$.each(data, function(index, item){
					result+="<tr class='search-result'>";
					result+=("<td><input type='radio' value="+item.postingCode+" class='ch-p' name='ch-p'/>"+item.title+"</td>");
					result+=("<td>"+item.writingDate+"</td>");
					result+=("<td>"+item.writerName+"</td>");
					result+=("<td class='m-like-p'>"+item.likeNum+"</td></tr>");
				});
			}
			result+="</tbody></table><button type='button' id='btn-p-2' class='ui-state-default ui-corner-all' onclick='tourPreparationRecoload()'>상세보기</button></form>";
			main_p=$("#tourPreparation-w").html();
			$("#tourPreparation-w").html(result);
		}
	});
}
function tourPreparationRecoload(){
	var postingCode = $(".ch-p:checked").val();
	$.getJSON(
            'TourPreparation?postingCode='+postingCode, 
            {format: 'json'},                
            function(data) {
                    $("#postingCode-p").val(data.postingCode);
                	$("#title-p").val(data.title);
                	$("#i-like-p").html(data.likeNum);
                	$("#destination1-p").val(data.destination1);
                	$("#destination2-p").val(data.destination2);
                	$("#writingDate-p").html(data.writingDate);
                	$("#writerName-p").html(data.writerName);
                	$("#startDate-p").html(data.startDate);
                	$("#endDate-p").html(data.endDate);
                	$("#content-p").html(data.content);
                	$("#dialog-form-p").dialog("open");
    });
}
function addLike_p(){  // 여행 준비물 포스팅에 쿠키로 막기
	var postingCode=$("#postingCode-p").val(); 
	var check = check_cookie(postingCode);
	if(check == false){  // 쿠키에 없을 경우
		$.getJSON(
    		'TourPreparationLike?likeAdd='+postingCode,
    		{format: 'json'},
    		function(data){
    			$("#i-like-p").html(data.likeNum);
    		}
    	);
		add_cookie(postingCode);
	}
	else{
		alert("이미 좋아요를 한 포스팅입니다.");
	}
}
function backPage_p(){
	$("#tourPreparation-w").html(main_p);
	/* 달력 다시 달기 */
	if($("#start-p").hasClass('hasDatepicker') == true) {
         $("#start-p").siblings('.ui-datepicker-trigger,.ui-datepicker-apply').remove();
         $("#start-p")
         .removeClass('hasDatepicker')
         .removeData('datepicker')
         .unbind().datepicker({ 
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
    			$('#end-p').datepicker("option","minDate", selectedDate); 
    		} 
    	 });
    }
	if($("#end-p").hasClass('hasDatepicker') == true) {
        $("#end-p").siblings('.ui-datepicker-trigger,.ui-datepicker-apply').remove();
        $("#end-p")
        .removeClass('hasDatepicker')
        .removeData('datepicker')
        .unbind().datepicker({ 
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
   			$('#start-p').datepicker("option","maxDate", selectedDate); 
   		} 
   	 });
    }
	$(".gu-p").empty();
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
</script>
<style type="text/css">@import url(../css/widget.css);</style>
</head>
<body id="wid-all">
	<div id="accordion">
  	<!-- 여행 일정 추천 -->
  	<jsp:include page="tourPlan_part.jsp"/>
  	<!-- 여행 준비물 추천 -->
    <jsp:include page="tourPreparation_part.jsp"/>
  	<!-- 동행자 찾기 -->
	<c:import url="companion_part.jsp"/>
  	<!-- 공실 검색 -->
  	<jsp:include page="emptyRoom_part.jsp"/>
</div>

<!-- 다이아로그 - 동행자 찾기 -->
<jsp:include page="companion_dialog.jsp"/>
<!-- 다이아로그 - 여행일정 찾기 -->
<jsp:include page="tourPlan_dialog.jsp"/>
<!-- 다이아로그 여행 준비물 추천 -->
<jsp:include page="tourPreparation_dialog.jsp"/>
</body>
</html>