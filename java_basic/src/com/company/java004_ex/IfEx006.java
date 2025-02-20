package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
	public static void main(String []args) {
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자를 입력하시오:");
		num=sc.nextInt();
		
		if(num%2==0) {System.out.println("여자");}
		else {System.out.println("남자");}
		
		sc.close();
		
		/*
		출력내용 : 숫자를입력받아
   		홀수면 남자, 짝수면 여자를 출력하는 프로그램을 작성하시오.
   		 */
	}
}
