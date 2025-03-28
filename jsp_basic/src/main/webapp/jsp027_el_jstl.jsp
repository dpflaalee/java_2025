<%@page import="jsp023_servlet.Servlet001"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h3 class ="card-header">001. el-Expression Language (표현식)</h3>
		<p><% out.println("hello"); %></p>
		<p><%="hello"%></p>
		<P>${"hello"} ${1} ${3.14} ${'A'} </P>
		
		<p><a href="jsp027_result.jsp?name=sally">PARAM</a></p>
		<% 	Servlet001 s = new Servlet001(1,2); 
			//pageContext.setAttribute("s",s);
			request.setAttribute("s",s);
		%>
		<p>객체.변수명 - getter() : ${s.a }</p>
	</div>
	<div class = "container card my-5">
		<h3 class ="card-header">002. jstl-JavaServer page Standard Tag Library ()</h3>
		<c:if test="${1<20 }"> > 1은 20보다 작다</c:if>
		
		<h3 class="card-header">002. jstl-for</h3>
		<% 
		String [] movie ={"범죄의 도시","조커","분노의질주","알라딘"};
		pageContext.setAttribute("movie",movie);
		for(String m:movie){out.println(m);}
		%>
<%-- 		<c:forEach var="m" items="${movie }" varStatus="status">
		${status.index } - ${m }
		</c:forEach> --%>
		
		
		<c:forEach items="" var=""></c:forEach>
	</div>
	
	
</body>
</html>