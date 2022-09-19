<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
<style>
#user-list {
	border-collapse: collapse;
	width: 100%;
}

#user-list td, #user-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
<%--분리한 header.jsp 가져오기 --%>
	<%@ include file="include/header.jsp"%>
	<h1>등록된 사용자 목록</h1>
	<%-- 사용자 수 등록되어있다면 출력하기 --%>
	<c:if test="${!empty users}">
		<h2>지금까지 등록한 사용자 수 : ${userCount}</h2>
	</c:if>
	<table id="user-list">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 등록된 자료를 반복문을 이용해 출력한다. 테이블의 구성은 위 thead 참고 --%>
			<c:forEach items="${users}" var="user" varStatus="vs">
				<tr>
					<td>${user.id}</td>
					<td>${user.password}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.age} 세</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>