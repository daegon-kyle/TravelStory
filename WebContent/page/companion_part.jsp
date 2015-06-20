<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>동행자 찾기</h3>
<div id="companion-w">
<table id="table-c">
  <tr>
    <td colspan="2">
    <select name='si-c' class='si-c' onchange="si_change()">
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
    <select name='gu-c' class='gu-c'>  
    	<option value=""></option>  	
    </select>
    </td>
  </tr>
  <tr>
    <td width="87">여행시작일</td>
    <td width="108"><input type="text" id="start-c" size="12" readonly></td>
  </tr>
  <tr>
    <td>여행종료일</td>
    <td><input type="text" id="end-c" size="12" readonly></td>
  </tr>
  <tr>
    <td>동행자성별</td>
    <td>
        <label>
          <input name="gender" type="radio" id="gender_0-c" value="남" checked class="ra-c">
          남</label>
        <label>
            <input type="radio" name="gender" value="여" id="gender_1-c" class="ra-c">
          여</label>
  </td>
  </tr>
  <tr>
    <td>연령대</td>
    <td><select name="age-c" id="age-c">
      <option value="20" selected="selected">20대</option>
      <option value="30">30대</option>
      <option value="40">40대</option>
      <option value="etc">그 이상</option>
    </select></td>
  </tr>
  <tr>
    <td colspan="2" id="btn-td-c"><button type="button" id="btn-c">동행 구하기</button></td>
  </tr>
</table>
</div>