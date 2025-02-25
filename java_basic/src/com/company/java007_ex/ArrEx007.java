package com.company.java007_ex;

import java.util.Arrays;

public class ArrEx007 {
	public static void main(String[] args) {
		
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
		int[] kor={100,20,90,70,35};   
		int[] eng={100,50,95,80,100};
		int[] mat={100,30,90,60,100};
		int[] aver=new int[5];
		String[] pass = new String[5];
		String[] exhibit = new String[5];
		int [] rank = new int[name.length];
		int spot = 0;
		
		//1. 평균 구하기 i번째 인물 평균(aver[i]) = (kor[i]+eng[i]+mat[i])/3 >>
		for(int i=0; i<name.length; i++) {	aver[i] = (kor[i]+eng[i]+mat[i])/3;	}
		
		//2. 합격-불합격 >> 60이상 if(aver(i) >= 60){String[i]="합격"} 
		for(int i=0; i<name.length; i++) {	if(aver[i] >= 60){ pass[i]= "합격"; } else { pass[i]= "불합격"; }	}
		
		//3. 장학생 >> 평균 95 이상 if(aver[i]>=95)
		for (int i=0; i<name.length; i++) {	if(aver[i]>=95) {exhibit[i]="장학생";} else {exhibit[i]="----";}}
		
		//4. 등수 평균값 비교해서... >> 기본값 0 시작 
		for(int i=0; i<name.length; i++) {
			spot=1;
			for(int j=0; j<name.length; j++) {
				if(aver[i]<aver[j]) {spot++;}
			}
			rank[i]=spot;					}
				
		// 출력
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t평균\t순위\t합격여부\t장학생");
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+aver[i]+"\t"+rank[i]+"\t"+pass[i]+"\t"+exhibit[i]);
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
	}//end main
}//end class
/*
배열을 이용하여 다음의 프로그램을 작성하시오.   
String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
int[] kor={100,20,90,70,35};   
int[] eng={100,50,95,80,100};
int[] mat={100,30,90,60,100};
int[] aver=new int[5];

1. 평균구하시오.
2. 합격,불합격   -  평균이 60점이상이면 합격, 아니면 불합격으로 처리하시오.
3. 장학생   - 평균 95점이상이면 장학생으로 처리하시오. 
 
3.출력예시:     
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
이름      국어   영어   수학   평균   합격여부   장학생   
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
아이언맨	100   100   100   100   합격     장학생   
헐크		20    50    30    33    불합격    ----   
캡틴		90    95    90    91    합격     ----   
토르		70    80    60    70    합격     ----   
호크아이	35    100   100   78    합격     ----   
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
*/