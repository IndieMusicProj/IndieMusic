<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp"%>

<div id="mid" class="frame">
<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
		/*  여기에 개인 css */
		</style>

<article>
	<table>
		<c:forEach items="${getAllPopular}" var="getAllPopular">
			<tr>
				<td bgcolor="red" width="70">${getAllPopular.m_genre}</td>
				<td bgcolor="red" width="70">${getAllPopular.m_nation}</td>
				<td bgcolor="red" width="70">${getAllPopular.m_name}</td>
				<td bgcolor="red" width="70">${getAllPopular.m_artist}</td>
				<td bgcolor="red" width="70">${getAllPopular.m_playcnt}</td>
			</tr>
		</c:forEach>
	</table>
</article>

	</div>
</div>
<%@ include file="/footer.jsp"%>