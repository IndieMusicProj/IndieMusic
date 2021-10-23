<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<!-- 여기에 개인 메인 영역 작성 -->
		
		<!-- / 나의 플레이리스트 // mb_id값 이용, 
	// playlist없으면 플레이리스트 없고, 만들기 버튼만 보여줌.
	// 해당 id가 가진 playlist(보여줌 playList컬럼 정보)
	// 플레이리스트 순서 , 정보(제목, 총 수록곡 수), 듣기(전체듣기), 삭제, 플레이리스트 만들기
	// 첫 로그인시 : 플레이리스트 만들기만 보임 (검색창으로 이동, 모든 노래 최신순 정렬)  -->
		<style>
		
a {
	color: #1a1a1a;
	text-decoration: none;
}

div {
	display: block;
}
			
			article.playlist_wrap{
			margin: 30px 0 0 30px;
			}
			
			dl.top_menu {
				width: 720px;
				height: 100px;
			}
			dt.sub_title {
				font-weight: bold;
				font-size: 40px;
				text-align: center;
				width: 200px;
				padding: 10px 0 10px 0;
				background-color: #edf2f5;
			}
			
			dt.playlist_make {
				float: right;
				font-size: 20px;
			}

			dt button{
			  color:#8C8C8C;
			  background-color: #fff;
			  border:1px solid #8C8C8C;
			  font-size:1.2em;
			  font-weight:bold;
			  padding:0 15px;
			  cursor:pointer;
			}
			button:hover{
			  background:#000000;
			  color:#fff;
			}
			
			table.playlist_content{
				width:720px;
				border-bottom:1px solid #DCDCDC;
				text-align: center;
			}
			
			tr.list_title {
				text-align: center;
				border-bottom:5px solid #DCDCDC;
			}
			tr.list_title th{
				padding-bottom: 10px;
			}
			
			tr.list_content {
				height: 60px;
				border-bottom:1px solid #DCDCDC;
			}
			
			span.content_count {
			
			}
			
			span.content_title {
			
			}
			
			td.icon{
			width:5%;
			}
			td.icon img{
			
			}
			
		</style>
	<article class="playlist_wrap">
		<dl class="top_menu">
			<dt class="sub_title">마이 뮤직</dt>
			<dt class="playlist_make">
				<button onclick="location.href='IndieServlet?command=Playlist_Insert_Form'">플레이리스트 만들기</button>
			</dt>
		</dl>
		<hr color="grey" style="margin:10px 0 10px 0; height: 1px;">
		<table class="playlist_content">
			<tr class="list_title">
				<th>NO</th><th>플레이리스트 정보</th><th>전체 듣기</th><th>삭제</th>
			</tr>
			<c:forEach items="${my_playlist}" var="my_playlist" varStatus="status">
				<tr class="list_content">
					<td width="5%">
						<span class="content_count">
							${status.count}
						</span>
					</td>
					<td width="35%">
						<span class="content_title">
							<a href="IndieServlet?command=Playlist_Detail_Form&pl_num=${my_playlist.pl_num}&pl_title=${my_playlist.pl_title}">
								${my_playlist.pl_title}
							</a>
						</span>
					</td>
					<td class="icon">
						<a href="IndieServlet?command=Play_PlaylistAction&pl_num=${my_playlist.pl_num}">
							<img width="30" height="30" src="img/chart/icon_playBefore.png"/>
						</a>
					</td>
					<td class="icon">
						<a href="IndieServlet?command=Playlist_Delete&pl_num=${my_playlist.pl_num}">
							<img width="30" height="30" src="img/chart/icon_Delete.png"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</article>
		
		
	</div>
</div>
<%@ include file="/footer.jsp"%>