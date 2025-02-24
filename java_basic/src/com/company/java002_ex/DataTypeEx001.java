package com.company.java002_ex;

import java.util.Scanner;

public class DataTypeEx001 {
/*	변수-입력(scanner)-처리-출력
 	나이를 입력받을 자료형 선택 후 변수명 age로 지정
 	Scanner 이용하여 나이를 입력받고 출력(당신의 나이를 입력하시오>입력받기)
 	내 나이는 **입니다 출력
 */
	public static void main(String[]args) {
		int age =0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요. : ");
		age = scanner.nextInt();
		System.out.printf("내 나이는 %d세 입니다", age);
		scanner.close();
	}
}
