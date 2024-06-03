<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String uri = request.getRequestURI();
	%>
	
	<c:set var="path" value="${uri}" scope="request"></c:set>
	<jsp:include page="/header.jsp"></jsp:include>
    <div class="container">
    	<div class="row justify-content-center">
    		<div class="col-10">
    			<jsp:include page="/notifications.jsp"></jsp:include>
    		</div>
    	</div>
    </div>
</body>
</html>