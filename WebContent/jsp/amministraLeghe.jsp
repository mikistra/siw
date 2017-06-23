<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amministra</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/admin.css"  />

</head>

<body>
	<jsp:include page="topbar.jsp"></jsp:include>
	<br>
	<br>

	<div class="container">
<h3>Leghe da te amministrate:</h3>
<br>
<br>
		<div id="lelist" class="list-group">

		<c:if test="${empty listaleghe}">
			<h3>
				<span class="label label-info">Attualmente non amministri alcuna lega</span>
			</h3>
		</c:if>

		<c:forEach var="Lega" items="${listaleghe}">
			<a id="${Lega.idlega}" class="list-group-item">${Lega.nomelega}</a>
		</c:forEach>

</div>
	</div>
<br>
<br>
<br>

	<div class="container" id="hid" style="display: none;">

<div id="exTab2" class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#1" data-toggle="tab">Crea nuova squadra</a></li>
			<li><a href="#2" data-toggle="tab">Calcola giornata</a></li>
		</ul>

		<div class="tab-content ">

       <div class="tab-pane active" id="1">
<%-- ------------########################################################### --%>
		<h3>Aggiungi nuova squadra</h3>
		<br> <br>

		<div class="alert alert-warning"><strong>Scegli: 2 portieri, 5 difensori, 5 centrocampisti e 4 attaccanti</strong></div>
		<br>
		<div class="input-group">
			<span class="input-group-addon" >Username</span> 
			<input id="usin" type="text" class="form-control" >
		</div>
		<br> <br>
		<div class="input-group">
			<span class="input-group-addon">Nome squadra</span>
			 <input id="nsin" type="text" class="form-control" >
		</div>

<br>
<br>
<div class="container">
<%--  <div class="row"> --%>

<div class="col-xs-4">
<h4>PORTIERI</h4>
<div id="portli" class="list-group" style="max-width: 300px; max-height: 500px; overflow-y: scroll ">

</div>

<h4>CENTROCAMPISTI</h4>
<div id="cenli" class="list-group" style="max-width: 300px; max-height: 500px; overflow-y: scroll ">
  
</div>
  
   
 </div>  
 
 <div class="col-xs-4">
 <h4>DIFENSORI</h4>
<div id="difli" class="list-group" style="max-width: 300px; max-height: 500px; overflow-y: scroll ">
  
</div>

<h4>ATTACCANTI</h4>
 <div id="attli" class="list-group" style="max-width: 300px; max-height: 500px; overflow-y: scroll ">
  
</div>
   
 </div>  
 
 <div class="col-xs-4">
 <h4>SQUADRA SCELTA</h4>
<div id="myteam" class="list-group" style="max-width: 300px; height: 900px; overflow-y: scroll ">
 <h5><strong>PORTIERI</strong></h5>
  <div id="mypo" > 
  </div>
  <h5> <strong>DIFENSORI</strong></h5>
  <div  id="mydi">
  </div>
   <h5><strong>CENTROCAMPISTI</strong></h5>
  <div id="myce">
  </div> 
   <h5><strong>ATTACCANTI</strong></h5>
  <div  id="myat">
  </div>
  
</div>
   
 </div>  



</div>
<br>
<br>
    <button id="conf" type="button" class="btn btn-primary btn-lg btn-block">Conferma</button> 
<br>
<br>
            </div>
<%-- --------prev-------- fine sezione crea squadra---------- --%>

				<div class="tab-pane" id="2">
					<div class="container">
					       
					       <h3>Seleziona giornata</h3>
						<div id="ngiornata" class="row">
							<div class="container">
								<nav aria-label="Page navigation">
								<ul id="indgiorn" class="pagination">
									<%-- <li><a href="#">1</a></li>  --%>
								</ul>
								</nav>
							</div>
						</div>
						<br>
						<br>
						<div id="evbutt" ></div>

					</div>
				</div>

<%-- ---------------- fine sezione calcolo---------- --%>

			</div>  <%-- --tab content------ --%>
</div> <%-- ---extab------- --%>

<%-- --------prev--- ------------- ----- --%>
	</div>


<hr>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/amministra.js" type="text/javascript"></script>

</body>
</html>