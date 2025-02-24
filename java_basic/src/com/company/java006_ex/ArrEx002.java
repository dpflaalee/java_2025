package com.company.java006_ex;

public class ArrEx002 {
	public static void main(String[] args) {
		/*	1. 배열명 : ch
		    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
		    3. ch 배열에서 a의 갯수 세기		*/
		int sum=0;
		char [] ch= {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		for(int i=0; i<ch.length; i++) {	if(ch[i]=='a') { sum++; }	}
		System.out.println("배열 ch에서 소문자 a의 개수: "+sum);
		
		
		/*  1. 배열명 : ch
    		2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    		3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트	*/
		int upper=0, small=0;
		char [] ch2= {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		for(int index=0; index<ch2.length; index++) {
			//대문자 카운트
			if('A'<=ch2[index] && ch2[index]<='Z') {upper++;}
			//소문자 카운트
			if('a'<=ch2[index] && ch2[index]<='z') {small++;}	}
		System.out.println("배열 ch2에서 대문자의 개수: "+upper);
		System.out.println("배열 ch2에서 소문자의 개수: "+small);
		
		//대문자>소문자 소문자>대문자 변환출력
//		ch2[0]
		for(int index=0; index<ch2.length; index++) {
			if('A'<=ch2[index] && ch2[index]<='Z') {ch2[index]=(char) (ch2[index]+32);}
			else if('a'<=ch2[index] && ch2[index]<='z') {ch2[index]=(char) (ch2[index]-32);}
			System.out.print(ch2[index]+"\t");
		}
	}
}
