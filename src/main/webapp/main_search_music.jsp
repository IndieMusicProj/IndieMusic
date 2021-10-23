<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
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
			
			article.playlist_wrap{
			margin: 30px 0 0 30px;
			}
			
			dl.top_menu {
				width: 720px;
				height: 50px;
			}
			dt.sub_title {
				font-weight: bold;
				font-size: 20px;
				text-align: left;
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
				width:30px;
				height:30px;
			}
			
	</style>
	<article class="playlist_wrap">
		<dl class="top_menu">
			<dt class="sub_title">‘${searchKeyword }’에 대한 검색 결과입니다.</dt>
			<dt class="playlist_make">
			</dt>
		</dl>
		<hr color="grey" style="margin:10px 0 10px 0; height: 1px;">
		<table class="playlist_content">
			<tr class="list_title">
				<th>NO</th><th></th><th>곡</th><th>아티스트</th><th>앨범</th><th>듣기</th><th>담기</th><th>가사</th>
			</tr>
			<c:forEach items="${musicInfoList}" var="musicInfoList" varStatus="status">
				<tr class="list_content">
					<td width="5%">
						<span class="content_count">
							${status.count}
						</span>
					</td>
					<td width="10%"><a href="#"><img src="${pageContext.request.contextPath}/img/music/${musicInfoList.m_album_pic}" width="50" height="50"/></a></td>
					<td width="30%">
						<span class="content_title">
							<a href="IndieServlet?command=music_view&m_id=${musicInfoList.m_id}">
								${musicInfoList.m_name}
							</a>
						</span>
					</td>
					<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${musicInfoList.m_artist}</span></td>
					<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${musicInfoList.m_album}</span></td>
					<td class="icon"><button type="submit" onclick="changeButton()"><img src="./img/chart/icon_playBefore.png"/></button></td>
					<td class="icon"><a href="#" onclick="goAdd(${musicInfoList.m_id})"><img width="30" height="30" src="img/chart/icon_listBefore.png"/></a></td>
				<td class="icon"><a href="#" onclick="golyrics(${musicInfoList.m_id})"><img width="30" height="30" src="img/chart/icon_lyricsBefore.png"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</article>
	</div>
</div>

<script>
function golyrics(no) {
	var url = "IndieServlet?command=lyrics_detail&m_id=" 
	+no;
	 window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=570, height=800");
	}
	
function goAdd(no) {
	var url = "IndieServlet?command=addlist_form&m_id=" 
	+no;
	 window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=600");
	}
	
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