package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		if(path.equals("/list.do")) {
			System.out.println("C:전체리스트   BList	/	V:list.jsp ");		
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/write_view.do")) {
			System.out.println("write_view.do:글쓰기폼");
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/write.do")) {
			System.out.println("write.do:글쓰기기능");		
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/detail.do")) {
			System.out.println("detail.do:상세보기");					
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/edit_view.do")) {
			System.out.println("edit_view.do:글수정폼");					
		}	
/////////////////////////////////////////////////////////////////
		else if(path.equals("/edit.do")) {
			System.out.println("edit.do:글수정");					
		}
/////////////////////////////////////////////////////////////////
		else if(path.equals("/delete.do")) {
			System.out.println("delete.do:글삭제");					
		}
/////////////////////////////////////////////////////////////////
		
		
	}
	
	

}
