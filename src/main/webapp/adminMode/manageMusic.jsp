<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/adminMode/header.jsp"%>
<style>
div.adminMain>article {
	margin: auto;
	padding-top: 100px;
}

div.head {
	padding: 30px;
}

span.title {
	font-size: 30px;
	font-weight: bold;
}

table {
	text-align: center;
}

img.album {
padding: 10px;
}

</style>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/adminMode/asideBar.jsp"%></div>
	<div id="grid2co">
		<div class="adminMain">
			<article>
				<div class="head">
					<span class="title">음악 리스트</span>
					&nbsp;&nbsp;&nbsp;
					<button onclick="location.href='IndieServlet?command=manage_music_insert_form'">신규 노래
						등록</button>
				</div>
				<table class="chart">
					<tr>
						<th align="center">번호</th>
						<th>이미지</th>
						<th>곡</th>
						<th>아티스트</th>
						<th>앨범</th>
						<th>가사</th>
					</tr>
					<c:forEach items="${musicInfoList}" var="musicInfo">
						<tr class="line">
							<td width="5%" style="text-align: center">
								<span style="font-size: 20px; color: #4C4C4C;">${musicInfo.m_id}</span>
							</td>
							<td width="10%">
								<a href="#">
									<img class="album" src="${pageContext.request.contextPath}/img/music/${musicInfo.m_album_pic}" width="50px"
										height="50px" />
								</a>
							</td>
							<td width="30%">
								<a
									href="${pageContext.request.contextPath}/IndieServlet?command=manage_music_detail&m_id=${musicInfo.m_id}">
									<span style="font-size: 20px; color: #4C4C4C;">${musicInfo.m_name}
								</a>
								</span>
							</td>
							<td width="20%">
								<span style="font-size: 20px; color: #BDBDBD;">${musicInfo.m_artist}</span>
							</td>
							<td width="20%">
								<span style="font-size: 20px; color: #BDBDBD;">${musicInfo.m_album}</span>
							</td>
							<td class="icon">
								<a>
									<img width="30" height="30" src="img/chart/icon_lyricsBefore.png" />
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</article>
		</div>
	</div>
</div>