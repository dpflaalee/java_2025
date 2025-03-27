<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../inc/header.jsp" %>


	<div class = "container card my-5">
		<h3 class ="card-header">글쓰기</h3>
	</div>
	
	<div>
		<form action="/action_page.php">
		
			<div class="mb-3 mt-3">
				<label for="bname">작성자:</label>
				<input type="text" class="form-control" id="bname" placeholder="사용자 이름을 작성해주세요" name="bname">
			</div>
			<div class="mb-3">
				<label for="btitle">제목:</label>
				<input type="text" class="form-control" id="btitle" placeholder="글의 제목을 입력해주세요" name="btitle">
			</div>
			<div class="mb-3 mt-3">
				<label for="bcontent">내용:</label>
				<textarea class="form-control" rows="5" id="bcontent" name="bcontent"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<%
	/* 빈칸검사 */
	%>
	
<%@ include file="../inc/footer.jsp"%>