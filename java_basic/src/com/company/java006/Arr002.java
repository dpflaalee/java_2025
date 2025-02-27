package com.company.java006;

import java.util.Arrays;

public class Arr002 {
	public static void main(String[] args) {
		// 1. new 연산자 이용하여 처리
		int [] arr = {1,2,3}; //배열 생성 및 초기화
		//1번지 {1,2,3} < arr : 1번지		갯수 3 / index 0~2
		
		int[] arr2 = new int[3]; // 배열 생성 new :: 공간 빌리기 :: 공간 연달아서 3개 만들어주세요
		//2번지 { , , } < arr2 : 2번지	/
		System.out.println(arr2); //[I@372f7a8d
		System.out.println(Arrays.toString(arr2)); // [0, 0,0]
		
		//데이터 대입하기
//		arr2[0] = 10;
//		arr2[1] = 20;
//		arr2[2] = 30;
		
		int data = 10;
//		arr2[0] = data; data+=10;
//		arr2[1] = data; data+=10;
//		arr2[2] = data; data+=10; // >>
		for(int i=0; i<arr2.length; i++) {arr2[i]=data; data+=10;}
		System.out.println(Arrays.toString(arr2));
		
		for(int i=0; i<arr2.length; i++) {	System.out.print(((i==0) ? "" : ",")+arr2[i]);	}
	}
}
