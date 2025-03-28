<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../inc/header.jsp" %>


	<div class = "container card my-5">
	<%-- <%=request.getAttribute("dto") %> --%>
	<!-- detail.do?bno= -->
		<h3 class ="card-header">Detail</h3>
		<div class="my-3 ">
				<div class="">
					<span><i class="bi bi-book-half"></i> 조회수</span>
					<p>${dto.bhit }</p><!-- dto.getBhit() -->
				</div>
		</div>
		<div class="my-3">
			<div class="">
					<span><i class="bi bi-book-half"></i> 이름</span>
					<p>${dto.bname }</p>
			</div>
		</div>
		<div class="my-3">
			<div class="">
					<span><i class="bi bi-book-half"></i> 제목</span>
					<p>${dto.btitle }</p>
			</div>
		</div>
		<div class="my-3">
			<div class="">
					<span><i class="bi bi-book-half"></i> 내용</span>
					<textarea class="form contril" readonly>${dto.bcontent }</textarea>
			</div>
		</div>
		<div class="text-end">
			<a href="edit_view.do?bno=${dto.bno }" class="btn" style="background-color: #E76F51;">수정</a>
			<a href="delete.do?bno=${dto.bno }" class="btn" style="background-color: #E76F51;">삭제</a>
			<a href="list.do" class="btn" style="background-color: #E76F51;">목록보기</a>
		</div>
	</div>
	<!-- test: http://localhost:8080/JOAbooks/detail.do?bno= -->
	
<%@ include file="../inc/footer.jsp"%>