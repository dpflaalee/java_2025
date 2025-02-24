package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx003 {
	public static void main(String[]args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.print("대문자를 입력하세요:");
		//char str = sc.next().charAt(0);
		//System.out.println("소문자:" + (str+=32));
		
		char ch = ' ' ;
		Scanner sc = new Scanner(System.in);
		System.out.print("대문자를 입력하세요:");
		ch= sc.next().charAt(0);
		ch += 32;
		System.out.print("소문자:" +ch );
		
		//실수에 정수대입시 실수로
		float fl = 1+1.0f;
		System.out.print(fl);
		
		sc.close();
	}
}
