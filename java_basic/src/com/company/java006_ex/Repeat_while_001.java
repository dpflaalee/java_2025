package com.company.java006_ex;

public class Repeat_while_001 {
	public static void main(String[] args) {
		int i=1, i2=1;
		//1-1. 1~5 for
		for(i=1;i<=5;i++) {System.out.print(i+"\t");} System.out.println();
		//1-2. 1~5 while
		int index=1; while(index<=5) {System.out.print(index+"\t"); index++;} System.out.println();
		//1-3. 1~5 do while
		int index2=1; do {System.out.print(index2+"\t"); index2++;} while(index2<=5);System.out.println();
		
		//2-1. 5~1 for
		for(i2=5;i2>0;i2--) {System.out.print(i2+"\t");} System.out.println();
		//2-2. 5~1 while
		int index3=5; while(index3>0) {System.out.print(index3+"\t");index3--;} System.out.println();
		//2-3. 5~1 do while
		int index4=5; do {System.out.print(index4+"\t"); index4--;} while(index4>0);System.out.println();
		
		//3-1 JAVA1~JAVA3 for
		int j1=1;
		for(j1=1; j1<4; j1++) {System.out.print("JAVA"+j1+"\t");} System.out.println();
		
		//3-2 JAVA1~JAVA3 while
		int java1=1; while(java1<4) {System.out.print("JAVA"+java1+"\t"); java1++;} System.out.println();
		
		//3-3 JAVA1~JAVA3 do while
		int java2=1; do{System.out.print("JAVA"+java2+"\t"); java2++;}while(java2<4); System.out.println();
		
		
	}//end main
}//end class
/*
1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3
*/
