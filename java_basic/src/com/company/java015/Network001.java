package com.company.java015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network001 {
	public static void main(String[] args) {
		try {
			//1. URL
			URL url = new URL("https://www.google.com/");
			
			//2. 연결객체(HttpURLConnection)
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			//3.요청설정
			conn.setRequestMethod("GET");//필수
			conn.setDoInput(true); conn.setDoOutput(true); conn.setReadTimeout(1000);
			//conn.setDoInput(true);//읽어들이는거 가능하게해줄게 
			//conn.setDoOutput(true);//받아들이는거 가능하게해줄게 
			//conn.setReadTimeout(1000); //1000:1초 시간 어떻게 할까 Set~~ 이건 옵션
			
			//4.응답코드
			System.out.println(conn.getResponseCode()); //200
			int code = conn.getResponseCode();
			
			//5.응답데이터
			BufferedReader br;
			if(code == 200) {br = new BufferedReader(new InputStreamReader(conn.getInputStream()));}
			else { br = new BufferedReader(new InputStreamReader(conn.getErrorStream())); }
			
			String line = ""; StringBuffer sb = new StringBuffer();
			while((line = br.readLine())!= null) { sb.append(line+"\n"); }
			System.out.println(sb.toString());
			
			br.close();
			conn.disconnect();		
			}
		catch(Exception e) {e.printStackTrace();}
		
		
	}//E.M
}//E.C
