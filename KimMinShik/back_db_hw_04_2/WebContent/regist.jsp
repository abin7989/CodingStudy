<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
<%--분리한 header.jsp 가져오기 --%>
	<%@ include file="include/header.jsp"%>
	<h1>SSAFY 사용자 관리</h1>
	<form method="post" action="main">
		<fieldset>
		<legend>사용자 정보 입력</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="regist">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id"><br>
		<label for="password">비밀번호</label>
		<input type="password" id="password" name="password"><br>
		<label for="name">이름</label>
		<input type="text" id="name" name="name"><br>
		<label for="email">이메일</label>
		<input type="email" id="email" name="email"><br>
		<label for="age">나이</label>
		<input type="number" id="age" name="age"><br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>