package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007 {
	public static void main(String[]args) {
		/*
		 * 정수를 하나 입력해주세요:10
		 * 정수를 하나 입력해주세요:3
		 * 연산자를 하나 입력해주세요(+ - * /):-
		 * 10-3=7
		 */
		int num1, num2; 
		String result = "";
		char operator = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력해주세요 :"); num1=sc.nextInt();
		System.out.print("정수를 하나 입력해주세요 :"); num2=sc.nextInt();
		System.out.print("연산자를 하나 입력해주세요 :"); operator=sc.next().charAt(0);
		
		// 1) 연산자로 if문 구현
//		if(operator == '+') {System.out.println(num1+"+"+num2+"="+ (num1+num2));}
//		else if(operator == '-') {System.out.println(num1+"-"+num2+"="+ (num1-num2));}
//		else if(operator == '*') {System.out.println(num1+"*"+num2+"="+ (num1*num2));}
//		else if(operator == '/') {System.out.println(num1+"/"+num2+"="+ (num1/num2));}
//		else {System.out.println("잘못된 입력입니다.");}
		
		// 2) 출력하는걸 하나만
//		if(operator == '+') {result=""+(num1+num2);}
//		else if(operator == '-') {result=""+(num1-num2);}
//		else if(operator == '*') {result=""+(num1*num2);}
//		else if(operator == '/') {result=""+(num1/num2);}
//		else {System.out.println("잘못된 입력입니다.");}
//		System.out.println( num1+""+(operator)+""+num2+"="+result );
		
		// 3) 나누기만... 소숫점 표시
			 if(operator == '+') { result=""+(num1+num2);}
		else if(operator == '-') { result=""+(num1-num2);}
		else if(operator == '*') { result=""+(num1*num2);}
		else if(operator == '/') { result=String.format("%.2f", (num1/(float)num2));}
		else {System.out.println("잘못된 입력입니다.");}
		System.out.println( num1+""+(operator)+""+num2+"="+result);
		
		sc.close();
	}
}
