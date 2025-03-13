package com.company.java015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JavaIO005_Buffered {
	public static void main(String[] args) {
		//경로만들기
		String folder_rel="src/com/company/java015/";//경로확인>패키지 우클릭 properties
		String file_rel="file005.txt";
		
		File folder = new File (folder_rel);
		File file = new File (folder_rel+file_rel);
				
		//폴더파일만들기
		try {
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
			}catch (Exception e) {e.printStackTrace();}
		
		//file쓰기(byte
		// BufferedWriter 속도향상 - OutputStreamWriter 단어 - FileOutputStream byte
		try {
			BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bw.write("1,white,1200\n");
			bw.write("2,choch,1500\n");
			bw.write("3,banana,1800");
			bw.flush();
			bw.close();
		}catch (Exception e) {e.printStackTrace();}
		
		
		//file 읽기(byte
		// BufferedReader 속도향상 - inputStreamReader 단어 - FileinputStream byte
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//			System.out.println(br.read());
//			int cnt = 0;
//			while((cnt=br.read())!=-1) {
//				System.out.print((char)cnt);
//			}
			String line="";
			StringBuffer sb = new StringBuffer(); // 
			while((line=br.readLine())!=null) {	sb.append(line+"\n");}
			System.out.println(sb.toString());
			br.close();
			
		}catch (Exception e) {	e.printStackTrace();}
		
		
	}//E.M
}//E.C
