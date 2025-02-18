package com.company.java002_ex;

import java.util.Scanner;

public class DataType004 {
	public static void main(String [] args) {
		//입력-국어/영어/수학
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수를 입력하시오:");
		int lang = sc.nextInt();
		System.out.print("수학점수를 입력하시오:");
		int math = sc.nextInt();
		System.out.print("영어점수를 입력하시오:");
		int eng = sc.nextInt();
		
		//처리-총점/평균
		int score = lang+math+eng;
		double average = (double)score/3;
		String average2 = String.format("%.2f", average);
		
		//출력
		System.out.println("총점 :" + score);
		System.out.println("평균 :" + average2);
		System.out.printf("평균: %.2f" , average);
		
		sc.close();  
		
		//정수/정수=정수가 나오기 때문에 실수값을 만들고 싶다면 어느 한쪽을 실수로 만들어야 한다.

	}
}
/*
국어점수를 입력하시오_입력받기
영어점수를 입력하시오_입력받기
수학점수를 입력하시오_입력받기

총점:
평균:
*/