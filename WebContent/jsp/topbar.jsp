<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style >

.navbar-form input, .form-inline input {
	width:auto;
}


#nav.affix {
    position: fixed;
    top: 0;
    width: 100%;
    z-index:10;
}


.navbar-default {
    background-color: #e1ecf7;
    border-color: #E7E7E7;
}

.navbar-default .navbar-nav > li > span > a {
    color: white;
}

.navbar-nav > li{
  padding-left:20px;
}

</style>


</head>

<body>
	<div id="logo" class="container">
		<div id="riga" class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6" >	<img class="img-responsive" style="  margin:auto;" src="${pageContext.request.contextPath}/imgs/fantastik300.png"> </div>
		<div class="col-md-3"></div>
		</div>
	</div>
<%------------------------------------------------------------------------- --%>
<!-- Begin Navbar -->
<div id="nav">
  <div class="navbar navbar-default navbar-static-top">
    <div class="container">
      <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
      <span  class="navbar-brand">Ciao</span>
         <span  class="navbar-brand">${loggeduser}</span>
      <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
<%-- 						<li class="active"><a href="${pageContext.request.contextPath}">HOME</a></li> --%>
						<li></li>
					</ul>
					<ul class="nav pull-right navbar-nav">
						<li></li>
						<li>
						</li>
						<li><span class="btn btn-primary navbar-btn"> <a href="${pageContext.request.contextPath}">HOME</a></span></li>
				    	<li></li>
						<li>
							<button class="btn btn-primary navbar-btn" type="submit" form="navform">
								<span></span> <span class="glyphicon glyphicon-off"> </span>
							</button>
						</li>
					</ul>
				</div>		
    </div>
  </div>
</div>

<%------------------------------------------------------------------------------------------ --%>

<form  id="navform" action="${pageContext.request.contextPath}/AccessServlet?action=logout" method="POST">
</form>


	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

	<script  type="text/javascript">
	
	$('#nav').affix({
	  //    offset: {
	   //     top: $('#logo').height()
	   target : $("#logo")  
	   
	    //  }
	
	});	
			
	</script>


</body>
</html>