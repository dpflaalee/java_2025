package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {
	public static void main(String[]args) {
//		출력내용 : 숫자 한개를 입력받아 양수라면 양수 , 음수라면 음수 ,0이라면 zero를 출력하는 프로그램을 작성하시오.
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자를 입력하시오 :");
		num=sc.nextInt();
		
		if(0<num) {System.out.println("양수");}
		else if(num<0) {System.out.println("음수");}
		else {System.out.println("zero");}
		
		sc.close();
	}
}
