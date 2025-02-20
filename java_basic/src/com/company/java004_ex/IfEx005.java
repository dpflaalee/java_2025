package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String []args) {
		char ch= '\u0000';
		Scanner sc = new Scanner(System.in);
		System.out.print("영문자를 입력하시오 : ");
		ch=sc.next().charAt(0);
		
		if('a'<=ch && ch<='z') {
			System.out.println(ch-=32);
		}
		else if('A'<=ch && ch<='Z') {
			System.out.println(ch+=32);
		}
		else {System.out.println("영문자를 입력해주세요.");}
	
		sc.close();
		/*
		출력내용 : 문자한개를 입력받아 
   		대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
   		※  a = 'A' + 32    
		 */
	}
}
