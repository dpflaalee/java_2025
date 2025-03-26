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

<!-- nav -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      
      <ul class="navbar-nav d-flex">
      <% 
      String id=(String)session.getAttribute("userID");
      
      if(id!=null){ %>
      <!-- 로그인시 -->
        <li class="nav-item">
          <a class="nav-link" href="jsp022_my.jsp"><%=id %></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="jsp022_logout.jsp">LogOut</a>
        </li>
      <!-- 로그인시 -->
      <% }else{%>
      <!-- 로그인 안했을때 -->
        <li class="nav-item">
          <a class="nav-link" href="jsp022_my.jsp">LogIn</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="jsp022_my.jsp">Join</a>
        </li>
      <% }%>  
      </ul>
    </div>
  </div>
</nav>
<!-- nav -->
	<%-- <div class="my-5"><%=session.getAttribute("userID") %></div> --%>
