<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<style>
.adminMain > article {
margin: auto;
padding-top: 100px;
}

</style>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/adminMode/asideBar.jsp"%></div>
	<div id="grid2co">
		<div class="adminMain">
			<article>
				<h2>노래 정보 추가</h2>
				<form id="insertMusic" action="IndieServlet?command=insert_music" method="post" name="formm">
					<fieldset>
						<legend>Music Basic Info</legend>
						<label>노래 제목</label>
						<input type="text" name="M_NAME" size="12">
						<br>
						<label>가수</label>
						<input type="text" name="M_ARTIST" size="12">
						<br>
						<label>앨범명</label>
						<input type="text" name="M_ALBUM" size="12">
						<br>
					</fieldset>
					<fieldset>
						<legend>Optional</legend>
						<label>장르</label>
						<input type="text" name="M_GENRE" size="12">
						<br>
						<label>앨범사진</label>
						<input type="text" name="M_ALBUM_PIC" size="12">
						<br>
						<label>가사</label>
						<input type="text" name="M_LYRICS" size="12">
						<br>
					</fieldset>
					<div class="clear"></div>
					<div id="buttons">
						<input type="button" value="추가" class="submit" >
<!-- 						onclick="go_save()" js 추가예정 -->
						<input type="reset" value="취소" class="cancel">
					</div>
				</form>
			</article>
		</div>
	</div>
</div>
<%@ include file="/footer.jsp"%>