<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//세션 초기화코드
// 로그인 페이지로 넘기기

	//ver1 //out.println("<script>alert('로그아웃합니다.'); location.href='jsp022_login.jsp)'</script>");

	//ver2 
	//session.invalidate();
	//response.sendRedirect("jsp022_login.jsp"); // 알림창 처리안됨
	
	//ver3 새로고침
	out.println("<meta http-equib='refresh' content='0; url=jsp022_login.jsp'	/>");
	
	//request.getRequestDispatcher("jsp022_my.jsp").forward(request, response);


%>