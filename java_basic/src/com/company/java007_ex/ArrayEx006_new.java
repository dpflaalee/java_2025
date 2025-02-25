package com.company.java007_ex;

import java.util.Arrays;

public class ArrayEx006_new {
	public static void main(String[] args) {
		/*  new 연산자 이용해서 배열만들기
		    1. 배열명 : arr     
		    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    for+length 이용해보기
		    3. for + length 로 출력	*/
		double [] arr = new double[5];
		double data=1.1; 
		//arr[0] = data+=0.1; //반복
		for (int i=0; i<arr.length; i++) {	arr[i]=data; data+=0.1;	}
		for(int i=0;i<arr.length; i++) {System.out.print(String.format("%.1f", arr[i])+"\t");}
//		System.out.println(Arrays.toString(arr));
		
				
		System.out.println();
		/*  new 연산자 이용해서 배열만들기
		    1. 배열명 : arr     
		    2. 값 넣기 : A   B   C   D   E    for+length 이용해보기
		    3. for + length 로 출력	*/
		char [] arr2 = new char[5];
		char data2 = 'A';
		for(int i=0; i<arr2.length; i++) {	arr2[i]=data2; data2+=1; 	}
		for(int i=0; i<arr.length; i++) {System.out.print(arr2[i]+"\t");}
	}
}
