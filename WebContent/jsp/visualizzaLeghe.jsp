<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Le mie leghe</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/visual.css">


<%--<link href="<%=request.getContextPath()%>/css/admin.css" rel="stylesheet" />  --%>

</head>
<body>

	<jsp:include page="topbar.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">
		<div id="lelist" class="list-group">

			<c:if test="${empty myleghe}">
				<h3>
					<span class="label label-info">Attualmente non partecipi a nessuna lega</span>
				</h3>
			</c:if>

			<c:forEach var="Obj" items="${myleghe}">
				<a id="${Obj.value}" data-nl="${Obj.key}" class="list-group-item"> La squadra <strong> ${Obj.value} </strong> che partecipa alla lega <strong> ${Obj.key} </strong>
				</a>
			</c:forEach>

		</div>
	</div>

	<br>
	<br>

	<div id="classif" style="display: none">
		<div class="container">
			Classifica lega <strong> <span id="nlega"> </span>
			</strong>

			<div class="panel-heading"></div>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Squadra</th>
						<th>Punteggio</th>
					</tr>
				</thead>
				<tbody>
			
				</tbody>
			</table>
			<br> 
			<%-- progress bar --%>
			<div class="container">
				<h4>Percentuale completamento lega</h4>
				<div class="progress">
					<div id="progbar" class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" >
						<span class="sr-only">giornate calcolare</span>
					</div>
				</div>
			</div>
			<%-- --%>
		<br>
		<br>	
			<a id="goto" href="<%=request.getContextPath()%>/SquadraServlet?action=pagsquadra&nsquadra="> Vai alla pagina squadra </a>

		</div>


	</div>
	
	<br>
	
	<hr>
	<br>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/visualizza.js" type="text/javascript"></script>

</body>
</html>