<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
		.allchart{
		margin: 30px 0 0 30px;
		}
		
		.headerinfo{
		width: 720px;
		height: 70px;
		}
		.form{
		width:720px;
		height: 50px;
		}
		
		input[type=checkbox] + label{
		display: inline-block;
		margin-left: 10px;
		width: 30px;
		height: 20px;
		border: 2px solid #bcbcbc;
		cursor: pointer;
		margin-bottom: 5px;
		}
		
		input[type=checkbox]:checked + label{
		background-color: #666666;
		}
		
		input[type=checkbox]{
		display: none;
		}
		
		#input1{
		vertical-align:top;
		width: 130px;
		height: 30px;
		margin-bottom : 5px;
		margin-left : 10px;
		background-color:white;
		border: 2px solid black;
		border-radius: 50px; 
		text-align: center;
		}
		
		#input2{
		}
		
		</style>
		<script type="text/javascript">
		function NoMultiChk(chk){ 
			var obj = document.getElementsByName("genre"); 
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}	

		</script>
		
<article class="allchart">
	<div class="headerinfo">
		<span style="font-size:30px; font-weight:bold;">추천곡 장르와 곡 수를 정하세요.</span>
	</div>
	<div class="form">
		<form method="post" name="formm" action="IndieServlet?command=random_action">
			<input type="checkbox" id="cb1" name="genre" value="bal" checked="checked" onclick="NoMultiChk(chk)">
			<label for="cb1"></label>발라드
			<input type="checkbox" id="cb2" name="genre" value="dan" onclick="NoMultiChk(this)">
			<label for="cb2"></label>댄스
			<input type="checkbox" id="cb3" name="genre" value="hip" onclick="NoMultiChk(this)">
			<label for="cb3"></label>힙합
			<input type="checkbox" id="cb4" name="genre" value="in" onclick="NoMultiChk(this)">
			<label for="cb4"></label>인디
			<input id="input1" type="text" name="r_num" placeholder="숫자만 입력하세요">
			<input id="input2" type="image" src="./img/common/icon_search.png" value="확인" class="submit" style="width: 40px; height: 40px">
		</form>
	</div>
</article>
	
		
		
		
		
	</div>
</div>
<%@ include file="/footer.jsp"%>