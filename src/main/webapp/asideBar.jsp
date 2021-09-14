<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="aside">
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_chart.png" alt="인기">
			<span class="navName">인기차트</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=AllPopular"> - 종합 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=KorPopular"> - 국내 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=ForPopular"> - 해외 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_music.png" alt="">
			<span class="navName">최신음악</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=AllNewest">- 종합</a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=KorNewest">- 국내</a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=ForNewest">- 해외</a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_genre.png" alt="">
			<span class="navName">장르</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=AllDance"> - 댄스/팝 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=AllBallad"> - 발라드 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=AllHiphop"> - 힙합 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=AllIndie"> - 인디 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_post.png" alt="게시판">
			<span class="navName">인디 포스트</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=BoardList_Category_form&b_category=news"> - 뮤직 이슈 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=BoardList_Category_form&b_category=magazine"> - 매거진 </a>
			</li>
			<br>
			<li class="list">
				<a class="navbtn" href="IndieServlet?command=BoardList_Category_form&b_category=concert">- 공연 </a>
			</li>
			<br>
		</ul>
	</div>
	
	<%	// 로그인 값이 존재 하면 보여지고 없으면 안보여짐.
		// MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
	
		// if (loginUser != null) {
	%>
<!-- 	<div class="subNavWrap"> -->
<!-- 		<div class="title"> -->
<%-- 			<img src="${pageContext.request.contextPath}/img/common/icon_post.png" alt="마이뮤직"> --%>
<!-- 			<span class="navName">마이 뮤직</span> -->
<!-- 		</div> -->
<!-- 		<br> -->
<!-- 		<ul> -->
<!-- 			<li class="list"> -->
<!-- 				<a href="IndieServlet?command=Playlist_FormAction">- 플레이리스트 </a> -->
<!-- 			</li> -->
<!-- 			<br> -->
<!-- 			<!-- 			 -->
<!-- 			<li class="list"> -->
<!-- 				<a href="IndieServlet?command=boardList_form"> - 나의 문의 내역 </a> -->
<!-- 			</li> -->
<!-- 			<br> -->
<!-- 			<li class="list"> -->
<!-- 				<a href="IndieServlet?command=boardList_form"> - FAQ </a> -->
<!-- 			</li> -->
<!-- 			<br> -->
<!-- 			<li class="list"> -->
<!-- 				<a href="IndieServlet?command=boardList_form"> - Notice </a> -->
<!-- 			</li> -->
<!-- 			<br>  -->
<!-- 			-->
<!-- 		</ul> -->
<!-- 	</div> -->
	<%
	// } else {
	// 	<div class="hr"></div>
	// </div>
	// }
	%>
	<div class="hr"></div>
</div>