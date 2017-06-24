<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Voti</title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.min.css">

</head>
<body>

<div class="container">  

<div class="list-group-item list-group-item-success">
<h3>Inserimento voti</h3>
</div>

<br>
<br>

<h4>Seleziona giornata</h4>
	<select id="giorn" class="form-control">
			<c:forEach var="i" begin="1" end="38">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>

<%-- ---------------form----------------------- --%>
<br>
<br>
<h4>Carica file voti</h4>

<form id="carica"  method="POST" enctype="multipart/form-data">

    <label class="btn btn-default btn-file ">
        Scegli file <input type="file"  name="fileup"  style="display: none;">
    </label>
			<input id="vai" class="btn btn-default" type="submit"  value="Upload"/>
    
</form>
<%-- ---------------form----------------------- --%>
<br>

<div id="risultato">
 <a  href="${pageContext.request.contextPath}" class="btn btn-lg btn-success"> Home</a>
</div>

 </div>


	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/advot.js" type="text/javascript"></script>

</body>
</html>