<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #f6f6f6;
	text-align: center;
	padding-top: 100px;
	display: grid;
	grid-template-rows: 80% 20%;
}

div#main {
	
}

div#footer {
	/* 	min-width: 700px; */
	width: 100%;
	margin: auto auto;
	position: fixed;
	bottom: 0px;
	margin: auto auto;
}

input.size {
	width: 300px;
	margin: 3px;
	height: 1.7rem;
}

input.login {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #436ea2;
	color: white;
	width: 308px;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

input.login:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 308px;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

a.join:link, a.join:hover, a.join:visited, a.join {
	color: #8b8b8c;
	text-decoration: none;
	font-size: 0.8rem;
}
</style>
</head>
<body>
	<div id="main">
		<article>
			<div class="frame">
				<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png" style="width: 150px;">
			</div>
			<form method="post" action="${pageContext.request.contextPath}/IndieServlet?command=login">
				<fieldset>
					<input class="size" name="id" type="text" value="" placeholder="아이디">
					<br>
					<input class="size" name="pwd" type="password" value="" placeholder="비밀번호">
					<br>
				</fieldset>
				<div id="button">
					<input class="size login" type="submit" value="로그인">
					<br>
					<a href="${pageContext.request.contextPath}/member/join.jsp" class="join">회원가입</a>
					<!-- <input type="button" value="아이디 비밀번호 찾기" class="submit" -->
					<!-- onclick="location='NonageServlet?command=find_id_form'"> -->
				</div>
			</form>
		</article>
	</div>
	<div id="footer"></div>
</body>