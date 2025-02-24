package com.company.java005_ex;

import java.util.Scanner;

public class Repeat003 {
	public static void main(String[]args) {
		int num, num2; double result = ' ';
		char oper;
		Scanner sc = new Scanner(System.in);

		//1 정수1입력 0~100 외의 숫자일 경우 입력 반복
		//2 정수2입력 0~100 외의 숫자일 경우 입력 반복
		
		for(;;) {
			System.out.print("첫번째 수를 입력해주세요");
			num=sc.nextInt();
			if(0<=num&&num<=100) {break;}
		}
		for(;;) {
			System.out.print("두번째 수를 입력해주세요");
			num2=sc.nextInt();
			if(0<=num2&&num2<=100) {break;}
		}
		for(;;) {
			System.out.print("연산자를 입력해주세요");
			oper = sc.next().charAt(0);
			if(oper=='+'||oper=='-'||oper=='*'||oper=='/'){break;}
		}

		if(oper=='+') {result=num+num2;}
		else if(oper=='-'){result=num-num2;}
		else if(oper=='*'){result=num*num2;}
		else if(oper=='/'){result=num/(double)num2;}
		
		System.out.println(""+num+oper+num2+"="+(oper!='/' ? ""+(int)result: String.format("%.2f", result)));
		
		//		System.out.print("정수를 하나 입력해주세요");
//		int num=sc.nextInt();
//		System.out.print("정수를 하나 입력해주세요");
//		int num2=sc.nextInt();
//		System.out.print("연산자를 입력해주세요");
//		String oper = sc.next();
//		while(true) {}
		
//		무한반복 오류 있었던게 char 말고 String 써서 그랫나..
		
		
	}
}
/*
1)  각 연산자에 맞게 계산처리
2)  숫자1, 숫자2는 0~100사이만 입력가능하게 아니면 무한반복
3)  연산자는 +, - ,*, /만 입력가능하게 아니면 무한반복
     

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13
*/
