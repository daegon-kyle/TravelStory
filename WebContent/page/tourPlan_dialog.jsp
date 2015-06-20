<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 다이아로그 - 여행일정 찾기 -->
<div id="dialog-form-t" title="여행 일정 추천!!!">
 	<form>
    <fieldset>
    	<input type="hidden" value="" id="postingCode-t"/>
      	<table width="374" cellpadding="5" class="ui-widget ui-widget-content">
  		<tr>
    		<td width="67" class="some">제목</td>
    		<td colspan="2"><input type="text" name="title" id="title-t" value="" class="text ui-widget-content ui-corner-all" size="35" readonly></td>
  			<td class="some">♥&nbsp;&nbsp;<span id="i-like-t"></span></td>
  		</tr>
  		<tr>
   		 	<td class="some">여행장소(시/도)</td>
    		<td width="81"><input type="text" name="destination1-t" id="destination1-t" value="" class="text ui-widget-content ui-corner-all" readonly></td>
    		<td width="84" class="some">여행장소(구)</td>
    		<td width="99"><input type="text" name="destinaion2-t" id="destination2-t" value="" class="text ui-widget-content ui-corner-all" readonly></td>
  		</tr>
  	    <tr>
  			<td class="some">작성날짜</td>
    		<td id="writingDate-t"></td>
    		<td class="some">작성자</td>
    		<td id="writerName-t"></td>
  		</tr>
  		<tr>
    		<td colspan="4">
    		<table width="281" border="0" cellpadding="5" id="preference-t">
  			<tr>
    			<td width="36" height="109"><img src="../img/graph2.jpg" width="15" height="0" id='rstrG-t'/><br/></td>
    			<td width="41"><img src="../img/graph2.jpg" width="15" height="0" id='hlG-t'/><br/></td>
    			<td width="59"><img src="../img/graph2.jpg" width="15" height="0" id='atrtG-t'/><br/></td>
    			<td width="38"><img src="../img/graph2.jpg" width="15" height="0" id='shpG-t'/><br/></td>
    			<td width="45"><img src="../img/graph2.jpg" width="15" height="0" id='etcG-t'/><br/></td>
  			</tr>
  			<tr>
    			<td id="rstrNum-t">0</td>
    			<td id="hlNum-t">0</td>
    			<td id="atrtNum-t">0</td>
    			<td id="shpNum-t">0</td>
    			<td id="etcNum-t">0</td>
  			</tr>
  			<tr>
    			<th><img src="../img/rstr.png" width="20" height="20"/><br/>맛집</th>
    			<th><img src="../img/hl.png" width="20" height="20"/><br/>힐링</th>
    			<th><img src="../img/atrt.png" width="20" height="20"/><br/>관광명소</th>
    			<th><img src="../img/shp.png" width="20" height="20"/><br/>쇼핑</th>
    			<th><img src="../img/etc.png" width="20" height="20"/><br/>기타</th>
  			</tr>
			</table>
    		</td>
  		</tr>
  		<tr>
    		<td id="guide-t">여행일정</td>
    		<td>&nbsp;</td>
    		<td>&nbsp;</td>
    		<td>&nbsp;</td>
  		</tr>
  		<tr>
    		<td colspan="4"><textarea id="content-t" name="content-t" cols="50" rows="8" readonly></textarea></td>
  		</tr>
	</table>
 
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  	</form>
</div>
