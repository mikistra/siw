<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creazione lega</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
</head>

<body>
	<jsp:include page="topbar.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">


		<form class="form-horizontal" action="" method="POST" id="cf">

			<div class="form-group">
				<label class="control-label col-sm-4"><b>Inserisci nome lega</b></label>
				<div class="col-sm-4">
					<input type="text" name="nomelega" class="form-control" placeholder="nome lega" required id="nomele">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<button type="button" class="btn btn-primary" id="b1">Crea Lega</button>
				</div>
			</div>

		</form>


		<div class="panel panel-default" style="display: none;" id="goback">
			<div class="panel-body">
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/LegheServlet?action=goamministra" > Amministra le tue leghe </a>
			</div>
		</div>

	</div>


	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/crealega.js" type="text/javascript"></script>


</body>
</html>