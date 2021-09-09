<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<style>
article {
text-align: center;
}
h1 {font-size: 30px;}
</style>
<article class="frame">
	<h1>Login</h1>
	<form method="post" action="IndieServlet?command=admin_login">
		<fieldset>
			<legend>관리자 모드에 오신 것을 환영합니다.</legend>
			<label>Admin ID</label>
			<input type="text" name="adm_id" value="${adm_id }">
			<br>
			<label>Password</label>
			<input type="text" name="adm_pwd">
			<br>
		</fieldset>
		<div class="class"></div>
		<div id="button">
			<input type="submit" value="로그인" class="submit">
			<input type="button" value="아이디 비밀번호 찾기" class="submit"
				onclick="location='<%=request.getContextPath()%>/adminMode/login_fail.html'">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp"%>
