<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#result{
		display: none;
	}
</style>
<title>SSAFY</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<form id="registForm" method="POST" action="${root}/attendance/register">
		<input type="hidden" name="usernumber" value="${memberInfo.usernumber}"/>
		<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="ano" id="ano">
		<br>
		<label for="usernumber" class="inputtitle">학번</label>
		<input type="text" name="usernum" id="usernumber" value="${memberInfo.usernumber}" readonly="readonly">
		<br>
		<label for="name" class="inputtitle">교육생명</label>
		<input type="text" name="name" id="name" value="${memberInfo.name}" readonly="readonly">
		<br>
		<label for="rclass" class="inputtitle">반</label>
		<input type="number" name="rclass" id="rclass"value="${memberInfo.rclass}" readonly="readonly">
		<br>
		<label for="rname" class="inputtitle">지역</label>
		<input type="text" name="rname" id="rname" value="${memberInfo.rname}" readonly="readonly">
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="date" name="issuedate" id="issuedate">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="issue" id="issue" >
		<br>
		<button type="submit">출결 이슈 등록</button>
		<button type="reset">초기화</button>
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>