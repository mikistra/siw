<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newsplugin.css">


</head>
<body>
	<jsp:include page="topbar.jsp"></jsp:include>

	<br>
	<br>
<div class="container">
	<div class="row">
		<div class="col-md-4">
			<div class="thumbnail col-md-9">
				<img src="<%=request.getContextPath()%>/imgs/socc-sample.jpg" alt="...">
				<div class="caption">
					<h3>Crea una lega</h3>
						<p>Crea una nuova lega e diventa amministratore. Aggiungi le squadre dei tuoi amici e unitevi alla comunità di Fantastik </p>
						<p>
							<a style="display: block; " class="btn btn-success" href="${pageContext.request.contextPath}/LegheServlet?action=gocrealega"> <span>CREA</span>
							</a>
						</p>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="thumbnail col-md-9">
				<img src="imgs/socc-sample.jpg" class="responsive" alt="...">
				<div class="caption">
					<h3>Amministra leghe</h3>
					<p>Gestisci le leghe di cui sei amministratore. Aggiungi i giocatori alle squadre, e calcola i punteggi di giornata.</p>
					<p>
							<a style="display: block;" class="btn btn-danger" href="${pageContext.request.contextPath}/LegheServlet?action=goamministra"> <span>AMMINISTRA</span>
							</a>
						</p>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="thumbnail col-md-9">
				<img src="imgs/socc-sample.jpg" alt="..." >
				<div class="caption">
					<h3>Visualizza squadre</h3>
					<p>Controlla l'andamento delle tue squadre e le classifiche di lega, inserisci la formazione di giornata e preparati a fare il tifo!</p>
					<p>
							<a style="display: block;" class="btn btn-primary" href="${pageContext.request.contextPath}/LegheServlet?action=govisualizza"> <span>SCOPRI</span>
							</a>
						</p>
				</div>
			</div>
		</div>
	</div>
</div>


<br>

	<%--   ------------------------------------------------------------------   --%>

	<div class="container">
<div class="col-md-2"></div>

		<div class="col-md-8">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b> Fanta News</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">
						<ul class="demo1">
							<li class="news-item">
								<table ="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/7.png" width="60" class="img-circle" /></td>
										<td>Calciomercato: per il Milan movimenti importanti all'orizzonte, il ds  Zhu è atterrato questo pomeriggio in...<a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/3.jpg" width="60" class="img-circle" /></td>
										<td>Fiorentina: infortunio Bernardeschi. Il giocatore ha riportato un trauma contusivo distorsivo a seguito dell'inf... <a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/1.png" width="60" class="img-circle" /></td>
										<td>Comunicato del giudice sportivo: 8 diffidati e 3 squalificati per la prossima giornata. Tra i gioc... <a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/5.png" width="60" class="img-circle" /></td>
										<td>Anticipo Atalanta - Crotone : comunicate le formazioni ufficiali, i rossoblu scenderanno in campo con il modulo...<a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/4.png" width="60" class="img-circle" /></td>
										<td>Caos Roma, Totti verso l'addio. Presidenza e giocatore distanti, i tifosi protestano. I possibili scenari... <a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/6.png" width="60" class="img-circle" /></td>
										<td>Voti 22esima giornata: vittoria-show del Sassuolo Berardi in gol, Inter sotto la sufficienza, male Handanovic <a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td><img src="${pageContext.request.contextPath}/imgs/slider/2.jpg" width="60" class="img-circle" /></td>
										<td>Rubriche settimanali: top&flop 11 - i migliori 11 giocatori dell'ultima giornata e le peggiori giocate <a href="#">Continua a leggere</a></td>
									</tr>
								</table>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel-footer"></div>
		</div>
	</div>



	</div>


<hr>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/newsplugin.js"></script>
	
</body>
</html>