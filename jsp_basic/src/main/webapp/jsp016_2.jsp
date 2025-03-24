<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int userage= Integer.parseInt(request.getParameter("userage"));
	
	if(userage<=19){
		out.println("<script>alert('미성년자입니다.'); location.href='jsp016_child.jsp'</script>");
		response.sendRedirect("jsp016_child.jsp"); // 경로노출됨. 권장사항 
	}else{
		out.println("<script>alert('성인입니다.'); location.href='jsp016_adult.jsp'</script>"); 
		request.getRequestDispatcher("jsp016_adult.jsp").forward(request, response);	//요청정보와 응답정보를 둘 다 넘김
	} 



%>