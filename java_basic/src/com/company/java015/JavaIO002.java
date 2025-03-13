package com.company.java015;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaIO002 {
	public static void main(String[] args) {
		//경로
		String folder_rel="src/com/company/java015/";
		String file_rel="file002.txt";
		
		//폴더+파일 만들기
		File folder = new File(folder_rel);
		File file = new File(folder_rel+file_rel);
		
		
		//byte 파일쓰기 InputStream > 프로그램 > OutputStream [##]
		try {
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
			} catch(IOException e) { e.printStackTrace(); }
		
		try {
			OutputStream output = new FileOutputStream(file); // 쓸 준비하기
			output.write('j');
			output.write('a');
			output.write('v');
			output.write('a'); //내용적기
			output.flush();
			output.close(); //닫기 #####필수#####
			System.out.println("쓰기완료");
			}catch (Exception e) { e.printStackTrace();	}
		
		//파일읽기 InputStream [##] > 프로그램 > OutputStream
		try{
			InputStream input = new FileInputStream(file);
			//System.out.println(input.read()); // 106 :: 문자-저장시 숫자 출력시 문자
			int cnt = 0;
			while( (cnt=input.read()) != -1 ) {// -1 > Stream 끝 파일 끝
				System.out.println((char)cnt);	}
			input.close();
			
			}catch (Exception e) {e.printStackTrace();}		
		
	}
}
