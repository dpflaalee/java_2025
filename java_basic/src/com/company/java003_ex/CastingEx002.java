package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {
	public static void main(String[]args) {
		int lang, math, eng, score, level ; 
		double ave;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수를 입력하세요 :");
		lang = sc.nextInt();
		System.out.print("수학점수를 입력하세요 :");
		math = sc.nextInt();
		System.out.print("영어점수를 입력하세요 :");
		eng = sc.nextInt();
		
		score = lang+math+eng;
		ave = (double)score/3;
		level = (int)ave/10;
		
		System.out.printf("국어:%d 영어:%d 수학:%d\n총점:%d\n평균:%.2f\n레벨:%d",lang,eng,math,score,ave,level);	
		
		sc.close();
		
	}
	
	
	
}
/*Scanner 이용하여 성적처리를 입력받고 출력
 *국어 영어 수학 총점 자료형을 int 
 *레벨 : 평균이 90점대면 레벨 9 80점대면 8 70점대면 7
 * 국어점수 100 영어점수 100 수학점수 99
 * 총점-평균-레벨 출력
 */