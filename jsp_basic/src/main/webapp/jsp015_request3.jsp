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
		<h3 class ="card-header">내장객체</h3>
		<form action="jsp015_checkbox.jsp" method="get" onsubmit="return c-check()">
			<div class="mb-3 mt-3">
		    	<label for="uName">NAME:</label>
		    	<input type="text" class="form-control" id="uName" placeholder="사용자이름을 적어주세요" 
		    	name="uName">
		    </div>
			
			<label for="color" class="form-label">COLOR:</label>
			    <select class="form-select" id="color" name="color">
			      <option value="bg-danger">RED</option>
			      <option value="bg-warnning">YELLOW</option>
			      <option value="bg-primary">BLUE</option>
			      <option  value="bg-dark">BLACK</option>
			    </select>
			    <button type="submit" class="btn btn-primary mt-3">전송</button>
		</form>
		<script>
			function check3(){
				let uName = document.querySelector("#uName");
				let color = document.qureySelector("#color>option:checked")
				
				if(uName.value==""){alert("빈칸입니다"); uName.focus(); return false;}
				if(color.value==""){alert("옵션을 선택하세요"); return false;}
			}
		</script>
	</div>
</body>
</html>