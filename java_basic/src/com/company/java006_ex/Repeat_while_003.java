package com.company.java006_ex;

public class Repeat_while_003 {
	public static void main(String[] args) {
		char ch='A';
		//for
		for(ch='A';ch<='Z';ch++){ if(ch%5==0) {System.out.println();} System.out.print(ch);}
		
		//while
		char ch2='A'; while(ch2<='Z'){ if(ch2%5==0) {System.out.println();} System.out.print(ch2); ch2++;}
		
		//do while
		char ch3='A'; do{ if(ch3%5==0) {System.out.println();} System.out.print(ch3); ch3++;} while(ch3<='Z');
		
	}
}
/*
for , while , do while 3가지 버젼으로 
ABCDE   
FGHIJ
KLMNO
PQRST
UVWXY
Z 
5번째마다 줄바꿈
*/
