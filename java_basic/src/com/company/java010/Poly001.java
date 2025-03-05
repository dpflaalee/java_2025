package com.company.java010;

/*
	Object				Object
	↑					↑
	TestA(int a)		TestB(int b)
	
*/
class TestA extends Object{ int a; }
class TestB extends Object{ int b; }

public class Poly001 {
	public static void main(String[] args) {
		TestA v110 = new TestA();
		//TestB v220 = v110; // type missmatch
		//클래스도 자료형( 틀 - Object )
		System.out.println(v110);
	}
}
