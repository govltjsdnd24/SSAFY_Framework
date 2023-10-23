<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="member/loginheader.jsp" %>
	<div align="center">
		<h1>Index.jsp</h1>
		<a href="${root }/hello?name=홍길동">hello</a>
		<a href="${root }/param">parameter</a>
		<a href="${root }/mem/insert">회원등록</a>
		<a href="${root }/mem/login">로그인</a>
		<a href="${root }/mem/logout">로그아웃</a>
		<a href="${root }/mem/list">회원리스트</a>
	</div>
</body>
</html>
