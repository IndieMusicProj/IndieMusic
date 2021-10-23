<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
		.allchart{
		margin: 30px 0 0 30px;
		}
		
		.headerinfo{
		width: 720px;
		height: 70px;
		}
		.form{
		width:720px;
		height: 50px;
		}

		.allchart a{
		text-decoration-line: none;
		}
		
		.topchart{
		width:720px;
		height:50px;
		}
	
		.chart{
		width:720px;
		
		}
		.chart td{
		height:71px;
		text-align:left;
		}
		.chart th{
		font-size:0.6em;
		color:blue;
		}
		
		.chart th:nth-of-type(n+6){
		text-align:center;
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
		
		input[type=checkbox] + label{
		display: inline-block;
		margin-left: 10px;
		width: 30px;
		height: 20px;
		border: 2px solid #bcbcbc;
		cursor: pointer;
		margin-bottom: 5px;
		}
		
		input[type=checkbox]:checked + label{
		background-color: #666666;
		}
		
		input[type=checkbox]{
		display: none;
		}
		
		#input1{
		vertical-align:top;
		width: 130px;
		height: 30px;
		margin-left : 10px;
		margin-bottom : 5px;
		background-color:white;
		border: 2px solid black;
		border-radius: 50px; 
		text-align: center;
		}
		
		</style>
		<script type="text/javascript">
		function NoMultiChk(chk){ 
			var obj = document.getElementsByName("genre"); 
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}	

		</script>
		
<article class="allchart">
	<div class="headerinfo">
		<span style="font-size:30px; font-weight:bold;">추천곡 장르와 곡 수를 정하세요.</span>
	</div>
	<div class="form">
		<form method="post" name="formm" action="IndieServlet?command=random_action">
			<input type="checkbox" id="cb1" name="genre" value="bal" checked="checked" onclick="NoMultiChk(chk)">
			<label for="cb1"></label>발라드
			<input type="checkbox" id="cb2" name="genre" value="dan" onclick="NoMultiChk(this)">
			<label for="cb2"></label>댄스
			<input type="checkbox" id="cb3" name="genre" value="hip" onclick="NoMultiChk(this)">
			<label for="cb3"></label>힙합
			<input type="checkbox" id="cb4" name="genre" value="in" onclick="NoMultiChk(this)">
			<label for="cb4"></label>인디
			<input id="input1" type="text" name="r_num" placeholder="숫자만 입력하세요">
			<input id="input2" type="image" src="./img/common/icon_search.png" value="확인" class="submit" style="width: 40px; height: 40px">
		</form>
	</div>
	
	<div>
	<table class="chart">
	<div class="hide" style="display: none;">
		<form name="onoff" class="formm" action="IndieServlet?command=random_action" method="post">
			<input type="button" value="음악켜기" name="B1" onClick="changeButton(${chartList.m_id})">
			<audio id="audio">
				<source src="stay.mp3" >
			</audio>
		</form>
	</div>
			<tr>
			</tr>
		<c:forEach items="${list}" var="chartList" begin="0" end="${count-1}" step="1" varStatus="status">
			<tr class="line">
				<td width="5%" style="text-align:center"><span style="font-size:20px; color:#4C4C4C;">${status.count}</span></td>
				<td width="10%"><a href="#"><img src="${pageContext.request.contextPath}/img/music/${chartList.m_album_pic}" width="50" height="50"/></a></td>
				<td width="30%"><a href="IndieServlet?command=music_view&m_id=${chartList.m_id}"><span style="font-size:20px; color:#4C4C4C;">${chartList.m_name}</a></span></td>
				<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_artist}</span></td>
				<td class="icon"><button type="submit" onclick="changeButton(${chartList.m_id})"><img src="./img/chart/icon_playBefore.png"/></button></td>
				<td class="icon"><a href="IndieServlet?command=addlist&m_id=${chartList.m_id}&list=allpop"><img width="30" height="30" src="img/chart/icon_listBefore.png"/></a></td>
				<td class="icon"><a href="#" onclick="golyrics(${chartList.m_id})"><img width="30" height="30" src="img/chart/icon_lyricsBefore.png"/></a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
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

function play() {
	var audio = document.getElementById("audio");
	audio.play();
}

function pause() {
	var audio = document.getElementById("audio");
	audio.pause();
}


function changeButton(no) {
	var id = no;
    var onoff = document.onoff;
    document.onoff.id.value=id;
    if(document.onoff.B1.value=='음악끄기') {
    	document.onoff.B1.value='음악켜기';
   		pause();
    	console.log(id);
   		onoff.submit();
    }else{
	    document.onoff.B1.value='음악끄기';
	    play();
    }
}
</script>
<%@ include file="/footer.jsp"%>