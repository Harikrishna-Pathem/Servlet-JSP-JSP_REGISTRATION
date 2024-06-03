<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String uri = request.getRequestURI();
	%>

	<c:set var="path" value="${uri}" scope="request"></c:set>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container  pt-3">
		<div class="row justify-content-center">
		<h3 class=" display-6 text-center">${from} <c:if test="${fn:contains(from, 'Register')}">Your Login Id is <b>${loginId}</b></c:if> </h3>
		<h6 class="text-center mb-5">Please try to login </h6>
			<div class="col-10">
				<jsp:include page="/login.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>