<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공실 찾기 위젯 -->
<h3>호텔 공실 찾기</h3>
<div id="empty-w">
<form>
    <table id="empty-tb">
      <tr>
        <td>여행지역&nbsp;&nbsp;&nbsp;</td>
        <td><input type='text' class="ch"  name="hotelLocation" required /></td>
      </tr>
      <tr>
        <td>여행날짜&nbsp;&nbsp;&nbsp;</td>
        <td><input type="text" id="emptyRoomDate" size="12" class="ch2" name="availableDate" required/></td>
      </tr>
      <tr>
      	<td>&nbsp;</td>
      	<td id="btn-td-e">
      	<button id='btn-e' type="button"  class="ui-state-default ui-corner-all" onclick="popUpEmptyRoom($('.ch').val(), $('.ch2').val())" style="cursor:pointer">공실 검색</button>
      	</td>
      </tr>
    </table>
    
</form>
</div>