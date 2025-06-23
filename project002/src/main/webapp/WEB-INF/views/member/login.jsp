<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>

<div class="container my-3 w-50">
    <h3 class="text-center mt-5">MEMBER-LOGIN</h3>
 <%--    <form:errors path="*" cssClass="text-primary text-center" />  
     --%>

		<form:form method="post" action="${pageContext.request.contextPath}/member/login" modelAttribute="memberLoginForm">        
			<c:if test="${not empty param.error}">
	            <div class="alert alert-danger  my-3">아이디 또는 비밀번호를 확인해주세요</div>
	        </c:if>
        <%-- <form:errors path="*" cssClass="text-danger text-center" /> --%>
        <div class="my-3">
            <label for="username">사용자ID</label>
            <form:input path="username" cssClass="form-control" id="username" />
            <form:errors path="username" cssClass="text-primary" />
        </div>

        <div class="my-3">
            <label for="password">비밀번호</label>
            <form:password path="password" cssClass="form-control" id="password" />
            <form:errors path="password" cssClass="text-primary" />
        </div>

        <div class="my-3 text-center">
            <input type="submit" class="btn btn-primary form-control" value="로그인" />
        </div>
        <hr/>
        <div class = "container my-5 social text-center">
        	<div class="row">
        		<div class="col-sm-4">
        			<a href = "${pageContext.request.contextPath}/oauth2/authorization/kakao" class="w-auto p-3">
        				<img src="${pageContext.request.contextPath}/images/kakao.png" alt="kakao login" />
        			</a>
        		</div>
        		<div class="col-sm-4">
        			<a href = "${pageContext.request.contextPath}/oauth2/authorization/naver" class="w-auto p-3">
        				<img src="${pageContext.request.contextPath}/images/naver.png" alt="naver login" />
        			</a>
        		</div>
        		        		        		<div class="col-sm-4">
        			<a href = "${pageContext.request.contextPath}/oauth2/authorization/google" class="w-auto p-3">
        				<img src="${pageContext.request.contextPath}/images/google.png" alt="google login" />
        			</a>
        		</div>
        	</div>
        </div>

    </form:form>

</div>

<%@ include file="../inc/footer.jsp" %>
