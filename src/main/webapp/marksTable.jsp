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
	<h3 class=" display-6">Semester Marks :</h3>

	

	<h6 class="mb-5 text-center">Welcome ${marks.fname} ${marks.lname} Your semester ${sem} marks are : </h6>

	<div class="rounded">
		<table class="table table-striped-columns rounded">
			<thead>
				<tr>
					<th class="text-center" scope="col">Subjects</th>
					<th class="text-center" scope="col">Marks</th>
					<th class="text-center">Grade</th>
				</tr>
				<tr>
					<th>Subject one</th>
					<td class="text-center">${marks.sub1}</td>
					<th class="text-center <c:if test="${fn:contains(marks.getGrade(marks.sub1), 'F') }">text-danger</c:if>">${marks.getGrade(marks.sub1)}</th>
				</tr>
				<tr>
					<th>Subject two</th>
					<td class="text-center">${marks.sub2}</td>
					<th  class="text-center <c:if test="${fn:contains(marks.getGrade(marks.sub2), 'F') }">text-danger</c:if>">${marks.getGrade(marks.sub2)}</th>
				</tr>
				<tr>
					<th>Subject Three</th>
					<td class="text-center">${marks.sub3}</td>
					<th class="text-center <c:if test="${fn:contains(marks.getGrade(marks.sub3), 'F') }">text-danger</c:if>">${marks.getGrade(marks.sub3)}</th>
				</tr>
				<tr>
					<th>Subject Four</th>
					<td class="text-center">${marks.sub4}</td>
					<th class="text-center <c:if test="${fn:contains(marks.getGrade(marks.sub4), 'F') }">text-danger</c:if>">${marks.getGrade(marks.sub4)}</th>
				</tr>
				<tr>
					<th>Subject Five</th>
					<td class="text-center">${marks.sub5}</td>
					<th class="text-center <c:if test="${fn:contains(marks.getGrade(marks.sub5), 'F') }">text-danger</c:if>">${marks.getGrade(marks.sub5)}</th>
				</tr>
				
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>