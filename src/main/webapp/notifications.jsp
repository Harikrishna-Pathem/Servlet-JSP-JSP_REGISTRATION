
<%@ page import="com.reg.dao.*, java.util.List, com.reg.model.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" runat="server" href="style.css">
<title>Document</title>
</head>
<body>

	<h3 class="mt-5 display-6">Notifications :</h3>

	<%
	StudentDAO sdao = new StudentDAOImpl();
	List<Notification> notifications = sdao.getNotification();
	request.setAttribute("notifications", notifications);
	%>



	<div class="nots">
		<table class="table table-striped table-hover mt-3">
			<thead>
				<tr>
					<th scope="col">Release Date</th>
					<th scope="col">Notification</th>
				</tr>
			</thead>
			<tbody>

			<%-- 	<%
				for (Notification not : notifications) {
				%>
			--%>
			<c:forEach var="notification" items="${notifications}" >
				<tr>
					<th>${notification.date}</th>
					<td>${notification.text}</td>
				</tr>
			</c:forEach>
			<%-- 	<%
				}
				%>
			--%>
			</tbody>
		</table>
	</div>
</body>
</html>