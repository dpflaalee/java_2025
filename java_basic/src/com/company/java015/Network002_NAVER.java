package com.company.java015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Network002_NAVER {
	public static void main(String[] args) {
		
		try {
		//1. URL
		String apiurl = "https://openapi.naver.com/v1/search/news.json?query="+URLEncoder.encode("ai","UTF-8");
		URL url = new URL(apiurl);
		
		//2. 연결객체(HttpURLConnection)
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Naver-Client-Id", "FeYwCFQ_uayvvPo7sfD0");
		conn.setRequestProperty("X-Naver-Client-Secret", "M0_yCHsNJe");
		
		//3.요청설정
/*		HTTP 메서드 
		GET
		파라미터를 쿼리스트링 형식으로 > 요청사항 주소표시창줄로 데이터 넘기기
		//query UTF-8로 인코딩 쿼리 스트링 형식 -요청사항 주소표 시작표시창줄로 데이터 넘기기
		///									주소?이름=값&이름=값
		query	String	Y	검색어. UTF-8로 인코딩되어야 합니다.
		"X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}" \
		"X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}" -v */

		//4.응답코드
		System.out.println(conn.getResponseCode());
		int code = conn.getResponseCode();
		BufferedReader br;
		if(code == 200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}else {
			br=new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		//5.응답데이터- xml / json / csv
		String line = ""; StringBuffer sb = new StringBuffer();
		while((line = br.readLine())!=null) {sb.append(line+"\n");}
		System.out.println(sb.toString());
		br.close();conn.disconnect();

		}catch(Exception e) {e.printStackTrace();}
		
	}//E.M
}//E.C
/*
Client ID 		FeYwCFQ_uayvvPo7sfD0
Client Secret	M0_yCHsNJe

요청 URL 
https://openapi.naver.com/v1/search/news.xml	XML
https://openapi.naver.com/v1/search/news.json	JSON

프로토콜 
HTTPS

9*/