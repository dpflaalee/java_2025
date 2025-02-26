package com.company.java007_ex;

import java.util.Arrays;

public class Repeat_250226 {
	public static void main(String[] args) {
		//001
		byte b1=1;   byte b2=2;   int result = b1+b2;
		System.out.println("001. result:"+result);
		
		//002 
		System.out.println("002-1. for 문 출력");
		for(int i=100; i<=300; i+=100) {System.out.print(i+"\t");}
		System.out.println("\n002-2. while 문 출력");
		int i=100; while(i<=300) {System.out.print(i+"\t"); i+=100;}
		System.out.println("\n002-3. do while 문 출력");
		i=100; do {System.out.print(i+"\t"); i+=100;} while(i<=300);
				
		
		//003
		int [] arr = {10,20,30};
		System.out.println("\n003. for + length을 사용하여 arr 출력");
		for(int index=0; index<arr.length; index++) {System.out.print((index==0 ? "" : ",")+arr[index]);}
		
		//004
		System.out.println("\n004. new를 이용하여 배열 작성, for + length를 사용하여 출력");
		int [][] arr2 = new int [2][3];
		int data=0;
		for(int index=0; index<arr2.length; index++) {
			for(int index2=0; index2<arr2[index].length; index2++) {
				arr2[index][index2]=data+=10;
			} data=40;
		}
		System.out.println(Arrays.deepToString(arr2));
		
		//005
		System.out.println("005. 이차원배열 추가문제");
		int [][] arr3 = new int [5][5];
		data = 1;
		for(int index=0; index<arr3.length; index++) {
			for(int index2=0; index2<arr3[index].length; index2++) {
				System.out.print((arr3[index][index2]=data++) +"\t");
			} System.out.print("\n");
		}
		
		//006
		System.out.println("006. 이차원배열 추가문제2");
		int [][] blue = new int [4][4];
		data=1;
		for(int dra=0; dra<blue.length; dra++) {
			for(int gon=0; gon<blue[dra].length; gon++) {
				System.out.print((blue[dra][gon]=data++)+"\t");
			} data=1; System.out.print("\n");
		}
				
		
	}//end main
}//end class

/*	1) 클래스명 : Repeat001
	다음 오류를 해결하시오.  오류가 나는 이유는?
	byte b1=1;   byte b2=2;   byte result = b1+b2;
	
	2) 클래스명 : Repeat002
	for, while, do while 3가지 버젼으로    100 200 300  출력
	
	3) 클래스명 : Repeat003
	0. new를 이용하여 다음과 배열을 작성한다.
	1. 배열명 : arr
	2. 값     : 10,20,30
	3. for + length 를 이용하여  배열안의 10,20,30을 출력하시오.
	
	4) 클래스명 : Repeat004
	0. new를 이용하여 다음과 배열을 작성한다.
	1. 배열명 : arr2
	2. 값     :  {10,20,30}, {50,60,70}
	3. for + length 를 이용하여  배열안의 값을을 출력하시오.	*/
