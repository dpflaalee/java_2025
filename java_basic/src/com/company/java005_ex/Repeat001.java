package com.company.java005_ex;

import java.util.Scanner;

public class Repeat001 {
	public static void main(String[]args) {
		//숫자 한 개 입력받아 if a가 10이면 10이다, 20이면 20이다 30이면 30이다
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자를 입력하세요");
		int num = sc.nextInt();
		if (num%10==0) {
			System.out.println(num+"이다");
		}
		
		System.out.print("숫자를 입력하세요");
		int num2 = sc.nextInt();
		switch(num2%10) {
		case 0 : System.out.println(num2+"이다"); break;
//		case 20 : System.out.println(num2+"이다"); break;
//		case 30 : System.out.println(num2+"이다"); break;
		}
		sc.close();
		//숫자 한 개 입력받아 switch a가 10이면 10이다, 20이면 20이다 30이면 30이다
		//for 이용하여 123출력
		//무한반복을 이용하여 1을 입력받을때까지 무한반복이 되는 프로그램
	}
}
