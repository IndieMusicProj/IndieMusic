<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="aside">
	<div class="welcome">
		<span>[${adminVO.adm_id }] 님 환영합니다.</span>
	</div>
	<div class="logo">
		<a href="${pageContext.request.contextPath}/adminMode/adminIndex.jsp">
			<img class="logo" alt="로고" src="${pageContext.request.contextPath}/img/common/logo_02.png">
		</a>
	</div>
	<div class="subNavWrap ${selected == 'member'? 'selected':'' }">
		<a class="selected"  href="${pageContext.request.contextPath}/IndieServlet?command=manage_member">
			<img class="sideImg" src="${pageContext.request.contextPath}/img/common/icon_user.png" alt="회원">
			<span class="navName">회원 관리</span>
		</a>
	</div>
	<div class="subNavWrap ${selected == 'music' ? 'selected':'' }">
		<a href="${pageContext.request.contextPath}/IndieServlet?command=manage_music">
			<img class="sideImg" src="${pageContext.request.contextPath}/img/common/icon_music.png" alt="노래">
			<span class="navName">노래 관리</span>
		</a>
	</div>
	<div class="subNavWrap ${selected == 'board'? 'selected':'' }">
		<a href="${pageContext.request.contextPath}/IndieServlet?command=manage_board">
			<img class="sideImg" src="${pageContext.request.contextPath}/img/common/icon_post.png" alt="게시판">
			<span class="navName">게시판 관리</span>
		</a>
	</div>
	<div class="subNavWrap ${selected == 'admin'? 'selected':'' }">
		<a href="${pageContext.request.contextPath}/IndieServlet?command=manage_admin">
			<img class="sideImg" src="${pageContext.request.contextPath}/img/common/icon_admin.png" alt="관리자">
			<span class="navName">관리자 계정 관리</span>
		</a>
	</div>
</div>