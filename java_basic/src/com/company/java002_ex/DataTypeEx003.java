package com.company.java002_ex;

import java.util.Scanner;

public class DataTypeEx003 {
	public static void main(String [] args) {
		float pi = 0.0f;
		Scanner scanner = new Scanner(System.in);
		System.out.print("파이값을 입력하시오 : "); pi = scanner.nextFloat();
		System.out.printf("파이값은 %.2f 입니다.", pi);

		scanner.close();  

	}
}
