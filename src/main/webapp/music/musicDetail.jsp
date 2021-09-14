<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
div.adminMain>article {
	margin: auto;
	padding: 100px 0px 0px 50px;
}

/* title 부분 */
h1.titleFormat {
	color: ##686564;
	font-size: 2.5rem;
	font-weight: bolder;
	padding: 20px;
}
</style>
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
						<ul>
							<li>
								<a>
									<img src="img/music/${musicInfo.m_album_pic}" width="200" height="200" />
								</a>
							</li>
						</ul>
					</div>
					<form id="insertMusic"
						action="${pageContext.request.contextPath}/IndieServlet?command=music_update" method="post"
						name="formm">
						<table>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										노래 제목
									</label>
									<br>
									<input class="size" type="text" name="m_name" value="${musicinfo.m_name }">
								</td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										아티스트
									</label>
									<br>
									<input class="size" type="text" name="m_artist" value="${musicinfo.m_artist }">
								</td>
								<td>
									<label>국가</label>
									<br>
									<input class="size" type="text" name="m_nation" value="${musicinfo.m_nation }">
								</td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										앨범명
									</label>
									<br>
									<input class="size" type="text" name="m_album" value="${musicinfo.m_album }">
								</td>
								<td>
									<label for="m_genre">
										<span style="color: red; font-weight: bold;">*</span>
										장르
									</label>
									<br>
									
									<select name="m_genre" id="m_genre" class="selectCondition size">
										<option value="bal" ${musicinfo.m_genre == 'bal'? selected:'' }>발라드(ballad)</option>
										<option value="dan" ${musicinfo.m_genre == 'dan'? selected:'' }>댄스(Dance)</option>
										<option value="hip" ${musicinfo.m_genre == 'hip'? selected:'' }>힙합(Hip Hop)</option>
										<option value="in" ${musicinfo.m_genre == 'in'? selected:'' }>인디(Indie)</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<label>앨범 사진</label>
									<br>
									<img alt="${musicinfo.m_album_pic }" src="${pageContext.request.contextPath}/img/music/${musicinfo.m_album_pic }">
									<input class="size" type="file" name="m_album_pic" size="50">
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<label>가사</label>
									<br>
									<textarea rows="20" cols="100">${musicinfo.m_lyrics }</textarea>
								</td>
							</tr>
						</table>
						<hr color="#f6f6f6">
						<div id="buttons">
							<input class="login" type="submit" value="등록">
							<a href="javascript:history.back();" style="text-decoration: none;">뒤로가기</a>
						</div>
					</form>
				</div>
			</article>
		</div>
	</div>
</div>
<%@ include file="/footer.jsp"%>