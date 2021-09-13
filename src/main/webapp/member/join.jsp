<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #f6f6f6;
	padding-top: 100px;
	display: grid;
	grid-template-rows: 80% 20%;
}

div.frame {
	margin: 0 auto;
	text-align: center;
}

fieldset {
	width: 300px;
	margin: 0 auto;
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

input.size2 {
	width: 244px;
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

input.checkBtn {
	background-color: white;
	width: 50px;
	height: 33px;
	border: 0px;
	outline: 0px;
}
</style>
</head>
<body>
	<div id="main">
		<article>
			<div class="frame">
				<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png"
					style="width: 150px;">
			</div>
			<form id="join" action="${pageContext.request.contextPath}/IndieServlet?command=join" method="post" name="formm">
				<fieldset>
					<label>아이디</label>
					<br>
					<input class="size2" type="text" name="id" size="12">
					<input class="size2" type="hidden" name="reid">
					<input class="checkBtn" type="button" value="확인">
					<br>
					<label>비밀번호</label>
					<br>
					<input class="size" type="password" name="pwd">
					<br>
					<label>비밀번호 재확인</label>
					<br>
					<input class="size" type="password" name="pwdCheck">
					<br>
					<label>이름</label>
					<br>
					<input class="size" type="text" name="name">
					<br>
					<label>이메일</label>
					<br>
					<input class="size" type="text" name="email" placeholder="xxx@xxx.com">
					<br>
					<label>우편번호</label>
					<br>
					<input class="size2" type="text" name="zipNum" size="10" placeholder="000-000">
					<input class="checkBtn" type="button" value="검색" onclick="post_zip()">
					<br>
					<label>주소</label>
					<br>
					<input class="size" type="text" name="addr1" size="50">
					<input class="size" type="text" name="addr2" size="25">
					<br>
					<label>번호</label>
					<br>
					<input class="size" type="text" name="mobile" placeholder="000-0000-0000">
					<br>
					<div id="buttons">
						<input class="size login" type="submit" value="회원가입">
					</div>
				</fieldset>
			</form>
		</article>
	</div>
	<div id="footer"></div>
</body>