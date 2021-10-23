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

table.size {
	width: 300px;
	margin: 3px auto;
	height: 1.7rem;
}

table.size td {
	min-height: 60px;
}

table.size>tr>td.th>a, a:link, a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

table.size tr td span.title {
	font-size: 2.5rem;
	padding-bottom: 20px;
	display: inline-block;
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
			<form method="post" action="${pageContext.request.contextPath}/IndieServlet?command=find_id">
				<table class="size">
					<tr>
						<td class="th">
							<span class="title">아이디 찾기</span>
						</td>
					</tr>
					<tr>
						<td>
							<fieldset>
								<input class="size" name="email" type="text" value="" placeholder="이메일 입력">
								<br>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td class="th">
							<br>
							<br>
							<a class="hover" href="${pageContext.request.contextPath}/member/findPwdForm.jsp">비밀번호가
								기억나지 않으세요?</a>
							<br>
							<br>
						</td>
					</tr>
					<tr>
						<td id="button">
							<input class="size login" type="submit" value="아이디 찾기">
							<br>
						</td>
					</tr>
				</table>
			</form>
		</article>
	</div>
	<div id="footer"></div>
</body>