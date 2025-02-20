package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
	public static void main(String [] args) {
		char ch ='\u0000';
		Scanner sc= new Scanner(System.in);
		System.out.print("영문자를 입력하시오:");
		ch=sc.next().charAt(0);
		
		if('a'<=ch && ch<='z') {System.out.println("소문자입니다.");}
		else if('A'<=ch && ch<='Z') { System.out.println("대문자입니다."); }
		else {System.out.println("영문자를 입력해주세요.");}
		
		sc.close();
		
		
		/*
		출력내용 : 문자한개를 입력받아 
   		대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
   		※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
		 */
	}
}
