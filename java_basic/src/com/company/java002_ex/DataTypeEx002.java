package com.company.java002_ex;

import java.util.Scanner;

public class DataTypeEx002 {
/*
	좋아하는 수(정수형)을 입력하시오<입력받기
	좋아하는 숫자는 oo입니다
 */
	public static void main(String [] args) {
		int num=0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("좋아하는 숫자를 입력하세요. :");
		num = scanner.nextInt();
		System.out.printf("내가 좋아하는 숫자는 %d 입니다.", num);
		
		scanner.close();  
	}
}
