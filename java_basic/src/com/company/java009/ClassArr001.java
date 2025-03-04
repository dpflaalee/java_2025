package com.company.java009;

import java.util.Arrays;

class A1{
	String name;
	
}

public class ClassArr001 {
	public static void main(String[] args) {
		//int[]arr=int new[3]; 
		A1 [] carr= new A1[3];
		
		System.out.println(Arrays.toString(carr));
		System.out.println("갯수:"+carr.length);
		
		//carr[0].name="apple"; //class로 만든 배열은 생성자를 이용하여 초기화하지 않으면 오류발생
		carr[0] = new A1(); //new 메모리 빌리고 객체생성 > 생성자 A1()초기화 > carr[0]번지
		carr[0].name="apple";
		System.out.println(carr[0].name);
		
		carr[1] = new A1();
		carr[1].name="banana"; System.out.println(carr[1].name);
		
		carr[2] = new A1();
		carr[2].name="grape"; System.out.println(carr[2].name);
	
	}
}
