<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="jsp022_header.jsp" %>

	<div class = "container card my-5">
		<h3 class ="card-header">JOIN-회원가입</h3>
		<p style="text-align: center;" class="my-5"><img src="img/login.png" alt="login" ></p>
		<form action="<%=request.getContextPath()%>/user_join" method="post" onsubmit="return login()">
		  <div class="mb-3 mt-3">
		    <label for="userID" class="form-label">ID:</label>
		    <input type="text" class="form-control" id="userID" placeholder="Enter ID" name="userID">
		  </div>
		  <div class="mb-3">
		    <label for="userPW" class="form-label">Password:</label>
		    <input type="password" class="form-control" id="userPW" placeholder="Enter password" name="userPW">
		  </div>
		  <div class="form-check mb-3">
		    <label class="form-check-label">
		      <input class="form-check-input" type="checkbox" name="remember"> Remember
		    </label>
		  </div>
		  <button type="submit" title="login 하러가기" class="btn btn-primary my-3">Submit</button>
		</form>
		<script>
			function login(){
				let userID = document.getElementById("userID");
				let userPW = document.getElementById("userPW");
				
				if(userID.value==""){alert("아이디를 입력하세요"); userID.focus(); return false;}
				if(userPW.value==""){alert("비밀번호를 입력하세요"); userPW.focus(); return false;}
			}
		</script>
	</div>
	
<%@ include file="jsp022_footer.jsp" %>