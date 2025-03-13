package com.company.java015;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class JavaIO003_char {
	public static void main(String[] args) {
		//경로준비
		String folder_rel="src/com/company/java015/";//경로확인>패키지 우클릭 properties
		String file_rel="file003.txt";
		
		File folder = new File (folder_rel);
		File file = new File (folder_rel+file_rel);
				
		//폴더파일만들기
		try {
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
			}catch (Exception e) {e.printStackTrace();}
		
		//char 쓰기		Reader > [프로그램] > Writer#
		try {
			Writer writer = new FileWriter(file);
			writer.write("hello");
			writer.flush(); //버퍼에서 밀어내기 사용하지 않으면 버퍼에만 남고 파일에 쓰이지 않는 상황 발생
			writer.close(); //쓰기완료
			System.out.println("쓰기완료");
			}catch(Exception e) {e.printStackTrace();}
		
		//char 읽기		Reader# > [프로그램] > Writer
		try {
			Reader reader = new FileReader(file);
//			System.out.println(reader.read()); // 104 숫자로 출력
			int cnt=0;
			while((cnt = reader.read())!= -1) { //read :: 다 읽고 -1 반환
				System.out.print((char)cnt);
			}
			reader.close();
			System.out.println("Reader 읽기완료!");
			
			}catch (Exception e) {e.printStackTrace();}
		
		
		
	}//E.M
}
