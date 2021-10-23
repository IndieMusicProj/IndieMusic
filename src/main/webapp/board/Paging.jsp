<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

#paging {
	font-size: 22pt;
}
</style>
</head>
<body>
	<div id="paging">
		<!-- 1~10까지 있는 페이지의 페이징 -->
		<%
		if (request.getParameter("b_category").equals("news")) {
		%>
		<c:url var="action" value="IndieServlet?command=BoardList_Category_form&b_category=news"/> 
		<%
			} else if (request.getParameter("b_category").equals("magazine")) {
		%>
		<c:url var="action" value="IndieServlet?command=BoardList_Category_form&b_category=magazine"/>
		<%
			} else if (request.getParameter("b_category").equals("concert")) {
		%>
		<c:url var="action" value="IndieServlet?command=BoardList_Category_form&b_category=concert"/>
		<%
			} else if (request.getParameter("b_category").equals("all")) {
		%>
		<c:url var="action" value="IndieServlet?command=BoardList_All_form&b_category=all"/>
		<%
		}
		%>
		<%-- <form action="BoardList_All_form&${boardList.b_category}&page=${param.page}" method="post"> --%>
			<c:if test="${param.prev}">
				<a href="${action}&page=${param.beginPage-1}">prev</a>
			</c:if>
			<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1"
				var="index">
				<c:choose>
					<c:when test="${param.page==index}">
	            ${index}
	        </c:when>
					<c:otherwise>
						<a href="${action}&page=${index}">${index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${param.next}">
				<a href="${action}&page=${param.endPage+1}">next</a>
			</c:if>
		<!-- </form> -->
	</div>
</body>
</html>
