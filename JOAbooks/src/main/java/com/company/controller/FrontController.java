package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.BDelete;
import com.company.service.BDetail;
import com.company.service.BEdit;
import com.company.service.BEditeView;
import com.company.service.BList;
import com.company.service.BWrite;
import com.company.service.BoardService;


@WebServlet("*.do") //#1
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);//#3
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);//#3
	}
	//#2
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String path = request.getServletPath();
		
		BoardService service = null;
		
		
		if(path.equals("/list.do")) {
			System.out.println("C:전체리스트   BList	/	V:list.jsp ");		
			service = new BList(); service.exec(request, response);
			request.getRequestDispatcher("board/list.jsp").forward(request, response);
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/write_view.do")) {
			System.out.println("write_view.do:글쓰기폼");
			request.getRequestDispatcher("board/write.jsp").forward(request, response);

		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/write.do")) {
			System.out.println("write.do:글쓰기기능");	
			service = new BWrite(); service.exec(request, response);
				
			//System.out.println("1:"+request.getAttribute("result"));
			String result = (String) request.getAttribute("result");
			String msg="관리자에게 문의바랍니다.";
			if(result.equals("1")) {msg="글쓰기 성공";}

			out.println("<script>alert('"+msg+"'); location.href='list.do';</script>");
			//주소표시창출이 유지되어야하면 dispatcher 아니면 이렇게
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/detail.do")) {
			System.out.println("detail.do:상세보기");	
			service = new BDetail(); service.exec(request, response);
			request.getRequestDispatcher("board/detail.jsp").forward(request, response);
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/edit_view.do")) {
			System.out.println("edit_view.do:글수정폼");	
			service = new BEditeView(); service.exec(request, response);
			request.getRequestDispatcher("board/update.jsp").forward(request, response);
		}	
/////////////////////////////////////////////////////////////////
		else if(path.equals("/edit.do")) {
			System.out.println("edit.do:글수정");	
			service = new BEdit(); service.exec(request, response);
			
			String result = (String) request.getAttribute("result");
			String msg="관리자에게 문의바랍니다.";
			if(result.equals("1")) {msg="수정 성공";}
			
			out.println("<script>alert('"+msg+"');location.href='detail.do?bno="+
																			request.getParameter("bno")+"';</script>");
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/delete.do")) {
			System.out.println("delete.do:글삭제");	
			service = new BDelete(); service.exec(request, response);
			
			String result = (String) request.getAttribute("result");
			String msg="관리자에게 문의바랍니다.";
			if(result.equals("1")) {msg="삭제 성공";}
			
			out.println("<script>alert('"+msg+"');location.href='list.do';</script>");
		}
/////////////////////////////////////////////////////////////////
		
		
	}
	
	

}
