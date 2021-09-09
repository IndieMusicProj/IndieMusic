<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<style>
.adminMain {
	text-align: center;
}
</style>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/adminMode/asideBar.jsp"%></div>
	<div id="grid2co">
		<div class="adminMain">
			<h1>관리자님 환영합니다.</h1>
			<br>
			<span style="font-size: 100px">관리를 시작해주세요!</span>
		</div>
	</div>
</div>
<%@ include file="/footer.jsp"%>