<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <div class="container card">
 	<h3 class = "card-header bg-success text-white">USERS</h3>
 	<!-- ###  c:forEach 오류제거   unkonwn tag -->
 	 <!--  import가 달라요! -->
 	${list}
	<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 	<c:forEach var="u" items="${list}" varStatus="status">
 	<div class="card-body my-3">
 		${u.uno} - ${u.name} -${u.age}
 	</div>
 	</c:forEach> --%>
 </div>
</body>
</html>