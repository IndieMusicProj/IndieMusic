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
			
			div.sub_title {
				font-weight: bold;
				font-size: 25px;
				text-align: center;
				width: 400px;
				padding: 10px 0 10px 0;
				background-color: #edf2f5;
				margin: 0 auto;
			}
			
			div.close_btn {
				background-color: #DCDCDC;
				text-align: center;
				margin: 20px auto 20px auto;
			    width: 50px;
			    padding: 10px;
			}
</style>
</head>
<body>
	<div id="wrap">
		<div class="sub_title">플레이리스트에 담기</div>
		<hr color="grey" style="margin:10px 0 1px 0; height:1px;">
		<table class="playlist_content">
			<tr class="list_title">
				<td class="">
					<p> 플레이리스트에 곡 담기가 완료되었습니다. </p>
				</td>
			</tr>
		</table>
		<div class="close_btn">
			<a href="javascript:top.window.close()">닫기</a>
		</div> 
	</div>
</body>
</html>
			