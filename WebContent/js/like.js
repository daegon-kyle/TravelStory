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
			
			if(local1.options[local1.selectedIndex].value == "����Ư����"){	
				$(local2).empty();
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','���ϱ�').text('���ϱ�').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','���Ǳ�').text('���Ǳ�').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','���α�').text('���α�').appendTo(local2);
				$('<option></option>').attr('value','��õ��').text('��õ��').appendTo(local2);
				$('<option></option>').attr('value','�����').text('�����').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','���빮��').text('���빮��').appendTo(local2);
				$('<option></option>').attr('value','���۱�').text('���۱�').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','���빮��').text('���빮��').appendTo(local2);
				$('<option></option>').attr('value','���ʱ�').text('���ʱ�').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
				$('<option></option>').attr('value','���ϱ�').text('���ϱ�').appendTo(local2);
				$('<option></option>').attr('value','���ı�').text('���ı�').appendTo(local2);
				$('<option></option>').attr('value','��õ��').text('��õ��').appendTo(local2);
				$('<option></option>').attr('value','��������').text('��������').appendTo(local2);
				$('<option></option>').attr('value','��걸').text('��걸').appendTo(local2);
				$('<option></option>').attr('value','����').text('����').appendTo(local2);
				$('<option></option>').attr('value','���α�').text('���α�').appendTo(local2);
				$('<option></option>').attr('value','�߱�').text('�߱�').appendTo(local2);
				$('<option></option>').attr('value','�߶���').text('�߶���').appendTo(local2);
			}else if(local1.options[local1.selectedIndex].value == "��õ������"){
				$(local2).empty();
				$('<option></option>').attr('value','��ȭ��').text('��ȭ��').appendTo(local2);
				$('<option></option>').attr('value','��籸').text('��籸').appendTo(local2);
				$('<option></option>').attr('value','����').text('����').appendTo(local2);
				$('<option></option>').attr('value','������').text('������').appendTo(local2);
			}else{
				$(local2).empty();
			}
		};
		
		
};