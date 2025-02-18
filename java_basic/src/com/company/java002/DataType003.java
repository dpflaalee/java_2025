package com.company.java002;

import java.util.Scanner;

public class DataType003 {
	public static void main(String[]args) {
		// 자료형 : 기본형/참조형
		// 기본형 - 논리형, 정수형(1-2-4-8 byte-short-int★-long), 실수형(float-double★)
		
		// gigo >> 변수-입력-처리-출력
		// 변수
//		float f = 3.14f;
		double d = 3.14;
		Scanner scanner = new Scanner(System.in);
		
		// 입력
		System.out.print("실수를 입력하세요. : ");
//		f= scanner.nextFloat();
		d= scanner.nextDouble();

		//출력
		System.out.println("입력하신 값은?" + d);
		
		scanner.close();  

	}//end main
}//end class
