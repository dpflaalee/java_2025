package com.company.java003_ex;

import java.util.Scanner;

public class Repeat003_score {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수를 입력하시오:"); int lang = sc.nextInt();
		System.out.print("수학점수를 입력하시오:"); int math = sc.nextInt();
		System.out.print("영어점수를 입력하시오:"); int eng = sc.nextInt();
		
		int score = lang+math+eng;
		double aveage = (double)score/3;
		System.out.printf("총점 : %d \n평균 : %.2f", score, aveage);
		
		sc.close();
	}
}
