<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<!-- 개개인 페이지를 만들기 위해 이 페이지를 복사하여 이름을 바꾸어 사용하길 바람. -->
		<!-- main jsp 부분에 각 개인 페이지를 만들면 됨 -->
		<%@ include file="/main.jsp"%><!-- 이 한줄 위치에 추가하여 사용하면됨 -->
	</div>
</div>
<%@ include file="/footer.jsp"%>