window.onload=function(){
		document.getElementById('first').onchange=function(){
			
			//var local1 = document.widget1.first;
			//var local2 = document.widget1.second;
			
			var local1 = document.getElementById('first');
			var local2 = document.getElementById('second');
			
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
		
		$( "#start" ).datepicker( $.datepicker.regional[ "kr" ] );
		$( "#locale" ).change(function() {
			$( "#start" ).datepicker( "option",
				$.datepicker.regional[ $( this ).val() ] );
		});
		
		$( "#end" ).datepicker( $.datepicker.regional[ "kr" ] );
		$( "#locale" ).change(function() {
			$( "#end" ).datepicker( "option",
				$.datepicker.regional[ $( this ).val() ] );
		});
	};