package com.company.javaPart001;

import java.util.Scanner;

public class SelfTest005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 나이를 입력하세요."); int age = sc.nextInt();
		if(age<19) {System.out.println("당신은 미성년자입니다.");}
		else {System.out.println("당신은 성인입니다.");}
		sc.close();
	}
}
/*
* 맞다 /틀리다
	당신의 나이를 입력하세요. __입력받기
	만약 19세 미만이라면 당신은  미성년자입니다.
	아니라면 성인입니다.
	*/