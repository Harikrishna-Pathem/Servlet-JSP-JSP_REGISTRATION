<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>

<c:if test="${student != null }">
	<c:set var="current" value="${student}" scope="page" />
	<c:set var="id" value="${student.sid}" scope="page" />
</c:if>
<c:if test="${staff != null }">
	<c:set var="current" value="${staff}" scope="page" />
	<c:set var="id" value="${staff.staffid}" scope="page" />
</c:if>
<div class="container justify-content-center " style="width: 700px">
	<h1 class="display-6 ">Update Details:</h1>
	<h6 class="mb-3 text-center">Update your details here</h6>
	<form class="row g-2 register card p-2" method="POST"
		action="CheckPasswordtoUpdate.jsp">
		<div class="row">
			<div class="col-6">
				<input type="hidden" class="form-control"
					id="formGroupExampleInput2" value="${id}" name="sid"> <label
					for="inputEmail4" class="form-label">First Name :</label> <input
					type="text" class="form-control" id="inputEmail4" name="fname"
					value="${current.fname }" />
			</div>
			<div class="col-6">
				<label for="inputPassword4" class="form-label">Last Name :</label> <input
					type="text" class="form-control" id="inputPassword4" name="lname"
					value="${current.lname }" />
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<label for="inputAddress" class="form-label">Email :</label> <input
					type="email"
					class="form-control <c:if test="${emailerror }">is-invalid</c:if>"
					id="inputAddress" placeholder="example@gmail.com" name="email"
					value="${current.email}" />
				<c:if test="${emailerror }">
					<div id="validationServer05Feedback"
						class="form-text invalid-feedback">Please provide a valid
						Email.</div>
				</c:if>

			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<label for="inputAddress2" class="form-label">Mobile :</label> <input
					type="text" class="form-control" id="inputAddress2" name="mobile"
					placeholder="Mobile Number" value="${current.mobile }" />
			</div>
		</div>
		<div class="row ">
			<div class="col-3">
				<p class="mt-3">Gender :</p>
			</div>
			<div class="form-check form-check-inline mt-3 col-2">
				<input class="form-check-input" type="radio" name="gender"
					id="inlineRadio1" value="male"
					<c:if test="${current.gender == 'male'}">checked</c:if>> <label
					class="form-check-label" for="inlineRadio1">Male</label>
			</div>
			<div class="form-check form-check-inline mt-3 col-2">
				<input class="form-check-input" type="radio" name="gender"
					id="inlineRadio2" value="female"
					<c:if test="${current.gender == 'female'}">checked</c:if>>
				<label class="form-check-label" for="inlineRadio2">Female</label>
			</div>
			<div class="form-check form-check-inline mt-3 col-2">
				<input class="form-check-input" type="radio" name="gender"
					id="inlineRadio3" value="others"
					<c:if test="${current.gender == 'others'}">checked</c:if>>
				<label class="form-check-label" for="inlineRadio3">others</label>
			</div>
		</div>
		<c:if test="${student != null }">
			<div class="row">
				<div class="col-12">
					<label for="inputAddress2" class="form-label">Date Of Birth
						:</label> <input type="date" class="form-control" id="inputAddress2"
						name="dob" value="${student.dob}" />
				</div>
			</div>
		</c:if>
		<c:if test="${staff != null }">
			<div class="row">
				<div class="col-12">
					<select name="subject" class="form-select" aria-label="Default select example">
						<option >--Select Subject--</option>
						<option value="subjectone" <c:if test="${staff.subject == 'subjectone'}">selected</c:if>>subjectOne</option>
						<option value="subjecttwo" <c:if test="${staff.subject == 'subjecttwo'}">selected</c:if>>subjectTwo</option>
						<option value="subjectthree" <c:if test="${staff.subject == 'subjectthree'}">selected</c:if>>subjectThree</option>
						<option value="subjectfour" <c:if test="${staff.subject == 'subjectfour'}">selected</c:if>>subjectFour</option>
						<option value="subjectfive" <c:if test="${staff.subject == 'subjectfive'}">selected</c:if>>subjectFive</option>
					</select>
				</div>
			</div>
		</c:if>
		<div class="row button justify-content-center">
			<div class="col-4 mt-5 mb-2 ">
				<button class="btn btn-secondary w-100">
					<a class="nav-link" href="index.jsp">Cancel</a>
				</button>
			</div>
			<div class="col-4 mt-5 mb-2 ">
				<button type="submit" class="btn btn-primary w-100">Update</button>
			</div>
		</div>
	</form>
</div>