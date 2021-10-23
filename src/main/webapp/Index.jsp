<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp"%>


<div id="mid" class="frame">
<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
	<!-- index용 차트 css -->
		<style>
			.allchart{
			margin: 30px 0 0 30px;
			}
		
			.chart{
			width:720px;
			
			}
			.chart td{
			height:71px;
			text-align:left;
			}
			
			.chart td a{
			text-decoration-line: none;
			}
			
			.line{
			border-bottom:1px solid #DCDCDC;
			}
			.icon{
			width:5%;
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
<script>
function play() {
	var audio = document.getElementById("audio");
	audio.play();
}

function pause() {
	var audio = document.getElementById("audio");
	audio.pause();
}

function goAdd(no) {
	var url = "IndieServlet?command=addlist_form&m_id=" 
	+no;
	 window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=600");
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

function change(form) {
	if (form.url.selectedIndex != 0)
		parent.location = form.url.options[form.url.selectedIndex].value
}

function setCookie(name, value, expiredays) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + expiredays);
	document.cookie = name + "=" + escape(value) + "; path=/; expires="
			+ todayDate.toGMTString() + ";"
}

function getCookie(name) {
	var nameOfCookie = name + "=";
	var x = 0;
	while (x <= document.cookie.length) {
		var y = (x + nameOfCookie.length);
		if (document.cookie.substring(x, y) == nameOfCookie) {
			if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
				endOfCookie = document.cookie.length;
			return unescape(document.cookie.substring(y, endOfCookie));
		}
		x = document.cookie.indexOf(" ", x) + 1;
		if (x == 0)
			break;
	}
	return "";
}

if (getCookie("Notice") != "done") {
	noticeWindow = window.open(
					'IndieServlet?command=popup',
					'notice',
					'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=550,height=500');//이부분을 자기에 맞게 변경하세요
	noticeWindow.opener = self;
}
</script>

<article class="allchart">
	<span style="font-size:30px; font-weight:bold;">실시간 차트</span> <span style="font-size:1em; font-weight:bold; color:#8C8C8C;">인기순</span><br><br>
	<table class="chart">
	<div class="hide" style="display: none;">
		<form name="onoff" class="formm" action="IndieServlet?command=AllPopular" method="post">
			<input type="button" value="음악켜기" name="B1" onClick="changeButton()">
			<audio id="audio">
				<source src="stay.mp3" >
			</audio>
		</form>
	</div>
		<c:forEach items="${getIndexPopular}" var="chartList" varStatus="status">
			<tr class="line">
				<td width="3%"><span style="font-size:20px; color:#4C4C4C;">${status.count}</span></td>
				<td width="10%"><a href="#"><img src="${pageContext.request.contextPath}/img/music/${chartList.m_album_pic}" width="50" height="50" align="center"/></a></td>
				<td width="40%"><a href="IndieServlet?command=music_view&m_id=${chartList.m_id}"><span style="font-size:20px; color:#4C4C4C;">${chartList.m_name}</a></span></td>
				<td width="37%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_artist}</span></td>
				<td class="icon"><button type="submit" onclick="changeButton()"><img src="./img/chart/icon_playBefore.png"/></button></td>
				<td class="icon"><a href="#" onclick="goAdd(${chartList.m_id})"><img width="30" height="30" src="img/chart/icon_listBefore.png"/></a></td>
			</tr>
		</c:forEach>
	
	</table>
</article>

<%-- 여기서 부터 게시판 작업하시면 됌 --%>


<!-- <span style="font-size: 70px">게시판 자리</span> -->
	</div>
</div>

<%@ include file="/footer.jsp"%>