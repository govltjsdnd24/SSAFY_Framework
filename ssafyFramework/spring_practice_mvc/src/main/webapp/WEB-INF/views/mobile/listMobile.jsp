<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	  <h2>핸드폰 목록</h2>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>고유번호</th>
	        <th>모델명</th>
	        <th>가격</th>
	        <th>제조사</th>
	      </tr>
	    </thead>
	    <tbody>
			<c:forEach items="${list}" var="m" varStatus="cnt">
				<tr class="table-danger">
					<td><a
						href="${root}/mobile/view?mobileCode=${m.mobileCode }">${m.mobileCode}</a></td>
					<td>${m.model }</td>
					<td>${m.price}</td>
					<td>${m.company }</td>
				</tr>
			</c:forEach>
	    </tbody>
	  </table>
	</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>