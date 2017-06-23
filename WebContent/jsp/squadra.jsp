<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>La mia squadra</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/squad.css">

</head>

<body>

<jsp:include page="topbar.jsp"></jsp:include>
	<br>
	<br>

	<div class="container">
		<h1> Pagina della squadra <span id="nsquadra">${nsquadra}</span></h1>
		<h2> partecipante alla lega <span id="nlega">${nlega}</span> </h2>
		
	</div>

	<div id="exTab2" class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#1" data-toggle="tab">Risultati</a></li>
			<li><a href="#2" data-toggle="tab">Inserisci formazione</a></li>
			<li><a href="#3" data-toggle="tab">other section</a></li>
		</ul>

		<div class="tab-content ">
		
			<div class="tab-pane active" id="1">
				<h3><strong>Risultati giornate concluse </strong></h3>
				<br>
				<h4>Seleziona giornata</h4>
				<div id="ngiornata" class="row">
				  <div class="container">
					<nav aria-label="Page navigation">
					<ul id="indgiorn" class="pagination">
					
				<%-- 		<li><a href="#">1</a></li>  --%>
					
					</ul>
					</nav>
					</div>
				</div>
				
				<div id="allsq" class="container">
					

					
				</div> 
				
				
			</div>
			
<%--  ---- ---------- ------- ---SEZIONI---- --------- --------- -----   ------------------  --%>

			<div class="tab-pane" id="2">
				<div class="container">


					<br>
					<h4>Scegli il modulo</h4>
					<br>
					<select id="modulo" class="form-control">
						<option>4-4-2</option>
						<option>3-5-2</option>
						<option>4-3-3</option>
						<option>3-4-3</option>
						<option>5-3-2</option>
						<option>4-5-1</option>
						<option>5-4-1</option>						
					</select>
					<br>
					<div class="alert alert-warning">
						<strong>Trascina i giocatori e componi la tua squadra. Lascia fuori le riserve, verranno aggiunte automaticamente</strong>
					</div>


					<div class="container">
						<div class="row">
						
						<div class="col-xs-4">
						<h4>Giocatori disponibili</h4>
						
						<div id="myteam" class="list-group" style="max-width: 300px; height: 750px;">
						
						<div id="myP" class="dropp" style="height: 90px; border:2px "></div>
						<div id="myD" class="dropd" style="height: 220px; border:2px "></div>
						<div id="myC" class="dropc" style="height: 220px; border:2px "></div>
						<div id="myA" class="dropa" style="height: 190px; border:2px "></div>
						</div>						
						</div>	
							
						<div class="col-xs-4">
						<h4>Formazione scelta</h4>
						
						<div id="myform" class="list-group" style="max-width: 300px; height: 750px;">
					
						<div class="mypd dropp" >
						</div>
						<div class="mydd dropd" >
						</div>
						<div class="mycd dropc" >
						</div>
						<div class="myad dropa" >
						</div>
						
						</div>
						</div>		
						
	
						</div>
					</div>	
						
						<div class="container">
							<div class="row">
					<h4>Scegli la giornata</h4>
					<br>
					<select id="giorndd" class="form-control">						
					</select>
						</div>
						<br>
						<div class="row">
						
						<div id="subform" class="btn btn-primary btn-lg btn-block">Inserisci Formazione</div>
						</div>
						<br>					
					</div>

					

				</div>
				
				<br>
			</div>

<%--  ---- ---------- ------- ---SEZIONI---- --------- --------- -----   ------------------  --%>


			<div class="tab-pane" id="3">
				<h3>zzzzzzzzzzzzzzzzzzzzzzzz zzzzzzzzzzzzZZZ zzzzzzzzzzzzzzzzzzzz Z zzzz Z z ZZZZZZZzz</h3>
				<div>
				  
				</div>
				
			</div>

		</div>
		
	</div>



<hr>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/squadra.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	
</body>
</html>