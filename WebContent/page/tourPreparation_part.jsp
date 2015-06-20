<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>여행 준비물 추천</h3>
<div id="tourPreparation-w">
<table>
	<tr>
    	<td width="189">
    	<select name='si-p' class='si-p' onchange="si_change_p()">
    		<option>지역선택</option>
    		<option value="서울">서울</option>
    		<option value="부산">부산</option>
    		<option value="대구">대구</option>
    		<option value="인천">인천</option>
    		<option value="광주">광주</option>
    		<option value="대전">대전</option>
    		<option value="울산">울산</option>
    		<option value="강원">강원</option>
    		<option value="경기">경기</option>
    		<option value="경남">경남</option>
    		<option value="경북">경북</option>
    		<option value="전남">전남</option>
    		<option value="전북">전북</option>
    		<option value="제주">제주</option>
    		<option value="충남">충남</option>
    		<option value="충북">충북</option>
   	 	</select>
   		</td>
    	<td width="182">
    	<select name='gu-p' class='gu-p'>  
    		<option></option>  	
    	</select>
	</tr>
	<tr>
		<td>여행시작일</td>
		<td><input type="text" id="start-p" size="12" name="start-p" readonly></td>
	</tr>
	<tr>
		<td>여행종료일</td>
		<td><input type="text" id="end-p" size="12" name="end-p" readonly></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	<tr>
		<td>&nbsp;</td>
		<td id="btn-td-p"><button type="submit" id="btn-p" class="ui-state-default ui-corner-all" onclick='loadSearch_p()'>추천 받기</button></td>
	</tr>
	</table>
</div>