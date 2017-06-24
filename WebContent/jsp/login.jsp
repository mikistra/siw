<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login/register</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">

</head>
<body>

	<div id="logo" class="container">
		<div id="riga" class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6" >	<img class="img-responsive" style="  margin:auto;" src="${pageContext.request.contextPath}/imgs/fantastik300.png"> </div>
		<div class="col-md-3"></div>
		</div>
	</div>


	<div class="container">

		<div class="col-md-6 ">
		<div class="well">
			<form class="" action="AccessServlet?action=login" method="POST">

				<div class="form-group">
					<label class="control-label "><b>Username</b></label>
					
						<input class="form-control" type="text" placeholder="Username" name="uname" required>
				
				</div>

				<div class="form-group">
					<label class="control-label "><b>Password</b></label>
					
						<input class="form-control" type="password" placeholder="Password" name="psw" required>
					
				</div>

				<div class="form-group">
					
						<button type="submit" class="btn btn-primary btn-block">Login</button>
				
				</div>

			</form>

			<c:if test="${not empty wronglog}">
				<div class="alert alert-danger alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<strong>Login fallito</strong>
				</div>
			</c:if>

 			
        </div>
        
		<br>
		<br>
		<div class="container">
			<div class="col">
				<a href="${pageContext.request.contextPath}"><span class="btn btn-primary ">Indietro</span></a>
			</div>
	   </div>	
		
		</div>

		<div class="col-md-6 well" >
			<form class="" action="AccessServlet?action=register" method="POST" onsubmit="return testfields(this)">

				<div class="form-group">
					<label class="control-label "><b>Nome</b></label>
					
						<input class="form-control" type="text" placeholder="nome" name="name" required>
				</div>

				<div class="form-group">
					<label class="control-label "><b>Cognome</b></label>
						<input class="form-control" type="text" placeholder="cognome" name="surname" required>
				</div>

				<div class="form-group">
					<label class="control-label "><b>Username</b></label>
						<input class="form-control" type="text" placeholder="username" name="usr" required>
				</div>

				<div id="availability" class="form-group">
				</div>

				<div class="form-group">
					<label class="control-label "><b>Email</b></label>
						<input class="form-control" type="text" placeholder="email" name="mail" required>
				</div>

				<div class="form-group">
					<label class="control-label "><b>Password</b></label>
						<input class="form-control" type="password" placeholder="password" name="psw" required>
				</div>

				<div class="form-group">
					<label class="control-label"><b>Conferma Password</b></label>
						<input class="form-control" type="password" placeholder="ripeti password" name="pswrepeat" required>
				</div>

						<button type="submit" class="btn btn-primary btn-block">Registrati</button>

			</form>


			<c:if test="${not empty wrongreg}">
				<div class="alert alert-danger alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<strong>Registrazione fallita</strong>
					<p>${wrongreg}</p>
				</div>
			</c:if>

		</div>
		
		

		
	</div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/loginscripts.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>




</body>
</html>