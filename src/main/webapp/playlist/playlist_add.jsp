		<!--  // 담기 누르면 보이는 나의 플레이리스트 페이지 
	// 작은 팝업 창으로 구현
	// MyPlaylist.jsp 와 뷰 기능 거의 일치, 선택 버튼 클릭 -> 담기 완료 alert()  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

a {
	color: #1a1a1a;
	text-decoration: none;
}

div {
	display: block;
}

body {
	font-family: Verdana;
}

#wrap {
	margin: 0 20px;
}

			table.playlist_content{
				width:500px;
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
				border-bottom: 1px solid #8c87ecd4;
			}
			div.sub_title {
				font-weight: bold;
				font-size: 25px;
				text-align: center;
				width: 400px;
				padding: 10px 0 10px 0;
				background-color: #edf2f5;
				margin: 0 auto;
			}
</style>
</head>
<body>
	<div id="wrap">
		<div class="sub_title">플레이리스트에 담기</div>
		<hr color="grey" style="margin:10px 0 1px 0; height:1px;">
		<table class="playlist_content">
			<tr class="list_title">
				<th>NO</th><th>플레이리스트 정보</th><th>담기</th>
			</tr>
			<c:forEach items="${my_playlist}" var="my_playlist" varStatus="status">
				<tr class="list_content">
					<td width="5%">
						<span class="content_count">
							${status.count}
						</span>
					</td>
					<td width="80%">
						<span class="content_title">
							${my_playlist.pl_title}
						</span>
					</td>
					<td class="icon">
						<a href="IndieServlet?command=addList&m_id=${m_id}&pl_num=${my_playlist.pl_num}">
							<img width="30" height="30" src="img/chart/icon_listBefore.png"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
			