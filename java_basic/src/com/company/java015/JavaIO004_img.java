package com.company.java015;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004_img {
	public static void main(String[] args) throws IOException {
		//경로
		//String folder_rel="src/com/company/java015/";
		//String file_rel="";
		String origin = "src/com/company/java015/jang.jpg";
		String target1 = "src/com/company/java015/jang1.jpg";
		String target2 = "src/com/company/java015/jang2.jpg";
		
		//byte 단위로 이미지 읽어들여 쓰기
		//jang.jpg > jang1.jpg
		//InputStream 읽기 > Program > OutputStream 쓰기
		InputStream bis = new FileInputStream(origin);
		OutputStream bos = new FileOutputStream(target1);
		int cnt1 = 0;
		while((cnt1=bis.read())!=-1) {	bos.write((byte)cnt1);	}
		bos.flush(); bos.close(); bis.close();
		System.out.println(">>바이트단위 이미지 복사완료");
		
		//char 단위로 이미지 읽어들여 쓰기 >>>>>> 실패
		//jang.jpg > jang2.jpg
		//Reader 읽기 > Program > Writer 쓰기
		Reader cr = new FileReader(origin);
		Writer cw = new FileWriter(target2);	
		int cnt2 =0;
		while((cnt2=cr.read())!=-1) {cw.write((char)cnt2);}
		cw.flush();cw.close();cr.close();
		System.out.println(">>char단위 이미지 복사완료");
		
		
	} // E.M
} // E.C
