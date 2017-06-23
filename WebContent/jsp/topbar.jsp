<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="model.Giocatore" %>
<%@ page import="java.util.List" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<nav class="navbar navbar-default ">
<div class="container-fluid navbar-left">
<%-- <label class="">Ciao, ${loggeduser} </label> --%>
<p class="navbar-brand">Ciao,</p>
<p class="navbar-brand">${loggeduser}</p>
</div>

<div class="container-fluid navbar-right ">
<a class="btn btn-default"  href= "${pageContext.request.contextPath}"> Home</a>
<a href= "${pageContext.request.contextPath}" class="btn btn-default"  >bt1</a>


<button class="btn btn-default navbar-btn " > leghe</button>

<button class="btn btn-default"  > logout</button>

<input class="btn btn-default" type="submit" form="navform" value="loggoout" />
</div>

</nav>

<form  id="navform" class="form-inline" action="${pageContext.request.contextPath}/AccessServlet?action=logout" method="POST">
</form>

</body>
</html>