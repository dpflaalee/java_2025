package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int num, num2;
		System.out.print("숫자를 입력하세요: ");
		num = sc.nextInt();
		System.out.print("숫자를 입력하세요: ");
		num2 = sc.nextInt();

		double div = (double)num/num2;
//		System.out.printf("%.2f", div);
		System.out.println( num + "/" + num2 + "=" + String.format("%.2f",div));
		
		sc.close();
		
	}
}
// Scanner를 이용하여 입력받고 출력하시오
// 입력1 _입력받기 10 (자료형 int)
// 입력2 _입력받기 3 (자료형 int)
// 10/3 = 3.33