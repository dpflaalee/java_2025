package com.company.java010;

// 클래스는 부품객체
// 부품객체는 멤버변수(상태)와 멤버함수(행위)를 가진다
/*
	상속-재활용/재사용
	Object {	}
	↑
	A1		int a
	↑
	B1		int b
	↑
	C1		int c
*/
class A1 extends Object {
	int a;

	public A1() { super(); /* TODO Auto-generated constructor stub*/ }}

class B1 extends A1 {
	int b;

	public B1() { super(); /* TODO Auto-generated constructor stub*/ }}

class C1 extends B1 {
	int c;
	public void show() {System.out.println(a + "/" + b + "/" + c);}

	public C1() { super(); /* TODO Auto-generated constructor stub 생략코드*/ }}

public class Extends001 {
	public static void main(String[] args) {
		C1 c1 = new C1(); c1.a = 1; c1.b = 2; c1.c = 3; c1.show();	}
	}
	
/*
 * 
 * -------------------------------------------------------- 
 * [method] A1.class B1.class C1.class , public Extends001.class #1
 * -------------------------------------------------------- 
 * [heap]								 | [stacks]
 * 			Object(){#3-4	} #3-5 Object 틀 사용가능
 * 			{a} A1(){#3-3	} #3-6 a=0 으로 초기화
 * 			{b} B1(){#3-2	} #3-7 b=0 으로 초기화 생성자
 * 19번 1번지 {c} C1(){#3-1	} #3-8 c=0 으로 초기화 - 인스턴스변수를 초기화해서 사용가능
 * 										 ← c1 1번지
 * 										 | main #2
 * --------------------------------------------------------
 * 
 */