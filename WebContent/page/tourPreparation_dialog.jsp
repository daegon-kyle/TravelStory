<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="dialog-form-p" title="recommend tour preparations">
 	<form>
    <fieldset>
    	<input type="hidden" value="" id="postingCode-p"/>
      	<table width="374" cellpadding="5" class="ui-widget ui-widget-content">
  		<tr>
    		<td width="67" class="some">제목</td>
    		<td colspan="2"><input type="text" name="title-p" id="title-p" value="" class="text ui-widget-content ui-corner-all" size="35" readonly></td>
  			<td class="some">♥&nbsp;&nbsp;<span id="i-like-p"></span></td>
  		</tr>
  		<tr>
   		 	<td class="some">여행장소(시/도)</td>
    		<td width="81"><input type="text" name="destination1-p" id="destination1-p" value="" class="text ui-widget-content ui-corner-all" readonly></td>
    		<td width="84" class="some">여행장소(구)</td>
    		<td width="99"><input type="text" name="destinaion2-p" id="destination2-p" value="" class="text ui-widget-content ui-corner-all" readonly></td>
  		</tr>
  	    <tr>
  			<td class="some">작성날짜</td>
    		<td id="writingDate-p"></td>
    		<td class="some">작성자</td>
    		<td id="writerName-p"></td>
  		</tr>
  		<tr>
    		<td class="some">여행시작일</td>
    		<td id="startDate-p"></td>
    		<td class="some">여행 종료일</td>
    		<td id="endDate-p"></td>
  		</tr>
  		<tr>
    		<td id="guide-p" colspan="2">나의 여행 준비물...</td>
    		<td>&nbsp;</td>
    		<td>&nbsp;</td>
  		</tr>
  		<tr>
    		<td colspan="4"><textarea id="content-p" name="content-p" cols="50" rows="8" readonly></textarea></td>
  		</tr>
	</table>
 	<!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  	</form>
</div>