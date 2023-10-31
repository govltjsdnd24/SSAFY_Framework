<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<style>
	#loginInfo{
		text-align: right;
	}
	#head{
		text-align: center;
	}
	
	.inputtitle{
		display: inline-block;
		width: 100px;
		background: silver;
		text-align: center;
	}
</style>

	<div id="loginInfo">
		<a class="nav-link disabled">${memberInfo.id}님 반갑습니다.</a> 
		<a href="${root}/member/logout">로그아웃</a>
	</div>

<h1 id="head">${title }</h1>
<hr>
