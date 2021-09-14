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

img.album {
	margin: 20px;
	width: 300px;
}

.size {
	width: 300px;
	margin: 3px;
	height: 1.7rem;
}

input.detailBtn {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #436ea2;
	color: white;
	width: 200px;
	height: 2rem; border : 0px;
	outline: 0px;
	margin-bottom: 10px;
	border: 0px;
}

input.detailBtn:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

input.updateBtn {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #40ae2a;
	color: white;
	width: 200px;
	height: 2rem; border : 0px;
	outline: 0px;
	margin-bottom: 10px;
	border: 0px;
}

input.updateBtn:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

input.deleteBtn {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #e67962;
	color: white;
	width: 200px;
	height: 2rem; border : 0px;
	outline: 0px;
	margin-bottom: 10px;
	border: 0px;
}

input.deleteBtn:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 200px;
	height: 2rem;
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
					<h1 class="titleFormat">노래 상세보기</h1>
				</div>
				<div class="headerinfo">
					<span style="font-size: 30px; font-weight: bold;">${musicInfo.m_name}</span>
				</div>
				<div class="musicInfo">
					<div class="photo">
						<img class="album" alt="${musicInfo.m_album_pic }"
							src="${pageContext.request.contextPath}/img/music/${musicInfo.m_album_pic }">
					</div>
					<form id="insertMusic"
						action="${pageContext.request.contextPath}/IndieServlet?command=music_update&m_id=${musicInfo.m_id }" method="post"
						name="formm">
						<table>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										노래 제목
									</label>
									<br>
									<input class="size" type="text" name="m_name" value="${musicInfo.m_name }">
								</td>
								<td></td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										아티스트
									</label>
									<br>
									<input class="size" type="text" name="m_artist" value="${musicInfo.m_artist }">
								</td>
								<td>
									<label>국가</label>
									<br>
									<input class="size" type="text" name="m_nation" value="${musicInfo.m_nation }">
								</td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										앨범명
									</label>
									<br>
									<input class="size" type="text" name="m_album" value="${musicInfo.m_album }">
								</td>
								<td>
									<label for="m_genre">
										<span style="color: red; font-weight: bold;">*</span>
										장르
									</label>
									<br>
									<select name="m_genre" id="m_genre" class="selectCondition size">
										<option value="bal" ${musicInfo.m_genre == 'bal'? 'selected':'' }>발라드(ballad)</option>
										<option value="dan" ${musicInfo.m_genre == 'dan'? 'selected':'' }>댄스(Dance)</option>
										<option value="hip" ${musicInfo.m_genre == 'hip'? 'selected':'' }>힙합(Hip Hop)</option>
										<option value="in" ${musicInfo.m_genre == 'in'? 'selected':'' }>인디(Indie)</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<label>앨범 사진(변경을 원할시 선택해주세요.)</label>
									<br>
									<input class="size" type="file" name="m_album_pic" size="50">
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<label>가사</label>
									<br>
									<textarea rows="20" cols="100" name="m_lyrics">${musicInfo.m_lyrics }</textarea>
								</td>
							</tr>
						</table>
						<hr color="#f6f6f6">
						<div id="buttons">
							<input class="updateBtn" type="submit" value="수정">
							<input class="deleteBtn" type="button" onclick="location.href='${pageContext.request.contextPath}/IndieServlet?command=music_delete&m_id=${musicInfo.m_id}'" value="삭제">
							<input class="detailBtn" type="button" onclick="javascript:history.back();" value="목록보기">
						</div>
					</form>
				</div>
			</article>
		</div>
	</div>
</div>