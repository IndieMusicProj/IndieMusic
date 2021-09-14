<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<header id="header">
			<c:choose>
				<c:when test="${empty sessionScope.loginUser}">
					<div class="frame">
						<div class="topBtns">
							<a class="btns adminlogin" name=login href="${pageContext.request.contextPath}/IndieServlet?command=admin_login_form"
								style="color: white;">관리자</a>
							<a class="btns login" name=login href="${pageContext.request.contextPath}/member/login.jsp">로그인</a>
							<a class="btns join" name=join href="${pageContext.request.contextPath}/member/join.jsp">회원가입</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="frame">
						<div class="topBtns">
							<span style="grid-column: 7/10;">${sessionScope.loginUser.mb_name}(${sessionScope.loginUser.mb_id})님
								안녕하세요.</span>
							<span>
								<a class="btns join" style="grid-column: -2;" href="IndieServlet?command=logout">LOGOUT</a>
							</span>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="mainHeader">
				<div class="frame">
					<a href="${pageContext.request.contextPath}/IndieServlet?command=index">
						<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png">
					</a>
					<div class="search">
						<form action="">
							<input class="searchKeyword" type="text" name="searchKeyword" size="50">
							<a class="searchIcon" href="IndieServlet" onclick="search()">
								<img src="${pageContext.request.contextPath}/img/common/icon_search.png"
									onclick="go_search()">
							</a>
						</form>
					</div>
				</div>
			</div>
		</header>