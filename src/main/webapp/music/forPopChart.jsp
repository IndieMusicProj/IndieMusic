<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp"%>

<div id="mid" class="frame">
<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
			.allchart{
			margin: 30px 0 0 30px;
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
			
			button{
			  background:#fff;
			  color:#8C8C8C;
			  border:none;
			  position:relative;
			  height:40px;
			  font-size:1.2em;
			  font-weight:bold;
			  padding:0 15px;
			  cursor:pointer;
			  transition:800ms ease all;
			  outline:none;
			}
			button:hover{
			  background:#000000;
			  color:#fff;
			}
			button:before,button:after{
			  content:'';
			  position:absolute;
			  top:0;
			  right:0;
			  height:2px;
			  width:0;
			  background: #fff;
			  transition:400ms ease all;
			}
			button:after{
			  right:inherit;
			  top:inherit;
			  left:0;
			  bottom:0;
			}
			button:hover:before,button:hover:after{
			  width:100%;
			  transition:800ms ease all;
			}
		</style>

<article class="allchart">
	<div class="topchart">
	
		<span style="font-size:30px; font-weight:bold;">인기차트</span><span style="font-size:25px; font-weight:bold; color:#4C4C4C;">(해외)</span>
		&nbsp;&nbsp;&nbsp;
		<button onclick="location.href='IndieServlet?command=AllPopular'">종합</button>
		<button onclick="location.href='IndieServlet?command=KorPopular'">국내</button>
		<button onclick="location.href='IndieServlet?command=ForPopular'">해외</button>
		<!-- <a href="IndieServlet?command=AllPopular"><span style="font-size:1.2em; font-weight:bold; color:#8C8C8C;">종합</span></a>
		<a href="IndieServlet?command=KorPopular"><span style="font-size:1.2em; font-weight:bold; color:#8C8C8C;">국내</span></a>
		<a href="IndieServlet?command=ForPopular"><span style="font-size:1.2em; font-weight:bold; color:#8C8C8C;">해외</span></a> -->
	</div>
	<table class="chart">
			<tr>
				<th align="center">순위</th><th></th><th>곡</th><th>아티스트</th><th>앨범</th><th>듣기</th><th>담기</th><th>가사</th>
			</tr>
		<c:forEach items="${getForPopular}" var="chartList" varStatus="status">
			<tr class="line">
				<td width="5%" style="text-align:center"><span style="font-size:20px; color:#4C4C4C;">${status.count}</span></td>
				<td width="10%"><a href="#"><img src="img/music/${chartList.m_album_pic}" width="50" height="50"/></a></td>
				<td width="30%"><a href="#"><span style="font-size:20px; color:#4C4C4C;">${chartList.m_name}</a></span></td>
				<td width="21%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_artist}</span></td>
				<td width="21%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_album}</span></td>
				<td class="icon"><a><img width="30" height="30" src="img/chart/icon_playBefore.png"/></a></td>
				<td class="icon"><a><img width="30" height="30" src="img/chart/icon_listBefore.png"/></a></td>
				<td class="icon"><a><img width="30" height="30" src="img/chart/icon_lyricsBefore.png"/></a></td>
			</tr>
		</c:forEach>
	</table>
</article>

	</div>
</div>
<%@ include file="/footer.jsp"%>