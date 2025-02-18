package com.company.java002;

public class DataType {
	public static void main(String [] args) {
//		1. 자바의 자료형 분류(기본형/참초형)
//		2. 기본형: 값 저장
//			논리, 정수, 실수
		boolean bl = true; // true / false
		System.out.println("2. 논리:"+bl);
		
//		정수(1,2,4,8 : byte-short-int★-long:L) long은 끝에 L을 붙여 써야 함
		byte by =1; // bit(0,1) = 8bit = 1byte
					//1byte = 8bit = 256 : 음수를 포함하여 -128~0~127
					//bit의 사이즈는 2^n으로 커진다 ==2,4,8,16,32 ...
		short sh=2; int in = 4; long l=8L;
		System.out.println("2 정수 byte-short-int-long :"+ by);
		
		int result = by+sh; //1+2 >>문제없음
//		1. 연산 시 +	2. int(기본자료형보다 작은 애:byte, short)	연산 시 주의 바람
//		연산 시 자동으로 int로 인식되기 때문에 자료형을 변환시키거나:[(short)by+sh] / 결과를 담을 변수를 int로 설정하는 게 좋음
//		short result = by+sh; // >>오류
		System.out.println(result);
		
		//실수 float/double 소수점이 붙은애들은 double로 인식
//		float fl = 3.14; >> 타입에러 // 정수형일 경우 f 없이 입력
		float fl = 3.14f; 
		double d = 3.14;
		System.out.println("3. 실수 folat-double :" + fl + "\t" + d);
		
		System.out.println("4. 실수>정수");
		fl = l; //fl(실수 : 4byte) - long(정수 : 8byte) 실수는 정수를 담을 수 있다
		System.out.println(fl);
		
		System.out.println("5.정밀도");
		float fper = 1.1000001f; 			//반올림하여 7자리
		double dper = 1.100000000000001;	//반올림하여 15자리
		System.out.println(fper + "\t" + dper);
		
		int a = 1; //int - 4byte - 8*4byte - 32
		int b = 2>>33;
		System.out.println(a+"\t"+b);
		
		System.out.println("6. 문자 - 저장시 숫자 / 출력시 문자로");
		char ch ='A'; //문자
		System.out.println(ch);		//출력
		System.out.println((int)ch);//(int) 정수표현시 65	
		
	}
}
