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
			.headerinfo{
			width: 720px;
			height: 70px;
			}
			.musicInfo .photo{
			float:left;
			width:200px;
			height:200px;
			margin-right: 30px;
			}
			.info{
			width:300px;
			}
			
			.info th{
			color: #5D5D5D;
			font-weight: 600;
			}
			
			.info td{
			height:30px;
			}
			
			img {
			    max-width: 100%;
			}
			
			details {
				margin-top:1rem;
			    margin-bottom: 1rem;
			}
			
			details > summary {
			    background: #ffffff;
			    padding: 1rem;
			    outline: 0;
			    border-radius: 5px;
			    cursor: pointer;
			    transition: background 0.5s;
			}
			
			details > summary::-webkit-details-marker {
			    background: url(https://marshall-storage.tistory.com/attachment/cfile29.uf@993E16335F785C0037CB43.svg) no-repeat center;
			    background-size: contain;
			    color: transparent;
			    transform: rotate3d(0, 0, 1, 90deg);
			    transition: transform 0.25s;
			}
			
			details[open] > summary::-webkit-details-marker {
			    transform: rotate3d(0, 0, 1, 180deg);
			}
			
			details[open] > summary {
			    background: #ffffff;
			}
			
			details[open] > summary ~ * {
			    animation: reveal 0.5s;
			}
			
			@keyframes reveal {
			    from {
			        opacity: 0;
			        transform: translate3d(0, -10px, 0);
			    }
			
			    to {
			        opacity: 1;
			        transform: translate3d(0, 0, 0);
			    }
			}
			
	
			
		</style>

<article class="allchart">
	<div class="headerinfo">
		<span style="font-size:30px; font-weight:bold;">${musicInfo.m_name}</span>
	</div>
	<div class="musicInfo">
		<div class="photo">
			<ul>
				<li>
					<a><img src="img/music/${musicInfo.m_album_pic}" width="200" height="200"/></a>
				</li>
			</ul>
		</div>
	<table class="info" style="position:relative">
		<tr>
			<th>아티스트</th>
			<td>${musicInfo.m_artist }</td>
		</tr>
		<tr>
			<th>앨범명</th>
			<td>${musicInfo.m_album}</td>
		</tr>
		<tr>
			<th>장르</th>
			<c:choose>
				<c:when test="${musicInfo.m_genre eq 'bal'}">
					<td>발라드</td>
				</c:when>
				<c:when test="${musicInfo.m_genre eq 'dan'}">
					<td>댄스/팝</td>
				</c:when>
				<c:when test="${musicInfo.m_genre eq 'hip'}">
					<td>힙합</td>
				</c:when>
				<c:otherwise>
					<td>인디</td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>
			<th>발매일</th>
			<td><fmt:formatDate value="${musicInfo.m_indate}" type="date"/></td>      
		</tr>
		<tr>
			<th>국가</th>
			<c:choose>
				<c:when test="${musicInfo.m_nation eq'kor'}">
					<td>국내</td>
				</c:when>
				<c:otherwise>
					<td>해외</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th></th>
			<td><a href="javascript:history.back();" style="text-decoration: none;">뒤로가기</a></td>
		</tr>
	</table>
	</div>
	<details>
	  <summary style="font-weight:bold;">가사보기</summary>
		<figure>
		<textarea cols="98" rows="33" readonly="readonly" style="overflow-y:scroll; text-align: left; border:none; overflow: hidden; overflow-y:auto;">${musicInfo.m_lyrics}</textarea>
  		</figure>
	</details>
</article>

	</div>
</div>
<%@ include file="/footer.jsp"%>