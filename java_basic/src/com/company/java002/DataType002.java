package com.company.java002;

import java.util.Scanner;

public class DataType002 {
	public static void main(String [] args) {
		//자료형의 분류 : 기본형/참조
		//기본형: 논리형, 정수형(int), 실수(double)
		
		// OOP - class(부품객체)들을 조립해 완성해가는 프로그램
		int a=1; //기본형 예시
		Scanner scanner = new Scanner(System.in); // 참조형 : crtl + shift + o
		//1. new : 공간 빌리기		heap 1000번지[]
		//2. Scanner(System.in) 사용 가능하게 초기화 - 키보드로 입력
		// heap 1000번지[	[키보드로 입력받는 기능]		] << 스캐너가 가져다 사용 가능하게 scanner(1000번지
		//#OOP
		
		System.out.println("좋아하는 숫자를 입력 > ");
		a = scanner.nextInt();
		System.out.println("좋아하는 숫자:" + a);
		
		scanner.close();  
		
	}

}
