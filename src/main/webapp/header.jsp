
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" runat="server" href="style.css">
    <title></title>
</head>
<body>

	<c:set var="path" value="<%= request.getRequestURI() %>"></c:set>
	
	
		
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid p-0">
        
          <a class="navbar-brand mt-2" href=""><h5 class="text-white mx-5" >Student - Dashboard <i class="bi bi-mortarboard-fill"></i></h5></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse p-0" id="navbarSupportedContent">
            <ul class="navul navbar-nav me-auto m-0 p-0">
              <li class="navli nav-item">
                <a class="nav-link text-white m-0 <c:if test="${(fn:endsWith(path, '/home')) || (fn:endsWith(path, '/'))}">active</c:if> " aria-current="page" href="/JSP_REGISTERATION/">Home</a>
              </li>
              <li class="navli nav-item">
                <a class="nav-link text-white m-0  <c:if test="${(fn:contains(path, 'notification'))}">active</c:if>" href="notificationsTable.jsp">Notifications</a>
              </li>
              <li class="navli nav-item dropdown">
                <a class="nav-link text-white dropdown-toggle m-0  <c:if test="${(fn:contains(path, 'Marks'))}">active</c:if> " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Mark List
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="semone">Semester 2-1</a></li>
                  <li><a class="dropdown-item" href="semtwo">Semester 2-2</a></li>
                  <li><a class="dropdown-item" href="semthree">Semester 3-1</a></li>
                </ul>
              </li>
              <li class=" navli nav-item">
                <a class="nav-link text-white  m-0  <c:if test="${(fn:contains(path, 'update'))}">active</c:if>" href="updateDetails.jsp">Update Details</a>
              </li>
              <li class=" navli nav-item">
                <a class="nav-link text-white  m-0  <c:if test="${(fn:contains(path, 'change'))}">active</c:if>" href="changePassword.jsp">Change password</a>
              </li>
            </ul>
            <form class="d-flex mx-3" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" >
              <button class="btn btn-success" type="submit">Search</button>
            </form>
             <c:if test="${student != null }">
             	<p class="display-6 m-2" Style="font-size: 25px;">Welcome ${student.fname }</p>
             	<button class="btn btn-secondary m-2">
					<a class="nav-link" href="logout">Logout</a>
				</button>
             </c:if>
             <c:if test="${staff != null }">
             	<p class="display-6 m-2" Style="font-size: 20px;">Welcome ${staff.fname }</p>
             	<button class="btn btn-secondary m-2">
					<a class="nav-link" href="logout">Logout</a>
				</button>
             </c:if>
            <c:if test="${student == null && staff == null }">
            	<button class="btn btn-warning m-2">
					<a class="nav-link" href="loginPage.jsp">Login / SignUp</a>
				</button>
            </c:if>
            
          </div>
        </div>
      </nav>


	<script src="script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>