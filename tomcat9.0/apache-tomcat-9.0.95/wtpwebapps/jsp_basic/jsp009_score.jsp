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
		<h3 class="card-header card alert alert-primary mt-3">FORM BASIC-SCORE</h3>
		<div class="alert alert-secondary"></div>
		<p><img src="" alt=""></p>
		
		<h3 class ="card-header">SCORE</h3>
		<form action="jsp009_sresult.jsp" method="post">
		  <div class="mb-3 mt-3">
		    <label for="kor" class="form-label">KOR</label>
		    <input type="number" min="0" max="100" class="form-control" id="kor" placeholder="점수 입력" name="kor">
		  </div>
		  <div class="mb-3">
		    <label for="eng" class="form-label">ENG</label>
		    <input type="number" min="0" max="100" class="form-control" id="eng" placeholder="점수 입력" name="eng">
		  </div>
		  <div class="mb-3">
		    <label for="math" class="form-label">MATH</label>
		    <input type="number" min="0" max="100" class="form-control" id="math" placeholder="점수 입력" name="math">
		  </div>
		  <div style="text-align: right;"><button type="submit" title="제출하러가기" class="btn btn-success my-3">Submit</button></div>
		</form>
	</div>
</body>
</html>