
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<c:if test="${! varified }">
	<c:set var="details" value="true"></c:set>
</c:if>

<div class="container login px-4" style="width:600px; margin-top: 20px">
	<form method="POST" action="forget">
		<h3 class="display-6 heading">Forget Your password ?</h3>
		<hr>
		<p>Please enter your LoginID and Email address to verify :</p>
		<div class="mb-3">
			<label for="formGroupExampleInput" class="form-label">Login ID : </label> 
				<input type="text" class="form-control <c:if test="${! details}">is-invalid</c:if>"
				id="formGroupExampleInput" placeholder="LoginId" name="loginid"
				required>
				
		</div>
		<div class="mb-3">
			<label for="formGroupExampleInput2" class="form-label">Email : </label> 
				<input type="email" class="form-control <c:if test="${! details}">is-invalid</c:if>"
				id="formGroupExampleInput2" placeholder="Email" name="email"
				required>
					<c:if test="${! details }"><div id="validationServer05Feedback" class="form-text invalid-feedback"><b>Your details are not Matched.</b></div></c:if>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<button class="btn btn-primary w-100 my-3" type="submit">Verify
					Details</button>
			</div>
		</div>
	</form>
</div>