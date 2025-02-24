package com.company.java006_ex;

public class ArrayEx001 {
	public static void main(String[] args) {
		/*
			1. 배열명 : arr
			2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.
			3. for + length 로 출력
		*/
		double [] arr= {1.1, 1.2, 1.3, 1.4, 1.5};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");} System.out.println();
						
		/*
			 1. 배열명 : arr
			 2. 값 넣기 : 'A' , 'B' , 'C' , 'D'
			 3. for + length 로 출력 
		*/
		char [] arr2= {'A' , 'B' , 'C' , 'D'};
		for(int index=0;index<arr2.length;index++) {
			System.out.print(arr2[index]+"\t");} System.out.println();
			
		/*
		    1. 배열명 : arr
		    2. 값 넣기 : "아이언맨" , "헐크" , "캡틴"
		    3. for + length 로 출력
		*/
		String [] arr3= {"아이언맨" , "헐크" , "캡틴"};
		for(int index2=0;index2<arr3.length;index2++) {
			System.out.print(arr3[index2]+"\t");}

	}
}