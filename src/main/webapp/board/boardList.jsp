<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.indie.dto.BoardVO"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<%
// 넘어온 category별로 vo객체에 다르게 대입. 
// ex) if (category.equals("News") { : getBoardListByCategory(String category) { 
// category = ? pstmt.setString(request.getParameter(category)) //category가 news인 컬럼들을 찾아 출력하는 메소드 
List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
String category = request.getParameter("b_category");
// String title_category = (String) request.getAttribute("title_category");
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

ol, ul, li {
	list-style: none;
	font-weight: normal;
}

dt.sub_title {
	font-size: 30px;
	margin-bottom: 10px;
    background-color: #f6f6f6;
    padding: 10px;
}

dt.category_btn {
	float: right;
	margin-top: 30px;
}

dt.category_btn button {
	color:#8C8C8C;
	background-color: #fff;
	border:1px solid #8C8C8C;
	font-size:1.2em;
	font-weight:bold;
	padding:5px 15px;
	cursor:pointer;
}

dt.category_btn button:hover{
	background:#000000;
	color:#fff;
}
			
tr.board_list {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	padding: 16px 10px;
	border-bottom: 1px solid #e6e6e6;
	height: 135px;
	position: relative;
	width: 100%;
	display: inline-block;
	vertical-align: top;
}

tr.board_list:hover {
	box-shadow: rgba(30, 22, 54, 0.3) 0 0px 0px 100px inset;
}

.board_list .list_date {
	float: left;
	width: 96px;
	text-align: center;
	padding: 48px 0 0;
}

td.image {
	position: relative;
	float: left;
	width: 240px;
	margin-right: 24px;
}

.board_list dl {
	width: 360px;
	float: left;
	color: #666;
	overflow: hidden;
}

.board_list .list_title {
	overflow: hidden;
	color: #1a1a1a;
	font-size: 18px;
	font-weight: bold;
	width: 100%;
	min-height: 20px;
	padding: 5px 5px 10px 0;
	margin-left: -2px;
	white-space: nowrap;
	text-overflow: ellipsis;
}

dd.list_content {
	color: #666;
	line-height: 20px;
	min-height: 50px;
	word-wrap: break-word;
	word-break: break-all;
	overflow: hidden;
	text-overflow: ellipsis;
}

.board_list .list_detail {
	text-align: right;
	width: 100%;
	margin-top: 5px;
	display: inline-block;
}

.board_list .list_detail .left {
	float: left;
	padding: 0;
	text-align: left;
}

.board_list .list_detail .left .list_category, .list_cnt {
	vertical-align: middle;
	color: #666;
	margin-right: 50px;
}

/* musicView에서 퍼온 것  */
.board_wrap {
	margin: 30px 0 0 30px;
}

.board_top {
	width: 720px;
	height: 140px;
}

dt.board_category {
	text-align: center;
    font-weight:bold;
	font-size: 35px;
	padding:10px;
    background-color: #edf2f5;
	display: inline-block;
	margin: 10px;
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
				<dt class="sub_title">인디 포스트</dt>
				<%
				if (request.getParameter("b_category") != null) {
					if (request.getParameter("b_category").equals("news")) {
				%>
				<dt class="board_category">뮤직 이슈</dt>
				<%
					} else if (request.getParameter("b_category").equals("magazine")) {
				%>
				<dt class="board_category">매거진</dt>
				<%
					} else if (request.getParameter("b_category").equals("concert")) {
				%>
				<dt class="board_category">공연</dt>
				<%
					} else if (request.getParameter("b_category").equals("all")) {
				%>
				<dt class="board_category">전체</dt>
				<%
					}
				}
				%>
				<dt class="category_btn">
					<button onclick="location.href='IndieServlet?command=BoardList_All_form&b_category=all'">전체</button>
					<button onclick="location.href='IndieServlet?command=BoardList_Category_form&b_category=news'">뮤직 이슈</button>
					<button onclick="location.href='IndieServlet?command=BoardList_Category_form&b_category=magazine'">매거진</button>
					<button onclick="location.href='IndieServlet?command=BoardList_Category_form&b_category=concert'">공연</button>
				</dt>
				<hr color="grey" style="margin-left: 0px; margin-top: 5px; height: 1px;">
			</dl>
			<table class="board_content">
				<c:forEach items="${boardList}" var="boardList">
					<tr class="board_list" onclick="location.href='IndieServlet?command=Board_Detail_form&b_num=${boardList.b_num}'">
						<td class="image">
							<img alt="게시판 이미지" src="${pageContext.request.contextPath}/img/board/${boardList.b_picture}"
								width="240" height="135">
						</td>
						<td>
							<dl style="height: 135px;">
								<dt class="list_title">${boardList.b_title}</dt>
								<dd class="list_content">${boardList.b_content}</dd>
				 			</dl>
						</td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="Paging.jsp">
			    <jsp:param value="${paging.page}" name="page"/>
			    <jsp:param value="${paging.beginPage}" name="beginPage"/>
			    <jsp:param value="${paging.endPage}" name="endPage"/>
			    <jsp:param value="${paging.prev}" name="prev"/>
			    <jsp:param value="${paging.next}" name="next"/>
			</jsp:include>
		</article>
	</div>
	<!-- grid2 div -->
</div>
<!-- mid div -->
<%@ include file="/footer.jsp"%>