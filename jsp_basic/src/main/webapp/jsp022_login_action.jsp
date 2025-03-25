<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//데이터값넘겨받기
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	//out.println(userID+userPW);
	
	Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
	String sql="select count(*) from member where name=? and pass=?";
	int result=-1;
	try{
	//드라이버연동
		Class.forName("com.mysql.cj.jdbc.Driver");
	//DB연동
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
		if(conn!=null){out.println("success");}
	//sql처리 select count(*) from member where name=? and pass=?
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userID);
		pstmt.setString(2, userPW);
		rset=pstmt.executeQuery();
		if(rset.next()){result=rset.getInt("count(*)");}
		
		if(result==1){
			request.getRequestDispatcher("jsp022_my.jsp").forward(request, response);
			session.setAttribute("userID", userID);
		}else{out.println("<script>alert('정보를 확인해주세요'); history.go(-1);</script>");}
	//결과확인
	}catch(Exception e){e.printStackTrace();}
	finally{
		if(conn==null){conn.close();}
		if(pstmt==null){pstmt.close();}
		if(rset==null){rset.close();}
	}
%>