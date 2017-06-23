<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fantastik</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home.css">

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


<%------------########################################------------------------------------- --%>

 
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalNorm">
    Launch
</button>

<!-- Modal -->
<div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog"   aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
      
      
            <div class="modal-header">
                <button type="button" class="close"  data-dismiss="modal">
                		<span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                  Admin Login
                </h4>
            </div>
            
        
            <div class="modal-body">
                
                <form id="modform" role="form" action="${pageContext.request.contextPath}/AccessServlet?action=adminlogin" method="POST">
                  <div class="form-group">
                    <label for="inputuser">User</label>
                      <input type="text" class="form-control" id="inputuser" placeholder="User" name="usr"/>
                  </div>
                  <div class="form-group">
                    <label for="inputpass">Password</label>
                      <input type="password" class="form-control" id="inputpass" placeholder="Password" name="psw"/>
                  </div>

                </form>
                
                
            </div>
           
            <div class="modal-footer">
                   <button type="submit" class="btn btn-primary"  form="modform">Accedi</button>
            </div>
        </div>
    </div>
</div>

<%------------########################################------------------------------------- --%>

	<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/home.js"></script>

</body>
</html>