package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {
	public static void main(String[]args) {
//		출력내용 : 평균을 입력받아 60점이상이면 합격,  불합격여부를 출력하는 프로그램을 IF로 작성하시오.
		int ave;
		Scanner sc = new Scanner(System.in);
		System.out.print("평균을 입력하시오 :");
		ave = sc.nextInt();
		
		//2형식
		if(ave>=60) {System.out.println("합격");}
		else {System.out.println("불합격");}
		
		//1형식
//		if(ave>=60) {System.out.println("합격");}
//		if(ave<60) {System.out.println("불합격");}
				
		sc.close();
	}
}
