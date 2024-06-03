<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ page import="com.reg.model.*" %>

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
   <div class="container login mt-5 px-5" style="width: 600px; margin-top: 20px">

	<c:if test="${student != null }">
		<jsp:useBean id="studentUpdate" class="com.reg.model.Student" scope="session">
		<jsp:setProperty name="studentUpdate" property="*"></jsp:setProperty>
	</jsp:useBean>
	</c:if>
	
	<c:if test="${staff != null }">
		<jsp:useBean id="staffUpdate" class="com.reg.model.Staff" scope="session">
		<jsp:setProperty name="staffUpdate" property="staffid" param="sid"></jsp:setProperty>
		<jsp:setProperty name="staffUpdate" property="*"></jsp:setProperty>
	</jsp:useBean>
	</c:if>
	
	<form method="POST" action="update">
		<h3 class="display-6 heading">Enter Your Password :</h3>
		<hr>
		<div class="mb-3">
		</div>
		<p>Give your password to verify thats you !</p>
		<div class="mb-3">
			<label for="inputAddress2" class="form-label">Password :</label>
                <input
                  type="password"
                  class="form-control <c:if test="${pwderror }">is-invalid</c:if>"
                  id="inputAddress2"
                  name="password"
                  
                  
                />
                <c:if test="${pwderror }"><div id="validationServer05Feedback" class="invalid-feedback">Your password doesn't Match</div></c:if>
		</div>

		
		<div class="row justify-content-center">
			<div class="col-5">
				<button class="btn btn-primary w-100 my-3" type="submit">Update Details</button>
			</div>
		</div>
	</form>
</div>
	
</body>
</html>
