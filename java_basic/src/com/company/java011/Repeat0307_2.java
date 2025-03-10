package com.company.java011;
/*
	Object
	↑
	Papa{int money=10 / toString()}
	↑
	Son{int money=150 int car =2 / toString() }
*/
class Papa{
	int money=10;
	public Papa() {}
	public Papa(int money) {this.money=money;}
	@Override
	public String toString() {
		return "Papa [money=" + money + "]";
	}
}
class Son extends Papa{
	int money=150;
	int car =2;
	public Son() {super();}
	public Son(int money) {this.money=money;}
	public Son(int money, int car) {this.money=money; this.car=car;}
	@Override
	public String toString() {
		return "Son [money=" + money + ", car=" + car + "]";
	}
}
public class Repeat0307_2 {
	public static void main(String[] args) {
		Papa p1 = new Papa();
		System.out.println("p1."+p1); // Papa [money=10]
		Son s2 = new Son();
		System.out.println("s2."+s2); //Son [money=150, car=2]
		//Son s3 = new Papa();
		//System.out.println("s3"); // 다운캐스팅 시 형 변환 연산자를 사용하지 않으면 오류가 남
		Papa p4 = new Son();
		System.out.println("p4."+p4); // Son [money=150, car=2]
		System.out.println("p4.money."+p4.money); // 10
		Papa p5 = new Son();
		Son s5 = (Son)p5;
		System.out.println("s5."+s5); // Son [money=150, car=2]
		System.out.println("s5.money."+s5.money); //150
	}
}
//Q8 :: 오버로딩 - 한 클래스 내에서 동일한 이름의 메소드가 존재하는 것. 메소드명이 동일하고 매개변수의 자료형형과 개수가 다르면 성립됨
//	 :: 오버라이딩 - 상속관계에서 동일한 메소드가 존재할 때 하위 클래스가 상위 클래스를 재정의하는 것. 메소드명, 매개변수의 자료형과 개수가 모두 동일해야 함
/* Q9~11
abstract - 추상화
	실체화된 객체들 간에 공통된 속성을 추출 / 미완성적 / 하위클래스가 상위 클래스의 메서드를 모두 상속해야 함
interface - 사실화
	설계와 구현을 분리함 / 코드 변경 없이 객체 변경 가능

차이 : interface가 abstract보다 추상화 정도가 높음. interface는 변수로 상수, 함수로 추상 메서드만 가지고
	 abstract는 인스턴스 변수, 일반메서드, 추상메서드 모두 가질 수 있음
*/