<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
	
	<% String uri = request.getRequestURI();
	%>
	
	<c:set var="path" value="${uri}" scope="request"></c:set>
	<jsp:include page="/header.jsp"></jsp:include>
    <jsp:include page="/home.jsp"></jsp:include>
	
</body>
</html>