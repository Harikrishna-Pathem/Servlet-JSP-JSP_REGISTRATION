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

	<c:choose>
		<c:when test="${student != null || staff != null}">
			<div class="container mt-5 pt-5">
				<div class="row justify-content-center">
					<div class="col-10">
						<div class="container login px-5"
							style="width: 600px; margin-top: 20px">
							<form method="POST" action="newpassword">
								<h3 class="display-6 heading">Enter New Password :</h3>
								<hr>
								<div class="mb-3">
									<input type="hidden" class="form-control"
										id="formGroupExampleInput2" 
										<c:if test="${student != null}">value="${student.sid}"</c:if>
										<c:if test="${staff != null}">value="${staff.staffid}"</c:if>
										name="loginid">
								</div>
								<div class="mb-3">
									<label for="formGroupExampleInput2" class="form-label">New
										Password : </label> <input type="password" class="form-control"
										id="formGroupExampleInput2" placeholder="new Password"
										name="newpassword">
								</div>

								<div class="mb-3">
									<label for="formGroupExampleInput2" class="form-label">Conform
										Password : </label> <input type="password" class="form-control"
										id="formGroupExampleInput2" placeholder="conform Password"
										name="renewpassword">
								</div>
								<div class="row justify-content-center">
									<div class="col-5">
										<button class="btn btn-primary w-100 my-3" type="submit">Update
											Password</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>


		</c:when>
		<c:otherwise>
			<div class="row justify-content-center">
				<h3 class=" display-6 text-center my-4">Please Login to Change
					your Password :</h3>
				<div class="col-10">
					<jsp:include page="/login.jsp"></jsp:include>
				</div>
			</div>
		</c:otherwise>
	</c:choose>



</body>
</html>