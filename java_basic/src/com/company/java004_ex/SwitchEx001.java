package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx001 { 
	public static void main(String[]args) {
		int num;
		Scanner sc = new Scanner(System.in); 
		System.out.print("달을 입력하세요: "); num=sc.nextInt();
		
		switch(num) {
			case 3: case 4: case 5: System.out.println("봄"); break;
			case 6: case 7: case 8: System.out.println("여름"); break;
			case 9: case 10: case 11: System.out.println("가을"); break;
			case 12: case 1: case 2: System.out.println("겨울"); break; 
		}
		
		sc.close();
	}

}
/*
숫자하나 입력받아
3~5 봄
6~8 여름
9~11 가을
12~2 겨울
*/