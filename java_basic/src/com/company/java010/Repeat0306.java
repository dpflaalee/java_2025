package com.company.java010;
class A11{
	int a; //1 인스턴스변수
	A11(){}
	A11(int a){this.a=a;} //2 지역변수 틀림!!! () << 이걸 왜못봤니
	void show() {this.a=11; System.out.println(this.a);} //3 인스턴스메서드
	//static void classMethod() {this.a=12;} //4 클래스메서드
	//int show2() {int a; return a;} //5 인스턴스메서드 문제를 잘못봤나봐 미친것
}
public class Repeat0306 {
	public static void main(String[] args) {
		A11 a1 = new A11(); //지역변수 / Q3 :: b : new, A11(), a1
	}
}
//Q2 :: static 삭제 static 에서는 this. 사용불가
//Q4 :: 생성한 클래스를 다회 호출하는 경우 기본생성자를 생성하여 초기화작업을 거쳐야 한다. // 생성자 오버로딩 , 상속 ㅠ ㅠ
//Q5 :: c d
//Q6 :: A, B, D 라인 static 내부에서는 인스턴스변수와 함수 사용불가 >> 클래스변수가 먼저 메모리에 올라가서 + 인스턴스는 new 연산자를 사용해 메모리를 할당받고 객체생성 후 사용가능
// 변수의 초기화 순서 기본값>명시적초기화>초기화블록>생성자
// 클래스변수		1.0		2.20	3.20	4.x
// 인스턴스변수		5.0		6.10	7.10	8.10

//Q7 :: public protected package private >> 아놔 순서 바꿔씀
//Q8 :: getters / setters // toString()
//Q9 :: c1.setColor("red")
//Q10 :: 중복코드 제거, 하나의 타입으로 여러 타입을 관리하기 위함(다향성)
//Q11 :: class 자식클래스 extends 부모클래스{}

//Q12 :: 타 이미지 첨부

//Q14 :: 메소드 오버라이딩 / 상속 :: 질문이 이해가 잘 안됩니다...
//Q15 :: 1)Object 2)Object 3)Parent 4)Parent(int i, int j) 5) 10,20,30

