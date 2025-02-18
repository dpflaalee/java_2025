package com.company.java002_ex;

public class VarEx002 {
	public static void main(String [] args) {
		int a=20;
		int b=7;
		System.out.println( a + "+" + b + "="+(a+b));
		System.out.println( a + "-" + b + "=" + (a-b));
		System.out.println( a + "*" + b + "=" + (a*b));
		System.out.println( a + "/" + b + "=" + (a/b));
		
		System.out.printf("%d+%d=%d\n" , a, b, a+b);
		
		System.out.printf("%d/%d=%f\n" , a, b, a/(float)b);
//		정수/정수 = 정수 
//		int는 정수형 자료형이라 나누기에서 실수가 나오게 하려면 정수/실수 or 실수/정수의 형태로 자료형을 변경해줘야함.
	

	}
}
