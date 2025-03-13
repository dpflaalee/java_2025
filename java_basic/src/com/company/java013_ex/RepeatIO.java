package com.company.java013_ex;

import java.io.File;
import java.io.IOException;

public class RepeatIO {
	public static void main(String[] args) {
		String folder_rel ="src/com/company/java013_ex/";
		String file_rel="JavaIO002.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_rel);
		try {
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
		}catch(IOException e) {e.printStackTrace();}
	}
}
/*
	1. folder 만들기   - 금일 패키지  com.company.java018
	2. 파일만들기      - 위의폴더에   JavaIO002.txt
*/