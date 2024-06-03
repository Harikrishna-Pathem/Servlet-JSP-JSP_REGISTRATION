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
	<div class="container mt-5 pt-5">
		<div class="row justify-content-center">
			<div class="col-10">
				<c:if test="${loginid == null }">
					<jsp:include page="/forget.jsp"></jsp:include>
				</c:if>
				<c:if test="${loginid != null }">
					<div class="container login px-5" style="width:600px; margin-top: 20px">
						<form method="POST" action="newpassword">
							<h3 class="display-6 heading">Enter New Password :</h3>
							<hr>
							<div class="mb-3">
								<label for="formGroupExampleInput2" class="form-label">Your LoginId : </label>
								<input type="text" class="form-control"
									id="formGroupExampleInput2"
									value="${loginid}"
									 disabled>
									
								<input type="hidden" class="form-control"
									id="formGroupExampleInput2"
									value="${loginid}"
									name="loginid">
							</div>
							<p>Your given details are matched </p>
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
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>