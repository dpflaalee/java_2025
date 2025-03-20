<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1 utf-8 설정
	request.setCharacterEncoding("UTF-8");

	//2 request.getParameter() 데이터받기
	int ono = Integer.parseInt(request.getParameter("ono"));
	out.println(ono);

	Connection conn = null; PreparedStatement pstmt = null; //ResultSet rset=null;
	String sql = "delete from milk_order where ono=?";
	//3 Driver 연동
	Class.forName("com.mysql.cj.jdbc.Driver");

	try{
	//4 DB 연동
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	
	//5 PreparedStatement sql처리
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,ono);
	
	//6 결과값 받기
	if(pstmt.executeUpdate()>0){out.println("<script>alert('취소완료!');location.href='testmilk.jsp';</script>");}
	else{out.println("<script>alert('취소 실패');location.href='testmilk.jsp';</script>");}
	
	
	}catch(Exception e){e.printStackTrace();
	}finally{
		if(conn!=null){conn.close();}
		if(pstmt!=null){pstmt.close();}
		//if(conn!=null){conn.close();}
	}

%>
    
    