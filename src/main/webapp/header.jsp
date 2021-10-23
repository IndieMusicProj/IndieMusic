<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
<script src = "https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
                           
	window.Kakao.init("766be57eb4da3b2919ff31220dcf1fd8");
	
	function totalLogout(){
		kakaoLogout();
		Logout();
	}
	
	function kakaoLogout(){
	    if (Kakao.Auth.getAccessToken()) {
	      //토큰이 있으면
	      Kakao.API.request({
	        //로그아웃하고
	        url: '/v1/user/unlink',
	        success: function (response) {
	          //console.log(response)
	      location.replace("IndieServlet?command=logout");
	        },
	        fail: function (error) {
	          console.log(error)
	        },
	      })
	    }
	  }
	    //토큰도 삭제
	  /*      Kakao.Auth.setAccessToken(undefined)  */
	      
	function Logout(){
		location.href="IndieServlet?command=logout";
	    }
	
</script>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<c:choose>
				<c:when test="${empty sessionScope.loginUser}">
					<div class="frame">
						<div class="topBtns">
							<a class="btns adminlogin" name=login
								href="${pageContext.request.contextPath}/IndieServlet?command=admin_login_form"
								style="color: white;">관리자</a>
							<a class="btns login" name=login href="${pageContext.request.contextPath}/member/login.jsp">로그인</a>
							<a class="btns join" name=join href="${pageContext.request.contextPath}/member/join.jsp">회원가입</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="frame">
						<div class="topBtns">
							<span style="grid-column: 7/9;">${sessionScope.loginUser.mb_name}님 안녕하세요.</span>
							<span>
								<a class="btns join" style="grid-column: -2;" href="${pageContext.request.contextPath}/member/update.jsp">정보수정</a>
							</span>
							<span>
								<a class="btns join" style="grid-column: -2;" href="javascript:totalLogout();">LOGOUT</a>
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
						<form action="${pageContext.request.contextPath}/IndieServlet?command=search" method="post">
							<input class="searchKeyword" type="text" name="searchKeyword" size="50" value="" placeholder="검색어를 입력하세요">
							<input type="hidden" name="tableName" value="main_music">
							<input class="searchIcon" type="image" type="submit" value="검색" src="${pageContext.request.contextPath}/img/common/icon_search.png"
								style="position: relative; left: -50px; top: 7.5px; z-index: 2;" >
						</form>
					</div>
				</div>
			</div>
		</header>
		

		