package com.company.java003;

public class Casting001 {
	public static void main(String[]args) {
//		#1 형변환(casting) - 자동타입변환
		byte by = 1;
		short sh = 2;
		int in = 4;
		long l = 8L;
		float f = 3.14f; // 실수는 무조건 double로 인식해서 f를 붙여줘야함
		//double d = 3.14;
		
		sh=by; // 정수(2byte)-정수(1byte) 변환 
		in=by; // 정수(4byte)-정수(1byte) 
		l=by; // 정수(8byte)-정수(1byte)
		
		l = (long)f; // 정수(8byte)-실수(4byte) 정수인지 실수인지 먼저 따지기. 실수가 정수보다 커서 에러 발생
		f = l;
		
//		boolean bl = true;
//		in = bl; boolean은 형변환 불가
		
//		#2 형변환(casting) - 강제타입변환
		by = (byte) in; // 정수(1byte)-정수(4byte)
		
		int in2 = (int) 1.2; //정수(4byte) - 실수(double:8byte)
		float fl2 = (float)3.14 ; // 실수(4byte) - 실수(double:8byte)
		
		System.out.println(in2); // 1
		System.out.println(fl2); // 3.14 >> 선언값이 소숫점 아래 8자리 넘어가면 7자리까지만 표현됨
		
		
//		Q1)
//		System.out.println( 1.5 + 2.7 ); 결과:3으로 나오게 만들기
		int num1 = (int)1.5; int num2 = (int) 2.7;
		System.out.println(num1+num2);
		System.out.println( (int)1.5 + (int)2.7 ); 
		
		
		System.out.println(sh);
		
	}//end main
}//end class
