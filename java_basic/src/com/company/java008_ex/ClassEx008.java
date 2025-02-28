package com.company.java008_ex;

class Area1{
	static double pi = 3.14159;
	static double react(int a, int b) {return a*b;}
	static double triangle(int a, int b) {return a*b*0.5;}
	//static void react() {}
	//static void triangle() {}

}

public class ClassEx008 {
	public static void main(String[] args) {
		System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		System.out.println("사각형의 면적 : " + Area1.react(10, 5));
		System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
	}
	
}
