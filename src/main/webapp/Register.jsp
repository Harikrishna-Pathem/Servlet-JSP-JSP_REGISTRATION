<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>


    <div class="container justify-content-center " style="width:700px">
        <h1 class="display-6 mb-4">Registeration Form:</h1>
        <h6 class="mb-3 text-center">Get Register with to get access into Student Dashboard</h6>
      <form class="row g-2 register card p-2" method="POST" action="register">
        <div class="row">
          <div class="col-6">
            <label for="inputEmail4" class="form-label">First Name :</label>
            <input type="text" class="form-control" id="inputEmail4" name="fname"/>
          </div>
          <div class="col-6">
            <label for="inputPassword4" class="form-label">Last Name :</label>
            <input type="text" class="form-control" id="inputPassword4" name="lname"/>
          </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="inputAddress" class="form-label">Email :</label>
                <input
                  type="email"
                  class="form-control <c:if test="${emailerror }">is-invalid</c:if>"
                  id="inputAddress"
                  placeholder="example@gmail.com"
                  name="email"
                />
                <c:if test="${emailerror }"><div id="validationServer05Feedback" class="form-text invalid-feedback">Please provide a valid Email.</div></c:if>
       
              </div>
        </div>
        
        		
        <div class="row">
            <div class="col-6">
                <label for="inputAddress2" class="form-label">Password :</label>
                <input
                  type="password"
                  class="form-control <c:if test="${pwderror }">is-invalid</c:if>"
                  id="inputAddress2"
                  name="password"
                />
            </div>
            <div class="col-6">
                <label for="inputAddress2" class="form-label">ReEnter - Password :</label>
                <input
                  type="password"
                  class="form-control <c:if test="${pwderror }">is-invalid</c:if>"
                  id="inputAddress2"
                  name="repassword"
                />
                <c:if test="${pwderror }"><div id="validationServer05Feedback" class="invalid-feedback">Your password doesn't Match</div></c:if>
            </div>
           
        </div>
        <div class="row">
            <div class="col-12">
                <label for="inputAddress2" class="form-label">Mobile :</label>
                <input
                  type="text"
                  class="form-control"
                  id="inputAddress2"
                  name="mobile"
                  placeholder="Mobile Number"
                />
            </div>
        </div>
        <div class="row ">
            <div class="col-3">
                <p class="mt-3">Gender :</p>
            </div>
            <div class="form-check form-check-inline mt-3 col-2">
                <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="male">
                <label class="form-check-label" for="inlineRadio1">Male</label>
            </div>
            <div class="form-check form-check-inline mt-3 col-2">
                <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="female">
                <label class="form-check-label" for="inlineRadio2">Female</label>
            </div>
            <div class="form-check form-check-inline mt-3 col-2">
                <input class="form-check-input" type="radio"name="gender" id="inlineRadio3" value="others">
                <label class="form-check-label" for="inlineRadio3">others</label>
            </div>   
        </div>
        <div class="row">
            <div class="col-12">
                <label for="inputAddress2" class="form-label">Date Of Birth :</label>
                <input
                type="date"
                  class="form-control"
                  id="inputAddress2"
                  name="dob"
                />
            </div>
        </div>        
        <div class="row button justify-content-center">
            <div class="col-6 mt-5 mb-2 ">
                <button type="submit" class="btn btn-primary w-100">Register</button>
            </div>
        </div>
      </form>
    </div>