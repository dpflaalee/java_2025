<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class = "container card my-5">
		<h3 class ="card-header">LOGIN</h3>
		<p style="text-align: center;"><img src="img/login.png" alt="login" ></p>
		<form action="jsp008_result.jsp" method="get">
		  <div class="mb-3 mt-3">
		    <label for="email" class="form-label">Email:</label>
		    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		  </div>
		  <div class="mb-3">
		    <label for="pwd" class="form-label">Password:</label>
		    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pass">
		  </div>
		  <div class="form-check mb-3">
		    <label class="form-check-label">
		      <input class="form-check-input" type="checkbox" name="remember"> Remember
		    </label>
		  </div>
		  <button type="submit" title="login 하러가기" class="btn btn-primary my-3">Submit</button>
		</form>
	</div>
</body>
</html>


