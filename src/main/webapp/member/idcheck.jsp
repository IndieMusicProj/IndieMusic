<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #f6f6f6;
	font-family: Verdana;
}

#wrap {
	margin: 0 20px;
}

h1 {
	font-size: 45px;
	color: #333333;
	font-weight: normal;
}

input[type=button], input[type=submit] {
	float: right;
}
</style>
<script type="text/javascript">
	function idok() {
		opener.formm.id.value = "${id}";
		opener.formm.reid.value = "${id}";
		self.close();
	}
</script>
</head>
<body>
	<div id="wrap">
		<div align="center">
			<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png"
				style="width: 150px;">
		</div>
		<h1>ID 중복확인</h1>
		<form method="post" name="formm" action="IndieServlet?command=id_check_form"
			style="margin-right: 0">
			User ID
			<input type=text name="id" value="" placeholder="아이디">
			<input type=submit value="검색" class="submit">
			<br>
			<div style="margin-top: 20px">
				<script>
					opener.document.formm.id.value = "";
				</script>
				<c:if test="${message == 1 }">
            	 	${id }는 이미 사용중인 아이디 입니다.
            	 </c:if>
				<c:if test="${message == -1 }">
            	 	${id }는 사용가능한 아이디 입니다.
            	 	<input type="button" value="사용" class="cancel" onclick="idok()">
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>
