package com.company.java005;

import java.util.Scanner;

public class Repeat002_For {
	public static void main(String[]args) {
		try (Scanner sc = new Scanner(System.in)) {
			//무한반복
			for(;;) {//1. 조건이 없으면 무한반복
				System.out.println("숫자 1을 입력하시오.");
				int a = sc.nextInt();
				if (a==1) {break;}
				//a가 1이라면 나가기 2. 나갈 조건
			}
			
			//for-break
			//1 2 3 4 5 6 7 8 9 10 > 3뒤로 없어짐 break
			System.out.println();
			for(int i=1;i<11;i++) {
				if(i==3) {break;}
				System.out.print(i+"\t");
			}
			
			//for-continue-skip
			//1 2 3 4 5 6 7 8 9 10 > 3을 스킵
			System.out.println();
			for(int i=1;i<11;i++) {
				if(i==3) {continue;}
				System.out.print(i+"\t");}
			
			//무한반복 하는데 9를 입력받으면 종료
			for(;;) {
				System.out.println("숫자 9를 입력하시오.");
				int b = sc.nextInt();
				if(b==9) {break;}}
			sc.close();
		}
		}
	}
