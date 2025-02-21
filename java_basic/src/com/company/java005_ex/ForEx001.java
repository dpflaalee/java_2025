package com.company.java005_ex;

public class ForEx001 {
	public static void main(String[]args) {
		int i;
		//q1 1~5
		for( i=1; i<=5; i++ ) { System.out.print(i+"\t"); } System.out.println();
		
		//q2 5~1
		for( i=5; i>=1; i-- ) { System.out.print(i+"\t"); } System.out.println();
		
		//q3 JAVA1~JAVA3
		for( i=1; i<4; i++ ) { System.out.print("JAVA"+i+"\t"); } System.out.println();
		
		//q4 HAPPY3~HAPPY1
		for( i=3; i>=1; i-- ) { System.out.print("HAPPY"+i+"\t"); } System.out.println();
		
		//q5 0~2
		for( i=0; i<3; i++ ) { System.out.print((i==0 ? " " : ",")+i); } System.out.println();
		
		//q6 0~99
//		for( i=0; i<100; i++ ) { System.out.print((i==0 ? " " : ",")+i); } System.out.println();
		
		//q7 10~1
		for( i=10; i>=1; i-- ) { System.out.print((i==10 ? " " : ",")+i); } System.out.println();
		
		//q8 0~8 2씩증가
		for( i=0; i<9; i+=2 ) { System.out.print((i==0 ? " " : ",")+i); } System.out.println();
		
		//q9 0~18 2씩증가
		for( i=0; i<19; i+=2 ) { System.out.print((i==0 ? " " : ",")+i); } System.out.println();
		
	}
}
/*
q1  for문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3  
q4  for문을 이용해서 다음과 같이 출력하시오 :  HAPPY3   HAPPY2  HAPPY1  
q5  for문을 이용해서 다음과 같이 출력하시오 :  0,1,2  
q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99  
q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 
q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 
*/