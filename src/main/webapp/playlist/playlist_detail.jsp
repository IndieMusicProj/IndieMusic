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
				height: 130px;
			}
			dt.sub_title {
				font-size: 25px;
				margin-bottom: 10px;
			    background-color: #f6f6f6;
			    padding: 10px;
			}
			
			dt.playlist_title {
			    text-align: center;
			    font-weight:lighter;
				font-size: 35px;
				padding:10px;
			    background-color: #edf2f5;
				display: inline-block;
				margin: 10px;
			}

			dt.playlist_add {
				float:right;
				margin-top: 30px;
			}
			
			/* dt button{
			  color:#8C8C8C;
			  background-color: #fff;
			  border:1px solid #8C8C8C;
			  font-size: 25px;
			  font-weight:bold;
			  padding:0 15px;
			  cursor:pointer;
			}
			
			button:hover{
			  background:#000000;
			  color:#fff;
			} */
			
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
			
			.icon button{
			border: 0;
			outline: 0;
			padding: 0;
			color: white;
			}
			
			.icon button img{
			width:30px;
			height:30px;
			}
			
		</style>
	<!-- <script type="text/javascript">
	function add_playlist() {
		var url = "IndieServlet?command=Playlist_Add_FormAction&m_id";
		window.open(url, "_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=600, top=300, left=300, ");
		}
	</script>  -->
<article class="playlist_wrap">
	<dl class="top_menu">
		<dt class="sub_title"> 플레이리스트 정보 </dt>
		<!-- <dt class="playlist_add">
			<button onclick="my_playlist()">담기</button>
		</dt> -->
		<dt class="playlist_title">
			${pl_title}
		</dt>
	</dl>
	<hr color="grey" style="margin:10px 0 10px 0; height: 1px;">
	<table class="playlist_content">
	<div class="hide" style="display: none;">
		<form name="onoff" class="formm" action="IndieServlet?command=AllPopular" method="post">
			<input type="button" value="음악켜기" name="B1" onClick="changeButton()">
			<audio id="audio">
				<source src="stay.mp3" >
			</audio>
		</form>
	</div>
		<tr class="list_title">
			<th>NO</th><th></th><th>곡명</th><th>아티스트</th><th>듣기</th><th>삭제</th>
		</tr>
		<c:forEach items="${playlist_songs}" var="playlist_songs" varStatus="status">
			<tr class="list_content">
				<td width="5%" style="text-align:center">
					<span style="font-size:20px; color:#4C4C4C;">
						${status.count}
					</span>
				</td>
					<td width="10%">
					<a href="#">
						<img src="img/music/${playlist_songs.m_album_pic}" width="50" height="50"/>
					</a>
				</td>
				<td width="30%">
					<span style="font-size:20px; color:#4C4C4C;">
						<a href="IndieServlet?command=music_detail&m_id=${playlist_songs.m_id}">
							${playlist_songs.m_name}
						</a>
					</span>
				</td>
				<td width="20%">
					<span style="font-size:20px;">
						${playlist_songs.m_artist}
					</span>
				</td>
				<td class="icon">
					
						<button type="submit" onclick="changeButton()"><img src="./img/chart/icon_playBefore.png"/></button></td>
					
				</td>
				<td class="icon">
					<a href="IndieServlet?command=Play_Delete_Song&m_id=${playlist_songs.m_id}&pl_num=${pl_num}&pl_title=${pl_title}">
						<img width="30" height="30" src="img/chart/icon_Delete.png"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</article>

		
	</div>
</div>
<script>
function play() {
	var audio = document.getElementById("audio");
	audio.play();
}

function pause() {
	var audio = document.getElementById("audio");
	audio.pause();
}


function changeButton() {
  if (document.onoff.B1.value=='음악끄기') {
    document.onoff.B1.value='음악켜기';
    pause();
  } else {
    document.onoff.B1.value='음악끄기';
    play();
  }
}
</script>
<%@ include file="/footer.jsp"%>