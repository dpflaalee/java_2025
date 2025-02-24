package com.company.java005_ex;

import java.util.Scanner;

public class Repeat002 {
	public static void main(String[]args) {
		//for 이용하여 123출력
		for(int i=1; i<4; i++) {
			System.out.print(i);
		}
		
		//무한반복을 이용하여 1을 입력받을때까지 무한반복이 되는 프로그램
		Scanner sc=new Scanner(System.in);
		for(;;) {
			System.out.print("\n숫자 1을 입력하세요");
			int num=sc.nextInt();
			if(num==1) {break;}
			sc.close();
		}
	}
}