// JavaScript Document
window.onload=function(){
		var healingCnt = 0;
		var restaurantCnt = 0;
		var attractionCnt = 0;
		var etcCnt = 0;
		var shoppingCnt = 0;
		document.getElementById('hl').onclick=function(){
			var label = document.getElementById('hlNum');
			var hei = document.getElementById('hlG');
			if(healingCnt== 5){
				healingCnt=0;
			}else{
				healingCnt++;
			}
			label.setAttribute('value',healingCnt);
			hei.setAttribute('height', healingCnt*20);
		};
		document.getElementById('rstr').onclick=function(){
			var label = document.getElementById('rstrNum');
			var hei = document.getElementById("rstrG");
			if(restaurantCnt== 5){
				restaurantCnt=0;
			}else{
				restaurantCnt++;
			}
			label.setAttribute('value',restaurantCnt);
			hei.setAttribute('height', restaurantCnt*20);
		};
		document.getElementById('atrt').onclick=function(){
			var label = document.getElementById('atrtNum');
			var hei = document.getElementById('atrtG');
			if(attractionCnt== 5){
				attractionCnt=0;
			}else{
				attractionCnt++;
			}
			label.setAttribute('value',attractionCnt);
			hei.setAttribute('height', attractionCnt*20);
		};
		document.getElementById('etc').onclick=function(){
			var label = document.getElementById('etcNum');
			var hei = document.getElementById('etcG');
			if(etcCnt== 5){
				etcCnt=0;
			}else{
				etcCnt++;
			}
			label.setAttribute('value',etcCnt);
			hei.setAttribute('height', etcCnt*20);
		};
		document.getElementById('shp').onclick=function(){
			var label = document.getElementById('shpNum');
			var hei = document.getElementById('shpG');
			if(shoppingCnt== 5){
				shoppingCnt=0;
			}else{
				shoppingCnt++;
			}
			label.setAttribute('value',shoppingCnt);
			hei.setAttribute('height', shoppingCnt*20);
		};
		
document.getElementById('widgetDest1').onchange=function(){
			
			var local1 = document.widgetDest1.widgetDest1;
			document.wirteln(local1);
			var local2 = document.widget1.widgetDest2;
			
			if(local1.options[local1.selectedIndex].value == "서울특별시"){	
				$(local2).empty();
				$('<option></option>').attr('value','강남구').text('강남구').appendTo(local2);
				$('<option></option>').attr('value','강동구').text('강동구').appendTo(local2);
				$('<option></option>').attr('value','강북구').text('강북구').appendTo(local2);
				$('<option></option>').attr('value','강서구').text('강서구').appendTo(local2);
				$('<option></option>').attr('value','관악구').text('관악구').appendTo(local2);
				$('<option></option>').attr('value','광진구').text('광진구').appendTo(local2);
				$('<option></option>').attr('value','구로구').text('구로구').appendTo(local2);
				$('<option></option>').attr('value','금천구').text('금천구').appendTo(local2);
				$('<option></option>').attr('value','노원구').text('노원구').appendTo(local2);
				$('<option></option>').attr('value','도봉구').text('도봉구').appendTo(local2);
				$('<option></option>').attr('value','동대문구').text('동대문구').appendTo(local2);
				$('<option></option>').attr('value','동작구').text('동작구').appendTo(local2);
				$('<option></option>').attr('value','마포구').text('마포구').appendTo(local2);
				$('<option></option>').attr('value','서대문구').text('서대문구').appendTo(local2);
				$('<option></option>').attr('value','서초구').text('서초구').appendTo(local2);
				$('<option></option>').attr('value','성동구').text('성동구').appendTo(local2);
				$('<option></option>').attr('value','성북구').text('성북구').appendTo(local2);
				$('<option></option>').attr('value','송파구').text('송파구').appendTo(local2);
				$('<option></option>').attr('value','양천구').text('양천구').appendTo(local2);
				$('<option></option>').attr('value','영등포구').text('영등포구').appendTo(local2);
				$('<option></option>').attr('value','용산구').text('용산구').appendTo(local2);
				$('<option></option>').attr('value','은평구').text('은평구').appendTo(local2);
				$('<option></option>').attr('value','종로구').text('종로구').appendTo(local2);
				$('<option></option>').attr('value','중구').text('중구').appendTo(local2);
				$('<option></option>').attr('value','중랑구').text('중랑구').appendTo(local2);
			}else if(local1.options[local1.selectedIndex].value == "인천광역시"){
				$(local2).empty();
				$('<option></option>').attr('value','강화군').text('강화군').appendTo(local2);
				$('<option></option>').attr('value','계양구').text('계양구').appendTo(local2);
				$('<option></option>').attr('value','남구').text('남구').appendTo(local2);
				$('<option></option>').attr('value','남동구').text('남동구').appendTo(local2);
			}else{
				$(local2).empty();
			}
		};
		
		
};