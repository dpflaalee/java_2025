<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "inc/header.jsp" %>

	<div class = "container card my-5">
		<h3 class ="card-header">PROJECT 1.설정</h3>
	
	<h4>error</h4>
		<a href="no">없는페이지</a>
		<%-- <%=null %> --%>


	<h4>DBCP</h4>
<%@page import="javax.naming.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.sql.Connection"%>

<%-- 	<%
    Context initContext = new InitialContext();
    Context envContext  = (Context)initContext.lookup("java:/comp/env");
    DataSource ds         = (DataSource)envContext.lookup("jdbc/mbasic");
    Connection conn = ds.getConnection();

	out.println("db연동");
	%> --%>
	
	</div>
	
	<div class = "container card my-5">
	<h3 class ="card-header">PROJECT 2.MODLE</h3>
	<ol>
		<li>DB	: table명-board
			<ul>
				<li>번호 : bno 		int, </li>
				<li>제목 : btitle 	varchar(1000), </li>
				<li>내용 : bcontent 	text, </li>
				<li>작성자: bname 	varchar(100), </li>
				<li>작성일 : bdate 	timestemp defult current_timestamp,</li>
				<li>조회수 : bhit 	int defult 0,</li>
				<li>아이피 : bip		varchar(100)</li>
				<li>upgrade : 글 비밀번호</li>
			</ul>
		</li>
		
		<li>Dto : 	com.company.domain - [BoardVO] private</li>
		<li>DBManager : 	com.company.dbmanager - [DBManager]</li>
		<li>Dao :	com.company.dao - BoardDao
			<ul>
			<li>executeQuery 	- select 표</li>
			<li>executeUpdate 	- insert, update, delete 실행줄수</li>
			<li>-----------------------------------------------------------------------</li>
			<li>글쓰기	insert into board (btitle,bcontent,bname,bip) values (?,?,?,?);<br>
				public int insert(BoardVO){ return 0; }</li>
				
			<li>최신글읽기	select*from board order by bno desc;<br>
				public ArrayList(BoardVO> selectAll(){return null;}</li>
				
			<li>해당글읽기	select*from board where bno=?;<br>
				글수정폼	select*from board where bno=?;<br>
				public BoardVO select(int bno){return null;}</li>
				
			<li>+조회수	update board set bhit=bhit+1 where bno=?;<br>
				public int updateHit(int bno){return 0;}</li>
				
			<li>해당글수정	update board set btitle=?, bcontent=? where bno=?;<br>
				public int update(BoardVO vo){return 0;}</li>
				
			<li>해당글삭제	delete from board where bno=?;<br>
				public delete(int bno){return 0;}</li>
			</ul>
		</li>
		<li>Test :	</li>
	</ol>
	<%@page import="com.company.domain.BoardVO"%>
     <%@page import="com.company.dao.BoardDao"%>   
		<%
		BoardDao dao= new BoardDao();
		//6.delete
		//System.out.println(dao.delete(1));
		//System.out.println(dao.select(1));
		
		//5.update
/* 		BoardVO vo = new BoardVO();
		vo.setBtitle("first title-new");
		vo.setBcontent("first content-new");
		vo.setBno(1);
		System.out.println(dao.update(vo)); 
		System.out.println(dao.select(1));  */
		
		
		//4. updateHit
		//System.out.println(dao.updateHit(1));
		
		//3. select
		//System.out.println(dao.select(1));
		
		//2. insert
/*   		BoardVO vo = new BoardVO();
		vo.setBtitle("first title");
		vo.setBcontent("first content");
		vo.setBname("first name");
		System.out.println(dao.insert(vo));   */
		
		//1. select All
		System.out.println(dao.selectAll());
		%>
	
	</div>
		<div class = "container card my-5">
	<h3 class ="card-header">PROJECT 3.View</h3>
	<pre>
	webapp - board
			 ::list.jsp
			 ::write.jsp
			 ::detail.jsp
			 ::update.jsp
	1. markup
	2. validator 오류검사
	3. 빈칸검사
	</pre>
	
	</div>
	
	
<!--
컬파
264653
2A9D8F
E9C46A
F4A261
E76F51
 -->	
<%@ include file="inc/footer.jsp"%>