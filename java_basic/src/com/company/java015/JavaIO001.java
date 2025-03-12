package com.company.java015;

import java.io.File;
import java.io.IOException;

public class JavaIO001 {
	public static void main(String[] args) {
		String folder_rel="C:\\java015\\";
		String file_rel="file001.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_rel);
		try {
			if(!folder.exists()) {	folder.mkdir();			} // 폴더 없으면 폴더 만들어
			if(!file.exists()) {	file.createNewFile();	} // 파일 없으면 파일 만들어
			System.out.println("폴더/파일 준비완료!");} catch(IOException e) {e.printStackTrace();}
		
	}
}
