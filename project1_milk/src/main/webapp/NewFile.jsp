<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
		<h3 class ="card-header">DB연동</h3>
		<pre class = "alert alert-warnning">
		1. 드라이버로딩 Class.forName
		2. db연동 DriverManager.getConnection(url,id,pass
		3. Startement, PreparedStatement
		4. 결과 : ResultSet (select) /int (insert, update, delete)
		</pre>
		<%Connection conn=null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mbasic", "root", "1234");
				if(conn!=null){out.println("db연동선공");}
			}	catch(Exception e){e.printStackTrace();}	
		%>
	</div>
</body>
</html>

 