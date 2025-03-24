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
	<div class = "container card my-5 bg-info">
		<h3 class ="card-header text-white bg-info">내장객체</h3>
		<pre style="background-color: white;">
		1. jsp 페이지가 웹컨테이너에 의해 서블릿으로 변환될 때
		2. 고정된 이름의 객체컨테이너에 의해 자동으로 구현
		3. request(요청), response(응답), session(정보저장), out(출력)
		</pre>
	</div>
	<div class="container card my-5">
		<h3 class="card-header bg-info text-white">request</h3>
		<pre>
		1. action	> 처리컴포넌트
		2. method	> 처리방식
		3. name 	> 사용자가 입력한 정보값 보관명
		</pre>
		<form action="jsp015_radio.jsp" method="get" onsubmit="return check2()">
			<div class="mb-3 mt-3">
		    	<label for="username1">NAME:</label>
		    	<input type="text" class="form-control" id="username1" placeholder="사용자이름을 적어주세요" name="username">
		    </div>
		    
		    <div class="form-check">
		      <input type="radio" class="form-check-input1" id="radio1" name="optradio" value="YES" style="margin-right:10px;" checked>
		      <label class="form-check-label" for="radio1">YES</label>
		    </div>
		    <div class="form-check">
		      <input type="radio" class="form-check-input1" id="radio2" name="optradio" value="NO" style="margin-right:10px;">
		      <label class="form-check-label" for="radio2">NO</label>
		    </div>
		    <div class="form-check">
		      <input type="radio" class="form-check-input1" disabled style="margin-right:10px;">
		      <label class="form-check-label">사용못함 disabled</label>
		    </div>
		    
		    <div class="my-3">
		    <button type="submit" class="btn btn-primary">전송</button>
		    </div>
		</form>
		<script>
		function  check2(){
			let username1 = document.querySelector("#username1");
			let radio= document.querySelectorAll(".form-check-input1:checked"); 
			
			if(username1.value == ""){
				alert("빈칸입니다.");  username1.focus();  return false;}  
			if(radio.length == 0){
				alert("체크박스를 한개이상은 체크하셔야합니다.");	return false;}
			
		}		
		</script>
	</div>
</body>
</html>