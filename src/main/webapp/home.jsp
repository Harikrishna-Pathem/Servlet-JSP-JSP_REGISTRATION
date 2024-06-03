<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" runat="server" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-evenly">
			<div class="col-7 ">
				<jsp:include page="/notifications.jsp"></jsp:include>
			</div>
			<div class="col-1">
			<div class="d-flex justify-content-center mt-5 ml-5 pt-5" style="height: 500px;">
				<div class="vr"></div>
			</div>
			</div>
			<div class="col-4 pt-5">
				<jsp:include page="/login.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>