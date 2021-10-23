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
					<h1 class="titleFormat">게시글 신규 등록</h1>
				</div>
				<form id="insertBoard"
					action="${pageContext.request.contextPath}/IndieServlet?command=board_insert" method="post"
					name="formm" enctype="multipart/form-data">
					<table>
						<tr>
							<td>
								<label>
									<span style="color: red; font-weight: bold;">*</span>
									게시글 제목
								</label>
								<br>
								<input class="size" type="text" name="b_title">
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								<label for="b_category">
									<span style="color: red; font-weight: bold;">*</span>
									카테고리
								</label>
								<br>
								<select name="b_category" id="b_category" class="selectCondition size">
									<option value="news">뉴스</option>
									<option value="magazine">매거진</option>
									<option value="concert">콘서트</option>
								</select>
							</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2">
								<label>게시글 사진</label>
								<br>
								<input class="size" type="file" name="b_picture" size="50">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<label>내용</label>
								<br>
								<textarea rows="20" cols="100" name="b_content"></textarea>
							</td>
						</tr>
					</table>
					<hr color="#f6f6f6">
					<div id="buttons">
						<input class="updateBtn" type="submit" value="등록">
						<input class="detailBtn" type="button" onclick="javascript:history.back();" value="목록보기">
					</div>
				</form>
			</article>
		</div>
	</div>
</div>