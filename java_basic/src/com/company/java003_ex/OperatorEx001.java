package com.company.java003_ex;

public class OperatorEx001 {
	public static void main(String[]args) {
		//() 값(연산) 비교(><) 조건(&& > ||) 대입(=)
		int a=3, b=10;
		System.out.println( b+=10 - a-- ); // 17 a=2
		System.out.println(a+=5); 		//7
		System.out.println( a>=10 || a<0 && a>3 ); //f || f && t ==> f	

	}
}
