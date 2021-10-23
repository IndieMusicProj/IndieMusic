<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/adminMode/header.jsp"%>
<style>

/* title 부분 */
h1.titleFormat {
	color: ##686564;
	font-size: 2.5rem;
	font-weight: bolder;
	padding: 20px;
}

.size {
	width: 300px;
	margin: 3px;
	height: 1.7rem;
}

input.login {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #436ea2;
	color: white;
	width: 308px;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

input.login:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 308px;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}
</style>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/adminMode/asideBar.jsp"%></div>
	<div id="grid2co">
		<div class="adminMain">
			<article>
				<div id="title">
					<h1 class="titleFormat">노래 신규 등록</h1>
				</div>
				<form id="insertMusic"
					action="${pageContext.request.contextPath}/IndieServlet?command=music_insert" method="post"
					name="formm" enctype="multipart/form-data">
					<table>
						<tr>
							<td>
								<label>
									<span style="color: red; font-weight: bold;">*</span>
									노래 제목
								</label>
								<br>
								<input class="size" type="text" name="m_name">
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								<label>
									<span style="color: red; font-weight: bold;">*</span>아티스트</label>
								<br>
								<input class="size" type="text" name="m_artist">
							</td>
							<td>
								<label>국가</label>
								<br>
								<input class="size" type="text" name="m_nation">
							</td>
						</tr>
						<tr>
							<td>
								<label>
									<span style="color: red; font-weight: bold;">*</span>앨범명</label>
								<br>
								<input class="size" type="text" name="m_album">
							</td>
							<td>
								<label for="m_genre">
									<span style="color: red; font-weight: bold;">*</span>장르</label>
								<br>
								<select name="m_genre" id="m_gerne" class="selectCondition size">
									<option value="bal">발라드(ballad)</option>
									<option value="dan">댄스(Dance)</option>
									<option value="hip">힙합(Hip Hop)</option>
									<option value="in">인디(Indie)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<label>앨범 사진</label>
								<br>
								<input class="size" type="file" name="m_album_pic" size="50">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<label>가사</label>
								<br>
								<textarea rows="20" cols="100" name="m_lyrics"></textarea>
							</td>
						</tr>
					</table>
					<hr color="#f6f6f6">
					<div id="buttons">
						<input class="login" type="submit" value="등록">
					</div>
				</form>
			</article>
		</div>
	</div>
</div>