package com.company.java012;

import java.util.Scanner;

public class Exception001 {
	public static void main(String[] args) {
		int a=-1;
		Scanner sc = new Scanner(System.in);

		for (;;) {

			System.out.print("숫자를 입력해주세요");
			
			try {
				a = sc.nextInt();
			} catch (Exception ex) {
				System.out.println("잘못된 입력");
				sc.next();
			}
			
			if (a == 1) {
				System.out.println("종료");
				break;						}

		}
		
		
	}
}
