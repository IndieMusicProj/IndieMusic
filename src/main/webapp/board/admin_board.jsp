<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp"%>


<div id="mid" class="frame">
<!-- board 리스트 -->
<!-- 게시판 보여주는 페이지 -->
<!-- 관리자로 추가,수정 클릭시 이동된 페이지 -->
	<!--  board_header include. (카테고리 이름과 이미지표기) 내용 폼은 통일. -->
	<!-- 
		parameter category, title, 
		content (해당 artist_pic, 해당 artist_songs : content에 해당), regDate(등록일)  
	 -->
	
<!-- 이 한줄 위치에 추가하여 사용하면됨 -->
	<article>
		<form action="#" method="post">
			<table>
				<tr>
					<td>카테고리</td>
					<td>
						<select name="b_category">
							<option value="magazine">매거진</option>
							<option value="news">새로운 소식</option>
							<option value="concert">공연 정보</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="b_title">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<input type="text" name="b_content">
					</td>
				</tr>
			</table>
		</form>
	</article>

<%@ include file="/asideBar.jsp"%>
</div>
<%@ include file="/footer.jsp"%>