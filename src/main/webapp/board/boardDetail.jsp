<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.indie.dto.BoardVO"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<%
// 넘어온 category별로 vo객체에 다르게 대입. 
// ex) if (category.equals("News") { : getBoardListByCategory(String category) { 
// category = ? pstmt.setString(request.getParameter(category)) //category가 news인 컬럼들을 찾아 출력하는 메소드 
BoardVO boardDetail = (BoardVO) request.getAttribute("boardDetail");
%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
a {
	color: #1a1a1a;
	text-decoration: none;
}

div {
	display: block;
}

.board_top {
	width: 720px;
	height: 20%;
}

dt.board_header {
	width: 720px;
	padding-bottom: 10px;
	font-size: 40px;
	padding-bottom: 20px;
	display: grid;
	grid-template-columns: 2fr 7fr 1fr;
	vertical-align: middle;
}

div.board_category {
	padding-left: 10px;
}

div.boardList {
	grid-column: 3;
	padding-left: 10px;
}

.board_title {
	font-size: 25px;
	font-weight: bold;
	padding: 15px 0 15px 30px;
	background-color: #f6f6f6;
	margin-bottom: 10px;
}

.board_detail {
	padding-left: 25px;
	text-align: right;
	width: 100%;
	margin-top: 5px;
	display: inline-block;
	font-size: 0.8em;
	opacity: 0.8;
}

.board_date {
	float: left;
	color: #666;
	padding-right: 10px;
}

.board_reg_date, .board_up_date {
	padding: 0 10px;
}

.board_cnt {
	float: right;
	color: #666;
	margin-right: 50px;
	padding-right: 30px;
}

img.imgDetail {
	border: grey 0.5px solid;
}

.board_content_wrap {
	width: 100%;
	color: #666;
}

dd.board_img {
	text-align: center;
}

.board_content {
	word-wrap: break-word;
	word-break: break-all;
	padding-top: 20px;
}

.board_content_note {
	min-height: 650px;
	width: 90%;
	margin: 0 auto 30px;
}

/* musicView에서 퍼온 것 */
.board_wrap {
	margin: 30px 0 0 30px;
}

.board_content {
	width: 720px;
}
</style>
		<!-- https://www.melon.com/musicstory/today/index.htm 참고
 	관리자로 로그인시 우측에   추가, 삭제, 수정 버튼 추가. -->
		<!-- category 별로 board_header 다르게 표시(이미지와 카테고리 명) -->
		<article class="board_wrap">
			<dl class="board_top">
				<dt class="board_header">
					<div class="board_category">${boardDetail.b_category }</div>
					<div class="boardList">
						<input style="font-size: 20px;" type="button" value="목록"
							onclick="location.href='javascript:history.back()'">
					</div>
				</dt>
				<dt class="board_title">${boardDetail.b_title}</dt>
				<dd class="board_detail">
					<p>
						<span class="board_date">
							<span class="board_reg_date">글 등록일 ${boardDetail.b_regDate}</span>
							<span class="board_up_date">글 수정일 ${boardDetail.b_upDate}</span>
						</span>
						<span class="board_cnt">
							<span>조회 횟수 :</span>
							<span>${boardDetail.b_readCnt}</span>
						</span>
					</p>
				</dd>
				<hr style="margin-bottom: 30px;">
			</dl>
			<dl class="board_content_wrap">
				<dd class="board_img">
					<img class="imgDetail" alt="게시판 이미지"
						src="${pageContext.request.contextPath}/img/music/${boardDetail.b_picture}" width="400">
				</dd>
				<dd class="board_content">
					<div class="board_content_note">${boardDetail.b_content}</div>
				</dd>
			</dl>
		</article>
	</div>
	<!-- grid2 div -->
</div>
<!-- mid div -->
<%@ include file="/footer.jsp"%>