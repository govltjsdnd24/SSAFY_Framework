<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: gray;
}

th, td {
	border: 1px dotted black;
	text-align: center;
}

#selectedDel {
	text-align: right;
}
</style>
<script type="text/javascript">
	function dels() {
		document.getElementById("dels").submit();
	} 
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<form action="${root}/attendance/deletes" method="POST"  id="dels">
		<table>
			<tr>
				<th>이슈번호</th>
				<th>학번</th>
				<th>교육생명</th>
				<th>반</th>
				<th>지역</th>
				<th>날짜</th>
				<th>사유</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${list}" var="m" varStatus="cnt">
				<tr>
					<td><a href="${root}/attendance/view?ano=${m.ano }">${m.ano}</a></td>
					<td>${m.usernumber}</td>
					<td>${m.name}</td>
					<td>${m.rclass}</td>
					<td>${m.rname}</td>
					<td>${m.issuedate}</td>
					<td>${m.issue }</td>
					<td><input type="checkbox" name="ano" value="${m.ano}"></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="선택항목삭제">
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>