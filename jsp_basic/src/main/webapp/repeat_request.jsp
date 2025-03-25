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
		<h3 class ="card-header">select box</h3>
		<form action="repeat_response.jsp" method="get" onsubmit="return select()">
			<div class="mb-3 mt-3">
		    	<label for="fruiteName">NAME:</label>
		    	<input type="text" class="form-control" id="fruiteName" placeholder="홍길동" name="fruiteName">
		   </div>
		   <select class="form-select form-select-lg" id="fruit" name="fruit">
		     <option value="apple">ALLPE</option>
		     <option value="banana">BANANA</option>
		     <option value="coconut">COCONUT</option>
		   </select>
		   <button type="submit" class="btn btn-primary my-3">제출</button>		   
		</form> 
	</div>
	<script>
	 	function select(){
	 		let fruiteName = document.getElementById("fruiteName");
	 		let fruit = document.qureySelector("#fruit>option:checked")
	 		
	 		if(fruiteName.value==""){alert('빈칸입니다.'); fruiteName.focus(); return false;}	 		
	 	}
	</script>
</body>
</html>