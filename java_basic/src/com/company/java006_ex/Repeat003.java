package com.company.java006_ex;

import java.util.Scanner;

public class Repeat003 {
	public static void main(String[] args) {
		//문자 하나를 입력받아 a - apple / b - banana / c-coconut >>if&switch
		Scanner sc = new Scanner(System.in);
		System.out.println("if 구문 사용");
		System.out.print("a,b,c중 하나를 입력하세요: ");
		char friut=sc.next().charAt(0);
		if(friut=='a') {System.out.println("apple");}
		else if(friut=='b'){System.out.println("banana");}
		else if(friut=='c'){System.out.println("coconut");}
		else {System.out.println("잘못된 입력입니다.");}
		
		System.out.println("switch 구문 사용");
		System.out.print("a,b,c중 하나를 입력하세요: ");
		friut=sc.next().charAt(0);
		switch(friut) {
		case 'a' : System.out.println("apple"); break;
		case 'b' : System.out.println("banana"); break;
		case 'c' : System.out.println("coconut"); break;
		}sc.close();
		
		//for while do while 로 10 20 30 출력
		System.out.println("for을 이용한 출력");
		for(int i=1; i<31; i++) {if(i%10==0) {System.out.print(i+"\t");}}System.out.println();
		System.out.println("while을 이용한 출력");
		int i=1; while(i<31) {if(i%10==0) {System.out.print(i+"\t");}i++;}System.out.println();
		System.out.println("do while을 이용한 출력");
		i=1; do {if(i%10==0) {System.out.print(i+"\t");}i++;} while(i<31); System.out.println();
		
		//배열 arr  값 1,2,3 배열안의 숫자 모두 출력
		System.out.print("arr 배열 출력: ");
		int[] arr= {1,2,3};
		for(int index=0; index<arr.length; index++) {
			System.out.print(((index==0) ? "" : ",")+arr[index]);	}

	}
}
