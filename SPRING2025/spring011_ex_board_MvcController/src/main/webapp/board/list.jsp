<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<script>
	//window.onload=function(){} 브라우저로딩 작업 맨 마지막 1번만
	//window.addEventListener("load", function(){}) 위쪽을 보완함. 여러번 실행
	//jQuery().read(); == $().read; == $(function(){});
	$(function(){
		let result='${result}'; console.log(result);
		if(result == 'fail'){alert('비밀번호를 확인해주세요'); tistory.go(-1);}
		else if(result.length != 0){alert(result);}
	})
</script>
<div class="container   my-5">
	<h3>MULTIBOARD</h3>	
	<table  class="table table-striped  table-bordered table-hover text-center">
		<caption>MULTIBOARD-LIST</caption>
		<thead>
			<tr><th scope="col">NO</th><th scope="col">TITLE</th>
			      <th scope="col">WRITER</th><th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
		<tbody>
	
		<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
			<c:forEach var="dto" items="${list}" varStatus="status">
				<tr>
					<td>${list.size()-status.index}</td>
					<td><a href="${pageContext.request.contextPath}/board/detail?bno=${dto.bno}">${dto.btitle}</a></td>
					<td>${dto.bname}</td>
					<td>${dto.bdate}</td>
					<td>${dto.bhit}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<p  class="text-end"><a href="${pageContext.request.contextPath}/board/create"   class="btn btn-primary">글쓰기</a></p>
</div>

<%@ include file="../inc/footer.jsp" %>