<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
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
					<h3>Thumbnail label</h3>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
						<p>
							<a style="display: block; " class="btn btn-success" href="${pageContext.request.contextPath}/LegheServlet?action=gocrealega"> <span>vai a crea</span>
							</a>
						</p>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="thumbnail col-md-9">
				<img src="imgs/socc-sample.jpg" alt="...">
				<div class="caption">
					<h3>Thumbnail label</h3>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
					<p>
							<a style="display: block;" class="btn btn-danger" href="${pageContext.request.contextPath}/LegheServlet?action=goamministra"> <span>vai a amministra</span>
							</a>
						</p>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="thumbnail col-md-9">
				<img src="imgs/socc-sample.jpg" alt="..." >
				<div class="caption">
					<h3>Thumbnail label</h3>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
					<p>
							<a style="display: block;" class="btn btn-primary" href="${pageContext.request.contextPath}/LegheServlet?action=govisualizza"> <span>vai a visualizza</span>
							</a>
						</p>
				</div>
			</div>
		</div>
	</div>
</div>




	<%--   ------------------------------------------------------------------   --%>

<div class="container">

</div>


<hr>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>