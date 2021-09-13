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
		</style>

<article class="allchart">
	<div class="topchart">
		<span style="font-size:30px; font-weight:bold;">발라드(Ballad)</span> 
		<a href="IndieServlet?command=AllBallad"><span style="font-size:1em; font-weight:bold; color:#8C8C8C;">종합</span></a>
		<a href="IndieServlet?command=KorBallad"><span style="font-size:1em; font-weight:bold; color:#8C8C8C;">국내</span></a>
		<a href="IndieServlet?command=ForBallad"><span style="font-size:1em; font-weight:bold; color:#8C8C8C;">해외</span></a>
	</div>
	<table class="chart">
			<tr>
				<th align="center">순위</th><th></th><th>곡</th><th>아티스트</th><th>앨범</th><th>듣기</th><th>담기</th><th>가사</th>
			</tr>
		<c:forEach items="${getAllBalladGenre}" var="chartList" varStatus="status">
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