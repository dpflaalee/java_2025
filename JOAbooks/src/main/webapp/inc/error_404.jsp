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
<script>
	/* window.onload = function(){
		let result = document.qureySelector(".result");
		result.style.textAlign="center";
	}; */

</script>

</head>
<body>
	<div class = "container card my-5">
		<h3 class ="card-header" 
		style="font-size: 3em; font-weight: bold; text-align: center; color: #ad0011;">ERROR 404</h3>
		<p style="text-align: center;">요청하신 페이지가 없습니다. 관리자에게 문의바랍니다.</p>
		<a href="<%=request.getContextPath()%>/" class="btn btn-danger">HOME</a>
	</div>
</body>
</html>