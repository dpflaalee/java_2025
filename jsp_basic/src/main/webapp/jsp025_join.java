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

/**
 * Servlet implementation class jsp025_join
 */
@WebServlet("/user_join")
public class jsp025_join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public jsp025_join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		doGet(request, response); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1.데이터 넘겨받기
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		//2.DB매니저 연동
		DBManager db = new DBManager();
		Connection conn=db.getConnection();
		
		//3.sql 구문처리
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		String sql="insert into member(userID, userPW) values(?,?)";
		 try {
			pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, userID);
			 pstmt.setString(2, userPW);
			 
			 int result = pstmt.executeUpdate();
			 if(result>0) {out.println("<script>alert('로그인성공'); location.href='jsp025_login.jsp';</script>");}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt==null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(rset==null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		//4.경로처리
		response.sendRedirect("jsp025_login.jsp");
	
	}

}
