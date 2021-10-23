<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	
%>

<article class="allchart">
	<form>
		<h2 align="left">${musicInfo.m_name}</h2>
		<textarea cols="75" rows="33" readonly="readonly" style="overflow-y:scroll; text-align: left;">${musicInfo.m_lyrics}</textarea>
		<div style="margin:20 20 20 245;">
		<a href="javascript:top.window.close()">창닫기</a>
	</div>
	</form>
</article>

<script>

</script>

