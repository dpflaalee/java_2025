<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1 utf-8 설정
	request.setCharacterEncoding("UTF-8");

	//2 request.getParameter() 데이터받기
	String oname = request.getParameter("oname");
	int num = Integer.parseInt(request.getParameter("num"));
	
	//out.println(oname + "/" );
	
	//3 Driver 연동
	Connection conn = null; PreparedStatement pstmt=null; //ResultSet rset = null'
	String sql="insert into milk_order (oname, num, oip) values (?,?,?);";
	try{
	//4 DB 연동
	Class.forName("com.mysql.cj.jdbc.Driver");
	//5 PreparedStatement sql처리
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	//out.println("연동성공"+conn);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,oname);
	pstmt.setInt(2, num);
	pstmt.setString(3,InetAddress.getLocalHost().getHostAddress());
	
	//6 결과값 받기
	int result = pstmt.executeUpdate();
	if(result>0){out.println("<script>alert('주문완료'); location.href='testmilk.jsp'</script>");}
	else{out.println("<script>alert('관리자에게 문의바랍니다.'); location.href='testmilk.jsp'</script>");}
	}catch(Exception e){e.printStackTrace();} finally{
//		if(rset!=null){rset.close();}
		if(pstmt!=null){pstmt.close();}
		if(conn!=null){conn.close();}
	}
%>