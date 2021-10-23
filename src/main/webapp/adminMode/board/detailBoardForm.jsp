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
	height: 2rem; border : 0px;
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
	height: 2rem; border : 0px;
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
	height: 2rem; border : 0px;
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
					<h1 class="titleFormat">게시글 상세보기</h1>
				</div>
				<div class="headerinfo">
					<span style="font-size: 30px; font-weight: bold;">${boardInfo.b_title}</span>
				</div>
				<div class="musicInfo">
					<div class="photo">
						<img class="album" alt="${boardInfo.b_picture }"
							src="${pageContext.request.contextPath}/img/board/${boardInfo.b_picture }">
					</div>
					<form id="updateBoard"
						action="${pageContext.request.contextPath}/IndieServlet?command=board_update&b_num=${boardInfo.b_num }" method="post"
						name="formm" enctype="multipart/form-data">
						<table>
							<tr>
								<td colspan="2">
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										게시글 제목
									</label>
									<br>
									<input class="size" type="text" name="b_title" value="${boardInfo.b_title }">
								</td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										작성자
									</label>
									<br>
									<input class="size" type="text" name="b_category" value="${boardInfo.b_category }">
								</td>
								<td>
									<label>조회수</label>
									<br>
									${boardInfo.b_readCnt }
								</td>
							</tr>
							<tr>
								<td>
									<label>
										<span style="color: red; font-weight: bold;">*</span>
										작성일
									</label>
									<br>
									${boardInfo.b_regDate }
								</td>
								<td>
									<label for="m_genre">
										<span style="color: red; font-weight: bold;">*</span>
										수정일
									</label>
									<br>
									<br>
									${boardInfo.b_upDate }
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<label>게시글 사진(변경을 원할시 선택해주세요.)</label>
									<br>
									<input class="size" type="file" name="b_picture" size="50" value="
									${boardInfo.b_picture }">
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<label>내용</label>
									<br>
									<textarea rows="20" cols="100" name="b_content">${boardInfo.b_content }</textarea>
								</td>
							</tr>
						</table>
						<hr color="#f6f6f6">
						<div id="buttons">
							<input class="updateBtn" type="submit" value="수정">
							<input class="deleteBtn" type="button" onclick="location.href='${pageContext.request.contextPath}/IndieServlet?command=board_delete&b_num=${boardInfo.b_num}'" value="삭제">
							<input class="detailBtn" type="button" onclick="javascript:history.back();" value="목록보기">
						</div>
					</form>
				</div>
			</article>
		</div>
	</div>
</div>