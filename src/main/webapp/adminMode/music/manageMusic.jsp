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

/* 검색창 부분 */
div#searchWrap {
	background-color: #edf2f5;
	width: 70%;
	text-align: center;
	padding: 25px 0px 25px 0px;
}

div#searchWrap select.selectCondition {
	width: 20%;
	height: 50px;
	border: #f6f6f6 1px solid;
	outline: #f6f6f6;
	font-size: 1.5rem;
	padding: 0px 5px 0px 5px;
}

div#searchWrap input.searchKeyword {
	width: 60%;
	height: 50px;
	border: #f6f6f6 1px solid;
	font-size: 1.5rem;
	padding: 0px 5px 0px 5px;
}

div#searchWrap input.searchBtn {
	width: 10%;
	height: 50px;
	color: white;
	background-color: #9dafb5;
	border: 0px;
	font-size: 1.5rem;
	padding: 0px 5px 0px 5px;
}

/* 리스트 테이블 부분 */
div.head {
	padding: 30px;
}

span.listTitle {
	font-size: 30px;
	font-weight: bold;
	grid-columns: 1fr 5fr 1fr;
}

button.insertBtn {
	width: 130px;
	height: 35px;
	color: white;
	background-color: #91b5bb;
	border: 0px;
	font-size: 1.3rem;
	grid-column: 2;
}

table.list {
	text-align: center;
	width: 70%;
}

tr.list {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
}

tr.list:hover {
	box-shadow: rgba(30, 22, 54, 0.3) 0 0px 0px 100px inset;
}

img.album {
	padding: 10px;
}

th.thead {
	background-color: #f6f6f6;
	font-weight: bold;
	height: 80px;
}

td.tdframe {
	height: 80px;
	border-bottom: gray 1px solid;
}
</style>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/adminMode/asideBar.jsp"%></div>
	<div id="grid2co">
		<div class="adminMain">
			<article>
				<div id="title">
					<h1 class="titleFormat">노래 관리</h1>
				</div>
				<form action="${pageContext.request.contextPath}/IndieServlet?command=search&tableName=member"
					method="post">
					<div id="searchWrap">
						<select class="selectCondition">
							<option>제목</option>
							<option>내용</option>
							<option>제목 + 내용</option>
							<option>id 값</option>
						</select>
						<input class="searchKeyword" type="text" name="keyword" value="" placeholder="검색할 값을 작성해주세요.">
						<input class="searchBtn" type="button" value="검색">
					</div>
				</form>
				<div class="head">
					<span class="listTitle">음악 리스트</span>
					&nbsp;&nbsp;&nbsp;
					<button class="insertBtn"
						onclick="location.href='${pageContext.request.contextPath}/adminMode/music/insertMusicForm.jsp'">신규 등록</button>
				</div>
				<table class="list">
					<tr class="trGrid">
						<th class="thead">번호</th>
						<th class="thead">이미지</th>
						<th class="thead">곡</th>
						<th class="thead">아티스트</th>
						<th class="thead">앨범</th>
						<th class="thead">가사</th>
					</tr>
					<c:forEach items="${musicInfoList}" var="musicInfo">
						<tr class="list" onclick="location.href='IndieServlet?command=music_detail&m_id=${musicInfo.m_id}'">
							<td class="tdframe" width="5%">
								<span style="font-size: 20px; color: #4C4C4C;">${musicInfo.m_id}</span>
							</td>
							<td class="tdframe" width="10%">
								<a href="#">
									<img class="album"
										src="${pageContext.request.contextPath}/img/music/${musicInfo.m_album_pic}" width="50px"
										height="50px" />
								</a>
							</td>
							<td class="tdframe" width="30%">
								<a
									href="${pageContext.request.contextPath}/IndieServlet?command=manage_music_detail&m_id=${musicInfo.m_id}">
									<span style="font-size: 20px; color: #4C4C4C;">${musicInfo.m_name}
								</a>
								</span>
							</td>
							<td class="tdframe" width="20%">
								<span style="font-size: 20px; color: #BDBDBD;">${musicInfo.m_artist}</span>
							</td>
							<td class="tdframe" width="20%">
								<span style="font-size: 20px; color: #BDBDBD;">${musicInfo.m_album}</span>
							</td>
							<td class="tdframe icon">
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