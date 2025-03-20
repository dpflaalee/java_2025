<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1 utf-8 설정
	request.setCharacterEncoding("UTF-8");

	//2 request.getParameter() 데이터받기
	int ono = Integer.parseInt(request.getParameter("ono"));
	String oname = request.getParameter("oname");
	int num = Integer.parseInt(request.getParameter("num"));
	out.println(ono+"/"+oname+"/"+num);

	
	Connection conn = null; PreparedStatement pstmt=null;
	String sql = "update milk_order set oname=?, num=? where ono=?";
	try{
	//3 Driver 연동
	Class.forName("com.mysql.cj.jdbc.Driver");
	//4 DB 연동
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	//5 PreparedStatement sql처리
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,oname); pstmt.setInt(2,num); pstmt.setInt(3, ono);
	//6 결과값 받기
	if(pstmt.executeUpdate()>0){out.println("<script>alert('수정성공!'); location.href='testmilk.jsp';</script>");}
	else{out.println("<script>alert('수정실패!'); location.href='testmilk.jsp';</script>");}
		
	}catch(Exception e){e.printStackTrace();
	}finally{
		if(conn!=null){conn.close();}
		if(pstmt!=null){pstmt.close();}
	}
%>