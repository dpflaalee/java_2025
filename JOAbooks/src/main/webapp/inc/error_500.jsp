<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%  response.setStatus(200); %>  
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class = "container my-5 p-3">
		<h3 class ="card-header"
		style="font-size: 3em; font-weight: bold; text-align: center; color: #ad0011;">ERROR 505</h3>
		<div style="text-align: center;"><%=exception.getMessage() %></div>
		<div class="container card"><a href="<%=request.getContextPath()%>/" class="btn btn-danger">HOME</a></div>
		
	</div>
</body>
</html>