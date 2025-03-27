<%@page import="com.company.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../inc/header.jsp" %>

	<div class = "container my-5" style="border-bottom: 2px solid #2A9d8f; margin-bottom: 0; padding-bottom: 10px;">
		<h1 class ="card-header" style="font-weight: bold; font-size: 2em; color: #2A9D8F;">게시글 목록</h1>
	</div>
	
	<div class="container my-3" style="border: none;">
	<% BoardDao dao=new BoardDao(); %>
		<table class="table">
		<caption>글 목록</caption>
			<thead class="table-dark">
				<tr>
			        <th scope="col">NO</th>
			        <th scope="col">제목</th>
			        <th scope="col">작성자</th>
			        <th scope="col">작성일</th>
			        <th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><% %></td>
					<td><% %></td>
					<td><% %></td>
					<td><% %></td>
					<td><% %></td>
				</tr>
			</tbody>
		</table>
		<p class="text-end" ><a href="write.jsp" class="btn" style="background-color: #E76F51;">글쓰기</a></p>
	
	</div>
	
	
<%@ include file="../inc/footer.jsp"%>