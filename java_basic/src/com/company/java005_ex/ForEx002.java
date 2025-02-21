package com.company.java005_ex;

import java.util.Scanner;

public class ForEx002 {
	public static void main(String[]args) {
		//구구단:사용자에게 단을 입력받아 해당하는 단을 출력해주는 프로그램을 작성하시오
		int index;
		System.out.print("숫자를 입력하세요(1~9):");
		Scanner sc = new Scanner(System.in); index=sc.nextInt();
		
		for( int i=1; i<10; i++ ) {
			System.out.println(index + "*" + i + "=" + (index*i)); 
		}
		
		sc.close();
	}
}
