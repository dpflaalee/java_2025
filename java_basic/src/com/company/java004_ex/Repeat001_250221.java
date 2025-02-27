package com.company.java004_ex;

import java.util.Scanner;

public class Repeat001_250221 {
	public static void main(String[]args) {
		
		int a;
		System.out.print("숫자를 입력하세요:");
		Scanner sc = new Scanner(System.in); a=sc.nextInt();
		
//		if(a==1) {System.out.println("1이다");}
//		else if(a==2) {System.out.println("2이다");}
//		else if(a==3) {System.out.println("3이다");}
//		else {System.out.println("1,2,3이 아니다");}
		
		switch(a) {
			case 1 : System.out.println("1이다"); break;
			case 2 : System.out.println("2이다"); break;
			case 3 : System.out.println("3이다"); break;			
		}
		sc.close();
	
	}
}
//숫자 한개를 입력받아 if-a가 1이면 1, 2이면 2, 3이면 3
//switch를 이용하여 a가 1이면 1이다 2이면 2이다 3이면 3이다
