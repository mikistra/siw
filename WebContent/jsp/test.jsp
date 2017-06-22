<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="model.Utente"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/sweetalert.css">
</head>
<body>
 
 <jsp:include page="topbar.jsp"></jsp:include>
 
 
CIAOO carissimo   "${loggeduser}"
 <br>
<br>

<br>
<br>
....altre cose...

<br>
<form action="<%=request.getContextPath() %>/AccessServlet?action=logout" method="POST">
    <input type="submit" value="Guarda che bel bottono" />
</form>


<script src="<%=request.getContextPath() %>/js/jquery-3.1.1.js" type="text/javascript" ></script>
<script src="<%=request.getContextPath() %>/js/loginscripts.js" type="text/javascript" ></script>
<script src="<%=request.getContextPath() %>/js/sweetalert.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>

</body>
</html>