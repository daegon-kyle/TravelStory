window.onload=function(){
		
		var healingCnt = 0;
		var restaurantCnt = 0;
		var attractionCnt = 0;
		var etcCnt = 0;
		var shoppingCnt = 0;
		document.getElementById('healing').onclick=function(){
			var label = document.getElementById('healingNum');
			if(healingCnt== 5){
				healingCnt=0;
				label.setAttribute('value','0');
			}else{
				healingCnt++;
				label.setAttribute('value',healingCnt);
			}
		};
		document.getElementById('restaurant').onclick=function(){
			var label = document.getElementById('restaurantNum');
			if(restaurantCnt== 5){
				restaurantCnt=0;
				label.setAttribute('value','0');
				
			}else{
				restaurantCnt++;
				label.setAttribute('value',restaurantCnt);
			}
		};
		document.getElementById('attraction').onclick=function(){
			var label = document.getElementById('attractionNum');
			if(attractionCnt== 5){
				attractionCnt=0;
				label.setAttribute('value','0');
			}else{
				attractionCnt++;
				label.setAttribute('value',attractionCnt);
			}
		};
		document.getElementById('etc').onclick=function(){
			var label = document.getElementById('etcNum');
			if(etcCnt== 5){
				etcCnt=0;
				label.setAttribute('value','0');
			}else{
				etcCnt++;
				label.setAttribute('value',etcCnt);
			}
		};
		document.getElementById('shoping').onclick=function(){
			var label = document.getElementById('shoppingNum');
			if(shoppingCnt== 5){
				shoppingCnt=0;
				label.setAttribute('value','0');
			}else{
				shoppingCnt++;
				label.setAttribute('value',shoppingCnt);
			}
		};
		
		document.getElementById('destination1').onchange=function(){
			
			var local1 = document.widget1.destination1;
			var local2 = document.widget3.destination3;
			
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
		
		document.getElementById('destination2').onchange=function(){
			
			var local1 = document.widget2.destination1;
			var local2 = document.widget2.destination2;
			document.writeln(local1);
			document.writeln(local2);
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