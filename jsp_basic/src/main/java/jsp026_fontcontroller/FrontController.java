package jsp026_fontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.front") // 1. 확장자 체크
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doAction(request, response);	//3. post, get 상관없게 Action 호출
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		doAction(request, response);	//3. post, get 상관없게 Action 호출
	}
	
	//2. 
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path=request.getServletPath();
		System.out.println("......"+path);
		
		if(path.equals("/a.front")) {System.out.println("A. a처리컨트롤러 호출 B. View");}
		if(path.equals("/b.front")) {System.out.println("B. b처리컨트롤러 호출 B. View");}
	}
	
	//4-1. 브라우저에 띄우기 >> http://localhost:8080/jsp_basic/*.front 확인
	//4-2. http://localhost:8080/jsp_basic/a.front 변경 후 콘솔창 확인
	//4-2. http://localhost:8080/jsp_basic/b.front 변경 후 콘솔창 확인

}
