package com.company.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class NaverBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NaverBookServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		try {
			//1. URL
//			https://openapi.naver.com/v1/search/book.xml	XML
//			https://openapi.naver.com/v1/search/book.json	JSON
			String apiurl="https://openapi.naver.com/v1/search/book.json?query="
							+URLEncoder.encode("요리","UTF-8");
			URL url = new URL(apiurl); //객체만들고
			
			
			//2. 연결객체(HttpURLConnection)
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); //열기
			
			//3.요청설정
			//GEt query
//			Client ID 		FeYwCFQ_uayvvPo7sfD0
//			Client Secret	M0_yCHsNJe
//			X-Naver-Client-Id
//			X-Naver-Client-Secret
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", "FeYwCFQ_uayvvPo7sfD0");
			conn.setRequestProperty("X-Naver-Client-Secret", "M0_yCHsNJe");
			
			
			//4.응답코드
			System.out.println(conn.getResponseCode());
			
			
			//5.응답데이터
			int code = conn.getResponseCode();
			BufferedReader br;
			if(code==200) {br=new BufferedReader(new InputStreamReader(conn.getInputStream()));}
			else {br=new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
			
			String line=""; StringBuffer sb = new StringBuffer();
			while((line = br.readLine())!=null) {sb.append(line+"\n");}
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
			
			PrintWriter out = response.getWriter();   
			out.println(sb.toString()); //##
					
			}catch (Exception e) {e.printStackTrace();}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
