<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
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
	<div class="container pt-5">
		<c:choose>
			<c:when test="${marks != null }">
				<div class="row justify-content-center">
					<div class="col-10">
						<jsp:include page="/marksTable.jsp"></jsp:include>
					</div>
				</div>
			</c:when>
			<c:when test="${staffmarks != null }">
				<div class="row justify-content-center">
					<div class="col-10">
						<jsp:include page="/staffMarksTable.jsp"></jsp:include>
					</div>
				</div>
			</c:when>
			<c:otherwise>
			<div class="row justify-content-center">
				<h3 class=" display-6 text-center mb-5">Please Login to get Semester Marks :</h3>
					<div class="col-10">
						<jsp:include page="/login.jsp"></jsp:include>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>