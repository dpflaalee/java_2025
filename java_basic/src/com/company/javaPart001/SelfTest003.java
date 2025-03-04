package com.company.javaPart001;

import java.util.Scanner;

//당신의 이름을 입력하세요. __입력받기
//당신의 이름은 __입니다.
public class SelfTest003 {
	public static void main(String[] args) {
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름을 입력하세요.>"); name = sc.next();
		System.out.println("당신의 이름은"+name+"입니다.");
		sc.close();
	}
}
