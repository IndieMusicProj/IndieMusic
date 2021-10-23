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

h1.title {
	font-size: 2rem;
}

table.size {
	width: 300px;
	margin: 30px auto;
	height: 1.7rem;
}

table.size>tr>td.th {
	text-align: center;
}

table.size>tr>td.th>a, a:link, a:visited {
	color: black;
	text-decoration: underline;
}

table.size>tr .selected {
	color: gray;
}

input.size {
	width: 300px;
	margin: 5px auto;
	height: 2.4rem;
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
				<a href="${pageContext.request.contextPath}/IndieServlet?command=index">
					<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png"
						style="width: 150px;">
				</a>
			</div>
			<h1 class="title"><b>비밀번호 찾기 결과</b></h1>
			<table class="size">
				<tr>
					<td class="th">회원님의 정보를<br><br></td>
				</tr>
				<tr>
					<td class="th">잘못입력하셨습니다.<br><br><br></td>
				</tr>
				<tr>
					<td class="th">다시 입력해주시거나<br><br></td>
				</tr>
				<tr>
					<td class="th">회원가입 부탁드립니다.<br></td>
				</tr>
			</table>
				<div id="button">
					<input class="size login" type="button" onclick="history.back(); return false;"  value="뒤로가기"><br>
					<input class="size login" type="button" onclick="location.href='${pageContext.request.contextPath}/member/join.jsp'"  value="회원가입">
				</div>
		</article>
	</div>
	<div id="footer"></div>
</body>