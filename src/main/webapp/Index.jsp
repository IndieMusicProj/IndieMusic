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
			text-align:center;
			}
			
			.chart td a{
			text-decoration-line: none;
			}
			
			.line{
			border-bottom:1px solid #DCDCDC;
			}
			.icon{
			width:7%;
			}
		</style>

<article class="allchart">
	<span style="font-size:30px; font-weight:bold;">실시간 차트</span> <span style="font-size:1em; font-weight:bold; color:#8C8C8C;">인기순</span><br><br>
	<table class="chart">
		<c:forEach items="${getIndexPopular}" var="chartList" varStatus="status">
			<tr class="line">
				<td width="3%"><span style="font-size:20px; color:#4C4C4C;">${status.count}</span></td>
				<td width="10%"><a href="#"><img src="${pageContext.request.contextPath}/img/music/${chartList.m_album_pic}" width="50" height="50" align="center"/></a></td>
				<td width="40%" style="text-align:left"><a href="#"><span align="left" style="font-size:20px; color:#4C4C4C;">${chartList.m_name}</a></span></td>
				<td width="37%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_artist}</span></td>
				<td class="icon"><a><img width="30" height="30" src="${pageContext.request.contextPath}/img/chart/icon_playBefore.png"/></a></td>
				<td class="icon"><a><img width="30" height="30" src="${pageContext.request.contextPath}/img/chart/icon_listBefore.png"/></a></td>
			</tr>
		</c:forEach>
	
	</table>
</article>

<%-- 여기서 부터 게시판 작업하시면 됌 --%>


<!-- <span style="font-size: 70px">게시판 자리</span> -->
	</div>
</div>
<%@ include file="/footer.jsp"%>