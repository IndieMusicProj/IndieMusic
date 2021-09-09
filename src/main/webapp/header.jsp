<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<header id="header">
			<div class="frame">
				<div class="topBtns">
					<a name=login href="IndieServlet?command=admin_login_form" style="color: white;">관리자</a>
					<a name=login href="IndieServlet?command=login">로그인</a>
					<a name=join href="IndieServlet?command=join">회원가입</a>
				</div>
			</div>
			<div class="mainHeader">
				<div class="frame">
					<a href="${pageContext.request.contextPath}/Index.jsp"><img alt="로고이미지" src="#"></a>
					<div class="search">
						<!-- 백그라운드 검색이미지 투명 svg 파일 -->
						<input type="text" name="search" size="50">
						<input type="button" value="검색">
					</div>
				</div>
			</div>
		</header>