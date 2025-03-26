package jsp023_servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Servlet003 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int initCnt = 1;
	int doGetCnt = 1;
	int destroyCnt = 1;
	
    public Servlet003() { super(); }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("#1. init() 첫 요청에만 호출 > " + initCnt++);
	}

	public void destroy() {
		System.out.println("파일 족므 수정하고 ctrl s 저장");
		System.out.println("#3. destory() 맨 마지막에 호출 > "+destroyCnt++);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("#2-1. get"+doGetCnt++);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("#2-2. post");
	}

}
