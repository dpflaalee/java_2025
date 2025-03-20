<%@page import="java.sql.*"%>
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
	<div class = "container card my-5">
		<h3 class ="card-header">Statement</h3>
		<pre class="alert alert-warning">
		1. 드라이버로딩 Class.forName
		2. db연동 DriverManager.getConnection(url,id,pass
		3. Statement, PreparedStatement
		4. 결과 : ResultSet (select) /int (insert, update, delete)
		</pre>
		
		<%
		Connection conn=null; Statement stmt=null; ResultSet rset=null;
		try{
			//1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. DB연동
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mbasic","root","1234");
			//3. Startement, PreparedStatement
			stmt= conn.createStatement(); //1
			rset = stmt.executeQuery("select * from milk where mname='white'"); //2 표
			while(rset.next()){//3 줄
				out.println(rset.getInt("mno") + "/" + rset.getString("mname") + "/" 
				+ rset.getInt("mprice")+"<br/>"); //칸
			}
			//4. 결과물
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rset != null){rset.close();}
			if(stmt != null){stmt.close();}
			if(conn != null){conn.close();}
		}
		
		%>
		
	</div>
</body>
</html>