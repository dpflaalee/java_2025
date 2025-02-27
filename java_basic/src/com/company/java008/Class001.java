package com.company.java008;

//1. 클래스는 부품객체이다
//2. 클래스는 속성(멤버변수)과 행위(멤버함수)를 포함함
class A1{}
public class Class001 { // jvm - main 구동시점
	public static void main(String[] args) {
		//class도 자료형이기 때문에... 자료형 변수명;
		A1  a=new A1(); // 3-1. 1번지 new(heap 공간빌리기, 객체생성) 3-2. A1() 생성자:초기화 
						// 3-3. a는 주소를 가져올 수 있게
		   
		System.out.println(a); //com.company.java008.A1@2f92e0f4

	}
}
/*
A1 a= new A1()
---------------------------------------------------------------[runtime data area]
[method: 정보, static, final :: 공용정보] A1.class, public Class001.class
---------------------------------------------------------------
[heap:동적 영역]			|[stack:잠깐 빌리기]
1번지 A1{ }				←(1번지)
						| main
---------------------------------------------------------------

*/