<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fantastik</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
</head>
<body>



	<div class="jumbotron">
		<div class="container">
			<h1>ciao,</h1>
			<p>Benvenuto in fantastik, il sito per la gestione del fantacalcio semplice e intuitivo e bla bla</p>
			<p>
				<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AccessServlet?action=loginpage"
					role="button">Accedi</a>
			</p>
		</div>
	</div>

	<div class="container">Content More em aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
		quia voluptas sit aspernatur aut odit aut fugit, sed quia cor magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit
		amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum
		exercitationem ullam corporis suscipit laboriosam, nisi ut</div>


	<hr>

<div class="row">
<div class="col-md-11"></div>
      <div class="col-md-1">
      
          <a href="<%=request.getContextPath()%>/AccessServlet?action=adminvoti"><span class="glyphicon glyphicon-cog"></span></a>
      </div>
   </div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</body>
</html>