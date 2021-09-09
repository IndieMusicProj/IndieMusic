<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="aside">
	<div class="subNavWrap">
		<div class="title">
			<img src="" alt="인기">
			<span class="navName">음악 관리</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/insertMusicForm.jsp"> - 노래 정보 추가
				</a>
			</li>
			<br>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/updateMusicForm.jsp"> - 노래 정보 수정 </a>
			</li>
			<br>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/deleteMusicForm.jsp"> - 노래 정보 삭제 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="" alt="">
			<span class="navName">회원 정보 관리</span>
		</div>
		<br>
		<table class="subMenu">
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/adminMode/insertMemberForm.jsp"> - 회원 정보 추가</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/adminMode/updateMemberForm.jsp"> - 회원 정보 수정</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/adminMode/deleteMemberForm.jsp"> - 회원 정보 삭제</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="" alt="">
			<span class="navName">게시판 관리</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/insertBoardForm.jsp"> - 게시판 정보 추가 </a>
			</li>
			<br>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/updateBoardForm.jsp"> - 게시판 정보 수정 </a>
			</li>
			<br>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/deleteBoardForm.jsp"> - 게시판 정보 삭제 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="" alt="">
			<span class="navName">관리자 계정 관리</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/insertAdminForm.jsp"> - 관리자 계정 생성 </a>
			</li>
			<br>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/updateAdminForm.jsp"> - 관리자 계정 수정 </a>
			</li>
			<br>
			<li class="list">
				<a href="<%=request.getContextPath()%>/adminMode/deleteAdminForm.jsp"> - 관리자 계정 삭제 </a>
			</li>
			<br>
		</ul>
	</div>
</div>