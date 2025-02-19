package com.company.java003;

import java.util.Scanner;

public class Casting002 {
	public static void main(String[]args) {
//		#1. 문자 초기화
//		문자는 저장 시 숫자/출력시 문자
		char ch1 = ' '; //공백 하나라도 있어야 오류 나지 않음
		char ch2 = '\u0000';
		
		System.out.println("1:" + ch1 + "\t" + ch2); 
		System.out.println("2:" + (int)ch1 + "\t" + (int)ch2);
		
	
//		#2. 문자의 연산
		char c ='A';
		System.out.println("3:" +  c + "\t" + (int)c);
		System.out.println("4:" + (c+1)); //66
		System.out.println("5:" + (char)(c+1)); //B
//		+더하기 연산
//		숫자+숫자 더히기
//		'A' + 1 = 'A' char 2byte + 1 (int|4byte)
//		
		//byte ex1 =1;
		//byte result = ex1+10;;
		//error byte result = ex + 10;
		//해결 int result ex1 +10;
		
//		Q1) 대문자 'A'를 소문자 'a'로 변환시키기
		System.out.println("A1-1:" + 'A' + "\t" + (int)'A');
		System.out.println("A1-1:" + 'a' + "\t" + (int)'a');
		System.out.println("A1-3:" + (char)('A'+32));
//		
		System.out.println("A1-4:" + (c+=32));
		
//		#3. 문자열
		//자료형은 기본형/참조형 
		String str1 = "abc"; //객체사용시 // str1 주소 
		Scanner scanner = new Scanner(System.in); //scanner 주소
		
		System.out.println(str1); 
//		System.out.println(scanner); 
		
		System.out.println(str1.charAt(0)); //a
		System.out.println(str1.charAt(1)); //b
		System.out.println(str1.charAt(2)); //c
		
		//char ch = scanner.nextChar(); ==>X
		String str = scanner.next(); //문자열 입력받기
		System.out.println("입력한 문자열:" + str);
		
		char ch = scanner.next().charAt(0);
		System.out.println("입력한 문자:" + ch);		
		
		//Q2대문자를 입력받아 소문자로 변경시키는 프로그램
		
	}
}
