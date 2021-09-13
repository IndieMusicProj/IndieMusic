<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
		/*  여기에 개인 css */
		</style>
		
		
		<!-- 여기에 개인 메인 영역 작성 -->
		
		<!-- 플레이리스트 순번,  -->
		<article>
			<label> 나의 플레이리스트 </label>
			<!--	정렬 방식 
				pl_num 값 이용, 담기 된 곡들 오래된 순, 최근 담은 순서 구분  
			-->
			<table>
				<tr>
					<th> 곡 정보 </th>
					<th> 아티스트</th>
					<th> 듣기 </th>
					<th> 삭제 </th> <!-- 버튼형식 -->
				</tr>
				<!-- (차트와 거의 일치) 내용  반복 -->
				<tr>
				<!-- 곡 정보, 아티스트, 앨범, 듣기, 가사 -->
				</tr>
			</table>
		</article>
		
		
	</div>
</div>
<%@ include file="/footer.jsp"%>