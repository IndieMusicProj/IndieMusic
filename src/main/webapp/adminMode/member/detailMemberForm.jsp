<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/adminMode/header.jsp"%>
<style>

/* title 부분 */
h1.titleFormat {
	color: ##686564;
	font-size: 2.5rem;
	font-weight: bolder;
	padding: 20px;
}

img.album {
	margin: 20px;
	width: 300px;
}

.size {
	width: 300px;
	margin: 3px;
	height: 1.7rem;
}

input.detailBtn {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #436ea2;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
	border: 0px;
}

input.detailBtn:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

input.updateBtn {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #40ae2a;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
	border: 0px;
}

input.updateBtn:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}

input.deleteBtn {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	background-color: #e67962;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
	border: 0px;
}

input.deleteBtn:hover {
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
	color: white;
	width: 200px;
	height: 2rem;
	border: 0px;
	outline: 0px;
	margin-bottom: 10px;
}
</style>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/adminMode/asideBar.jsp"%></div>
	<div id="grid2co">
		<div class="adminMain">
			<article>
				<div id="title">
					<h1 class="titleFormat">회원정보 상세보기</h1>
				</div>
				<div class="headerinfo" style="padding: 20px;">
					<span style="font-size: 30px; font-weight: bold;">${memberInfo.mb_name}님의 정보</span>
				</div>
				<div class="memberInfo">
					<form id="updateMember"
						action="${pageContext.request.contextPath}/IndieServlet?command=music_update&mb_num=${memberInfo.mb_num }" method="post"
						name="formm">
						<table>
							<tr>
								<td>
									<label>
										아이디(변경 불가)
									</label>
									<br>
									<input class="size" type="text" name="mb_id" value="${memberInfo.mb_id }" readonly="readonly">
								</td>
<!-- 								<td> -->
<!-- 									<label> -->
<!-- 										<span style="color: white; font-weight: bold;">*</span> -->
<!-- 										공백 -->
<!-- 									</label> -->
<!-- 									<br> -->
<!-- 									<input class="detailBtn" type="button" onclick="confirmID();" value="중복확인" -->
<!-- 										style="width: 100px;"> -->
<!-- 								</td> -->
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										비밀번호
									</label>
									<br>
									<input class="size" type="text" name="mb_pwd" value="${memberInfo.mb_pwd }">
								</td>
								<td>
									<label>이름</label>
									<br>
									<input class="size" type="text" name="mb_name" value="${memberInfo.mb_name }">
								</td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										이메일
									</label>
									<br>
									<input class="size" type="text" name="mb_email" value="${memberInfo.mb_email }">
								</td>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										우편번호
									</label>
									<br>
									<input class="size" type="text" name="mb_zipNum" value="${memberInfo.mb_zipNum }">
								</td>
							</tr>
							<tr>
								<td colspan="1">
									<label>주소</label>
									<br>
									<input class="size" type="text" name="mb_address1" value="${memberInfo.mb_address }">
								</td>
							</tr>
							<tr>
								<td>
									<label>폰 번호</label>
									<br>
									<input class="size" type="text" name="mb_mobile" value="${memberInfo.mb_mobile }">
								</td>
								<td>
									<label>가입일자</label>
									<br>
									<input class="size" type="text" name="mb_indate" value="${memberInfo.mb_indate }">
								</td>
							</tr>
						</table>
						<hr color="#f6f6f6">
						<div id="buttons">
<!-- 							<input class="updateBtn" type="submit" value="수정"> -->
							<input class="deleteBtn" type="button"
								onclick="location.href='${pageContext.request.contextPath}/IndieServlet?command=member_delete&mb_num=${memberInfo.mb_num}'"
								value="삭제">
							<input class="detailBtn" type="button" onclick="javascript:history.back();" value="목록보기">
						</div>
					</form>
				</div>
			</article>
		</div>
	</div>
</div>