<%@page import="com.company.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../inc/header.jsp" %>

<%-- <%=request.getAttribute("list") %> --%>
	<div class="container my-5">
		<h3>NAVER BOOK</h3>
		<div class="result">
		</div>
		<script>
			//window.onload=function 브라우저 로딩되면 동작
			//el $()jaurery
			$(function(){
				//alert("test");
				
			      $.ajax({
			          url:"${pageContext.request.contextPath}/books",
			          dataType:"json", 
			          type:"GET",
			          success:function(json){ //Object
			        	  //1.데이터 분해
			        	  //console.log(json);
			        	  let items=json.items;
			        	  //console.log(items[0]); // 객체1 items[0]={title:"",image:"",,,};
			        	  
			        	  for(let i=0; i<items.length; i++){
			        		  let div=$('<div class="card my-3">');
			        		  let p1=$('<div class="card-body">').html('<img src="'+items[i].image+'"/>');
			        		  let p2=$('<div class="card-body">').html(items[i].title); //html reset해서 넣기
			        		  div.append(p1).append(p2); //div 태그안에 p1 추가하고 p2 추가
			        		  $(".result").append(div);
			        	  }
			        	  //2.보여줄 화면에 끼워넣기
			          
			          },error:function(xhr, textStatus, errorThrown){
			             $(".result").html(textStatus + "(HTTP-" + xhr.status + "/" + errorThrown);
			          } // $(".result")  document.querySelector(".result")
			       });
				
			}); // jQuery 브라우저 로딩 시 동작
		</script>
	</div>
	
	<div class = "container my-5" style="border-bottom: 2px solid #2A9d8f; margin-bottom: 0; padding-bottom: 10px;">
		<h1 class ="card-header" style="font-weight: bold; font-size: 2em; color: #2A9D8F;">게시글 목록</h1>
	</div>
	
	<div class="container my-3" style="border: none;">
		<table class="table table-hover">
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
				<!-- for(BoardDto dto:list) -->
				<c:forEach var="dto" items="${list}" varStatus="status">
					<tr>
						<td>${list.size()-status.index}</td><!-- 전체 - (0,1,2,,) -->
						<td><a href="detail.do?bno=${dto.bno}">${dto.btitle}</a></td>
						<td>${dto.bname}</td>
						<td>${dto.bdate}</td>
						<td>${dto.bhit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="text-end" ><a href="write_view.do" class="btn" style="background-color: #E76F51; font-weight: bold; color: #ffffff;">글쓰기</a></p>
	
	</div>
	
	
<%@ include file="../inc/footer.jsp"%>