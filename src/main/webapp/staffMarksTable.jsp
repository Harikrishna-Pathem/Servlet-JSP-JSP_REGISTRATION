<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 class=" display-6">Semester Marks :</h3>



	<h6 class="mb-5 text-center">Welcome ${staff.fname} ${staff.lname}
		Your semester ${sem} marks are :</h6>

	<div class="rounded">
		<table class="table table-striped-columns rounded">
			<thead>
				<tr>
					<th class="text-center" scope="col">S.no</th>
					<th class="text-center" scope="col">Student ID</th>
					<th class="text-center">First Name</th>
					<th class="text-center">Last Name</th>
					<th class="text-center">Marks</th>
					<th class="text-center">Grade</th>
					<th class="text-center">Edit Details</th>
				</tr>

			</thead>
			<tbody>

				<c:forEach var="staffmark" items="${staffmarks}" varStatus="status">
					<tr>
						<th class="text-center">${status.count}</th>
						<td class="text-center">${staffmark.sid }</td>
						<td class="text-center">${staffmark.fname }</td>
						<td class="text-center">${staffmark.lname}</td>
						<td class="text-center">${staffmark.marks }</td>
						<th
							class="text-center <c:if test="${fn:contains(staffmark.getGrade(staffmark.marks), 'F') }">text-danger</c:if>">${staffmark.getGrade(staffmark.marks)}</th>
						<td class="text-center">
							<button class="btn btn-warning w-75">
								<a class="nav-link" href="edit">Edit</a>
							</button>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>