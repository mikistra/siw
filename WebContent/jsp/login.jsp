<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login/register</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">

</head>
<body>


	<div class="container">

		<div class="col-md-6">
			<form class="form-horizontal" action="AccessServlet?action=login" method="POST">

				<div class="form-group">
					<label class="control-label col-sm-4"><b>Username</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="Username" name="uname" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4"><b>Password</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="password" placeholder="Password" name="psw" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-6 col-sm-4">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</div>

			</form>
		</div>

		<div class="col-md-6">
			<form class="form-horizontal" action="AccessServlet?action=register" method="POST" onsubmit="return testfields(this)">

				<div class="form-group">
					<label class="control-label col-sm-2"><b>Nome</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="nome" name="name" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2"><b>Cognome</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="cognome" name="surname" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2"><b>Username</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="username" name="usr" required>
					</div>
				</div>

				<div id="availability" class="form-group"></div>

				<div class="form-group">
					<label class="control-label col-sm-2"><b>Email</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="email" name="mail" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2"><b>Password</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="password" placeholder="password" name="psw" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2"><b>Conferma Password</b></label>
					<div class="col-sm-4">
						<input class="form-control" type="password" placeholder="ripeti password" name="pswrepeat" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button type="submit" class="btn btn-primary">Sign Up</button>
					</div>
				</div>

			</form>
		</div>
	</div>


	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/loginscripts.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>




</body>
</html>