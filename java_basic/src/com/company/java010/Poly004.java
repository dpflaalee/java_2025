package com.company.java010;


class TestA4 extends Object{
	int a=10;
	@Override
	public String toString() { return "TestA2 [a=" + a + "]"; }}

class TestB4 extends TestA4{
	int b=20;
	@Override
	public String toString() { return "TestB2 [b=" + b + "]"; }}


public class Poly004 {
	public static void main(String[] args) {
		TestA4 ta = new TestA4();
		// 1.{int a/toString} = {int a/toString}
		TestB4 tb = new TestB4();
		// 2.{int b/toString}{int a/----} = {int b/toString}{int a/----}
		
		//tb = ta; // ta가... 부모속성 범위라서 누수생기니까 tb안에 못넣지
		//3.ta의 메모리는 {int a/toString} 만족 | int b는 생성자 호출해서 초기화한적이 없음
		
		ta = new TestB4(); //5. int b의 생성자 호출
		//다운캐스팅에서 오류가 나지 않기 위해서 부모는 자식을 담은적이 있어야 한다. 없으면 타입캐스팅해도 오류남
		
		tb = (TestB4) ta; // 4. 자식=부모 / 다운캐스팅 / 타입캐스팅O
		System.out.println(tb);
	}
}
