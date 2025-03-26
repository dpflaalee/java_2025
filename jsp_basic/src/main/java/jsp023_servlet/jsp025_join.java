package jsp023_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user_join")
public class jsp025_join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public jsp025_join() { super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		doGet(request, response); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1.데이터 넘겨받기
		String name = request.getParameter("userID");
		String pass = request.getParameter("userPW");
		//2.DB매니저 연동
		DBManager db = new DBManager();
		Connection conn=db.getConnection();
		
		//3.sql 구문처리
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		String sql="insert into member(name, pass) values(?,?)";
		 try {
			pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, name);
			 pstmt.setString(2, pass);
			 
			 int result = pstmt.executeUpdate();
			 if(result>0) {out.println("<script>alert('로그인성공'); location.href='jsp025_login_servlet_dbcp.jsp';</script>");}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		//4.경로처리
		//response.sendRedirect("jsp025_login_servlet_dbcp.jsp");
	
	}

}
