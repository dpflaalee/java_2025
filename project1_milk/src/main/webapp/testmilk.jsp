<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
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
<%
//Context initContext = new InitialContext();
//Context envContext  = (Context)initContext.lookup("java:/comp/env");
//DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
//Connection conn = ds.getConnection();
//if(conn!=null){out.println("DB연동 선공");}
%>
	<div class="p-5 bg-light rounded ">
	  <h1>Milk Order</h1>
	  <p>PreparedStatement Ex</p>
	</div>
	<!-- 메뉴판 -->
	<!-- 메뉴판 -->
	<div class = "container card my-5 p-3">
		<h3 class ="card-header text-white" style="background-color: #e9734f;">Milk Menu</h3>
			  
		<table class="table table-hover table-striped my-5 table-light">
			  <caption>Milk Menu</caption>
			    <thead>
			      <tr>
			        <th scope="col">NO</th>
			        <th scope="col">NAME</th>
			        <th scope="col">PRICE</th>
			      </tr>
			    </thead>
			    <tbody>
		<%
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String sql = "select*from milk";
			String url="jdbc:mysql://localhost:3306/mbasic";
			String id = "root", pass = "1234";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pass);
				
				pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1,"white");
				//pstmt.setInt(2,1);
				
				rset=pstmt.executeQuery();
				while(rset.next()){
					//out.println(rset.getInt("mno")+"/"+rset.getString("mname")+"/"+rset.getInt("mprice")+"<br>");
					int mno=rset.getInt("mno");
					String mname=rset.getString("mname");
					int mprice=rset.getInt("mprice");
		%>
			<tr>
			        <td><%=mno %></td>
			        <td><%=mname %></td>
			        <td><%=rset.getInt("mprice") %></td>
			      </tr>
		<%	
			}
				
			}catch(Exception e){e.printStackTrace();
			}finally{
				if(rset != null){rset.close();}
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			}
		
		%>
			    </tbody>
		</table>

	</div>
	
	
	<!-- 주문현황 표 -->
	<!-- 주문현황 표-->
	<div class = "container card my-5 p-3">
		  <h3 class ="card-header text-white"style="background-color: #e9734f;">Milk Order</h3>
			<table class="table table-hover table-striped my-5 table-light">
			  <caption>Milk 주문현황</caption>
			    <thead>
			      <tr>
			        <th scope="col">No</th>
			        <th scope="col">NAME</th>
			        <th scope="col">NUM</th>
			        <th scope="col">날짜</th>
			      </tr>
			    </thead>
			    <tbody>
					<%
					//3 Driver 연동
					String sql1 = "select*from milk_order order by ono desc";
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						//4 DB 연동
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
						//5 PreparedStatement sql처리 최신주문이 위로 올라가게...
						pstmt = conn.prepareStatement(sql1);
						//6 결과값 받기
						rset=pstmt.executeQuery();
						while(rset.next()){
							out.println(
									"<tr><td>"+rset.getInt("ono")
									+"</td><td>"+rset.getString("oname")
									+"</td><td>"+rset.getInt("num")	
									+"</td><td>"+rset.getDate("odate")	
									+"</td></tr>"
									);
						/*                                        */
						}
					}catch(Exception e){e.printStackTrace();
					}finally{
						if(conn!=null){conn.close();}
						if(pstmt!=null){pstmt.close();}
						if(rset!=null){rset.close();}
					}
					%>
			    </tbody>
			</table>
	</div>

	
	<div class = "container card my-5 p-3" style="background-color: #e9734f;">
	<h3  class ="card-header text-white"style="background-color: #e9734f;">Milk 주문하러가기</h3>
		<div id="accordion">
			<!-- 주문하기 -->
		    <div class="card my-3">
		      <div class="card-header" style="background-color: #E8E7D2">
		        <a class="btn" data-bs-toggle="collapse" href="#collapseOne" style="color: #e9734f; font-weight: bold; font-size: 1.2em;">
		          주문하기
		        </a>
		      </div>
		      <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		        <div class="card-body">
					<!--  -->
					<!--
						action 처리 	milk_input.jsp
						method 방식	데이터 노출 안됨(post)
						name 		oname, num
					 -->
					  <form action="milk_input.jsp" method="post" onsubmit="return check()">
					    <div class="mb-3 mt-3">
					      <label for="oname" style="font-weight: bold;">NAME</label>
					      <input type="text" class="form-control" id="oname" placeholder="상품명을 입력하세요" name="oname">
					    </div>
					    <div class="mb-3">
					      <label for="num" style="font-weight: bold;">NUM</label>
					      <input type="number" min="1" max="10" class="form-control" id="num" placeholder="수량을 입력하세요" name="num">
					    </div>
					    <button type="submit" class="btn btn-primary" style="background-color: #e9734f; font-weight: bold;">주문하기</button>
					  </form>
					  <script>				  
						function check(){
							let oname = document.getElementById("oname");
							let num = document.getElementBtId("num");
							
							if(oname.value==""){alert("값을 입력하세요"); oname.focus();return false;}
							if(num.value==""){alert("값을 입력하세요"); oname.focus();return false;}
						}
					  </script>
		        	<!--  -->
		        </div>
		      </div>
		    </div>
		    <!-- 주문하기-->
		    
		    <!-- 주문수정 -->		    
		    <div class="card my-3">
		      <div class="card-header" style="background-color: #E8E7D2">
		        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo" style="color: #e9734f; font-weight: bold; font-size: 1.2em;">
		        주문수정
		      </a>
		      </div>
		      <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
		        <div class="card-body">
					<!--  -->
					<!--  -->
					  <form action="milk_update.jsp" method="post">
					  	<div class="mb-3 mt-3">
					      <label for="ono_update" style="font-weight: bold;">수정 주문번호</label>
					      <input type="number" class="form-control" id="ono_update" placeholder="수정할 주문번호를 입력하세요." name="ono">
					    </div>
					    <div class="mb-3 mt-3">
					      <label for="oname_update" style="font-weight: bold;">상품명 수정</label>
					      <input type="text" class="form-control" id="oname_update" placeholder="상품명을 입력하세요" name="oname">
					    </div>
					    <div class="mb-3">
					      <label for="num_update" style="font-weight: bold;">수량 수정</label>
					      <input type="number" class="form-control" id="num_update" placeholder="수량을 입력하세요" name="num">
					    </div>
					    <button type="submit" class="btn btn-primary" style="background-color: #e9734f; font-weight: bold;">주문수정하기</button>
					  </form>
		        	<!--  -->
		        	<!--  -->
		        </div>
		      </div>
		    </div>
			<!-- 주문수정 -->
		    
		   	<!-- 주문삭제 -->
		    <div class="card my-3">
		      <div class="card-header" style="background-color: #E8E7D2">
		        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree" style="color: #e9734f; font-weight: bold; font-size: 1.2em;">
		          주문삭제
		        </a>
		      </div>
		      <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
		        <div class="card-body">
		        	<!--  -->
		        	<!--  -->
					  <form action="milk_delete.jsp" method="get">
					  	<div class="mb-3 mt-3">
					      <label for="ono_delete" style="font-weight: bold;">삭제 주문번호</label>
					      <input type="number" class="form-control" id="ono_delete" placeholder="수정할 주문번호를 입력하세요." name="ono">
					    </div>
					    <button type="submit" class="btn btn-primary" style="background-color: #e9734f; font-weight: bold;">주문취소하기</button>
					  </form>
		        	<!--  -->
		        	<!--  -->
		        </div>
		      </div>
		    </div>
		    <!-- 주문삭제 -->
		    
	  </div>


	</div>
	
	
</body>
</html>