<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>여행일정 추천</h3>
<div id="tourPlan-w">
<table>
<tr>
<td>
	<select class='si-t' name='si-t'  onchange="si_change_t()">
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
<td>
    <select name='gu-t' class='gu-t'>  
    	<option></option>  	
    </select> 
</td>
</tr>
<tr>
<td colspan="2">
  <table id="like-t">
  <tr>
    <td height="110" width="40"><img src="../img/graph2.jpg" width="15" height="0" id='rstrG'/><br/></td>
    <td width="40"><img src="../img/graph2.jpg" width="15" height="0" id='hlG'/><br/></td>
    <td width="80"><img src="../img/graph2.jpg" width="15" height="0" id='atrtG'/><br/></td>
    <td width="40"><img src="../img/graph2.jpg" width="15" height="0" id='shpG'/><br/></td>
    <td width="40"><img src="../img/graph2.jpg" width="15" height="0" id='etcG'/><br/></td>
  </tr>
  <tr>
    <td id="rstrNum">0</td>
    <td id="hlNum">0</td>
    <td id="atrtNum">0</td>
    <td id="shpNum">0</td>
    <td id="etcNum">0</td>
  </tr>
  <tr>
    <th height="40"><img src="../img/rstr.png" width="25" height="25" id='rstr' onclick="up_restaurant()"/><br/>맛집</th>
    <th><img src="../img/hl.png" width="25" height="25" id='hl' onclick="up_healing()"/><br/>힐링</th>
    <th><img src="../img/atrt.png" width="25" height="25" id="atrt" onclick="up_attraction()"/><br/>관광명소</th>
    <th><img src="../img/shp.png" width="25" height="25" id='shp' onclick="up_shopping()"/><br/>쇼핑</th>
    <th><img src="../img/etc.png" width="25" height="25" id='etc' onclick="up_etc()"/><br/>기타</th>
  </tr>
  </table>
</td>
<tr>
<td>&nbsp;</td>
<td id="btn-td-t"><button type="button" id="btn-t-s">추천받기</button></td>
</tr>
</table>
</div>