<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet">
<script src = "https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
				<a href="${pageContext.request.contextPath}/IndieServlet?command=index">
					<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png" style="width: 150px;">
				</a>
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
					<a href="${pageContext.request.contextPath}/member/join.jsp" class="join">회원가입</a>&nbsp;&nbsp;&nbsp;
					<!-- <input type="button" value="아이디 비밀번호 찾기" class="submit" -->
					<!-- onclick="location='NonageServlet?command=find_id_form'"> -->
					<a href='${pageContext.request.contextPath}/member/findIdForm.jsp'" class="join">아이디 비밀번호 찾기</a>
					
					
				</div>
			</form>
		</article>
	</div>
	<br>
	                      <a href="javascript:kakaoLogin();"><img src="${pageContext.request.contextPath}/img/common/kakao.JPG" style="width:308px; height:40px"></a><br> 
                         
                         <script>
                           
                         
                            window.Kakao.init("766be57eb4da3b2919ff31220dcf1fd8");
                            
                            console.log(Kakao.isInitialized());
                            function kakaoLogout() {
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

                            function kakaoLogin() {
                            	
                            	if (window.Kakao.Auth.getAccessToken()) { 
                            		window.Kakao.API.request({ 
                            			url: '/v1/user/unlink', 
                            			success: function (response) { 
                            				console.log(response) 
                           				},
                           				fail: function (error) { 
                           					console.log(error) },
                       				})
                       				window.Kakao.Auth.setAccessToken(undefined)
                    			}

                            	   console.log(Kakao.isInitialized());
                            	   Kakao.Auth.login({
                            	      success: function(response) {
                            	         window.Kakao.API.request({
                            	            url: '/v2/user/me',
                            	            success: function(response) {
                            	               console.log(response)
                            	               $('#response').append(response);
                            	               id = response.id
                            	               connected_at = response.connected_at
                            	               kakao_account = response.kakao_account
                            	               properties = response.properties

                            	               $('#response').append(kakao_account);
                            	               responsediv = "<h2>로그인 성공"
                            	               responsediv += '<h4>id: ' + id + '<h4>'
                            	               responsediv += '<h4>connected_at: ' + connected_at + '<h4>'
                            	               email = "";
                            	               gender = "";
                            	               nickname = "";
                            	               birthday = "";
                            	               if (typeof kakao_account != 'undefined') {
                            	                  email = kakao_account.email;
                            	                  gender = kakao_account.gender;
                            	                  birthday = kakao_account.birthday;
                            	                  nickname = properties.nickname;
                            	               }

                            	               responsediv += '<h4>email: ' + email + '<h4>'
                            	               responsediv += '<h4>gender: ' + gender + '<h4>'
                            	               responsediv += '<h4>nickname: ' + nickname + '<h4>'
                            	               responsediv += '<h4>birthday: ' + birthday + '<h4>'
                            	               $('#response').append(responsediv);
                            	               console.log("사용자 정보");
	
                            	               $("#email").val(email);

                                               $("#id").val(id);
                                               
                                               $("#name").val(nickname);
                                               $("#form2").submit();



                            	               if (typeof kakao_account == 'undefined') {
                            	                  console.log("넘어왔어요!22");


                            	                  
                            	               }
                            	            },
                            	            fail: function(error) {
                            	               console.log(error)
                            	            },
                            	         })
                            	      },
                            	      fail: function(error) {
                            	         console.log(error)
                            	      },
                            	   }
                            	   )
                            	}
                         </script>
                         <div id = "response"></div>
    <form id="form2" name="form2" action="${pageContext.request.contextPath}/IndieServlet?command=klogin" method="post" >
		<input type="hidden" name="email" id="email"/>
		<input type="hidden" name="name" id="name"/>
		<input type="hidden" name="id" id="id"/>
	</form>	
	<div id="footer"></div>
</body>