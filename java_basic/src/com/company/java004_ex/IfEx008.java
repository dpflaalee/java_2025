package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {
		public static void main(String[]args) {
			int lang, math, eng, score;
			double ave;	char level = '\u0000' ; String snum, pass, exh;
			//입력-학번·국어·수학·영어
			Scanner sc = new Scanner(System.in);
			System.out.print("학번을 입력 >"); snum=sc.nextLine();
			System.out.print("국어점수 입력 >"); lang = sc.nextInt();
			System.out.print("수학점수 입력 >"); math = sc.nextInt();
			System.out.print("영어점수 입력 >"); eng = sc.nextInt();
			
			//계산-총점·평균
			score=lang+math+eng;
			ave=(double)score/3;
			
			//합격여부>>평균이 60점 이상이고 각 과목이 40점 미만이 아니라면 합격/아니면 불합격
			if((60<=ave)&&(40<=lang)&&(40<=math)&&(40<=eng)) {pass="합격";}
			else {pass="불합격";}
			//장학생 여부>>평균이 95점 이상이면 장학생
			if(ave>=95) {exh="장학생";}
			else {exh="-";}
			//레벨>>평균이 90이상:수 80이상:우 70이상:미 60이상:양 그 외:가
			if(90<=ave) {level='수';}
			else if(80<=ave) {level='우';}
			else if(70<=ave) {level='미';}
			else if(60<=ave) {level='양';}
			else  {level='가';}
			
			//level = (ave>=90) ? "수" : (ave>=80) ? "우" : (ave>=70) ? "미" : (ave>=60) ? "양" : "가";
			
			//출력
			System.out.println("===================================================================================");
			System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s" , snum, lang, eng, math, score, ave, pass, level, exh );
			System.out.println("\n===================================================================================");
			
			sc.close();
		}
}
/*
학번 입력 > std111
국어점수 입력 > 100
수학점수 입력 > 100
영어점수 입력 > 99
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/