package com.company.java003_ex;

public class OperatorEx002 {
	public static void main(String[]args) {
		int x = 5;
		char ch = '\u0000' ;
		System.out.println( 3<x && x<10 );
		
		//ch가 a or A일때 true인 조건식
		ch = 'a';
		System.out.println( ch=='a' || ch=='A' );
		
		//ch가 0~9일때 true인 조건식
		System.out.println( '0'<=ch && ch<='9' );
		System.out.println( 0<=(int)ch && (int)ch<=9 );
		
		//ch가 영문자(대문자 또는 소문자)일때 true인 조건식
		System.out.println(('a'<=ch && ch<='z')||('A'<=ch && ch<='Z'));
	}
}
