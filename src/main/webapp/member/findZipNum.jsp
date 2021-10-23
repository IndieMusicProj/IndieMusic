<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #f6f6f6;
	font-family: Verdana;
}

#popup {
	padding: 0 10px;
}

#popup h1 {
	font-family: "Times New Roman", Times, serif;
	font-size: 45px;
	color: #333333;
	font-weight: normal;
}

table#zipcode {
	border-collapse: collapse; /* border 사이의 간격 없앰 */
	border-top: 3px solid #333333;
	border-bottom: 3px solid #333333;
	width: 100%;
	margin-top: 15px;
}

table#zipcode th, table#zipcode td {
	text-align: center;
	border-bottom: 1px dotted #333333;
	color: #333333;
}

table th, td {
	padding: 10px;
}

table#zipcode  a {
	display: block;
	height: 20px;
	text-decoration: none;
	color: #333333;
	padding: 10px;
}

table#zipcode a:hover {
	color: #F90;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	function result(zip_num, sido, gugun, dong) {
		opener.document.formm.zip_num.value = zip_num;
		opener.document.formm.addr1.value = sido + " " + gugun + " " + dong;
		self.close();
	};
</script>
</head>
<body>
	<div id="popup">
		<form method=post name=formm action="IndieServlet?command=find_zip_num">
			동 이름 :
			<input name="dong" type="text">
			<input type="submit" value="찾기" class="submit">
		</form>
		<table id="zipcode">
			<tr>
				<th>우편번호</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${addressList }" var="addressVO">
				<tr>
					<td>${addressVO.zip_num }</td>
					<td>
						<a href="#"
							onclick="return result('${addressVO.zip_num }','${addressVO.sido}','${addressVO.gugun}','${addressVO.dong}')">
							${addressVO.sido} ${addressVO.gugun} ${addressVO.dong} </a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
